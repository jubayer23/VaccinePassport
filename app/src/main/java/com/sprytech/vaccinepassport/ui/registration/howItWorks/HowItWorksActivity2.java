package com.sprytech.vaccinepassport.ui.registration.howItWorks;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.sprytech.vaccinepassport.R;
import com.sprytech.vaccinepassport.ui.registration.RegistrationConfirmationActivity;

public class HowItWorksActivity2 extends AppCompatActivity {


    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private RelativeLayout  btnNext;
    private ImageView dot_1, dot_2, dot_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch - before calling setContentView()


        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_how_it_works);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);

        btnNext =  findViewById(R.id.btn_next);
        dot_1 =  findViewById(R.id.dot_active_slide_1);
        dot_2 =  findViewById(R.id.dot_active_slide_2);
        dot_3 =  findViewById(R.id.dot_active_slide_3);


        // layouts of welcome sliders
        layouts = new int[]{
                R.layout.howitworks_slide_1,
                R.layout.howitworks_slide_2,
                R.layout.howitworks_slide_3
        };

        // adding bottom dots
        addBottomDots(0);

        // making notification bar transparent
        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

       /* btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //launchHomeScreen();
            }
        });*/

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page if true launch MainActivity
                int current = getItem(+1);
                if (current < layouts.length) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {
                    //launchHomeScreen();
                    startActivity(new Intent(HowItWorksActivity2.this, RegistrationConfirmationActivity.class));
                }
            }
        });
    }


    private void addBottomDots(int currentPage) {


        if(currentPage == 0){

            dot_1.setImageDrawable(getResources().getDrawable(R.drawable.ic_dot_active));
            dot_2.setImageDrawable(getResources().getDrawable(R.drawable.ic_dot_inactive));
            dot_3.setImageDrawable(getResources().getDrawable(R.drawable.ic_dot_inactive));
        }else if(currentPage == 1){

            dot_1.setImageDrawable(getResources().getDrawable(R.drawable.ic_dot_inactive));
            dot_2.setImageDrawable(getResources().getDrawable(R.drawable.ic_dot_active));
            dot_3.setImageDrawable(getResources().getDrawable(R.drawable.ic_dot_inactive));
        }else if(currentPage == 2){

            dot_1.setImageDrawable(getResources().getDrawable(R.drawable.ic_dot_inactive));
            dot_2.setImageDrawable(getResources().getDrawable(R.drawable.ic_dot_inactive));
            dot_3.setImageDrawable(getResources().getDrawable(R.drawable.ic_dot_active));
        }


    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }



    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
               // btnNext.setText("Start");
               // btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
               // btnNext.setText("Next");
               // btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    // Making notification bar transparent

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}


