package com.example.taskmanager.util

class Util {
    companion object{
        var counter = 0
        fun generateId():Int{
            counter++
            return counter
        }
    }
}