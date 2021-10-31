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
import id.ac.unej.inaparadise.model.DaftarKontak;

public class AdapterDaftarPesan extends RecyclerView.Adapter<AdapterDaftarPesan.ViewHolder> {

    private List<DaftarKontak> listKontak;
    private OnItemClickListener listener;

    public AdapterDaftarPesan(List<DaftarKontak> daftar, OnItemClickListener listener) {
        listKontak = daftar;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_daftar_kontak, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(listKontak.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return listKontak.size();
    }

    public interface OnItemClickListener {
        void onItemClick(DaftarKontak model);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nama, preview;
        private ImageView foto;

        ViewHolder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            preview = itemView.findViewById(R.id.preview);
            foto = itemView.findViewById(R.id.foto_profil);
        }

        void bind(final DaftarKontak model, final OnItemClickListener listener) {
            nama.setText(model.getNama());
            preview.setText(model.getPreview());
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
