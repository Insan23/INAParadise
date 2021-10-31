package id.ac.unej.inaparadise.adapter

import android.view.View
import android.widget.ImageView
import id.ac.unej.inaparadise.model.DaftarKontak

class AdapterDaftarPesan(daftar: List<DaftarKontak>, listener: OnItemClickListener) :
    RecyclerView.Adapter<AdapterDaftarPesan.ViewHolder?>() {
    private val listKontak: List<DaftarKontak>
    private val listener: OnItemClickListener
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.list_item_daftar_kontak, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(listKontak[i], listener)
    }

    override fun getItemCount(): Int {
        return listKontak.size
    }

    interface OnItemClickListener {
        fun onItemClick(model: DaftarKontak?)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nama: TextView
        private val preview: TextView
        private val foto: ImageView
        fun bind(model: DaftarKontak, listener: OnItemClickListener) {
            nama.setText(model.getNama())
            preview.setText(model.getPreview())
            foto.setImageResource(model.getFoto())
            itemView.setOnClickListener(View.OnClickListener { listener.onItemClick(model) })
        }

        init {
            nama = itemView.findViewById<TextView>(R.id.nama)
            preview = itemView.findViewById<TextView>(R.id.preview)
            foto = itemView.findViewById(R.id.foto_profil)
        }
    }

    init {
        listKontak = daftar
        this.listener = listener
    }
}