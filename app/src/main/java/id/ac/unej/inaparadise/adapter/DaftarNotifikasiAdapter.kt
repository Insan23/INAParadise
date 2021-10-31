package id.ac.unej.inaparadise.adapter

import android.view.View
import android.widget.ImageView
import id.ac.unej.inaparadise.model.DaftarNotifikasi

class DaftarNotifikasiAdapter(daftar: List<DaftarNotifikasi>, listener: OnItemClickListener) :
    RecyclerView.Adapter<DaftarNotifikasiAdapter.ViewHolder?>() {
    var daftar: List<DaftarNotifikasi>
    var listener: OnItemClickListener
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.list_item_notifikasi, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(daftar[i], listener)
    }

    override fun getItemCount(): Int {
        return daftar.size
    }

    interface OnItemClickListener {
        fun onItemClick(model: DaftarNotifikasi?)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nama: TextView
        var isi: TextView
        var waktu: TextView
        var foto: ImageView
        fun bind(model: DaftarNotifikasi, listener: OnItemClickListener) {
            nama.setText(model.getNama())
            isi.setText(model.getIsi())
            waktu.setText(model.getWaktu().toString() + " jam yang lalu")
            foto.setImageResource(model.getFoto())
            itemView.setOnClickListener(View.OnClickListener { listener.onItemClick(model) })
        }

        init {
            nama = itemView.findViewById<TextView>(R.id.nama)
            isi = itemView.findViewById<TextView>(R.id.preview)
            waktu = itemView.findViewById<TextView>(R.id.waktu)
            foto = itemView.findViewById(R.id.foto_profil)
        }
    }

    init {
        this.daftar = daftar
        this.listener = listener
    }
}