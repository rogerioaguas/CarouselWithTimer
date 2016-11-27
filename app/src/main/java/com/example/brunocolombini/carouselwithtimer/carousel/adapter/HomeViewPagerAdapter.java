package com.example.brunocolombini.carouselwithtimer.carousel.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.brunocolombini.carouselwithtimer.R;


public class HomeViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int[] mResources = {
            R.mipmap.image_1,
            R.mipmap.image_2,
            R.mipmap.image_3,
            R.mipmap.image_4,
    };


    public HomeViewPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.adapter_viewpager, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.image_view);
        imageView.setImageResource(mResources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
