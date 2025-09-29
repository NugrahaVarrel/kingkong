abstract class Calculator {
    abstract fun calculate(a: Int, b: Int)
}

class Add : Calculator() {
    override fun calculate(a: Int, b: Int) {
        println("Addition of two numbers ${a + b}")
    }
}

class Subtract : Calculator() {
    override fun calculate(a: Int, b: Int) {
        println("Subtraction of two numbers ${a - b}")
    }
}

class Multiply : Calculator() {
    override fun calculate(a: Int, b: Int) {
        println("Multiplication of two numbers ${a * b}")
    }
}

class Divide : Calculator() {
    override fun calculate(a: Int, b: Int) {
        println("Division of two numbers ${a / b}")
    }
}

fun main() {
    val add = Add()
    val sub = Subtract()
    val mul = Multiply()
    val div = Divide()

    add.calculate(5, 5)
    sub.calculate(10, 6)
    mul.calculate(10, 12)
    div.calculate(30, 10)
}