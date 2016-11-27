package com.example.brunocolombini.carouselwithtimer.carousel.handler;


import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.brunocolombini.carouselwithtimer.R;

public class CircularViewPagerHandler implements ViewPager.OnPageChangeListener {
    private Activity mActivity;
    private ViewPager mViewPager;
    private int mCurrentPosition;
    private int mScrollState;
    private boolean changed = true;

    public CircularViewPagerHandler(final ViewPager viewPager, Activity activity) {
        mViewPager = viewPager;
        mActivity = activity;
    }

    @Override
    public void onPageSelected(final int position) {
        mCurrentPosition = position;
        isSelectedItem(position);
    }

    @Override
    public void onPageScrollStateChanged(final int state) {
        handleScrollState(state);
        mScrollState = state;
    }

    private void handleScrollState(final int state) {
        if (state == ViewPager.SCROLL_STATE_IDLE) {
            setNextItemIfNeeded();
        }
    }

    private void setNextItemIfNeeded() {
        if (!isScrollStateSettling()) {
            handleSetNextItem();
        }
    }

    private boolean isScrollStateSettling() {
        return mScrollState == ViewPager.SCROLL_STATE_SETTLING;
    }

    private void handleSetNextItem() {
        final int lastPosition = mViewPager.getAdapter().getCount() - 1;
        if (mCurrentPosition == 0 && changed) {
            changed = false;
            mViewPager.setCurrentItem(lastPosition, true);
            mViewPager.beginFakeDrag();
            isSelectedItem(lastPosition);
        } else if (mCurrentPosition == lastPosition && changed) {
            changed = false;
            mViewPager.setCurrentItem(0, true);
            mViewPager.beginFakeDrag();
            isSelectedItem(0);
        } else {
            changed = true;
        }
    }

    @Override
    public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
    }

    private void isSelectedItem(int position) {
        createSelectedItens(mViewPager,position);
    }



    public void createSelectedItens(ViewPager mViewPager) {
        makeItens(mViewPager,0);
    }

    public void createSelectedItens(ViewPager mViewPager,int mCurrentPosition) {
        makeItens(mViewPager,mCurrentPosition);
    }

    private void makeItens(ViewPager mViewPager,int mCurrentPosition){
        int position = mCurrentPosition;
        final int NUM_PAGES = mViewPager.getAdapter().getCount();

        LinearLayout linearLayout = (LinearLayout) mActivity.findViewById(R.id.indicator);
        linearLayout.removeAllViews();
        int density = (int) linearLayout.getResources().getDisplayMetrics().density;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20 * density, LinearLayout.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < NUM_PAGES; i++) {
            ImageView imageView = new ImageView(mActivity);
            imageView.setImageResource(i == position ? R.drawable.selecteditem_dot : R.drawable.nonselecteditem_dot);
            imageView.setLayoutParams(layoutParams);
            linearLayout.addView(imageView);
        }
    }

}