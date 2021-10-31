package id.ac.unej.inaparadise.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.ac.unej.inaparadise.R;
import id.ac.unej.inaparadise.adapter.DaftarNotifikasiAdapter;
import id.ac.unej.inaparadise.model.DaftarNotifikasi;
import id.ac.unej.inaparadise.ui.ChatActivity;

public class Notifikasi extends Fragment {

    List<DaftarNotifikasi> daftarNotifikasi;

    public Notifikasi() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifikasi, container, false);

        RecyclerView notifikasi = root.findViewById(R.id.daftar_notifikasi);
        daftarNotifikasi = new ArrayList<>();
        DaftarNotifikasiAdapter adapter = new DaftarNotifikasiAdapter(daftarNotifikasi, new DaftarNotifikasiAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DaftarNotifikasi model) {
                Intent chat = new Intent(getActivity(), ChatActivity.class);
                chat.putExtra("nama", model.getNama());
                startActivity(chat);
            }
        });

        populate();
        notifikasi.setLayoutManager(new LinearLayoutManager(getActivity()));
        notifikasi.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return root;
    }

    void populate() {
        //String nama, String isi, long waktu, int foto
        daftarNotifikasi.add(new DaftarNotifikasi("Ludfi Ika P", "Hari ini mau gathering dimana?", 2, R.drawable.profil_2));
        daftarNotifikasi.add(new DaftarNotifikasi("Erinda", "Ada pagelaran di kota", 6, R.drawable.profil_3));
        daftarNotifikasi.add(new DaftarNotifikasi("Aleq", "Saya punya solusi untuk itu", 10, R.drawable.profil_1));
    }
}
