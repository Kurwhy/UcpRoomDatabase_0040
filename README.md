# 🏥 Doctor Schedule Management

### Android Application with Kotlin, Jetpack Compose & Room Database

**Doctor Schedule Management** adalah aplikasi Android yang dikembangkan menggunakan **Kotlin** dan **Jetpack Compose** untuk mengelola data dokter serta jadwal praktik melalui penyimpanan database lokal menggunakan **Room Database**.

Proyek ini dibuat untuk mempraktikkan pengembangan aplikasi Android modern, pengelolaan formulir, validasi input, navigasi antarlayar, serta operasi pengelolaan data menggunakan database lokal.

---

## ✨ Fitur Utama

| Fitur | Deskripsi |
|---|---|
| Manajemen Dokter | Menampilkan dan menambahkan data dokter |
| Validasi Formulir | Memastikan kolom wajib diisi sebelum data diproses |
| Manajemen Jadwal | Menambahkan dan menampilkan jadwal praktik |
| Pemilihan Dokter | Memilih dokter melalui dropdown berdasarkan data dokter yang tersedia |
| Detail Jadwal | Melihat informasi lengkap jadwal praktik |
| Update Status | Mengubah status jadwal |
| Hapus Jadwal | Menghapus data dengan dialog konfirmasi |
| Room Database | Penyimpanan data lokal pada perangkat Android |

---

## 📱 Dokumentasi Tampilan Aplikasi

### 1. Halaman Utama Dokter

Halaman ini menampilkan daftar data dokter yang tersedia. Pengguna dapat melihat informasi dokter dan mengakses fitur penambahan data.

