package id.ac.unej.inaparadise.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import id.ac.unej.inaparadise.R
import android.widget.TextView
import id.ac.unej.inaparadise.model.Chat
import id.ac.unej.inaparadise.model.DaftarFeed

class FeedAdapter(var daftarFeed: List<DaftarFeed>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<FeedAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_feed, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(daftarFeed[position], listener)
    }

    override fun getItemCount(): Int {
        return daftarFeed.size
    }

    interface OnItemClickListener {
        fun onItemClick(model: DaftarFeed?)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //        private TextView namaBarang, deskripsiBarang;
        //        private ImageView fotoBarang;
        private val fotoProfil: ImageView
        private val foto: ImageView
        private val nama: TextView
        private val waktu: TextView
        fun bind(model: DaftarFeed, listener: OnItemClickListener) {
            fotoProfil.setImageResource(model.fotoUploader)
            foto.setImageResource(model.foto)
            nama.text = model.uploader
            waktu.text = model.waktu.toString() + "jam "

//            StorageReference ref = FirebaseStorage.getInstance().getReferenceFromUrl(model.getUrlFotoBarang());
//            ref.getBytes(MB).addOnCompleteListener(new OnCompleteListener<byte[]>() {
//                @Override
//                public void onComplete(@NonNull Task<byte[]> task) {
//                    if (task.isSuccessful()) {
//                        Bitmap fotoDownload = BitmapFactory.decodeByteArray(task.getResult(), 0, task.getResult().length);
//                        fotoBarang.setImageBitmap(fotoDownload);
//                    } else {
//                        Log.w(FeedAdapter.class.getSimpleName(), "gagal download foto:" + task.getException());
//                        fotoBarang.setImageResource(R.drawable.ic_camera);
//                        fotoBarang.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                    }
//                }
//            });
            itemView.setOnClickListener { listener.onItemClick(model) }
        }

        init {
            fotoProfil = itemView.findViewById(R.id.foto_profil)
            foto = itemView.findViewById(R.id.foto_feed)
            nama = itemView.findViewById(R.id.nama)
            waktu = itemView.findViewById(R.id.waktu)
        }
    }
}