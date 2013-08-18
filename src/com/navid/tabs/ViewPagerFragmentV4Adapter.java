package com.navid.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import org.appcelerator.titanium.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Navid Ghahramani
 * You can contact to me with ghahramani.navid@gmail.com
 */
public class ViewPagerFragmentV4Adapter extends FragmentStatePagerAdapter implements ViewPagerDynamicAdapter {
    public static final String TAG = ViewPagerFragmentV4Adapter.class.getSimpleName();

    private List<ViewPagerFragment> pagerFragments = new ArrayList<ViewPagerFragment>();

    public ViewPagerFragmentV4Adapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int addView(String title, View view) {
        return addView(title, view, pagerFragments.size());
    }

    @Override
    public int addView(String title, View view, int position) {
        pagerFragments.add(position, new ViewPagerFragment(title, view));
        notifyDataSetChanged();
        return position;
    }

    @Override
    public int removeView(ViewPager viewPager, View view) {
        for (int i = 0; i < pagerFragments.size(); i++) {
            ViewPagerFragment fragment = pagerFragments.get(i);
            if (fragment.getContent().equals(view)) {
                return removeView(viewPager, i);
            }
        }
        return -1;
    }

    @Override
    public int removeView(ViewPager viewPager, int position) {
        viewPager.setAdapter(null);
        pagerFragments.remove(position);
        viewPager.setAdapter(this);
        return position;
    }

    @Override
    public View getView(int position) {
        return pagerFragments.get(position).getContent();
    }

    /**
     * Return the Fragment associated with a specified position.
     */
    public Fragment getItem(int position) {
        return pagerFragments.get(position);
    }

    @Override
    public int getCount() {
        return pagerFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pagerFragments.get(position).getTitle();
    }
}
