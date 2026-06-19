package bagian2.bacatulis;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LatihanMandiriBacaTulis {

    public static void main(String[] args) {

        // ==========================================
        // SOAL 1: Menulis 5 hari lalu membacanya
        // ==========================================
        System.out.println("--- SOAL 1: Menulis & Membaca 5 Hari ---");

        // 1a. Menulis 5 hari ke file (mode overwrite/menulis ulang)
        try {
            // Secara default, new FileWriter("nama_file") akan menimpa isi file lama
            FileWriter fileWriter = new FileWriter("hari.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Senin");
            printWriter.println("Selasa");
            printWriter.println("Rabu");
            printWriter.println("Kamis");
            printWriter.println("Jumat");

            // Wajib ditutup setelah selesai menulis agar data benar-benar tersimpan
            printWriter.close();
            System.out.println("Berhasil menulis 5 hari ke hari.txt\n");

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis file: " + e.getMessage());
        }

        // 1b. Membaca kembali dan menampilkan ke layar
        try {
            FileReader fileReader = new FileReader("hari.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println("Isi file hari.txt saat ini:");
            String baris;
            // Membaca file baris demi baris sampai teksnya habis (null)
            while ((baris = bufferedReader.readLine()) != null) {
                System.out.println("- " + baris);
            }

            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }

        System.out.println("\n----------------------------------------\n");

        // ==========================================
        // SOAL 2: Menambahkan (append) 2 hari lagi
        // ==========================================
        System.out.println("--- SOAL 2: Menambahkan 2 Hari (Append) ---");

        try {
            // Menggunakan true pada parameter kedua FileWriter agar masuk ke mode APPEND (menambah tanpa menghapus)
            FileWriter fileWriterAppend = new FileWriter("hari.txt", true);
            PrintWriter printWriterAppend = new PrintWriter(fileWriterAppend);

            printWriterAppend.println("Sabtu");
            printWriterAppend.println("Minggu");

            printWriterAppend.close();
            System.out.println("Berhasil menambahkan Sabtu dan Minggu.\n");

            // Tampilkan seluruh isinya setelah di-append
            FileReader fileReader = new FileReader("hari.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println("Isi file hari.txt setelah ditambahkan:");
            String baris;
            while ((baris = bufferedReader.readLine()) != null) {
                System.out.println("- " + baris);
            }

            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan pada Soal 2: " + e.getMessage());
        }

        System.out.println("\n----------------------------------------\n");

        // ==========================================
        // SOAL 3: Menghitung jumlah baris
        // ==========================================
        System.out.println("--- SOAL 3: Menghitung Jumlah Baris ---");

        try {
            FileReader fileReader = new FileReader("hari.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int jumlahBaris = 0;
            // Melakukan looping untuk membaca baris, setiap ada baris baru variabel counter bertambah 1
            while (bufferedReader.readLine() != null) {
                jumlahBaris++;
            }

            bufferedReader.close();

            System.out.println("Total jumlah baris di dalam hari.txt adalah: " + jumlahBaris + " baris.");

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menghitung baris: " + e.getMessage());
        }
    }
}
