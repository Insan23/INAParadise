package id.ac.unej.inaparadise.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.ac.unej.inaparadise.R;
import id.ac.unej.inaparadise.model.DaftarFeed;


public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    List<DaftarFeed> daftarFeed;
    private OnItemClickListener listener;

    public FeedAdapter(List<DaftarFeed> daftarFeed, OnItemClickListener listener) {
        this.daftarFeed = daftarFeed;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_feed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(daftarFeed.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return daftarFeed.size();
    }

    public interface OnItemClickListener {
        void onItemClick(DaftarFeed model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //        private TextView namaBarang, deskripsiBarang;
//        private ImageView fotoBarang;
        private ImageView fotoProfil, foto;
        private TextView nama, waktu;

        public ViewHolder(View itemView) {
            super(itemView);
            fotoProfil = itemView.findViewById(R.id.foto_profil);
            foto = itemView.findViewById(R.id.foto_feed);
            nama = itemView.findViewById(R.id.nama);
            waktu = itemView.findViewById(R.id.waktu);
        }

        public void bind(final DaftarFeed model, final OnItemClickListener listener) {
            fotoProfil.setImageResource(model.getFotoUploader());
            foto.setImageResource(model.getFoto());
            nama.setText(model.getUploader());
            waktu.setText(model.getWaktu() + "jam ");

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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(model);
                }
            });
        }

    }
}
