````markdown
# 🔄 Sinkronisasi Fork dengan Upstream Repository

Jika kamu telah melakukan fork terhadap repository `godzilla`, kamu bisa menyinkronkan perubahan dari repository utama (upstream) dengan langkah-langkah berikut:

## 📥 Tambahkan Remote Upstream

Tambahkan remote dari repository asli agar bisa mengambil perubahan terbaru.

```bash
git remote add upstream https://github.com/khalidalhabibie/godzilla
```
````

## 🔄 Ambil Perubahan dari Upstream

Ambil (fetch) semua update dari `upstream`.

```bash
git fetch upstream
```

## ⏩ Checkout ke Branch `master`

Pindah ke branch `master` (atau `main` tergantung nama branch default-mu).

```bash
git checkout master
```

## 🔀 Gabungkan Perubahan dari Upstream ke Local

Gabungkan branch `master` dari `upstream` ke dalam `master` lokal milikmu.

```bash
git merge upstream/master
```

> 💡 Jika branch utamamu bernama `main`, ganti `master` menjadi `main`.

## ✅ Selesai

Sekarang repository lokalmu telah disinkronkan dengan repository upstream. Kamu bisa melakukan push ke GitHub jika ingin memperbarui branch di remote GitHub-mu:

```bash
git push origin master
```

---

📌 **Catatan**:

- Pastikan tidak ada perubahan lokal yang belum di-commit sebelum melakukan merge.
- Jika terjadi konflik, selesaikan konflik tersebut terlebih dahulu sebelum melanjutkan proses merge.

```

Jika branch utamamu bernama `main` bukan `master`, beri tahu saja agar saya sesuaikan ya.
```
