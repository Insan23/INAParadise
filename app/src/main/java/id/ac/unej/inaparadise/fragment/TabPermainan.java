package id.ac.unej.inaparadise.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import id.ac.unej.inaparadise.R;
import id.ac.unej.inaparadise.adapter.GridViewAdapter;
import id.ac.unej.inaparadise.ui.MapActivity;

public class TabPermainan extends Fragment {

    public TabPermainan() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tab_permainan, container, false);
        GridView gridview = root.findViewById(R.id.menu_kebudayaan);
        gridview.setAdapter(new GridViewAdapter(getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(HelloGridView.this, "" + position, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MapActivity.class));
            }
        });

        return root;
    }
}