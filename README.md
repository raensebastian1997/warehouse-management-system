# Warehouse Management System

Rest Api sederhana untuk manajemen gudang (Warehouse Management) yang dibangun menggunakan Spring Boot.

## Prasyarat

Pastikan Anda telah menginstal perangkat lunak berikut sebelum melanjutkan:

-   [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) atau versi yang lebih baru.
-   [Apache Maven](https://maven.apache.org/download.cgi) (Opsional, karena proyek ini sudah menyertakan Maven Wrapper).

## Cara Menjalankan Aplikasi

1.  **Clone Repository**

    ```bash
    git clone <URL_REPOSITORY_ANDA>
    cd warehouse-management
    ```

2.  **Jalankan Aplikasi menggunakan Maven Wrapper**

    Buka terminal atau command prompt di direktori root proyek, lalu jalankan perintah berikut:

    -   Untuk pengguna Windows:
        ```bash
        mvnw.cmd spring-boot:run
        ```

    -   Untuk pengguna Linux/macOS:
        ```bash
        ./mvnw spring-boot:run
        ```

    Aplikasi akan berjalan pada port `8080` secara default.

## Akses Aplikasi

Setelah aplikasi berhasil berjalan, Anda dapat mengakses beberapa endpoint berikut melalui browser:

### 1. H2 Database Console

Aplikasi ini menggunakan H2 sebagai *in-memory database*. Anda dapat mengakses konsol H2 untuk melihat dan mengelola data di dalam database.

-   **URL**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
-   **JDBC URL**: `jdbc:h2:mem:testdb`
-   **Username**: `sa`
-   **Password**: (kosongkan)

### 2. Dokumentasi API (Swagger UI)

Proyek ini dilengkapi dengan dokumentasi API interaktif menggunakan SpringDoc OpenAPI (Swagger UI).

-   **URL**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Melalui Swagger UI, Anda dapat melihat semua endpoint yang tersedia, serta mencoba mengirim request dan melihat response secara langsung.