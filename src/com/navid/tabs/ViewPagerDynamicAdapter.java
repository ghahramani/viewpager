package com.navid.tabs;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Author: Navid Ghahramani
 * You can contact to me with ghahramani.navid@gmail.com
 */
public interface ViewPagerDynamicAdapter {
    public int addView(String title, View view);

    public int addView(String title, View view, int position);

    public int removeView(ViewPager viewPager, View view);

    public int removeView(ViewPager viewPager, int position);

    public View getView(int position);

    public int getCount();

    public CharSequence getPageTitle(int position);
}
