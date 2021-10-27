package id.ac.unej.inaparadise.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import id.ac.unej.inaparadise.R;

/**
 * Created by Sumeet Jain on 25-02-2018.
 */

public class SliderAdapter extends PagerAdapter {

    //Array
    public int[] list_images = {
            R.drawable.intro_1,
            R.drawable.intro_2,
            R.drawable.intro_3,
            R.drawable.intro_4
    };
    public String[] list_title = {
            "Belajar",
            "Adu Pengetahuan",
            "Upload",
            "Komunitas"
    };
    public String[] list_description = {
            "Ayo belajar dan mengenal Budaya Indonesia bersama INA Paradise, Pasti Seru",
            "Adu pengetahuanmu tentang Budaya Indonesia bersama kawanmu",
            "Upload karyamu ke INA Paradise agar orang lain bisa mengetahui karyamu",
            "Temukan kawanmu di berbagai daerah, buat komunitasmu, dan temukan karya-karya luar biasa dari seniman Indonesia"
    };
    public int[] list_color = {
            Color.rgb(255, 255, 255),
            Color.rgb(255, 255, 255),
            Color.rgb(255, 255, 255),
            Color.rgb(255, 255, 255)

    };
    Context context;
    LayoutInflater inflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.intro_slide, container, false);

        RelativeLayout linearLayout = (RelativeLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView img = (ImageView) view.findViewById(R.id.slideimg);
        TextView txt1 = (TextView) view.findViewById(R.id.slidetitle);
        TextView txt2 = (TextView) view.findViewById(R.id.slidedescription);

        img.setImageResource(list_images[position]);
        txt1.setText(list_title[position]);
        txt2.setText(list_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
