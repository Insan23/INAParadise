package id.ac.unej.inaparadise.model

class DaftarFeed {
    var foto = 0
    var fotoUploader = 0
    var uploader: String? = null
    var waktu = 0

    constructor() {}
    constructor(foto: Int, fotoUploader: Int, uploader: String?, waktu: Int) {
        this.foto = foto
        this.fotoUploader = fotoUploader
        this.uploader = uploader
        this.waktu = waktu
    }
}