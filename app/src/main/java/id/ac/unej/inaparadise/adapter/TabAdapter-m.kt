package id.ac.unej.inaparadise.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import id.ac.unej.inaparadise.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.BaseAdapter
import java.util.ArrayList

class TabAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    private val fragmentList: MutableList<Fragment> = ArrayList()
    private val fragmentListTitle: MutableList<String> = ArrayList()
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentListTitle[position]
    }

    override fun getCount(): Int {
        return fragmentListTitle.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentListTitle.add(title)
    }
}