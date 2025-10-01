package com.example.taskmanager

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.adapter.TaskAdapter
import com.example.taskmanager.dao.TaskDao
import com.example.taskmanager.storage.AppDatabase

class ThirdActivity : ComponentActivity() {
    private lateinit var dao: TaskDao
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        dao = AppDatabase.get(this).TaskDao()

        val tvFilterInfo = findViewById<TextView>(R.id.tvFilterInfo)
        val rvFilteredTasks = findViewById<RecyclerView>(R.id.rvFilteredTasks)

        adapter = TaskAdapter(mutableListOf(), onItemClick = {  })
        rvFilteredTasks.layoutManager = LinearLayoutManager(this)
        rvFilteredTasks.adapter = adapter

        loadFilteredTasks(tvFilterInfo)
    }

    private fun loadFilteredTasks(tvFilterInfo: TextView) {
        val prefs = getSharedPreferences("task_prefs", MODE_PRIVATE)
        val sortBy = prefs.getString("SORT_BY", "created")!!
        val showDone = prefs.getBoolean("SHOW_DONE", false)

        tvFilterInfo.text = "Sorting by: $sortBy | SHOW_DONE: $showDone"

        val filteredTasks = when (sortBy) {
            "priority" -> dao.getTasksSortedByPriority(showDone)
            else -> dao.getTasksSortedByCreated(showDone)
        }

        adapter.setData(filteredTasks)
    }


}