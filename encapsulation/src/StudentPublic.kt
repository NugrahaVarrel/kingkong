class StudentPublic(initialName: String, initialAge: Int) {
    var name: String = initialName
        get() = field
        set(value) {
            println("👉 Nama diubah: $field -> $value")
            field = value
        }

    var age: Int = initialAge
        get() = field
        set(value) {
            if (value > 0) {
                println("Umur berhasil diubah: $field -> $value")
                field = value
            } else {
                println("Umur tidak valid, harus > 0")
            }
        }
}