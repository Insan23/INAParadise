package id.ac.unej.inaparadise.adapter

import android.content.Context
import android.graphics.Color
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import id.ac.unej.inaparadise.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.BaseAdapter
import android.widget.ImageView

/**
 * Created by Sumeet Jain on 25-02-2018.
 */
class SliderAdapter(var context: Context) : PagerAdapter() {
    //Array
    var list_images = intArrayOf(
        R.drawable.intro_1,
        R.drawable.intro_2,
        R.drawable.intro_3,
        R.drawable.intro_4
    )
    var list_title = arrayOf(
        "Belajar",
        "Adu Pengetahuan",
        "Upload",
        "Komunitas"
    )
    var list_description = arrayOf(
        "Ayo belajar dan mengenal Budaya Indonesia bersama INA Paradise, Pasti Seru",
        "Adu pengetahuanmu tentang Budaya Indonesia bersama kawanmu",
        "Upload karyamu ke INA Paradise agar orang lain bisa mengetahui karyamu",
        "Temukan kawanmu di berbagai daerah, buat komunitasmu, dan temukan karya-karya luar biasa dari seniman Indonesia"
    )
    var list_color = intArrayOf(
        Color.rgb(255, 255, 255),
        Color.rgb(255, 255, 255),
        Color.rgb(255, 255, 255),
        Color.rgb(255, 255, 255)
    )
    var inflater: LayoutInflater? = null
    override fun getCount(): Int {
        return list_title.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.intro_slide, container, false)
        val linearLayout = view.findViewById<View>(R.id.slidelinearlayout) as RelativeLayout
        val img = view.findViewById<View>(R.id.slideimg) as ImageView
        val txt1 = view.findViewById<View>(R.id.slidetitle) as TextView
        val txt2 = view.findViewById<View>(R.id.slidedescription) as TextView
        img.setImageResource(list_images[position])
        txt1.text = list_title[position]
        txt2.text = list_description[position]
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}