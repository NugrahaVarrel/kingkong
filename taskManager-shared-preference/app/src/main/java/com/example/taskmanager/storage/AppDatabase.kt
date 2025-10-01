package com.example.taskmanager.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskmanager.dao.TaskDao
import com.example.taskmanager.entity.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun TaskDao() : TaskDao

    companion object{
        @Volatile private var INSTANCE: AppDatabase ? = null

        fun get(ctx: Context): AppDatabase =
            INSTANCE?: synchronized(this){
                INSTANCE?: Room.databaseBuilder(
                    ctx.applicationContext,
                    AppDatabase::class.java,
                    "task-manager-db"
                )
                    .allowMainThreadQueries()
                    .build().also { INSTANCE = it }
            }
    }
}