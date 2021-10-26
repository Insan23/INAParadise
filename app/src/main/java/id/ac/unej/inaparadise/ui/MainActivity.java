package id.ac.unej.inaparadise.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import id.ac.unej.inaparadise.R;
import id.ac.unej.inaparadise.adapter.TabAdapter;
import id.ac.unej.inaparadise.fragment.Notifikasi;
import id.ac.unej.inaparadise.fragment.TabInformasi;
import id.ac.unej.inaparadise.fragment.TabKebudayaan;
import id.ac.unej.inaparadise.fragment.TabPermainan;
import id.ac.unej.inaparadise.fragment.Upload;
import id.ac.unej.inaparadise.support.BottomNavigationViewBehavior;
import id.ac.unej.inaparadise.ui.CommunityActivity;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigation;
    FragmentManager fm;
    boolean back = false;
    Upload fUpload;
    Notifikasi fNotifikasi;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int selectedItem = navigation.getSelectedItemId();
            switch (item.getItemId()) {
                case R.id.pengetahuan:
//                    startActivity(new Intent(MainActivity.this, ));
                    findViewById(R.id.frame_utama).setVisibility(View.GONE);
                    findViewById(R.id.layout_utama).setVisibility(View.VISIBLE);
                    return true;
                case R.id.komunitas:
                    startActivity(new Intent(MainActivity.this, CommunityActivity.class));
                    return true;
                case R.id.upload:
                    findViewById(R.id.frame_utama).setVisibility(View.VISIBLE);
                    findViewById(R.id.layout_utama).setVisibility(View.GONE);
                    fm.beginTransaction().replace(R.id.frame_utama, fUpload, "upload").commit();
                    return true;
                case R.id.info:
//                    fm.beginTransaction().replace(R.id.frame_utama, new Upload(), "upload").commit();
                    return true;
                case R.id.notifikasi:
                    findViewById(R.id.frame_utama).setVisibility(View.VISIBLE);
                    findViewById(R.id.layout_utama).setVisibility(View.GONE);
                    fm.beginTransaction().replace(R.id.frame_utama, fNotifikasi, "notifikasi").commit();
                    return true;
                default:
                    //nothing
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();

        TabLayout tab = findViewById(R.id.tab_menu_utama);
        ViewPager pager = findViewById(R.id.pager_menu_utama);
        fUpload = new Upload();
        fNotifikasi = new Notifikasi();

        TabAdapter menuUtamaAdapter = new TabAdapter(getSupportFragmentManager());
        menuUtamaAdapter.addFragment(new TabKebudayaan(), "Kebudayaan");
        menuUtamaAdapter.addFragment(new TabPermainan(), "Permainan");
        menuUtamaAdapter.addFragment(new TabInformasi(), "Informasi");

        pager.setAdapter(menuUtamaAdapter);
        tab.setupWithViewPager(pager);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());
    }

    @Override
    public void onBackPressed() {
        Fragment upload = getSupportFragmentManager().findFragmentByTag("upload");
        Fragment notifikasi = getSupportFragmentManager().findFragmentByTag("notifikasi");
        if (upload != null && upload.isVisible()) {
            fm.beginTransaction().remove(fUpload).commit();
            findViewById(R.id.frame_utama).setVisibility(View.GONE);
            findViewById(R.id.layout_utama).setVisibility(View.VISIBLE);
        } else if (notifikasi != null && notifikasi.isVisible()) {
            fm.beginTransaction().remove(fNotifikasi).commit();
            findViewById(R.id.frame_utama).setVisibility(View.GONE);
            findViewById(R.id.layout_utama).setVisibility(View.VISIBLE);
        } else {
            if (back) {
                super.onBackPressed();
                return;
            }
            back = true;
            Toast.makeText(this, "Tekan Kembali Lagi Untuk Keluar", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    back = false;
                }
            }, 2000);
        }
    }
}
