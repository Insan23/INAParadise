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
import android.widget.EditText
import id.ac.unej.inaparadise.ui.MainActivity
import id.ac.unej.inaparadise.fragment.TabPesan
import id.ac.unej.inaparadise.fragment.TabKomunitas
import id.ac.unej.inaparadise.fragment.DialogBuatKomunitas

class FeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
    }
}