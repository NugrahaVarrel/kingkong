import java.time.LocalDate

data class Book(val id: Int, val judul: String, var stok: Int, var totalDipinjam: Int = 0)

open class Member(val id: Int, val nama: String) {
    open val maxPinjam = 0
}
class Siswa(id: Int, nama: String) : Member(id, nama) { override val maxPinjam = 3 }
class Guru(id: Int, nama: String) : Member(id, nama) { override val maxPinjam = 5 }

data class Transaksi(
    val id: Int,
    val member: Member,
    val book: Book,
    val tanggalPinjam: LocalDate,
    var tanggalKembali: LocalDate? = null,
    var denda: Int = 0
)
