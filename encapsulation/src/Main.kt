fun main() {
    val student = Student("Varrel", 20)

    // Akses lewat getter
    println("Nama: ${student.getName()}")
    println("Umur: ${student.getAge()}")

    // Ubah umur lewat setter
    student.setAge(21)
    println("Umur setelah diubah: ${student.getAge()}")

    // Coba set umur tidak valid
    student.setAge(-5)



    println()
    println("=== Public ===")

    val student2 = StudentPublic("Varrel", 20)

    // Akses langsung (public)
    println("Nama awal: ${student2.name}")   // Getter jalan otomatis
    println("Umur awal: ${student2.age}")

    // Ubah langsung (public) tapi tetap tervalidasi
    student2.name = "Firhan"   // Setter jalan
    student2.age = 21          // Setter jalan (valid)
    student2.age = -5          // Setter jalan (invalid)

    println("Nama akhir: ${student2.name}")
    println("Umur akhir: ${student2.age}")


//    println(student.name) akan error
//    println(student.age) akan error

//    val derived = Derived()
//    derived.accessEncapsulatedProperties()
//
//    println(derived.myPublicProperty)
//    println(derived.myInternalProperty)
}
