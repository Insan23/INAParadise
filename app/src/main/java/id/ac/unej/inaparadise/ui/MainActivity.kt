package id.ac.unej.inaparadise.ui

import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.MenuItem
import android.view.View
import id.ac.unej.inaparadise.adapter.TabAdapter
import id.ac.unej.inaparadise.support.BottomNavigationViewBehavior

class MainActivity : AppCompatActivity() {
    var navigation: BottomNavigationView? = null
    var fm: FragmentManager? = null
    var back = false
    var fUpload: Upload? = null
    var fNotifikasi: Notifikasi? = null
    private val mOnNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                val selectedItem: Int = navigation.getSelectedItemId()
                when (item.itemId) {
                    R.id.pengetahuan -> {
                        //                    startActivity(new Intent(MainActivity.this, ));
                        findViewById<View>(R.id.frame_utama).setVisibility(View.GONE)
                        findViewById<View>(R.id.layout_utama).setVisibility(View.VISIBLE)
                        return true
                    }
                    R.id.komunitas -> {
                        startActivity(Intent(this@MainActivity, CommunityActivity::class.java))
                        return true
                    }
                    R.id.upload -> {
                        findViewById<View>(R.id.frame_utama).setVisibility(View.VISIBLE)
                        findViewById<View>(R.id.layout_utama).setVisibility(View.GONE)
                        fm!!.beginTransaction().replace(R.id.frame_utama, fUpload, "upload")
                            .commit()
                        return true
                    }
                    R.id.info -> //                    fm.beginTransaction().replace(R.id.frame_utama, new Upload(), "upload").commit();
                        return true
                    R.id.notifikasi -> {
                        findViewById<View>(R.id.frame_utama).setVisibility(View.VISIBLE)
                        findViewById<View>(R.id.layout_utama).setVisibility(View.GONE)
                        fm!!.beginTransaction().replace(R.id.frame_utama, fNotifikasi, "notifikasi")
                            .commit()
                        return true
                    }
                    else -> {
                    }
                }
                return false
            }
        }

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fm = getSupportFragmentManager()
        val tab: TabLayout = findViewById<TabLayout>(R.id.tab_menu_utama)
        val pager: ViewPager = findViewById<ViewPager>(R.id.pager_menu_utama)
        fUpload = Upload()
        fNotifikasi = Notifikasi()
        val menuUtamaAdapter = TabAdapter(getSupportFragmentManager())
        menuUtamaAdapter.addFragment(TabKebudayaan(), "Kebudayaan")
        menuUtamaAdapter.addFragment(TabPermainan(), "Permainan")
        menuUtamaAdapter.addFragment(TabInformasi(), "Informasi")
        pager.setAdapter(menuUtamaAdapter)
        tab.setupWithViewPager(pager)
        navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val layoutParams: CoordinatorLayout.LayoutParams =
            navigation.getLayoutParams() as CoordinatorLayout.LayoutParams
        layoutParams.setBehavior(BottomNavigationViewBehavior())
    }

    override fun onBackPressed() {
        val upload: Fragment = getSupportFragmentManager().findFragmentByTag("upload")
        val notifikasi: Fragment = getSupportFragmentManager().findFragmentByTag("notifikasi")
        if (upload != null && upload.isVisible) {
            fm!!.beginTransaction().remove(fUpload).commit()
            findViewById<View>(R.id.frame_utama).setVisibility(View.GONE)
            findViewById<View>(R.id.layout_utama).setVisibility(View.VISIBLE)
        } else if (notifikasi != null && notifikasi.isVisible) {
            fm!!.beginTransaction().remove(fNotifikasi).commit()
            findViewById<View>(R.id.frame_utama).setVisibility(View.GONE)
            findViewById<View>(R.id.layout_utama).setVisibility(View.VISIBLE)
        } else {
            if (back) {
                super.onBackPressed()
                return
            }
            back = true
            Toast.makeText(this, "Tekan Kembali Lagi Untuk Keluar", Toast.LENGTH_LONG).show()
            Handler().postDelayed({ back = false }, 2000)
        }
    }
}