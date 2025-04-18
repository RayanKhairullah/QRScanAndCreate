# 📱 QR ScanAndCreate

Aplikasi _QR ScanAndCreate_ memungkinkan Anda memindai dan membuat QR/Barcode dengan mudah langsung dari ponsel Android Anda! 🚀

## 🎯 Fitur Utama

- **📸 Scan QR/Barcode**
  - Pindai kode menggunakan kamera perangkat.
  - Simpan hasil scan secara otomatis ke **Riwayat**.
  - **Salin** hasil scan ke clipboard sekali ketuk.

- **🖼️ Generate QR Code**
  - Buat QR Code dari teks atau tautan (URL).
  - Tampilkan preview dalam **CardView**.
  - **Unduh** QR Code ke folder Downloads.

- **📜 Riwayat Scan**
  - Lihat daftar hasil scan terbaru.
  - **Hapus** riwayat individual dengan konfirmasi.

## 🛠️ Persyaratan Sistem

- Android Studio (Arctic Fox atau lebih baru) 🏗️
- Java 11 ☕
- compileSdk 35, minSdk 24, targetSdk 35 📦
- Dependencies:
  ```groovy
  implementation "com.journeyapps:zxing-android-embedded:4.3.0"
  implementation "com.google.zxing:core:3.5.1"
  implementation "androidx.room:room-runtime:2.6.1"
  kapt "androidx.room:room-compiler:2.6.1"
  implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1"
  implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.6.1"
  implementation "com.google.android.material:material:1.12.0"
  ```

## 🚀 Instalasi

1. **Clone** repository:
   ```bash
   git clone https://github.com/RayanKhairullah/QRScanAndCreate.git
   ```
2. **Buka** proyek di Android Studio.
3. **Sync** Gradle & **Build** proyek.
4. **Run** di emulator atau perangkat fisik.

## 📂 Struktur Proyek

```
app/
├─ src/main/
│  ├─ java/com/example/barcodescanncreate/
│  │  ├─ MainActivity.java
│  │  ├─ ScanFragment.java
│  │  ├─ GenerateFragment.java
│  │  ├─ HistoryFragment.java
│  │  ├─ HistoryAdapter.java
│  │  ├─ HistoryViewModel.java
│  │  ├─ HistoryRepository.java
│  │  ├─ ScanHistory.java
│  │  ├─ ScanHistoryDao.java
│  │  └─ AppDatabase.java
│  └─ res/
│     ├─ layout/
│     │  ├─ activity_main.xml
│     │  ├─ fragment_scan.xml
│     │  ├─ fragment_generate.xml
│     │  ├─ fragment_history.xml
│     │  └─ history_item.xml
│     ├─ drawable/
│     ├─ menu/
│     │  ├─ bottom_nav_menu.xml
│     │  └─ top_app_bar_menu.xml
│     └─ values/
│        ├─ styles.xml
│        └─ colors.xml
└─ build.gradle.kts
```

## 📖 Cara Menggunakan

### Tab “Scan” 📸
1. Ketuk **Scan QR/Barcode**.
2. Beri izin **Kamera** jika diminta.
3. Arahkan kamera ke kode.
4. Hasil tampil di bawah.
5. Ketuk **Salin** untuk salin hasil.

### Tab “Generate” 🛠️
1. Masukkan teks/URL.
2. Ketuk **Generate QR Code**.
3. Preview QR muncul.
4. Ketuk **Unduh** untuk simpan.

### Tab “History” 📜
1. Lihat daftar scan terbaru.
2. Tekan dan tahan untuk **Hapus**.

## 🤝 Kontribusi

1. **Fork** proyek ini.
2. Buat **branch** fitur/bugfix.
3. Commit & push.
4. **Pull Request** dibuka untuk review.

## ⚖️ Lisensi

MIT License © 2025 Rayan3k