![Home Dokter](https://github.com/user-attachments/assets/0ebdcf70-d30b-44dc-9662-73f6b9c20f4d)

### 2. Validasi Formulir Dokter

Aplikasi menyediakan validasi untuk memastikan informasi dokter yang wajib diisi tidak dibiarkan kosong. Pesan validasi membantu pengguna memperbaiki input sebelum menyimpan data.

![Validasi Data Dokter](https://github.com/user-attachments/assets/ccb5768c-482d-4645-b681-dfd9369fe541)

### 3. Form Input Dokter

Halaman ini digunakan untuk menambahkan data dokter baru melalui formulir yang tersedia.

![Input Dokter](https://github.com/user-attachments/assets/e38e2a02-47e0-492b-a24a-a114e90aecdf)

### 4. Hasil Penambahan Dokter

Setelah data berhasil dimasukkan, informasi dokter baru ditampilkan pada halaman daftar dokter.

![Data Dokter Berhasil Ditambahkan](https://github.com/user-attachments/assets/3763b794-da12-462d-95df-3afb1a55add7)

---

## 📅 Manajemen Jadwal Praktik

### 5. Halaman Utama Jadwal

Halaman ini menampilkan daftar jadwal praktik yang tersedia dan menyediakan akses untuk mengelola data jadwal.

![Home Jadwal](https://github.com/user-attachments/assets/b5009cea-7566-409e-bae3-0279ec23f63c)

### 6. Validasi Formulir Jadwal

Formulir jadwal dilengkapi validasi untuk membantu memastikan informasi yang diperlukan telah diisi sebelum data disimpan.

![Validasi Jadwal](https://github.com/user-attachments/assets/331f4638-cdf3-42c9-aebb-df4b8b5d1832)

### 7. Dropdown Pemilihan Dokter

Saat membuat jadwal, pengguna dapat memilih nama dokter melalui dropdown yang menampilkan data dari daftar dokter.

Fitur ini memperlihatkan hubungan antara data dokter dan data jadwal pada antarmuka aplikasi.

![Dropdown Nama Dokter](https://github.com/user-attachments/assets/db7cc24b-fb16-427f-babf-d0938d01656f)

### 8. Hasil Penambahan Jadwal

Setelah formulir diisi, jadwal baru ditampilkan pada daftar jadwal yang tersedia.

![Data Jadwal Berhasil Ditambahkan](https://github.com/user-attachments/assets/eb3136b1-a0d7-441f-ba72-b4ad0df94e83)

### 9. Detail Jadwal

Halaman detail menampilkan informasi lebih lanjut mengenai jadwal praktik yang dipilih.

![Detail Jadwal](https://github.com/user-attachments/assets/f964e0bd-ba3f-4b06-b940-ef6a63b8bb1b)

### 10. Update Status Jadwal

Pengguna dapat mengubah status jadwal melalui antarmuka yang tersedia.

![Update Status Jadwal](https://github.com/user-attachments/assets/263690df-3ff6-482c-be06-c8a74f53cc81)

### 11. Hasil Perubahan Status

Setelah proses perubahan, aplikasi menampilkan status jadwal yang telah diperbarui.

![Status Jadwal Berhasil Diperbarui](https://github.com/user-attachments/assets/2eed627f-dc41-4cd5-8650-25ec4e99e5a8)

### 12. Konfirmasi Penghapusan

Sebelum menghapus jadwal, aplikasi menampilkan dialog konfirmasi untuk memastikan tindakan pengguna.

![Konfirmasi Hapus Jadwal](https://github.com/user-attachments/assets/0553bfb0-a9f7-4919-b0dd-f899af8cb087)

### 13. Hasil Penghapusan Jadwal

Setelah pengguna mengonfirmasi penghapusan, daftar jadwal menampilkan kondisi terbaru tanpa data yang telah dihapus.

![Data Jadwal Berhasil Dihapus](https://github.com/user-attachments/assets/68229497-e49d-40ca-b5c6-9fe7beec35a9)

---

## 🛠️ Teknologi yang Digunakan

| Teknologi | Kegunaan |
|---|---|
| Kotlin | Bahasa pemrograman utama |
| Android SDK | Platform pengembangan Android |
| Jetpack Compose | Pembuatan antarmuka deklaratif |
| Material Design 3 | Komponen UI aplikasi |
| Room Database | Penyimpanan data lokal berbasis SQLite |
| Room KTX | Dukungan integrasi Room dengan Kotlin |
| Kotlin Symbol Processing (KSP) | Pemrosesan anotasi Room |
| ViewModel | Pengelolaan state pada lapisan presentasi |
| Navigation Compose | Navigasi antarlayar |
| Gradle Kotlin DSL | Pengelolaan konfigurasi build |

---

## 🔄 Alur Penggunaan

```text
Aplikasi
   │
   ├── Data Dokter
   │      ├── Lihat Daftar Dokter
   │      ├── Tambah Dokter
   │      └── Validasi & Simpan
   │
   └── Data Jadwal
          ├── Lihat Daftar Jadwal
          ├── Tambah Jadwal
          │      └── Pilih Dokter
          ├── Lihat Detail
          ├── Update Status
          └── Hapus Jadwal
                 └── Konfirmasi
```

---

## 🚀 Instalasi dan Menjalankan Aplikasi

### Persyaratan

- Android Studio.
- Android SDK yang kompatibel dengan project.
- JDK sesuai konfigurasi Gradle.
- Emulator Android atau perangkat Android fisik.

### 1. Clone Repository

```bash
git clone https://github.com/Kurwhy/UcpRoomDatabase_0040.git
cd UcpRoomDatabase_0040
```

### 2. Buka Project

Buka **Android Studio**, pilih **Open**, lalu arahkan ke folder project.

### 3. Sinkronisasi Gradle

Tunggu proses Gradle Sync hingga seluruh dependency selesai diunduh dan dikonfigurasi.

### 4. Jalankan Aplikasi

Pilih emulator atau perangkat Android, kemudian klik **Run** di Android Studio.

Aplikasi menggunakan Room sebagai database lokal, sehingga pengembangan fitur penyimpanan datanya tidak memerlukan server database eksternal.

---

## 📂 Struktur Project

```text
UcpRoomDatabase_0040/
├── app/
│   └── src/
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── README.md
```

---

## 🎯 Tujuan Pengembangan

Proyek ini dibuat sebagai praktik pengembangan aplikasi Android menggunakan Kotlin, Jetpack Compose, dan Room Database, dengan fokus pada:

- Pengelolaan data melalui database lokal.
- Pembuatan antarmuka berbasis Compose.
- Validasi formulir input.
- Penyajian daftar dan detail data.
- Pemilihan data dokter pada formulir jadwal.
- Pembaruan status jadwal.
- Implementasi konfirmasi sebelum penghapusan.
- Navigasi antarlayar dan pengelolaan state.

---

## 👨‍💻 Developer

**Kurwhy**

GitHub: [github.com/Kurwhy](https://github.com/Kurwhy)

Repository: [UcpRoomDatabase_0040](https://github.com/Kurwhy/UcpRoomDatabase_0040)

---

*Developed with Kotlin, Jetpack Compose & Room Database.*
