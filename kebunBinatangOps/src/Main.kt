import service.ActionService
import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val scanner = Scanner(System.`in`)
    val service = ActionService()

    while (true) {
        println(
            """
            === 🐾 Kebun Binatang Menu ===
            1. Tambah Hewan
            2. Tambah Jadwal Pakan
            3. Parade Suara
            4. Laporan Pakan
            0. Keluar
            ------------------------------
            Pilih menu: 
            """.trimIndent()
        )

        when (scanner.nextInt()) {
            1 -> {
                scanner.nextLine() // consume newline
                print("Masukkan kategori (mamalia/burung/reptil): ")
                val kategori = scanner.nextLine()

                print("Masukkan nama: ")
                val nama = scanner.nextLine()

                print("Masukkan umur: ")
                val umur = scanner.nextInt()

                service.createData(nama, kategori, umur)
                println("✅ Hewan berhasil ditambahkan!\n")
            }

            2 -> {
                print("Masukkan ID hewan: ")
                val id = scanner.nextInt()

                print("Masukkan jam pakan: ")
                val jam = scanner.nextInt()

                service.addFeedSchedule(id, jam)
                println("✅ Jadwal pakan ditambahkan!\n")
            }

            3 -> {
                println()
                service.soundParade()
            }

            4 -> {
                println()
                service.report()
            }

            0 -> {
                println("👋 Keluar dari program...")
                return
            }

            else -> println("❌ Pilihan tidak valid, coba lagi!\n")
        }
    }

}