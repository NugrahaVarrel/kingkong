### 1) Event Registration

Kampusmu mengadakan **seminar besar**. Peserta harus mendaftar lewat aplikasi:

- Di halaman utama, peserta mengisi **nama** dan **email**.
- Saat menekan tombol **Kirim ke Panitia**, data dikirim ke halaman panitia untuk dikonfirmasi. Panitia lalu mengirim balasan berupa pesan bahwa data sudah diterima.
- Peserta juga bisa menekan tombol **Lihat Profil Pendaftaran** untuk masuk ke halaman profil, yang menampilkan ringkasan nama dan email, lalu mengembalikan pesan bahwa profil sudah ditampilkan.

**Tugas:** Buat alur tiga Activity yang bisa mengirim dan menerima data sesuai cerita di atas.

---

### 2) Movie Night Ticketing

Komunitas kampus mengadakan acara **nonton bareng film**. Sistem pemesanan tiket dibuat lewat aplikasi:

- Mahasiswa memilih **judul film** dan **jam tayang** di halaman utama.
- Saat menekan tombol **Konfirmasi**, data dikirim ke halaman konfirmasi untuk diterbitkan **kode booking**. Kode booking ini dikembalikan ke halaman utama.
- Dengan kode booking itu, mahasiswa bisa membuka halaman tiket untuk melihat detail tiket yang sudah dipesan.

**Tugas:** Buat aplikasi dengan tiga Activity yang mendukung proses pemesanan hingga tiket ditampilkan.

---

### 3) Food Order (Quick Lunch)

Kantin kampus menyediakan layanan **pre-order makan siang**.

- Mahasiswa menulis **menu** dan **catatan** (misalnya “pedas” atau “tanpa sambal”).
- Saat menekan tombol **Cek Harga**, data dikirim ke halaman konfirmasi. Sistem menghitung harga (boleh harga tetap sederhana) lalu mengembalikan total ke halaman utama.
- Mahasiswa bisa lanjut membuka halaman ringkasan untuk melihat menu, catatan, dan total harga.

**Tugas:** Buat aplikasi tiga Activity untuk mengatur alur pemesanan sederhana ini.

---

### 4) Campus Directions (Implicit + Explicit Intents)

Seorang mahasiswa baru ingin mencari **gedung kuliah**.

- Di halaman utama, ia mengisi **nama gedung** beserta **koordinat (lat, lng)**.
- Saat menekan tombol ke halaman kedua, aplikasi menampilkan ringkasan gedung dengan tombol **Buka Peta** yang menjalankan aplikasi Maps (implicit intent). Halaman ini mengembalikan status apakah peta berhasil dibuka.
- Ada juga halaman ketiga yang menampilkan detail lengkap gedung, lalu mengirimkan catatan balik ke halaman utama.

**Tugas:** Buat aplikasi tiga Activity yang memperlihatkan kombinasi intent eksplisit (antar Activity) dan intent implisit (buka Maps).

---

### 5) Photo Notes (Camera/Picker Simulation)

Mahasiswa ingin membuat **catatan dengan foto**.

- Di halaman utama, user mengisi **judul catatan**, lalu menekan tombol **Tambah Foto**.
- Halaman kedua muncul, seolah-olah memilih foto, dan mengembalikan **URI foto palsu** (dummy string).
- Dengan judul dan foto itu, user bisa membuka halaman ringkasan untuk menampilkan catatan lengkap (judul + foto/URI).

**Tugas:** Buat aplikasi tiga Activity yang mendukung alur membuat catatan dengan foto dummy.

---

### 6) Task Manager (Status Update)

Mahasiswa membuat aplikasi sederhana untuk **mencatat tugas harian**.

- Di halaman utama, user menulis **judul tugas** dan memilih **prioritas** (Low/Medium/High).
- Di halaman kedua, user bisa menekan tombol untuk mengubah status tugas menjadi **IN_PROGRESS** atau **DONE**. Status ini dikirim balik ke halaman utama.
- Halaman ketiga menampilkan histori tugas lengkap: judul, prioritas, dan status terakhir.

**Tugas:** Buat aplikasi tiga Activity yang mendukung alur pencatatan tugas ini, lengkap dengan perubahan statusnya.

---

Team:

1. roy, steven(1,2)
2. yehez, rian(3,4)
3. maik, varrel(5,6)
