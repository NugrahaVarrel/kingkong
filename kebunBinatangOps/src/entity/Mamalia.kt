package entity

import util.Util

class Mamalia (name:String, age:Int) : Animal(name = name, age=age) {
    override val category: String = "mamalia"
    override fun sound(): String = "snore-snore"
}