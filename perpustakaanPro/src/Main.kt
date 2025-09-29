fun main() {
    var isContinue = true
    while (isContinue) {
        println(
            """
            ====== MENU ======
            a. Tambah Buku
            b. Pinjam Buku
            c. Tambah Member
            d. Laporan Ringkas
            e. Hitung Denda Siswa
            f. Hitung Denda Guru
            x. Keluar
            =================
        """.trimIndent()
        )

        print("Inputan: ")
        when (readlnOrNull()?.lowercase()) {
            "a" -> {
                print("Judul: ")
                val inputanJudul = readlnOrNull() ?: ""
                LibraryService.addBook(inputanJudul)
            }
            "b" -> {
                print("Member id: ")
                val inputanMember = readlnOrNull()?.toIntOrNull() ?: 0
                print("Book id: ")
                val inputanBook = readlnOrNull()?.toIntOrNull() ?: 0
                LibraryService.pinjam(inputanMember, inputanBook)
            }
            "c" -> {
                print("Nama: ")
                val inputanNewMember = readlnOrNull() ?: ""
                LibraryService.addMember(inputanNewMember)
            }
            "d" -> {
                LibraryService.getLaporan()
            }
            "e" -> {
                print("Member id Siswa: ")
                val inputanDendaSiswa = readlnOrNull()?.toIntOrNull() ?: 0
                LibraryService.CalculateDendaSiswa(inputanDendaSiswa)
            }
            "f" -> {
                print("Member id Guru: ")
                val inputanDendaGuru = readlnOrNull()?.toIntOrNull() ?: 0
                LibraryService.CalculateDendaGuru(inputanDendaGuru)
            }
            "x" -> {
                println("👋 Program selesai.")
                isContinue = false
            }
            else -> println("❌ Pilihan tidak valid")
        }
    }
}
