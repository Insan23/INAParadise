package id.ac.unej.inaparadise.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.ac.unej.inaparadise.R;
import id.ac.unej.inaparadise.adapter.FeedAdapter;
import id.ac.unej.inaparadise.model.DaftarFeed;

public class Upload extends Fragment {

    List<DaftarFeed> daftarFeed;

    public Upload() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_upload, container, false);

        FloatingActionButton upload = root.findViewById(R.id.upload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        RecyclerView feed = root.findViewById(R.id.umpan);
        daftarFeed = new ArrayList<>();
        FeedAdapter adapter = new FeedAdapter(daftarFeed, new FeedAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DaftarFeed model) {

            }
        });

        populate();
        feed.setLayoutManager(new LinearLayoutManager(getActivity()));
        feed.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return root;
    }

    void populate() {
        //int foto, int fotoUploader, String uploader, long waktu
        daftarFeed.add(new DaftarFeed(R.drawable.foto_1, R.drawable.profil_1, "Aleq", 1));
        daftarFeed.add(new DaftarFeed(R.drawable.foto_2, R.drawable.profil_2, "Ludfi", 3));
        daftarFeed.add(new DaftarFeed(R.drawable.foto_3, R.drawable.profil_3, "Erinda", 5));
        daftarFeed.add(new DaftarFeed(R.drawable.foto_4, R.drawable.profil_2, "Ludfi", 6));
    }
}
