package com.example.taskmanager.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var taskTitle: String,
    var taskPriority: Int,
    var done: Boolean,
    var createdAt: Long
)