/*
Nama    : Azkaa Muhammad Suta
NPM     : 2410010057
*/
package tugas;

public class MainTugas {
    public static void main(String[] args) {

        // Array 
        String[] kategori = {
            "Elektronik",
            "Aksesoris",
            "Alat Tulis"
        };

        System.out.println("=== KATEGORI BARANG ===");

        for (String k : kategori) {
            System.out.println("- " + k);
        }

        System.out.println();

        // Membuat objek (Gudang)
        Gudang gudang = new Gudang("barang.txt");

        //=== menambahkan barang================================================
        gudang.tambahBarang(new Barang("Laptop Axioo", 6000000, 5));
        gudang.tambahBarang(new Barang("Mouse Wireless", 115000, 20));
        gudang.tambahBarang(new Barang("Earphone", 150000, 25));
        gudang.tambahBarang(new Barang("Printer canon", 500000, 5));
        gudang.tambahBarang(new Barang("Keyboard", 200000, 10));
        gudang.tambahBarang(new Barang("Proyektor Limited Ed.FIFAWC26", 1000000, 1));
        //======================================================================
        

        System.out.println("DATA BARANG AWAL");
        gudang.tampilkanSemua();

        // Simpan ke file
        System.out.println("\n==========================\n");
        gudang.simpanKeBerkas();

        System.out.println("\n======================\n");

        // Objek baru
        Gudang gudangBaru =new Gudang("barang.txt");

        // Muat dari file
        gudangBaru.muatDariBerkas();

        System.out.println("\nDATA HASIL MUAT FILE");
        gudangBaru.tampilkanSemua();

        System.out.println("\nTotal Nilai Persediaan = Rp"+ gudangBaru.totalNilai());
    }
}