## Exercise: Deklarasi & Inisialisasi di Kotlin

### 🔹 Bagian 1 — Dasar (Data Type & Print)

1. Deklarasikan variabel `studentName` dengan tipe **String** dan inisialisasikan dengan nama kamu sendiri. Cetak hasilnya.
2. Deklarasikan variabel `age` dengan tipe **Int** dan isi dengan umur kamu. Cetak hasilnya.
3. Buat variabel `temperature` dengan tipe **Float**, isi dengan nilai suhu 36.7, lalu cetak.
4. Buat variabel `isGraduated` dengan tipe **Boolean**, isi dengan `false`, lalu cetak.
5. Deklarasikan variabel `grade` dengan tipe **Char** dan isi dengan huruf `'A'`. Cetak.

---

### 🔹 Bagian 2 — Numeric Types

1. Buat variabel `population` dengan tipe **Long** dan isi dengan `273_000_000`.
2. Buat variabel `smallNumber` dengan tipe **Short** dan isi dengan `32000`.
3. Buat variabel `tinyValue` dengan tipe **Byte** dan isi dengan `127`.
4. Cetak ketiga variabel di atas dalam satu baris menggunakan **string template**.

---

### 🔹 Bagian 3 — Nullable

1. Deklarasikan variabel `nickname` bertipe **String?** dan beri nilai `null`.
2. Setelah itu, isi `nickname` dengan nama panggilan kamu.
3. Cetak nilai `nickname` sebelum dan sesudah diisi.

---

### 🔹 Bagian 4 — Array & Collection

1. Buat array `numbers` berisi angka 1 sampai 5. Cetak semua elemen.
2. Buat `listOfFruits` dengan tipe **List<String>** berisi `"Apple"`, `"Banana"`, `"Mango"`. Cetak list tersebut.
3. Buat `mutableListOfScores` dengan tipe **MutableList<Int>**, isi dengan `80, 85, 90`. Tambahkan angka `95`, lalu cetak semua.
4. Buat `setOfNumbers` dengan isi `1,2,2,3,3,4`. Cetak hasilnya. Apakah ada elemen yang duplikat?
5. Buat `mapOfStudent` dengan isi: `"Math" to 90`, `"Science" to 85`. Cetak semua pasangan key-value.

---

### 🔹 Bagian 5 — Mix & Match

1. Deklarasikan variabel `city`, `year`, dan `pi` menggunakan **type inference** (tanpa menuliskan tipe datanya).

   - `city = "Jakarta"`
   - `year = 2025`
   - `pi = 3.14159`
     Cetak semua nilai dalam satu baris.

2. Buat variabel `isLoggedIn` dengan nilai `false`. Ubah nilainya menjadi `true` dan cetak sebelum & sesudah.
3. Buat variabel `charList` berisi huruf-huruf nama depanmu (contoh: `"K", "H", "A", "L", "I", "D"`) dalam bentuk **Array<Char>**. Cetak seluruh isi array.

---

### 🔹 Bagian 6 — Tantangan

1. Buat variabel `studentInfo` berupa **MutableMap<String, Any>**, dengan isi:

   - `"name"` → nama kamu (String)
   - `"age"` → umur kamu (Int)
   - `"score"` → nilai ujian (Double)
     Tambahkan key `"isGraduated"` dengan nilai Boolean, lalu cetak seluruh isi map.

2. Buat array `grades` berisi `A, B, C, D, E`. Cetak hanya nilai pertama dan terakhir.
3. Buat `MutableList<String>` bernama `hobbies`, isi dengan minimal 3 hobi kamu. Hapus satu hobi dari list, lalu cetak hasil akhirnya.

---
