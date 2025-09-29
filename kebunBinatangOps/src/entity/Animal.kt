package entity

import util.Util

interface Noice{
    fun sound(): String
}

abstract class Animal (
    val id: Int = Util.createID(),
    val name: String,
    val age: Int
): Noice {
    private val feedSchedule = mutableListOf<Int>()
    abstract val category: String

    fun addFeedSchedule(hour: Int){
        feedSchedule.add(hour)
    }

    fun getFeedSchedule(): List<Int> = feedSchedule.toList()
}