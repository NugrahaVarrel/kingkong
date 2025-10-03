# 🚀 OOP & Android Assignments

Repository ini berisi kumpulan tugas pemrograman berbasis **Object-Oriented Programming (OOP)** dan **Android Development**.  
Setiap folder berisi project terpisah dengan fokus konsep berbeda.  

---

## 📂 Struktur Project

- ├── [1-encapsulation-varrel/](https://github.com/NugrahaVarrel/kingkong/tree/main/1-encapsulation-varrel/)
- ├── [2-abstraction-mike/](https://github.com/NugrahaVarrel/kingkong/tree/main/2-abstraction-mike/)
- ├── [3-perpustakaan-pro-varrel/](https://github.com/NugrahaVarrel/kingkong/tree/main/3-perpustakaan-pro-varrel/)
- ├── [4-kebun-binatang-mike/](https://github.com/NugrahaVarrel/kingkong/tree/main/4-kebun-binatang-mike/)
- ├── [5-photo-notes-varrel/](https://github.com/NugrahaVarrel/kingkong/tree/main/5-photo-notes-varrel/)
- ├── [6-task-manager-mike/](https://github.com/NugrahaVarrel/kingkong/tree/main/6-task-manager-mike/)
- ├── [7-photo-notes-db-varrel/](https://github.com/NugrahaVarrel/kingkong/tree/main/7-photo-notes-db-varrel/)
- ├── [8-task-manager-db-mike/](https://github.com/NugrahaVarrel/kingkong/tree/main/8-task-manager-db-mike/)

---

## 📝 Deskripsi Tugas

### 1. [Encapsulation](https://github.com/NugrahaVarrel/kingkong/tree/main/1-encapsulation-varrel/) (Varrel)
Implementasi prinsip **encapsulation** menggunakan `private` field dan public method.  
Contoh: class dengan variabel tersembunyi (hidden) dan getter/setter.  

---

### 2. [Abstraction](https://github.com/NugrahaVarrel/kingkong/tree/main/2-abstraction-mike/) (Mike)
Implementasi **abstraction** dengan `abstract class` & `interface`.  
Memisahkan definisi (kontrak) dan implementasi.  

---

### 3. [Perpustakaan Pro — Peminjaman & Denda](https://github.com/NugrahaVarrel/kingkong/tree/main/3-perpustakaan-pro-varrel/) (Varrel)
- Fitur:
  - Tambah buku & anggota
  - Pinjam/Kembalikan buku (stok otomatis)
  - Hitung denda (Siswa: Rp1.000/hari, Guru: Rp500/hari)
  - Laporan ringkas (total buku, terpinjam, top 3 populer)
- OOP Concepts:  
  `data class`, `interface`, `object singleton`, `open/override`, `encapsulation`.

---

### 4. [Kebun Binatang Ops — Registrasi & Jadwal Pakan](https://github.com/NugrahaVarrel/kingkong/tree/main/4-kebun-binatang-mike/) (Mike)
- Fitur:
  - Registrasi hewan (Mamalia, Burung, Reptil)
  - Jadwal pakan harian
  - Parade suara hewan
- OOP Concepts:  
  inheritance, polymorphism, `interface`, `companion object`.

---

### 5. [Photo Notes](https://github.com/NugrahaVarrel/kingkong/tree/main/5-photo-notes-varrel/) (Varrel)
Aplikasi Android (3 Activity):
1. Main → input judul + tambah foto  
2. Second → pilih foto dummy (URI palsu)  
3. Third → tampilkan catatan (judul + foto)  

---

### 6. [Task Manager](https://github.com/NugrahaVarrel/kingkong/tree/main/6-task-manager-mike/) (Mike)
Aplikasi Android (3 Activity):
1. Main → buat task + pilih prioritas  
2. Second → update status (IN_PROGRESS / DONE)  
3. Third → histori lengkap (judul, prioritas, status)  

---

### 7. [Photo Notes: Filter & Database](https://github.com/NugrahaVarrel/kingkong/tree/main/7-photo-notes-db-varrel/) (Varrel)
- SharedPreferences untuk filter & grid mode  
- Room Database untuk catatan  
- RecyclerView untuk list sesuai filter  

---

### 8. [Task Manager: Sortir & Database](https://github.com/NugrahaVarrel/kingkong/tree/main/8-task-manager-db-mike/) (Mike)
- SharedPreferences untuk sorting & show/hide DONE  
- Room Database untuk menyimpan task  
- RecyclerView dengan query dinamis  

---

## 📌 Catatan

### Project OOP (Kotlin CLI)
- Setiap project menekankan konsep OOP/Android berbeda.
- Beberapa memiliki tantangan lanjutan (opsional).
- Struktur code dibuat modular & mudah diperluas.
