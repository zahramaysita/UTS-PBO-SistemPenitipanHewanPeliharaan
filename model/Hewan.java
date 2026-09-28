package model;

public class Hewan {

    private int idHewan;
    private String namaHewan;
    
    
    public String getInfo(){
        return "Nama Hewan : " + namaHewan;
    }

    public Hewan(int idHewan, String namaHewan) {
        this.idHewan = idHewan;
        this.namaHewan = namaHewan;
    }

    public int getIdHewan() {
        return idHewan;
    }

    public void setIdHewan(int idHewan) {
        this.idHewan = idHewan;
    }

    public String getNamaHewan() {
        return namaHewan;
    }

    public void setNamaHewan(String namaHewan) {
        this.namaHewan = namaHewan;
    }
}