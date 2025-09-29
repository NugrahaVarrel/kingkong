package util

class Util {
    companion object{
        private var counter = 0
        fun createID(): Int {
            counter++
            return counter
        }
    }
}