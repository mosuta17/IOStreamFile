package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiriStreamDanFile {

    public static void main(String[] args) {
        
        // ==========================================
        // 1: Mengecek keberadaan & ukuran file laporan.txt
        // ==========================================
        System.out.println("--- SOAL 1 ---");
        File fileLaporan = new File("laporan.txt");
        
        if (fileLaporan.exists()) {
            System.out.println("Berkas 'laporan.txt' DITEMUKAN.");
            System.out.println("Ukuran berkas: " + fileLaporan.length() + " byte");
        } else {
            System.out.println("Berkas 'laporan.txt' TIDAK ditemukan.");
        }
        
        System.out.println(); // Baris baru untuk pembatas

        // ==========================================
        // 2: Membuat folder baru 'arsip'
        // ==========================================
        System.out.println("--- SOAL 2 ---");
        File folderArsip = new File("arsip");
        
        // mkdir() mengembalikan true jika berhasil, dan false jika gagal (atau folder sudah ada)
        boolean folderBerhasilDibuat = folderArsip.mkdir();
        
        if (folderBerhasilDibuat) {
            System.out.println("Pesan: Folder 'arsip' BERHASIL dibuat.");
        } else {
            System.out.println("Pesan: Folder 'arsip' GAGAL dibuat (atau folder sudah ada).");
        }
        
        System.out.println(); // Baris baru untuk pembatas

        // ==========================================
        // 3: Membuat file 'sementara.txt' lalu menghapusnya
        // ==========================================
        System.out.println("--- SOAL 3 ---");
        File fileSementara = new File("sementara.txt");
        
        try {
            // Membuat file baru
            boolean fileBerhasilDibuat = fileSementara.createNewFile();
            
            if (fileBerhasilDibuat) {
                System.out.println("File 'sementara.txt' berhasil dibuat.");
            }
            
            // Cek status sebelum dihapus
            System.out.println("Status keberadaan sebelum dihapus: " + fileSementara.exists());
            
            // Menghapus file
            boolean fileBerhasilDihapus = fileSementara.delete();
            
            if (fileBerhasilDihapus) {
                System.out.println("File 'sementara.txt' berhasil dihapus.");
            }
            
            // Cek status setelah dihapus
            System.out.println("Status keberadaan setelah dihapus: " + fileSementara.exists());
            
        } catch (IOException e) {
            System.out.println("Terjadi error saat memproses file sementara: " + e.getMessage());
        }
    }
}