package com.example.photonotes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PhotoPickerActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageButton
    private lateinit var btnSelectPhoto: Button
    private lateinit var dummyPhoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_picker)

        btnBack = findViewById(R.id.btnBack)
        btnSelectPhoto = findViewById(R.id.btnSelectPhoto)
        dummyPhoto = findViewById(R.id.dummyPhoto)

        // Back manual
        btnBack.setOnClickListener { finish() }

        val title = intent.getStringExtra("note_title")

        btnSelectPhoto.setOnClickListener {
            val dummyUrl = "content://dummy/photo_123.jpg"
            val intent = Intent(this, SummaryActivity::class.java)
            intent.putExtra("note_title", title)
            intent.putExtra("photo_uri", dummyUrl)
            intent.putExtra("photo_res_id", R.drawable.orangganteng) // ✅ pakai id drawable
            startActivity(intent)
            finish()
        }
    }
}
