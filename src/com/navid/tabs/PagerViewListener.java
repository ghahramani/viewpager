package com.navid.tabs;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import org.appcelerator.kroll.KrollDict;
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

    public void addAllListener() {
        addPageChangeLister();
        addTouchLister();
        addClickLister();
        addLongClickLister();
        addFocusChangeLister();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (!proxy.hasListeners(PAGE_SCROLLED_EVENT_NAME)) {
            return;
        }

        KrollDict options = new KrollDict();
        options.put("position", position);
        options.put("positionOffset", positionOffset);
        options.put("positionOffsetPixels", positionOffsetPixels);
        proxy.fireEvent(PAGE_SCROLLED_EVENT_NAME, options, true);
    }

    @Override
    public void onPageSelected(int position) {
        if (!proxy.hasListeners(PAGE_SELECTED_EVENT_NAME)) {
            return;
        }

        KrollDict options = new KrollDict();
        options.put("position", position);
        proxy.fireEvent(PAGE_SELECTED_EVENT_NAME, options, true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (!proxy.hasListeners(PAGE_SCROLL_STATE_CHANGED_EVENT_NAME)) {
            return;
        }

        KrollDict options = new KrollDict();
        options.put("state", state);
        proxy.fireEvent(PAGE_SCROLL_STATE_CHANGED_EVENT_NAME, options, true);
    }

    @Override
    public void onClick(View v) {
        if (!proxy.hasListeners(CLICK_EVENT_NAME)) {
            return;
        }

        proxy.fireEvent(CLICK_EVENT_NAME, null, true);
    }

    @Override
    public boolean onLongClick(View v) {
        return proxy.hasListeners(LONG_CLICK_EVENT_NAME) && proxy.fireEvent(LONG_CLICK_EVENT_NAME, null, true);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!proxy.hasListeners(FOCUS_CHANGE_EVENT_NAME)) {
            return;
        }

        KrollDict options = new KrollDict();
        options.put("hasFocus", hasFocus);
        proxy.fireEvent(FOCUS_CHANGE_EVENT_NAME, options, true);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (!proxy.hasListeners(TOUCH_EVENT_NAME)) {
            return false;
        }

        KrollDict options = new KrollDict();
        options.put("event", event);
        proxy.fireEvent(TOUCH_EVENT_NAME, options, true);
        return false;
    }
}
