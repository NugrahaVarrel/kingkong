class Student(private var name: String, private var age: Int) {

    // Getter
    fun getName(): String = name

    // Setter dengan validasi
    fun setAge(newAge: Int) {
        if (newAge > 0) {
            age = newAge
        } else {
            println("Umur tidak boleh negatif")
        }
    }

    fun getAge(): Int = age
}