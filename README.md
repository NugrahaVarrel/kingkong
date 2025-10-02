1.) Encapsulation (Varrel)
2.) Abstraction (Mike)
3) Perpustakaan Pro — Peminjaman & Denda (Varrel)
Cerita: Sekolah ingin sistem perpustakaan: simpan buku, data anggota, transaksi pinjam/kembali, plus denda jika telat.
Fokus OOP: class/object, data class, interface (rule denda), polymorphism (anggota: Siswa/Guru), object singleton (Repo/Service), encapsulation.
Wajib pakai:
•	data class untuk entitas (Buku, Anggota, Transaksi)
•	interface untuk strategi denda (mis. PenaltyRule)
•	open/override untuk beda perilaku Siswa vs Guru
•	object untuk LibraryService (singleton)
•	Visibility (private, internal) pada koleksi data
Fitur minimal:
1.	Tambah buku & anggota.
2.	Pinjam buku → stok berkurang; Kembali buku → stok naik.
3.	Hitung denda berdasarkan hari telat:
o	Siswa: Rp1.000/hari
o	Guru: Rp500/hari
4.	Laporan ringkas: total buku, buku terpinjam, top 3 buku paling sering dipinjam.
Tantangan lanjutan (pilih ≥1):
•	Batasi max pinjaman (Siswa 3, Guru 5).
•	Blacklist jika telat > 7 hari.
•	Export laporan (cukup print format tabel di console).
________________________________________
4) Kebun Binatang Ops — Registrasi & Jadwal Pakan (Mike)
Cerita: Kebun binatang butuh sistem untuk mencatat hewan, jadwal pakan, dan suara khas tiap hewan. Ada mamalia, burung, reptil—tiap kategori punya cara pakan/riwayat berbeda.
Fokus OOP: inheritance/polymorphism, interface (suara/perilaku), sealed class (opsional untuk kategori), encapsulation, companion object (ID generator).
Wajib pakai:
•	Hierarki class: Hewan (open/abstract) → Mamalia, Burung, Reptil
•	interface Suara { fun bunyi(): String }
•	Polymorphism: daftar List<Hewan> loop panggil metode yang di-override
•	companion object untuk generator ID hewan
Fitur minimal:
1.	Tambah hewan (nama, umur, kategori).
2.	Jadwal pakan harian (jam integer) per hewan.
3.	Cetak “parade suara” (urut ID): tampilkan nama + bunyi().
4.	Laporan pakan hari ini: daftar hewan & jam pakan.
Tantangan lanjutan (pilih ≥1):
•	Validasi jadwal tidak bentrok (hewan yang sama).
•	Filter laporan per kategori.
•	Hitung konsumsi pakan total per hari (mis. mamalia 2 porsi, burung 1, reptil 0.5).
5) Photo Notes (Camera/Picker Simulation) (Varrel)
Mahasiswa ingin membuat catatan dengan foto.
•	Di halaman utama, user mengisi judul catatan, lalu menekan tombol Tambah Foto.
•	Halaman kedua muncul, seolah-olah memilih foto, dan mengembalikan URI foto palsu (dummy string).
•	Dengan judul dan foto itu, user bisa membuka halaman ringkasan untuk menampilkan catatan lengkap (judul + foto/URI).
Tugas: Buat aplikasi tiga Activity yang mendukung alur membuat catatan dengan foto dummy.
________________________________________
6) Task Manager (Status Update) (Mike)
Mahasiswa membuat aplikasi sederhana untuk mencatat tugas harian.
•	Di halaman utama, user menulis judul tugas dan memilih prioritas (Low/Medium/High).
•	Di halaman kedua, user bisa menekan tombol untuk mengubah status tugas menjadi IN_PROGRESS atau DONE. Status ini dikirim balik ke halaman utama.
•	Halaman ketiga menampilkan histori tugas lengkap: judul, prioritas, dan status terakhir.
Tugas: Buat aplikasi tiga Activity yang mendukung alur pencatatan tugas ini, lengkap dengan perubahan statusnya.
7) “Photo Notes: Filter Tampilan & Database Catatan” (Varrel)
Tujuan: Simpan preferensi filter dan catatan lokal.
•	SP: FILTER_TEXT (untuk pencarian), GRID_MODE (Boolean).
•	Room (Entity): Note(id:Long, title:String, photoUri:String, createdAt:Long).
•	Alur: Main simpan preferensi filter & grid di SP → ke Second untuk “pilih foto dummy” (URI), insert Note ke Room → Third menampilkan list Note dari Room yang difilter berdasarkan FILTER_TEXT SP, mode grid/list mengikuti GRID_MODE SP.
•	Tugas:
i.	Main: UI filter & toggle grid, simpan ke SP saat berubah.
ii.	Second: hasil pilih foto (dummy) → insert ke Room.
iii.	Third: baca FILTER_TEXT, GRID_MODE dari SP lalu query Room (LIKE) & atur layout manager (Grid/Linear).
•	Goals:
o	Preferensi tampilan/teks bertahan (SP).
o	List catatan muncul sesuai filter & mode dari SP (data dari Room).
________________________________________
8) “Task Manager: Preferensi Sortir & Daftar Tugas” (Mike)
Tujuan: Simpan preferensi urutan dan tugas lokal.
•	SP: SORT_BY ("created" / "priority"), SHOW_DONE (Boolean).
•	Room (Entity): Task(id:Long, title:String, priority:Int, done:Boolean, createdAt:Long).
•	Alur: Main menyimpan preferensi sortir & “tampilkan selesai” di SP → ke Second untuk ubah status task (IN_PROGRESS/DONE) → perubahan update di Room → Third menampilkan daftar task dengan query sesuai preferensi SP (order by & where done).
•	Tugas:
i.	Main: kontrol sortir & toggle SHOW_DONE, simpan ke SP.
ii.	Second: pilih task (by id extras), update done di Room, return status.
iii.	Third: baca preferensi SP → query Room dinamis (ORDER BY, WHERE) → tampilkan ke RecyclerView.
•	Goals:
o	Perubahan preferensi mengubah urutan/penyaringan.
o	Update status task di Room tercermin pada tampilan Third.
