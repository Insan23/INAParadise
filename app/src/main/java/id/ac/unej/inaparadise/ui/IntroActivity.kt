package id.ac.unej.inaparadise.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import id.ac.unej.inaparadise.R;
import id.ac.unej.inaparadise.adapter.SliderAdapter;

public class IntroActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private LinearLayout liner;
    private SliderAdapter myadapter;

    private TextView[] mdots;
    private Button next, back, mulai;

    private int mCureentPage;
    ViewPager.OnPageChangeListener viewlistener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            adddots(position);
            mCureentPage = position;

            if (position == 0) {
                next.setEnabled(true);
                back.setEnabled(false);
                back.setVisibility(View.INVISIBLE);

                next.setText("lanjut");
                back.setText("");
            } else if (position == mdots.length - 1) {
                next.setEnabled(true);
                back.setEnabled(true);
                back.setVisibility(View.VISIBLE);

                next.setText("");
                back.setText("kembali");
                setMulai(true);
            } else {
                next.setEnabled(true);
                back.setEnabled(true);
                back.setVisibility(View.VISIBLE);

                next.setText("lanjut");
                back.setText("kembali");
                setMulai(false);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        viewpager = (ViewPager) findViewById(R.id.viewpager);
        liner = (LinearLayout) findViewById(R.id.dots);

        next = (Button) findViewById(R.id.nextBtn);
        back = (Button) findViewById(R.id.backBtn);
        mulai = findViewById(R.id.mulai);

        myadapter = new SliderAdapter(this);
        viewpager.setAdapter(myadapter);
        adddots(0);

        viewpager.addOnPageChangeListener(viewlistener);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpager.setCurrentItem(mCureentPage + 1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpager.setCurrentItem(mCureentPage - 1);
            }
        });
        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
            }
        });
    }

    public void adddots(int i) {

        mdots = new TextView[4];
        liner.removeAllViews();

        for (int x = 0; x < mdots.length; x++) {
            mdots[x] = new TextView(this);
            mdots[x].setText(Html.fromHtml("&#8226;"));
            mdots[x].setTextSize(35);
            mdots[x].setTextColor(getResources().getColor(R.color.gray));

            liner.addView(mdots[x]);
        }
        if (mdots.length > 0) {
            mdots[i].setTextColor(getResources().getColor(R.color.colorPrimary));
        }

    }

    public void setMulai(boolean status) {
        if (status) {
            mulai.setVisibility(View.VISIBLE);
        } else {
            mulai.setVisibility(View.GONE);
        }
    }

}
