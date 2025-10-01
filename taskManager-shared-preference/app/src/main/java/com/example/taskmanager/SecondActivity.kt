package com.example.taskmanager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.example.taskmanager.dao.TaskDao
import com.example.taskmanager.storage.AppDatabase
import java.util.Date

class SecondActivity : ComponentActivity() {
    private lateinit var dao: TaskDao
    private var taskId: Int = -1

    private var priorString : String ?= "UNIDENTIFIED"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        dao = AppDatabase.get(this).TaskDao()

        taskId = intent.getIntExtra("TASK_ID", -1)
        if (taskId == -1) {
            Toast.makeText(this, "Masuk sini?", Toast.LENGTH_SHORT).show()
            finish() // no task ID, close
        }

        val task = dao.getTaskById(taskId)

        if (task.taskPriority == 1){
            priorString = "LOW"
        } else if(task.taskPriority == 2){
            priorString = "MEDIUM"
        } else if(task.taskPriority == 3){
            priorString = "HIGH"
        }

        val tvTitle = findViewById<TextView>(R.id.tvTaskTitleSecond)
        val tvPriority = findViewById<TextView>(R.id.tvTaskPrioritySecond)
        val tvCreatedAt = findViewById<TextView>(R.id.tvTaskCreatedAtSecond)
        val rgStatus = findViewById<RadioGroup>(R.id.rgStatus)
        val btnUpdate = findViewById<Button>(R.id.btnUpdateStatus)

        tvTitle.text = task.taskTitle
        tvPriority.text = "Priority: ${priorString}"
        tvCreatedAt.text = "Created: ${Date(task.createdAt)}"

        if (task.done) {
            rgStatus.check(R.id.rbDone)
        } else {
            rgStatus.check(R.id.rbInProgress)
        }

        btnUpdate.setOnClickListener {
            val isDone = rgStatus.checkedRadioButtonId == R.id.rbDone
            val updatedTask = task.copy(done = isDone)
            dao.updateTask(updatedTask)

            val resultIntent = Intent()
            resultIntent.putExtra("UPDATED_TASK_ID", task.id)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}