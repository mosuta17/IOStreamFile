
package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Gudang {
    private ArrayList<Barang> daftar = new ArrayList<>();
    private String namaBerkas;

    public Gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    //method tambah barang
    public void tambahBarang(Barang barang) {
        daftar.add(barang);
    }

    //tampilkan semwa
    public void tampilkanSemua() {

        System.out.println("=== [DAFTAR BARANG] ===");

        for (int i = 0; i < daftar.size(); i++) {
            Barang b = daftar.get(i);
            System.out.println((i + 1) + ". " + b.info());
        }
    }

    //simpan ke berkas
    public void simpanKeBerkas() {

        try (PrintWriter penulis =
                new PrintWriter(new FileWriter(namaBerkas))) {

            for (Barang b : daftar) {
                penulis.println(b.keBaris());
            }

            System.out.println("[Data berhasil disimpan dari " + namaBerkas + "]...");

        } catch (IOException e) {
            System.out.println(" [error] Gagal menyimpan: " + e.getMessage());
        }
    }

    //muat dari berkas
    public void muatDariBerkas() {

        daftar.clear();

        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]);
                    int stok = Integer.parseInt(bagian[2]);
                    daftar.add(new Barang(nama, harga, stok)
                    );
                }
            }

            System.out.println("[Memuat data barang dari " + namaBerkas + "]...");

        } catch (IOException e) {
            System.out.println(" [error] Gagal memuat: " + e.getMessage());
        }
    }

    //total nilai (harga dikali stok dari seluruh barang.)
    public double totalNilai() {

        double total = 0;

        for (Barang b : daftar) {
            total += b.getHarga() * b.getStok();
        }
        return total;
    }    
}