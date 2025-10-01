package com.example.taskmanager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Switch
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.adapter.TaskAdapter
import com.example.taskmanager.dao.TaskDao
import com.example.taskmanager.entity.Task
import com.example.taskmanager.storage.AppDatabase
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    private lateinit var dao: TaskDao

    private lateinit var adapter: TaskAdapter

    private lateinit var updateTaskLauncher: ActivityResultLauncher<Intent>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val saveButton = findViewById<Button>(R.id.btnAdd)
        val filterButton = findViewById<Button>(R.id.filterAdd)
        val tvTaskTitle = findViewById<EditText>(R.id.etTaskTitle)
        val priorityGroup = findViewById<RadioGroup>(R.id.priorityGroup)
        val rvTask = findViewById<RecyclerView>(R.id.rvTasks)



        dao = AppDatabase.get(this).TaskDao()

        updateTaskLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                loadData()
            }
        }

        adapter = TaskAdapter(tasks = mutableListOf(),
//            onTaskDone = {
//            updated -> dao.updateTask(updated)
//            loadData()
//            },
            onItemClick = {
            clickedTask ->
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("TASK_ID", clickedTask.id)
//                startActivity(intent)
                updateTaskLauncher.launch(intent)
            }
        )


        rvTask.layoutManager = LinearLayoutManager(this)
        rvTask.adapter = adapter

        saveButton.setOnClickListener {
            val selectedId = priorityGroup.checkedRadioButtonId.toString()
            if (selectedId == "-1") {
                Toast.makeText(this, "Please select a priority", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val selectedRadioButton = findViewById<RadioButton>(selectedId.toInt())

            val taskTitleValue = tvTaskTitle.text.toString().uppercase()
            val priorityText = selectedRadioButton.text.toString().uppercase()

            val priorityValue = when (priorityText) {
                "LOW" -> 1
                "MEDIUM" -> 2
                "HIGH" -> 3
                else -> 0
            }

            val newTask = Task(
                taskTitle = taskTitleValue,
                taskPriority = priorityValue,
                done = false,
                createdAt = System.currentTimeMillis()
            )

            saveData(newTask)
            tvTaskTitle.setText("")
            loadData()
        }

        filterButton.setOnClickListener {
            val prefs = getSharedPreferences("task_prefs", MODE_PRIVATE)
            val editor = prefs.edit()
            editor.putString("SORT_BY", "priority")
            editor.putBoolean("SHOW_DONE", true)
            editor.apply()

            val intent  = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

         loadData()
    }

    private fun saveData(task: Task){
        dao.insertTask(task)
    }

    private fun loadData(){
        val data = dao.getAllTask()
        adapter.setData(data)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        Greeting("Android")
    }
}