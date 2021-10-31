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

public class TabPesan extends Fragment {

    List<DaftarKontak> listPrioritas;
    List<DaftarKontak> listSemuaChat;

    public TabPesan() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tab_pesan, container, false);

        RecyclerView prioritas = root.findViewById(R.id.prioritas);
        RecyclerView semuaChat = root.findViewById(R.id.semua_chat);

        listPrioritas = new ArrayList<>();
        listSemuaChat = new ArrayList<>();

        AdapterDaftarPesan adapterPrioritas = new AdapterDaftarPesan(listPrioritas, new AdapterDaftarPesan.OnItemClickListener() {
            @Override
            public void onItemClick(DaftarKontak model) {
                Intent chat = new Intent(getActivity(), ChatActivity.class);
                chat.putExtra("nama", model.getNama());
                startActivity(chat);
            }
        });

        AdapterDaftarPesan adapterSemuaChat = new AdapterDaftarPesan(listSemuaChat, new AdapterDaftarPesan.OnItemClickListener() {
            @Override
            public void onItemClick(DaftarKontak model) {
                Intent chat = new Intent(getActivity(), ChatActivity.class);
                chat.putExtra("nama", model.getNama());
                startActivity(chat);
            }
        });

        prioritas.setLayoutManager(new LinearLayoutManager(getContext()));
        semuaChat.setLayoutManager(new LinearLayoutManager(getContext()));

        populate();
        prioritas.setAdapter(adapterPrioritas);
        semuaChat.setAdapter(adapterSemuaChat);

        adapterPrioritas.notifyDataSetChanged();
        adapterSemuaChat.notifyDataSetChanged();

        return root;
    }

    void populate() {
        //String id, String nama, String preview
        listSemuaChat.add(new DaftarKontak("0", "Ludfi Ika P", "Hari ini mau gathering dimana?", R.drawable.profil_2));
        listSemuaChat.add(new DaftarKontak("0", "Aleq", "Saya punya solusi untuk itu", R.drawable.profil_1));
        listSemuaChat.add(new DaftarKontak("0", "Erinda", "Ada pagelaran di kota", R.drawable.profil_3));

    }
}
