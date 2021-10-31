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
import id.ac.unej.inaparadise.model.DaftarNotifikasi;

public class DaftarNotifikasiAdapter extends RecyclerView.Adapter<DaftarNotifikasiAdapter.ViewHolder> {

    List<DaftarNotifikasi> daftar;
    OnItemClickListener listener;

    public DaftarNotifikasiAdapter(List<DaftarNotifikasi> daftar, OnItemClickListener listener) {
        this.daftar = daftar;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_notifikasi, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(daftar.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return daftar.size();
    }

    public interface OnItemClickListener {
        void onItemClick(DaftarNotifikasi model);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView nama, isi, waktu;
        ImageView foto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            isi = itemView.findViewById(R.id.preview);
            waktu = itemView.findViewById(R.id.waktu);
            foto = itemView.findViewById(R.id.foto_profil);
        }

        void bind(final DaftarNotifikasi model, final OnItemClickListener listener) {
            nama.setText(model.getNama());
            isi.setText(model.getIsi());
            waktu.setText(model.getWaktu() + " jam yang lalu");
            foto.setImageResource(model.getFoto());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(model);
                }
            });
        }
    }
}
