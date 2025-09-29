import java.time.LocalDate
import java.time.temporal.ChronoUnit

object LibraryService {
    private val bookRepo = mutableListOf<Book>()
    private val memberRepo = mutableListOf<Member>()
    private val transaksiRepo = mutableListOf<Transaksi>()
    private val blacklist = mutableListOf<Member>()
    private var nextId = 1

    fun addBook(judul: String) {
        bookRepo.add(Book(bookRepo.size + 1, judul, 1, 0))
        println("✅ Buku '$judul' ditambahkan.")
    }

    fun addMember(nama: String) {
        memberRepo.add(Member(memberRepo.size + 1, nama))
        println("✅ Member '$nama' ditambahkan.")
    }

    fun pinjam(memberId: Int, bookId: Int) {
        val member = memberRepo.find { it.id == memberId }
        val book = bookRepo.find { it.id == bookId }

        if (member == null || book == null) return println("❌ Member atau buku tidak ditemukan")
        if (book.stok <= 0) return println("❌ Buku '${book.judul}' stok habis")

        nextId++
        transaksiRepo.add(
            Transaksi(nextId, member, book, LocalDate.now())
        )
        book.stok--
        book.totalDipinjam++
        println("✅ ${member.nama} meminjam buku '${book.judul}'")
    }

    fun CalculateDendaSiswa(memberId: Int) {
        var totalHutang = 0
        for (transaksi in transaksiRepo) {
            if (transaksi.member.id == memberId && transaksi.tanggalKembali != null) {
                val hariTelat = ChronoUnit.DAYS.between(transaksi.tanggalKembali, LocalDate.now())
                if (hariTelat > 0) totalHutang += (hariTelat * 1000).toInt()
            }
        }
        println("💰 Total denda siswa dengan ID $memberId = Rp$totalHutang")
    }

    fun CalculateDendaGuru(memberId: Int) {
        var totalHutang = 0
        for (transaksi in transaksiRepo) {
            if (transaksi.member.id == memberId && transaksi.tanggalKembali != null) {
                val hariTelat = ChronoUnit.DAYS.between(transaksi.tanggalKembali, LocalDate.now())
                if (hariTelat > 0) totalHutang += (hariTelat * 500).toInt()
            }
        }
        println("💰 Total denda guru dengan ID $memberId = Rp$totalHutang")
    }

    fun getLaporan() {
        println("===== Laporan Ringkas =====")
        println("Jumlah Buku : ${bookRepo.size}")
        println("Jumlah Buku Terpinjam : ${transaksiRepo.size}")
        println("Top Buku Paling Sering Dipinjam:")
        bookRepo.sortedByDescending { it.totalDipinjam }
            .take(3)
            .forEachIndexed { i, b ->
                println("${i + 1}. ${b.judul} (${b.totalDipinjam} kali)")
            }
    }
}
