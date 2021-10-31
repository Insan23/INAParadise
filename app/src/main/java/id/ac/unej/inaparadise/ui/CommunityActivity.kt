package id.ac.unej.inaparadise.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.ac.unej.inaparadise.R
import android.support.design.widget.BottomNavigationView
import id.ac.unej.inaparadise.fragment.Upload
import id.ac.unej.inaparadise.fragment.Notifikasi
import android.content.Intent
import id.ac.unej.inaparadise.ui.CommunityActivity
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import id.ac.unej.inaparadise.fragment.TabKebudayaan
import id.ac.unej.inaparadise.fragment.TabPermainan
import id.ac.unej.inaparadise.fragment.TabInformasi
import android.support.design.widget.CoordinatorLayout
import android.widget.Toast
import android.widget.LinearLayout
import id.ac.unej.inaparadise.adapter.SliderAdapter
import android.widget.TextView
import android.support.v4.view.ViewPager.OnPageChangeListener
import id.ac.unej.inaparadise.ui.LoginActivity
import android.text.Html
import android.view.View
import android.widget.EditText
import id.ac.unej.inaparadise.adapter.TabAdapter
import id.ac.unej.inaparadise.ui.MainActivity
import id.ac.unej.inaparadise.fragment.TabPesan
import id.ac.unej.inaparadise.fragment.TabKomunitas
import id.ac.unej.inaparadise.fragment.DialogBuatKomunitas

class CommunityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)
        val tab = findViewById<TabLayout>(R.id.tab_menu_komunitas)
        val pager = findViewById<ViewPager>(R.id.pager_menu_komunitas)
        val menuKomunitas = TabAdapter(supportFragmentManager)
        menuKomunitas.addFragment(TabPesan(), "Pesan")
        menuKomunitas.addFragment(TabKomunitas(), "Komunitas")
        pager.adapter = menuKomunitas
        tab.setupWithViewPager(pager)
        findViewById<View>(R.id.fab_komunitas).setOnClickListener {
            val ft = supportFragmentManager.beginTransaction()
            val kom = DialogBuatKomunitas()
            kom.show(ft, "dialog_komunitas")
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
    }
}