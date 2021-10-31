package id.ac.unej.inaparadise.adapter

import android.content.Context
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

class GridViewAdapter(private val mContext: Context) : BaseAdapter() {
    // references to our images
    private val mThumbIds = arrayOf(
        R.drawable.ic_tarian, R.drawable.ic_makanan,
        R.drawable.ic_senjata, R.drawable.ic_rumah,
        R.drawable.ic_alat_musik, R.drawable.ic_pakaian
    )

    override fun getCount(): Int {
        return mThumbIds.size
    }

    override fun getItem(position: Int): Any {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    // create a new ImageView for each item referenced by the Adapter
    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        val imageView: ImageView
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = ImageView(mContext)
            imageView.layoutParams = ViewGroup.LayoutParams(parent.width / 2, parent.width / 2)
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            imageView.setPadding(8, 8, 8, 8)
        } else {
            imageView = convertView as ImageView
        }
        imageView.setImageResource(mThumbIds[position])
        return imageView
    }
}