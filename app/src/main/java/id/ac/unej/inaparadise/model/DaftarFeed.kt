package id.ac.unej.inaparadise.model;

public class DaftarFeed {

    private int foto;
    private int fotoUploader;
    private String uploader;
    private int waktu;

    public DaftarFeed() {
    }

    public DaftarFeed(int foto, int fotoUploader, String uploader, int waktu) {
        this.foto = foto;
        this.fotoUploader = fotoUploader;
        this.uploader = uploader;
        this.waktu = waktu;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getFotoUploader() {
        return fotoUploader;
    }

    public void setFotoUploader(int fotoUploader) {
        this.fotoUploader = fotoUploader;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public int getWaktu() {
        return waktu;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }
}
