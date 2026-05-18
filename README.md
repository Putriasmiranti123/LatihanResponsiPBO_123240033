# Responsi PBO - E-Commerce Cart

## Deskripsi
Project ini merupakan aplikasi desktop sederhana berbasis Java Swing
untuk mengelola keranjang belanja (shopping cart).

Program dibuat menggunakan konsep MVC/MVP agar struktur program lebih rapi,
mudah dipahami, dan mudah dikembangkan.

---

# Yang Saya Lakukan

Pada project ini saya melakukan beberapa pengembangan, yaitu:

## 1. Menambahkan Koneksi Database MySQL
Saya menambahkan package:

```text
config

dengan class:

DatabaseConfig.java

Class ini digunakan untuk:

mengatur koneksi database MySQL
memanggil JDBC Driver
menyediakan koneksi untuk repository
2. Menambahkan Controller

Saya menambahkan package:

controller

dengan class:

ControllerCart.java

Controller digunakan untuk:

menghubungkan View dengan Model
menangani event tombol
memproses input user
melakukan refresh data ke tabel

Dengan adanya controller, kode menjadi lebih rapi karena logic program
tidak ditulis langsung di class main.

3. Menambahkan Repository MySQL

Saya menambahkan class:

MySQLCartRepository.java

pada package:

model

Class ini digunakan untuk:

menyimpan data ke database MySQL
mengambil data dari database
update quantity barang
menghapus data barang

Class ini juga dapat membuat database dan tabel secara otomatis.

4. Menambahkan Strategy Diskon

Saya menambahkan class:

DiscountEvent.java

pada package:

service

Class ini digunakan untuk menghitung diskon event sebesar 12%.

Konsep yang digunakan adalah Strategy Pattern sehingga jenis diskon dapat
diganti tanpa mengubah program utama.

Konsep PBO yang Digunakan
Interface

Digunakan pada:

CartRepository
DiscountStrategy
Encapsulation

Digunakan pada:

CartItemDTO

Data dibuat private dan diakses menggunakan getter.

Inheritance / Implements

Digunakan pada:

MySQLCartRepository implements CartRepository
DiscountEvent implements DiscountStrategy
MVC / MVP Pattern
Model
CartRepository
MySQLCartRepository
CartItemDTO
View
CartView
Controller
ControllerCart
Fitur Program
Menambah barang
Mengubah quantity barang
Menghapus barang
Menghitung subtotal otomatis
Menghitung diskon otomatis
Menghitung total pembayaran
Penyimpanan data menggunakan MySQL
Database

Nama database:

cart_db

Nama tabel:

cart_items
