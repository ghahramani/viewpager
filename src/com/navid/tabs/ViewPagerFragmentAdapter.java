package com.navid.tabs;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Navid Ghahramani
 * You can contact to me with ghahramani.navid@gmail.com
 */
public class ViewPagerFragmentAdapter extends PagerAdapter implements ViewPagerDynamicAdapter {
    public static final String TAG = ViewPagerFragmentAdapter.class.getSimpleName();

    private List<ViewPagerFragment> pagerFragments = new ArrayList<ViewPagerFragment>();
    private FragmentManager pagerFragmentManager;
    private FragmentTransaction pagerCurrentTransaction = null;
    private Fragment pagerCurrentPrimaryItem = null;

    public ViewPagerFragmentAdapter(FragmentManager fragmentManager) {
        super();
        this.pagerFragmentManager = fragmentManager;
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

    @Override
    public void startUpdate(ViewGroup container) {
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (pagerCurrentTransaction == null) {
            pagerCurrentTransaction = pagerFragmentManager.beginTransaction();
        }

        final long itemId = getItemId(position);

        // Do we already have this fragment?
        String name = makeFragmentName(container.getId(), itemId);
        Fragment fragment = pagerFragmentManager.findFragmentByTag(name);
        if (fragment != null) {
            pagerCurrentTransaction.attach(fragment);
        } else {
            fragment = getItem(position);
            pagerCurrentTransaction.add(container.getId(), fragment,
                    makeFragmentName(container.getId(), itemId));
        }
        if (fragment != pagerCurrentPrimaryItem) {
            fragment.setMenuVisibility(false);
        }

        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (pagerCurrentTransaction == null) {
            pagerCurrentTransaction = pagerFragmentManager.beginTransaction();
        }
        pagerCurrentTransaction.detach((Fragment) object);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        Fragment fragment = (Fragment) object;
        if (fragment != pagerCurrentPrimaryItem) {
            if (pagerCurrentPrimaryItem != null) {
                pagerCurrentPrimaryItem.setMenuVisibility(false);

            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
            }
            pagerCurrentPrimaryItem = fragment;
        }
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        if (pagerCurrentTransaction != null) {
            pagerCurrentTransaction.commitAllowingStateLoss();
            pagerCurrentTransaction = null;
            pagerFragmentManager.executePendingTransactions();
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return ((Fragment) object).getView() == view;
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    /**
     * Return a unique identifier for the item at the given position.
     * <p/>
     * <p>The default implementation returns the given position.
     * Subclasses should override this method if the positions of items can change.</p>
     *
     * @param position Position within this adapter
     * @return Unique identifier for the item at position
     */
    public long getItemId(int position) {
        return position;
    }

    private static String makeFragmentName(int viewId, long id) {
        return "android:switcher:" + viewId + ":" + id;
    }
}
