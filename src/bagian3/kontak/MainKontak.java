package bagian3.kontak;

public class MainKontak {

    public static void main(String[] args) {
        // Membuat objek pengelola dan mengisinya
        BukuKontak buku = new BukuKontak("kontak.txt");
        buku.tambahKontak(new Kontak("Arap", "0811111", "arap01@gmail.com"));
        buku.tambahKontak(new Kontak("Aloy", "0822222", "aloy02@gmail.com"));
        buku.tambahKontak(new Kontak("Bravy", "0833333", "bravy03@gmail.com"));

        System.out.println("DATA AWAL");
        buku.tampilkanSemua();
        buku.simpanKeBerkas();

        System.out.println("\nPENCARIAN KONTAK");
        buku.cariKontak("Arap");
        buku.cariKontak("Aloy");

        System.out.println("\nMENGHAPUS KONTAK");
        buku.hapusKontak("Bravy");

        System.out.println("\nDATA SETELAH HAPUS");
        buku.tampilkanSemua();

        System.out.println("\nMEMUAT DARI FILE");

        System.out.println();

        // Objek baru yang kosong, lalu memuat dari berkas
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak: " + bukuLain.jumlahKontak());
    }
}
//Yang dijalankan hanyalah class yang memiliki method main, yaitu MainKontak.main. Pastikan ketiga file berada di package yang sama
