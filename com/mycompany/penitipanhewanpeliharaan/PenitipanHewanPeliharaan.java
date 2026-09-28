package com.mycompany.penitipanhewanpeliharaan;

import model.Service;
import java.util.Scanner;

public class PenitipanHewanPeliharaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Service service = new Service(scanner);
        
        boolean berjalan = true;
        
        while (berjalan){
            System.out.println("\n===== SISTEM MANAJEMEN PENITIPAN HEWAN =====");
            System.out.println("1. Tambah Hewan");
            System.out.println("2. Tampilkan Hewan");
            System.out.println("3. Update Hewan");
            System.out.println("4. Hapus Hewan");
            System.out.println("5. Tambah Penitipan");
            System.out.println("6. Tampilkan Penitipan");
            System.out.println("7. Update Penitipan");
            System.out.println("8. Hapus Penitipan");
            System.out.println("9. Cari Hewan");
            System.out.println("10. Keluar");
            
            System.out.print("Pilih menu (1-10): ");

            if (!scanner.hasNextInt()) {
            System.out.println(">> Input harus berupa angka!");
            scanner.nextLine();
            continue;
            }

int pilihan = scanner.nextInt();
scanner.nextLine();
            
            switch (pilihan){
                case 1 -> service.tambahHewan();
                case 2 -> service.tampilkanHewan();
                case 3 -> service.updateHewan();
                case 4 -> service.hapusHewan();
                case 5 -> service.tambahPenitipan();
                case 6 -> service.tampilkanPenitipan();
                case 7 -> service.updatePenitipan();
                case 8 -> service.hapusPenitipan();
                case 9 -> service.cariHewan();
                case 10 -> {
                    System.out.println("\n=== Terima kasih sudah menggunakan program ini ===");
                    System.out.println("\n ==== Byeee ====");
                    berjalan = false;
                }    
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
        
        scanner.close();
    }
}
