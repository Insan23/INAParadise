package id.ac.unej.inaparadise.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.ac.unej.inaparadise.R;
import id.ac.unej.inaparadise.adapter.AdapterDaftarPesan;
import id.ac.unej.inaparadise.model.DaftarKontak;
import id.ac.unej.inaparadise.ui.ChatActivity;

public class TabKomunitas extends Fragment {

    List<DaftarKontak> listKomunitas;

    public TabKomunitas() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tab_komunitas, container, false);

        RecyclerView komunitas = root.findViewById(R.id.komunitasku);

        listKomunitas = new ArrayList<>();

        AdapterDaftarPesan adapterKomunitas = new AdapterDaftarPesan(listKomunitas, new AdapterDaftarPesan.OnItemClickListener() {
            @Override
            public void onItemClick(DaftarKontak model) {
                Intent chat = new Intent(getActivity(), ChatActivity.class);
                chat.putExtra("nama", model.getNama());
                startActivity(chat);
            }
        });

        populate();
        komunitas.setLayoutManager(new LinearLayoutManager(getContext()));
        komunitas.setAdapter(adapterKomunitas);
        adapterKomunitas.notifyDataSetChanged();

        return root;
    }

    void populate() {
        listKomunitas.add(new DaftarKontak("0", "Event Lukis Lumajang", "Ella - Sukses buat acaranya", R.drawable.logo_1));
        listKomunitas.add(new DaftarKontak("0", "Pameran Lukis Top", "Hani - Event nasional kembali", R.drawable.logo_2));
    }
}
