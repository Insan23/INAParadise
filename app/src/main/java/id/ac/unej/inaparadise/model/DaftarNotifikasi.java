package id.ac.unej.inaparadise.model;

public class DaftarNotifikasi {

    private String nama, isi;
    private long waktu;
    private int foto;

    public DaftarNotifikasi() {
    }

    public DaftarNotifikasi(String nama, String isi, long waktu, int foto) {
        this.nama = nama;
        this.isi = isi;
        this.waktu = waktu;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public long getWaktu() {
        return waktu;
    }

    public void setWaktu(long waktu) {
        this.waktu = waktu;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
