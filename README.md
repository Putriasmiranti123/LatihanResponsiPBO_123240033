# LatihanResponsiPBO_123240033
# RESPONSI PBO - E-Commerce Cart

## Deskripsi Program
Program ini merupakan aplikasi desktop sederhana berbasis Java Swing untuk
mengelola keranjang belanja (shopping cart) dengan konsep MVP
(Model View Presenter).

Program dapat:
- Menambahkan barang
- Mengubah quantity barang
- Menghapus barang
- Menghitung subtotal
- Menghitung diskon event
- Menghitung total pembayaran
- Menyimpan data ke database MySQL
---
# Struktur Package

## 1. config
Berisi konfigurasi koneksi database.

### DatabaseConfig.java
Class ini digunakan untuk:
- Menghubungkan aplikasi ke database MySQL
- Menyediakan koneksi database
- Menggunakan JDBC Driver MySQL
---
## 2. controller
Berisi logika utama program.

### ControllerCart.java
Class controller bertugas untuk:
- Menghubungkan View dengan Model
- Mengatur event tombol
- Memproses input user
- Refresh tampilan tabel
- Mengatur proses tambah, update, dan delete data
---
## 3. dto

### CartItemDTO.java
Class DTO digunakan sebagai object data cart item.

Berisi:
- nama barang
- harga barang
- quantity barang
---
## 4. model

### CartRepository.java
Interface repository yang berisi:
- findAll()
- save()
- updateQuantity()
- delete()

Digunakan agar source data dapat diganti dengan mudah.

---

### FakeCartRepository.java
Repository sementara menggunakan ArrayList.

Digunakan untuk testing tanpa database.

---

### MySQLCartRepository.java
Repository utama yang menggunakan MySQL.

Fungsi:
- Membuat database otomatis
- Membuat tabel otomatis
- Menyimpan data ke MySQL
- Mengambil data dari MySQL
- Mengupdate data
- Menghapus data

---

## 5. service

### DiscountStrategy.java
Interface strategy untuk sistem diskon.

Tujuan:
Agar jenis diskon dapat diganti tanpa mengubah program utama.

---

### NoDiscountStrategy.java
Class diskon default tanpa potongan harga.

---

### DiscountEvent.java
Class diskon event.

Menggunakan diskon sebesar 12%.

---

## 6. view

### CartView.java
Class GUI menggunakan Java Swing.

Berfungsi untuk:
- Menampilkan tabel cart
- Menampilkan form input
- Menampilkan subtotal
- Menampilkan diskon
- Menampilkan total pembayaran

View hanya menangani tampilan dan tidak mengatur logika program.

---

# Konsep PBO yang Digunakan

## 1. Interface
Digunakan pada:
- CartRepository
- DiscountStrategy

Tujuan:
Agar program lebih fleksibel.

---

## 2. Inheritance / Implements
Digunakan pada:
- MySQLCartRepository implements CartRepository
- DiscountEvent implements DiscountStrategy

---

## 3. Encapsulation
Digunakan pada:
- CartItemDTO

Data dibuat private dan diakses menggunakan getter.

---

## 4. MVC / MVP Pattern

### Model
- Repository
- DTO

### View
- CartView

### Controller
- ControllerCart

Tujuan:
Agar kode lebih rapi dan mudah dipelihara.
---
# Database

## Nama Database
```sql
cart_db

Nama Tabel
cart_items
