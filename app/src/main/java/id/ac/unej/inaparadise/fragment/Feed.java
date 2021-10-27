package id.ac.unej.inaparadise.fragment;

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
import id.ac.unej.inaparadise.adapter.FeedAdapter;
import id.ac.unej.inaparadise.model.DaftarFeed;

public class Feed extends Fragment {

    List<DaftarFeed> daftarFeed;

    public Feed() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_feed, container, false);

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
        daftarFeed.add(new DaftarFeed());
    }
}
