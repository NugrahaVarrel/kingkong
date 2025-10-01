package com.example.taskmanager.model

import android.os.Parcelable
import com.example.taskmanager.util.Util
import java.io.Serializable

data class Task (
    val id: Int = Util.generateId(),
    val name: String ?= "Anonymous",
    val taskTitle: String ?= "TASK_${name}_${id.toString()}",
    val priority: String ?= "LOW",
    val status: String ?= "IN_PROGRESS"
)