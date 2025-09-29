package entity

import util.Util


class Burung(name: String, age: Int) : Animal(name = name, age=age) {
    override val category = "burung"
    override fun sound(): String = "chirp-chirp"
}
