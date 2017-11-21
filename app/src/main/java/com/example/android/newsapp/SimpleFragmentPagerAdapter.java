package com.example.android.newsapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by marcelo on 20/11/17.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    // App Context
    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);

        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // Get fragment based on item position
        switch (position) {
            case 0:
                return new Section1Fragment();
            case 1:
                return new Section2Fragment();
            case 2:
                return new Section3Fragment();
            case 3:
                return new Section4Fragment();
            default:
                return new Section1Fragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Get page title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.category_section_1);
            case 1:
                return mContext.getString(R.string.category_section_2);
            case 2:
                return mContext.getString(R.string.category_section_3);
            case 3:
                return mContext.getString(R.string.category_section_4);
            default:
                return mContext.getString(R.string.category_section_1);
        }
    }

}
