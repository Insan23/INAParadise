package id.ac.unej.inaparadise.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import id.ac.unej.inaparadise.R;
import id.ac.unej.inaparadise.adapter.TabAdapter;
import id.ac.unej.inaparadise.fragment.DialogBuatKomunitas;
import id.ac.unej.inaparadise.fragment.DialogKonfirmasi;
import id.ac.unej.inaparadise.fragment.TabKomunitas;
import id.ac.unej.inaparadise.fragment.TabPesan;

public class CommunityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        TabLayout tab = findViewById(R.id.tab_menu_komunitas);
        ViewPager pager = findViewById(R.id.pager_menu_komunitas);

        TabAdapter menuKomunitas = new TabAdapter(getSupportFragmentManager());
        menuKomunitas.addFragment(new TabPesan(), "Pesan");
        menuKomunitas.addFragment(new TabKomunitas(), "Komunitas");

        pager.setAdapter(menuKomunitas);
        tab.setupWithViewPager(pager);

        findViewById(R.id.fab_komunitas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                DialogBuatKomunitas kom = new DialogBuatKomunitas();
                kom.show(ft, "dialog_komunitas");
//                kom.onDismiss(new DialogInterface() {
//                    @Override
//                    public void cancel() {
//
//                    }
//
//                    @Override
//                    public void dismiss() {
//                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                        DialogKonfirmasi kon = new DialogKonfirmasi();
//                        kon.show(ft, "konfirmasi");
//                    }
//                });


            }
        });
    }
}
