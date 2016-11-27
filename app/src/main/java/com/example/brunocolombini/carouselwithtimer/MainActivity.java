package com.example.brunocolombini.carouselwithtimer;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.brunocolombini.carouselwithtimer.carousel.adapter.HomeViewPagerAdapter;
import com.example.brunocolombini.carouselwithtimer.carousel.handler.CircularViewPagerHandler;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private final Handler handler = new Handler();
    private Timer swipeTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {git git
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);

        HomeViewPagerAdapter homeViewPagerAdapter = new HomeViewPagerAdapter(this);
        viewPager.setOnPageChangeListener(new CircularViewPagerHandler(viewPager, this));
        viewPager.setAdapter(homeViewPagerAdapter);
        autoChangeViewPagerCarousel(viewPager);


    }


    public void autoChangeViewPagerCarousel(ViewPager viewPager) {
        final int NUM_PAGES = viewPager.getAdapter().getCount() - 1;
        final ViewPager mViewPager = viewPager;


        final Runnable Update = new Runnable() {
            boolean START = false;
            @Override
            public void run() {
                if (mViewPager.getCurrentItem() == NUM_PAGES) {
                    mViewPager.setCurrentItem(0, true);
                    return;
                }
                mViewPager.setCurrentItem(START?mViewPager.getCurrentItem() + 1:mViewPager.getCurrentItem(), true);
                START = true;
            }
        };

        swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 7, 7 * 1000);
    }
}
