# 1) Perpustakaan Pro — Peminjaman & Denda

**Cerita:** Sekolah ingin sistem perpustakaan: simpan buku, data anggota, transaksi pinjam/kembali, plus denda jika telat.

**Fokus OOP:** class/object, **data class**, **interface** (rule denda), **polymorphism** (anggota: Siswa/Guru), **object singleton** (Repo/Service), **encapsulation**.

**Wajib pakai:**

- `data class` untuk entitas (Buku, Anggota, Transaksi)
- `interface` untuk strategi denda (mis. `PenaltyRule`)
- `open/override` untuk beda perilaku Siswa vs Guru
- `object` untuk `LibraryService` (singleton)
- Visibility (`private`, `internal`) pada koleksi data

**Fitur minimal:**

1. Tambah buku & anggota.
2. Pinjam buku → stok berkurang; Kembali buku → stok naik.
3. Hitung denda berdasarkan hari telat:

   - Siswa: Rp1.000/hari
   - Guru: Rp500/hari

4. Laporan ringkas: total buku, buku terpinjam, top 3 buku paling sering dipinjam.

**Tantangan lanjutan (pilih ≥1):**

- Batasi max pinjaman (Siswa 3, Guru 5).
- Blacklist jika telat > 7 hari.
- Export laporan (cukup print format tabel di console).

---

# 2) Kebun Binatang Ops — Registrasi & Jadwal Pakan

**Cerita:** Kebun binatang butuh sistem untuk mencatat hewan, jadwal pakan, dan suara khas tiap hewan. Ada mamalia, burung, reptil—tiap kategori punya cara pakan/riwayat berbeda.

**Fokus OOP:** **inheritance/polymorphism**, **interface** (suara/perilaku), **sealed class** (opsional untuk kategori), **encapsulation**, **companion object** (ID generator).

**Wajib pakai:**

- Hierarki class: `Hewan` (open/abstract) → `Mamalia`, `Burung`, `Reptil`
- `interface Suara { fun bunyi(): String }`
- Polymorphism: daftar `List<Hewan>` loop panggil metode yang di-override
- `companion object` untuk generator ID hewan

**Fitur minimal:**

1. Tambah hewan (nama, umur, kategori).
2. Jadwal pakan harian (jam integer) per hewan.
3. Cetak “parade suara” (urut ID): tampilkan `nama` + `bunyi()`.
4. Laporan pakan hari ini: daftar hewan & jam pakan.

**Tantangan lanjutan (pilih ≥1):**

- Validasi jadwal tidak bentrok (hewan yang sama).
- Filter laporan per kategori.
- Hitung konsumsi pakan total per hari (mis. mamalia 2 porsi, burung 1, reptil 0.5).

# 3) Kasir Toko — Keranjang, Diskon, & Struk

**Cerita:**
Sebuah toko ingin aplikasi kasir sederhana: catat produk, keranjang belanja, terapkan berbagai jenis diskon, dan cetak struk yang rapi.

**Fokus OOP:** **data class** (entitas), **interface** (strategi diskon), **polymorphism** (beragam diskon), **object singleton** (Kasir/Service), **encapsulation** (koleksi item keranjang), **companion object** (opsional: generator kode struk).

**Wajib pakai:**

- `data class` untuk entitas: `Produk`, `ItemKeranjang`, (opsional) `Struk`.
- `interface Diskon { fun hitung(subtotal: Int): Int }` dengan implementasi: `TanpaDiskon`, `DiskonPersen`, `DiskonNominal`.
- `class Keranjang` dengan koleksi privat (`private`) untuk item & method: `tambah`, `hapus`, `totalKotor`, `totalBersih(diskon)`.
- `object Kasir` (singleton) untuk `checkout(keranjang, diskon)` yang mencetak struk.
- Visibility (`private`, `internal`) pada koleksi data/utility.

**Fitur minimal:**

1. Tambah/hapus produk di keranjang (merge qty jika produk sama).
2. Hitung subtotal, terapkan diskon, dan tampilkan **struk** (nama, qty, harga, subtotal, potongan, total).
3. Dua mode diskon minimal: **persen** (mis. 10%) dan **nominal** (mis. Rp20.000).
4. **Validasi:** total bersih tidak boleh negatif.

**Tantangan lanjutan (pilih ≥1):**

Diskon bertingkat (≥ 300k diskon 5%, ≥ 500k diskon 10%).

Voucher code (mapping code → strategi diskon).

Pajak PPN setelah diskon (mis. 11%).

---

# 4) Klinik Sehat — Antrian Dokter, Janji Temu, & Tagihan

**Cerita:**
Sebuah klinik membutuhkan sistem: daftar pasien & dokter, buat janji temu (appointment), kelola antrian per dokter, dan hitung tagihan dengan kebijakan asuransi berbeda.

**Fokus OOP:** **class/object**, **data class** (entitas), **interface** (kebijakan pembayaran/asuransi), **polymorphism** (tipe asuransi), **object singleton** (ClinicService), **encapsulation** (koleksi & validasi), **inheritance** ringan (opsional untuk dokter spesialis/umum).

**Wajib pakai:**

- `data class` untuk: `Pasien`, `Dokter`, `JanjiTemu`, `Tagihan`.
- `interface Pembayaran { fun hitungBiaya(dasar: Int): Int }` dengan implementasi: `Tunai`, `AsuransiBPJS`, `AsuransiSwasta`.
- `object ClinicService` (singleton) menyimpan koleksi privat pasien/dokter/janji & menyediakan API: tambah pasien/dokter, buat janji, proses pembayaran.
- Encapsulation & validasi: jam janji (0–23), **tidak bentrok** untuk dokter yang sama pada jam yang sama.
- (Opsional) `open class Dokter` → `DokterUmum`, `DokterSpesialis` dengan biaya dasar berbeda (override via properti/method).

**Fitur minimal:**

1. Tambah pasien & dokter.
2. Buat janji temu: pilih dokter, pasien, dan jam → **tolak** jika bentrok.
3. Hitung biaya dasar kunjungan (mis. umum: 100k, spesialis: 200k).
4. Terapkan kebijakan pembayaran:

   - `Tunai` → bayar penuh.
   - `AsuransiBPJS` → diskon 100% untuk jasa dokter (mis. obat tetap bayar, boleh disederhanakan nol).
   - `AsuransiSwasta` → diskon persentase (mis. 70% ditanggung, pasien bayar 30%).

5. Laporan ringkas harian: total janji per dokter, total pemasukan kas, dan 3 dokter dengan janji terbanyak.

**Tantangan lanjutan (pilih ≥1):**

- Batas antrian per dokter per hari (mis. maksimal 10).
- Denda pembatalan mendadak (no-show) → tambahkan pada `Tagihan`.
- Export laporan ringkas (print tabel di console).
- (Opsional) Prioritas pasien lansia → antrean diurutkan berdasarkan prioritas.

---
