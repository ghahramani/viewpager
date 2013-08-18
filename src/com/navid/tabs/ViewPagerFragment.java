package com.navid.tabs;

/**
 * Author: Navid Ghahramani
 * You can contact to me with ghahramani.navid@gmail.com
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Author: Navid Ghahramani
 * You can contact to me with ghahramani.navid@gmail.com
 */
public class ViewPagerFragment extends Fragment {
    public static final String TAG = ViewPagerFragment.class.getSimpleName();
    protected String title;
    protected View content;

    public ViewPagerFragment(String title, View view) {
        super();
        this.content = view;
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        FrameLayout layout = new FrameLayout(getActivity());
        layout.setLayoutParams(params);
        layout.addView(content);
        return layout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (content.getParent() != null) {
            ((ViewGroup) content.getParent()).removeView(content);
        }

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public View getContent() {
        return content;
    }

    public void setContent(View content) {
        this.content = content;
    }
}