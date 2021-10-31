package id.ac.unej.inaparadise.model;

public class DaftarKontak {

    private String id;
    private String nama;
    private String preview;
    private int foto;

    public DaftarKontak() {
    }

    public DaftarKontak(String id, String nama, String preview, int foto) {
        this.id = id;
        this.nama = nama;
        this.preview = preview;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
