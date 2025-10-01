package com.example.taskmanager.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.taskmanager.entity.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks ORDER by id ASC")
    fun getAllTask(): List<Task>

    @Update
    fun updateTask(task: Task)

    @Insert
    fun insertTask(task: Task) : Long

    @Query("SELECT * FROM tasks WHERE id = :taskId LIMIT 1")
    fun getTaskById(taskId: Int): Task

    @Query("SELECT * FROM tasks WHERE (:showDone = 1 OR done = 0) ORDER BY CASE WHEN :sortBy = 'priority' THEN taskPriority END DESC, CASE WHEN :sortBy = 'created' THEN createdAt END DESC")
    fun getTasksFiltered(sortBy: String, showDone: Boolean): List<Task>

    @Query("SELECT * FROM tasks WHERE done = :showDone")
    fun getTasksByDone(showDone: Boolean): List<Task>

    @Query("SELECT * FROM tasks WHERE (:showDone = 1 OR done = 0) ORDER BY taskPriority DESC")
    fun getTasksSortedByPriority(showDone: Boolean): List<Task>

    @Query("SELECT * FROM tasks WHERE (:showDone = 1 OR done = 0) ORDER BY createdAt DESC")
    fun getTasksSortedByCreated(showDone: Boolean): List<Task>
}