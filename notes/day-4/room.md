```
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-kapt'
}

dependencies {
    implementation "androidx.recyclerview:recyclerview:1.3.2"

    def room_version = "2.6.1"
    implementation "androidx.room:room-runtime:$room_version"
    implementation "androidx.room:room-ktx:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
}

```

```
package com.example.lifecycledemo.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "participants")
data class Participant(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val email: String,
    val checkedIn: Boolean = false
)

```

```

package com.example.lifecycledemo.room

import androidx.room.*

@Dao
interface ParticipantDao {
    @Query("SELECT * FROM participants ORDER BY id DESC")
    fun getAll(): List<Participant>

    @Insert
    fun insert(p: Participant): Long

    @Update
    fun update(p: Participant)

    @Delete
    fun delete(p: Participant)
}

```

```
package com.example.lifecycledemo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Participant::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun participantDao(): ParticipantDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun get(ctx: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    ctx.applicationContext,
                    AppDatabase::class.java,
                    "lifecycledemo-db"
                )
                // DEMO: izinkan main thread. Produksi: pakai coroutine.
                .allowMainThreadQueries()
                .build().also { INSTANCE = it }
            }
    }
}
```

```
package com.example.lifecycledemo.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecycledemo.R

class ParticipantAdapter(
    private val items: MutableList<Participant>,
    private val onToggleCheckIn: (Participant) -> Unit,
    private val onDelete: (Participant) -> Unit
) : RecyclerView.Adapter<ParticipantAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val tvName: TextView = v.findViewById(R.id.tvName)
        val tvEmail: TextView = v.findViewById(R.id.tvEmail)
        val cbCheckedIn: CheckBox = v.findViewById(R.id.cbCheckedIn)
        val btnDelete: ImageButton = v.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_participant, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.tvName.text = item.name
        holder.tvEmail.text = item.email
        holder.cbCheckedIn.setOnCheckedChangeListener(null)
        holder.cbCheckedIn.isChecked = item.checkedIn

        holder.cbCheckedIn.setOnCheckedChangeListener { _, isChecked ->
            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                onToggleCheckIn(item.copy(checkedIn = isChecked))
            }
        }

        holder.btnDelete.setOnClickListener {
            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) onDelete(item)
        }
    }

    override fun getItemCount() = items.size

    fun setData(newItems: List<Participant>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}

```

```
package com.example.lifecycledemo.room

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecycledemo.R

class RoomActivity : AppCompatActivity() {

    private lateinit var dao: ParticipantDao
    private lateinit var adapter: ParticipantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        supportActionBar?.title = "Participants (Room)"

        dao = AppDatabase.get(this).participantDao()

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val rv = findViewById<RecyclerView>(R.id.rvParticipants)

        adapter = ParticipantAdapter(
            items = mutableListOf(),
            onToggleCheckIn = { updated ->
                dao.update(updated)
                loadData()
            },
            onDelete = { del ->
                dao.delete(del)
                loadData()
            }
        )

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        btnAdd.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            if (name.isEmpty() || !email.contains("@")) {
                etName.error = if (name.isEmpty()) "Nama wajib" else null
                if (!email.contains("@")) etEmail.error = "Email tidak valid"
                return@setOnClickListener
            }
            dao.insert(Participant(name = name, email = email))
            etName.setText("")
            etEmail.setText("")
            loadData()
        }

        loadData()
    }

    private fun loadData() {
        val data = dao.getAll()
        adapter.setData(data)
    }
}

```

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:padding="16dp"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText
        android:id="@+id/etName"
        android:hint="Nama peserta"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <EditText
        android:id="@+id/etEmail"
        android:hint="Email peserta"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"/>

    <Button
        android:id="@+id/btnAdd"
        android:text="Tambah Peserta"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"/>

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rvParticipants"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_marginTop="12dp"
        android:layout_weight="1"/>
</LinearLayout>

```
