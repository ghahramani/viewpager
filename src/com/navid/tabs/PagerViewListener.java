package com.navid.tabs;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import org.appcelerator.titanium.proxy.TiViewProxy;

import static com.navid.tabs.PagerTabsModule.*;

/**
 * Author: Navid Ghahramani
 * You can contact to me with ghahramani.navid@gmail.com
 */
public class PagerViewListener implements ViewPager.OnPageChangeListener, ViewPager.OnTouchListener, View.OnLongClickListener,
        View.OnClickListener, View.OnFocusChangeListener {

    protected TiViewProxy proxy;
    protected ViewPager pager;
    protected ViewPagerDynamicAdapter adapter;

    public PagerViewListener(TiViewProxy proxy, ViewPager viewPager, ViewPagerDynamicAdapter adapter) {
        this.proxy = proxy;
        this.pager = viewPager;
        this.adapter = adapter;
    }

    public void addPageChangeLister() {
        pager.setOnPageChangeListener(this);
    }

    public void addTouchLister() {
        pager.setOnTouchListener(this);
    }

    public void addClickLister() {
        pager.setOnClickListener(this);
    }

    public void addLongClickLister() {
        pager.setOnLongClickListener(this);
    }

    public void addFocusChangeLister() {
        pager.setOnFocusChangeListener(this);
    }

    public void addAllListener(){
        addPageChangeLister();
        addTouchLister();
        addClickLister();
        addLongClickLister();
        addFocusChangeLister();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        proxy.fireEvent(PAGE_SCROLLED_EVENT_NAME, adapter.getView(position), true);
    }

    @Override
    public void onPageSelected(int position) {
        proxy.fireEvent(PAGE_SELECTED_EVENT_NAME, adapter.getView(position), true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        proxy.fireEvent(PAGE_SCROLL_STATE_CHANGED_EVENT_NAME, state, true);
    }

    @Override
    public void onClick(View v) {
        proxy.fireEvent(CLICK_EVENT_NAME, v, true);
    }

    @Override
    public boolean onLongClick(View v) {
        return proxy.fireEvent(LONG_CLICK_EVENT_NAME, v, true);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        proxy.fireEvent(FOCUS_CHANGE_EVENT_NAME, hasFocus, true);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        proxy.fireEvent(TOUCH_EVENT_NAME, event, true);
        return false;
    }
}
