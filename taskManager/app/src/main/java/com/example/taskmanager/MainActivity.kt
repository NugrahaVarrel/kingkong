package com.example.taskmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.model.Task
import com.example.taskmanager.ui.theme.TaskmanagerTheme

class MainActivity : ComponentActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskAdapter
    private lateinit var taskList: MutableList<Task>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_list_data)

        val addButton = findViewById<Button>(R.id.addTaskButton)
//        val editButton = findViewById<Button>(R.id.editTaskButton)

        recyclerView = findViewById(R.id.listTask)
        taskList = mutableListOf()

        val receivedName = intent.getStringExtra("NAME")
        val receivedTask = intent.getStringExtra("TITLE_TASK")
        val receivedPriority = intent.getStringExtra("PRIORITY")
        val receivedStatus = intent.getStringExtra("STATUS")

//        val updatedData = intent.getSerializableExtra("UPDATED_TASK")


        taskList.add(Task(name = "VARREL", taskTitle = "PHILOSOPHY", priority = "LOW"))
        taskList.add(Task(name = "STEVEN", taskTitle = "SCIENCE", priority = "MEDIUM"))
        taskList.add(Task(name = "ROY", taskTitle = "PHYSICS", priority = "HIGH", status = "DONE"))

        val dataTask = Task(
            name = receivedName,
            taskTitle = receivedTask,
            priority = receivedPriority,
            status = receivedStatus
        )

        taskList.add(dataTask)

        adapter = TaskAdapter(taskList) { selectedTask ->
            val intent = Intent(this, EditActivity::class.java).apply {
                intent.putExtra("taskId", selectedTask.id)
                intent.putExtra("taskName", selectedTask.name)
                intent.putExtra("taskTitle", selectedTask.taskTitle)
                intent.putExtra("taskPriority", selectedTask.priority)
                intent.putExtra("taskStatus", selectedTask.status)
            }
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        addButton.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }
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
    TaskmanagerTheme {
        Greeting("Android")
    }
}