package model;

public class MamaliaKecil extends Hewan {

    public MamaliaKecil(int idHewan, String namaHewan) {
        super(idHewan, namaHewan);
    }

    @Override
    public String getInfo() {
        return "Mamalia Kecil - " + getNamaHewan();
    }
}