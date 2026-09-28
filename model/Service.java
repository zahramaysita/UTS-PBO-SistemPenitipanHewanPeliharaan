package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {

    private ArrayList<Hewan> daftarHewan = new ArrayList<>();
    private ArrayList<Penitipan> daftarPenitipan = new ArrayList<>();

    private Scanner scanner;

    public Service(Scanner scanner) {
        this.scanner = scanner;

        // Dummy data awal
        daftarHewan.add(new Kucing(1, "Milo", "Persia"));
    }

    // =========================
    // TAMBAH HEWAN
    // =========================
    public void tambahHewan() {
    System.out.print("ID Hewan: ");

if (!scanner.hasNextInt()) {
    System.out.println(">> ID hewan harus berupa angka!");
    scanner.nextLine();
    return;
}

int id = scanner.nextInt();
scanner.nextLine();


    if (id <= 0) {
        System.out.println(">> ID hewan tidak valid!");
        return;
    }
    
    for (Hewan h : daftarHewan) {
        if (h.getIdHewan() == id) {
            System.out.println(">> ID hewan sudah digunakan!");
            return;
        }
    }

    System.out.print("Nama Hewan: ");
    String nama = scanner.nextLine();

    if (nama.isEmpty()) {
        System.out.println(">> Nama hewan tidak boleh kosong!");
        return;
    }

    System.out.println("\nPilih Jenis Hewan:");
    System.out.println("1. Kucing");
    System.out.println("2. Anjing");
    System.out.println("3. Kelinci");
    System.out.println("4. Hamster");
    System.out.print("Pilihan: ");
    if (!scanner.hasNextInt()) {
    System.out.println(">> Pilihan harus berupa angka!");
    scanner.nextLine();
    return;
}
    int pilihan = scanner.nextInt();
    scanner.nextLine();

    Hewan hewanBaru;

    switch (pilihan) {
        case 1 -> {
            System.out.print("Ras Kucing: ");
            String ras = scanner.nextLine();
            if (ras.isEmpty()) {
                System.out.println(">> Ras kucing tidak boleh kosong!");
                return;
            }
            hewanBaru = new Kucing(id, nama, ras);
        }

        case 2 -> {
            System.out.print("Ras Anjing: ");
            String ras = scanner.nextLine();
            if (ras.isEmpty()) {
                System.out.println(">> Ras anjing tidak boleh kosong!");
                return;
            }
            hewanBaru = new Anjing(id, nama, ras);
        }

        case 3 -> {
            System.out.print("Ras Kelinci: ");
            String ras = scanner.nextLine();
            if (ras.isEmpty()) {
                System.out.println(">> Ras kelinci tidak boleh kosong!");
                return;
            }
            hewanBaru = new Kelinci(id, nama, ras);
        }

        case 4 -> {
            System.out.print("Ras Hamster: ");
            String ras = scanner.nextLine();
            if (ras.isEmpty()) {
                System.out.println(">> Ras hamster tidak boleh kosong!");
                return;
            }
            hewanBaru = new Hamster(id, nama, ras);
        }

        default -> {
            System.out.println(">> Pilihan jenis hewan tidak valid!");
            return;
        }
    }

    daftarHewan.add(hewanBaru);

    System.out.println(">> Hewan berhasil ditambahkan!");
}

    // =========================
    // TAMPILKAN HEWAN
    // =========================
    public void tampilkanHewan() {

        if (daftarHewan.isEmpty()) {
            System.out.println(">> Belum ada data hewan.");
            return;
        }

        for (Hewan h : daftarHewan) {

            System.out.println("ID Hewan: " + h.getIdHewan());
            System.out.println("Nama Hewan: " + h.getNamaHewan());
            System.out.println("Info Hewan: " + h.getInfo());

            if (h instanceof Kucing) {
                Kucing k = (Kucing) h;
                System.out.println("Jenis Hewan: Kucing");
                System.out.println("Ras: " + k.getRas());

            } else if (h instanceof Anjing) {
                Anjing a = (Anjing) h;
                System.out.println("Jenis Hewan: Anjing");
                System.out.println("Ras: " + a.getRas());

            } else if (h instanceof Kelinci) {
                Kelinci k = (Kelinci) h;
                System.out.println("Jenis Hewan: Kelinci");
                System.out.println("Ras: " + k.getRasKelinci());

            } else if (h instanceof Hamster) {
                Hamster hm = (Hamster) h;
                System.out.println("Jenis Hewan: Hamster");
                System.out.println("Ras: " + hm.getRasHamster());
            }

            System.out.println("----------------------------");
        }
    }

    // =========================
    // HAPUS HEWAN
    // =========================
    public void hapusHewan() {
        System.out.print("Masukkan ID Hewan: ");
        if (!scanner.hasNextInt()) {
            System.out.println(">> ID hewan harus berupa angka!");
            scanner.nextLine();
            return;
        }

        int idTarget = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < daftarHewan.size(); i++) {

            if (daftarHewan.get(i).getIdHewan() == idTarget) {
                daftarHewan.remove(i);

                System.out.println(">> Hewan berhasil dihapus!");
                return;
            }
        }

        System.out.println(">> Hewan tidak ditemukan!");
    }

    // =========================
    // UPDATE HEWAN
    // =========================
    public void updateHewan() {
        System.out.print("Masukkan ID Hewan: ");
        if (!scanner.hasNextInt()) {
            System.out.println(">> ID hewan harus berupa angka!");
            scanner.nextLine();
            return;
        }

        int idTarget = scanner.nextInt();
        scanner.nextLine();

        for (Hewan h : daftarHewan) {

            if (h.getIdHewan() == idTarget) {

                System.out.print("Nama Hewan Baru: ");
                String namaBaru = scanner.nextLine();

                if (namaBaru.isEmpty()) {
                    System.out.println(">> Nama hewan tidak boleh kosong!");
                    return;
                }

                h.setNamaHewan(namaBaru);

                System.out.println(">> Data hewan berhasil diperbarui!");
                return;
            }
        }

        System.out.println(">> Hewan tidak ditemukan!");
    }

    // =========================
    // TAMBAH PENITIPAN
    // =========================
    public void tambahPenitipan() {
        System.out.print("ID Penitipan: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println(">> ID penitipan harus berupa angka!");
            scanner.nextLine();
            return;
        }
        int idPenitipan = scanner.nextInt();

        if (idPenitipan <= 0) {
            System.out.println(">> ID penitipan tidak valid!");
            scanner.nextLine();
            return;
        }
        
        for (Penitipan p : daftarPenitipan) {
            if (p.getIdPenitipan() == idPenitipan) {
                System.out.println(">> ID penitipan sudah digunakan!");
                scanner.nextLine();
                return;
            }
        }
        System.out.print("ID Hewan: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println(">> ID hewan harus berupa angka!");
            scanner.nextLine();
            return;
        }
        
        int idHewan = scanner.nextInt();
        scanner.nextLine();
        
        if (idHewan <= 0) {
            System.out.println(">> ID hewan tidak valid!");
            return;
        }
        boolean hewanDitemukan = false;

        for (Hewan h : daftarHewan) {
            if (h.getIdHewan() == idHewan) {
                hewanDitemukan = true;
                break;
            }
        }

        if (!hewanDitemukan) {
            System.out.println(">> ID hewan belum terdaftar!");
            return;
        }

        System.out.print("Tanggal Masuk: ");
        String tanggalMasuk = scanner.nextLine();
        
        if (tanggalMasuk.isEmpty()) {
            System.out.println(">> Tanggal masuk tidak boleh kosong!");
            return;
        }

        System.out.print("Lama Penitipan (hari): ");
        
        if (!scanner.hasNextInt()) {
            System.out.println(">> Lama penitipan harus berupa angka!");
            scanner.nextLine();
            return;
        }
        
        int lamaPenitipan = scanner.nextInt();
        
        if (lamaPenitipan <= 0) {
            System.out.println(">> Lama penitipan harus lebih dari 0 hari!");
            scanner.nextLine();
            return;
        }

        scanner.nextLine();

        Penitipan penitipanBaru = new Penitipan(
                idPenitipan,
                idHewan,
                tanggalMasuk,
                lamaPenitipan
        );

        daftarPenitipan.add(penitipanBaru);

        System.out.println(">> Data penitipan berhasil ditambahkan!");
    }

    // =========================
    // TAMPILKAN PENITIPAN
    // =========================
    public void tampilkanPenitipan() {

        if (daftarPenitipan.isEmpty()) {
            System.out.println(">> Belum ada data penitipan.");
            return;
        }

        for (Penitipan p : daftarPenitipan) {

            System.out.println("ID Penitipan: " + p.getIdPenitipan());
            System.out.println("ID Hewan: " + p.getIdHewan());
            System.out.println("Tanggal Masuk: " + p.getTanggalMasuk());
            System.out.println(
                    "Lama Penitipan: "
                    + p.getLamaPenitipan()
                    + " hari"
            );

            System.out.println("-----------------------------------------------");
        }
    }

    // =========================
    // HAPUS PENITIPAN
    // =========================
    public void hapusPenitipan() {
        System.out.print("Masukkan ID Penitipan: ");
        if (!scanner.hasNextInt()) {
            System.out.println(">> ID penitipan harus berupa angka!");
            scanner.nextLine();
            return;
        }

        int idTarget = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < daftarPenitipan.size(); i++) {

            if (daftarPenitipan.get(i).getIdPenitipan() == idTarget) {
                daftarPenitipan.remove(i);

                System.out.println(">> Data penitipan berhasil dihapus!");
                return;
            }
        }

        System.out.println(">> Data penitipan tidak ditemukan!");
    }

    // =========================
    // UPDATE PENITIPAN
    // =========================
    public void updatePenitipan() {
        System.out.print("Masukkan ID Penitipan: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println(">> ID penitipan harus berupa angka!");
            scanner.nextLine();
            return;
        }
        
        int idTarget = scanner.nextInt();
        scanner.nextLine();

        for (Penitipan p : daftarPenitipan) {

            if (p.getIdPenitipan() == idTarget) {

                System.out.print("Tanggal Masuk Baru: ");
                String tanggalBaru = scanner.nextLine();

                System.out.print("Lama Penitipan Baru: ");
                int lamaBaru = scanner.nextInt();
                scanner.nextLine();

                p.setTanggalMasuk(tanggalBaru);
                p.setLamaPenitipan(lamaBaru);

                System.out.println(">> Data penitipan berhasil diperbarui!");
                return;
            }
        }

        System.out.println(">> Data penitipan tidak ditemukan!");
    }

    // =========================
    // CARI HEWAN
    // =========================
    public void cariHewan() {
        System.out.print("Masukkan ID Hewan yang dicari: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println(">> ID hewan harus berupa angka!");
            scanner.nextLine();
            return;
        }
        
        int idTarget = scanner.nextInt();
        scanner.nextLine();

        for (Hewan h : daftarHewan) {

            if (h.getIdHewan() == idTarget) {

                System.out.println("=== DATA HEWAN DITEMUKAN ===");
                System.out.println("ID Hewan: " + h.getIdHewan());
                System.out.println("Nama Hewan: " + h.getNamaHewan());

                if (h instanceof Kucing) {
                    Kucing k = (Kucing) h;
                    System.out.println("Jenis Hewan: Kucing");
                    System.out.println("Ras: " + k.getRas());

                } else if (h instanceof Anjing) {
                    Anjing a = (Anjing) h;
                    System.out.println("Jenis Hewan: Anjing");
                    System.out.println("Ras: " + a.getRas());

                } else if (h instanceof Kelinci) {
                    Kelinci k = (Kelinci) h;
                    System.out.println("Jenis Hewan: Kelinci");
                    System.out.println("Ras: " + k.getRasKelinci());

                } else if (h instanceof Hamster) {
                    Hamster hm = (Hamster) h;
                    System.out.println("Jenis Hewan: Hamster");
                    System.out.println("Ras: " + hm.getRasHamster());
                }

                return;
            }
        }

        System.out.println(">> Hewan tidak ditemukan!");
    }
}