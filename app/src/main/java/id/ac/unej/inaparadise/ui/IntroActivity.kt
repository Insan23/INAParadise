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
import id.ac.unej.inaparadise.adapter.SliderAdapter
import android.support.v4.view.ViewPager.OnPageChangeListener
import id.ac.unej.inaparadise.ui.LoginActivity
import android.text.Html
import android.view.View
import android.widget.*
import id.ac.unej.inaparadise.ui.MainActivity
import id.ac.unej.inaparadise.fragment.TabPesan
import id.ac.unej.inaparadise.fragment.TabKomunitas
import id.ac.unej.inaparadise.fragment.DialogBuatKomunitas

class IntroActivity : AppCompatActivity() {
    private var viewpager: ViewPager? = null
    private var liner: LinearLayout? = null
    private var myadapter: SliderAdapter? = null
    private var mdots: Array<TextView?>
    private var next: Button? = null
    private var back: Button? = null
    private var mulai: Button? = null
    private var mCureentPage = 0
    var viewlistener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            adddots(position)
            mCureentPage = position
            if (position == 0) {
                next!!.isEnabled = true
                back!!.isEnabled = false
                back!!.visibility = View.INVISIBLE
                next!!.text = "lanjut"
                back!!.text = ""
            } else if (position == mdots.size - 1) {
                next!!.isEnabled = true
                back!!.isEnabled = true
                back!!.visibility = View.VISIBLE
                next!!.text = ""
                back!!.text = "kembali"
                setMulai(true)
            } else {
                next!!.isEnabled = true
                back!!.isEnabled = true
                back!!.visibility = View.VISIBLE
                next!!.text = "lanjut"
                back!!.text = "kembali"
                setMulai(false)
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        viewpager = findViewById<View>(R.id.viewpager) as ViewPager
        liner = findViewById<View>(R.id.dots) as LinearLayout
        next = findViewById<View>(R.id.nextBtn) as Button
        back = findViewById<View>(R.id.backBtn) as Button
        mulai = findViewById(R.id.mulai)
        myadapter = SliderAdapter(this)
        viewpager!!.adapter = myadapter
        adddots(0)
        viewpager!!.addOnPageChangeListener(viewlistener)
        next!!.setOnClickListener { viewpager!!.currentItem = mCureentPage + 1 }
        back!!.setOnClickListener { viewpager!!.currentItem = mCureentPage - 1 }
        mulai.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@IntroActivity,
                    LoginActivity::class.java
                )
            )
        })
    }

    fun adddots(i: Int) {
        mdots = arrayOfNulls(4)
        liner!!.removeAllViews()
        for (x in mdots.indices) {
            mdots[x] = TextView(this)
            mdots[x]!!.text = Html.fromHtml("&#8226;")
            mdots[x]!!.textSize = 35f
            mdots[x]!!.setTextColor(resources.getColor(R.color.gray))
            liner!!.addView(mdots[x])
        }
        if (mdots.size > 0) {
            mdots[i]!!.setTextColor(resources.getColor(R.color.colorPrimary))
        }
    }

    fun setMulai(status: Boolean) {
        if (status) {
            mulai!!.visibility = View.VISIBLE
        } else {
            mulai!!.visibility = View.GONE
        }
    }
}