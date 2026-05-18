# Latihan Responsi PBO

## Deskripsi
Project ini merupakan aplikasi Java Swing sederhana yang dibuat
menggunakan konsep MVC (Model View Controller).

Aplikasi digunakan untuk mengelola data menggunakan database MySQL.

---

# Yang Saya Kerjakan

Pada latihan responsi ini saya melakukan beberapa pengembangan, yaitu:

## 1. Menambahkan Koneksi Database MySQL
Saya menambahkan koneksi database menggunakan JDBC agar data dapat
disimpan secara permanen ke MySQL.

Class yang digunakan:
- DatabaseConfig.java

Fungsi:
- Menghubungkan aplikasi dengan database
- Menyediakan connection untuk repository

---

## 2. Menambahkan Repository MySQL
Saya menambahkan repository berbasis MySQL.

Class:
- MySQLTodoRepository.java

Fungsi:
- Menyimpan data ke database
- Mengambil data dari database
- Mengupdate data
- Menghapus data

---

## 3. Menambahkan Controller
Saya menambahkan controller untuk memisahkan logic program dari tampilan.

Class:
- TodoController.java

Fungsi:
- Menghubungkan model dan view
- Mengatur event tombol
- Mengatur proses CRUD

---

## 4. Menggunakan Konsep MVC
Project dibagi menjadi beberapa bagian:

### Model
Berisi data dan repository.

### View
Berisi tampilan GUI Swing.

### Controller
Berisi logic program dan penghubung model dengan view.

---

# Teknologi yang Digunakan

- Java
- Java Swing
- JDBC
- MySQL
- Maven

---

# Cara Menjalankan

1. Jalankan MySQL/XAMPP/Laragon
2. Import database jika diperlukan
3. Jalankan project Java
4. Program siap digunakan
