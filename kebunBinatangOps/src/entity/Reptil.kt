package entity

import util.Util


class Reptil(name:String, age: Int) : Animal(name=name, age=age) {
    override val category = "reptil"
    override fun sound(): String = "reptile sound"
}