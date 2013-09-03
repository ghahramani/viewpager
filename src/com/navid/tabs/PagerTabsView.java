package com.navid.tabs;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.astuetz.viewpager.extensions.PagerSlidingTabStrip;
import com.astuetz.viewpager.extensions.R;
import org.appcelerator.kroll.KrollDict;
import org.appcelerator.titanium.proxy.TiBaseWindowProxy;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.util.TiUIHelper;
import org.appcelerator.titanium.view.TiUIView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author: Navid Ghahramani
 * You can contact to me with ghahramani.navid@gmail.com
 */
public class PagerTabsView extends TiUIView {
    public static final String TAG = PagerTabsView.class.getSimpleName();

    private ViewPagerDynamicAdapter adapter;
    private ViewPager viewPager;
    private final PagerSlidingTabStrip tabStrip;
    private final List<TiViewProxy> viewProxies;

    public PagerTabsView(final TiViewProxy pagerTabProxy, KrollDict properties) {
        this(pagerTabProxy);
        applyProperties(properties, null);
    }

    public PagerTabsView(final TiViewProxy pagerTabProxy) {
        super(pagerTabProxy);

        viewProxies = new ArrayList<TiViewProxy>();

        LinearLayout layout = new LinearLayout(pagerTabProxy.getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);
        setNativeView(layout);

        DisplayMetrics dm = pagerTabProxy.getActivity().getResources().getDisplayMetrics();
        FrameLayout.LayoutParams pagerSlidingTabStripLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, dm));

        tabStrip = new PagerSlidingTabStrip(pagerTabProxy.getActivity());
        tabStrip.setTabBackground(Utilities.getResourceIdByName(pagerTabProxy.getActivity().getPackageName(), "drawable", "background_tab"));
        layout.addView(tabStrip, pagerSlidingTabStripLayoutParams);


        ViewPager.LayoutParams viewPagerLayoutParams = new ViewPager.LayoutParams();
        viewPagerLayoutParams.width = ViewPager.LayoutParams.MATCH_PARENT;
        viewPagerLayoutParams.height = ViewPager.LayoutParams.MATCH_PARENT;

        viewPager = new ViewPager(layout.getContext());
        viewPager.setId(8889);

        layout.addView(viewPager, viewPagerLayoutParams);

        FragmentActivity activity = (FragmentActivity) pagerTabProxy.getActivity();
        adapter = new ViewPagerFragmentV4Adapter(activity.getSupportFragmentManager());
        PagerViewListener pagerViewListener = new PagerViewListener(pagerTabProxy, viewPager, adapter);
        pagerViewListener.addAllListener();
        tabStrip.setOnPageChangeListener(pagerViewListener);

        viewPager.setAdapter((PagerAdapter) adapter);
        viewPager.setOffscreenPageLimit(2);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, pagerTabProxy.getActivity().getResources()
                .getDisplayMetrics());
        viewPager.setPageMargin(pageMargin);

        tabStrip.setViewPager(viewPager);
    }

    public PagerTabsView(PagerTabsProxy pagerTabsProxy, KrollDict properties, List<KrollDict> runTimeViews) {
        this(pagerTabsProxy);
        applyProperties(properties, runTimeViews);
    }

    public void applyProperties(KrollDict properties, List<KrollDict> runTimeViews) {
        if (properties.containsKey("tab")) {
            KrollDict tabProperties = properties.getKrollDict("tab");
            properties.remove("tab");


            if (tabProperties.containsKey("color")) {
                tabStrip.setTextColor(
                        Utilities.getColor(
                                tabProperties.getString("color"),
                                Color.BLACK
                        )
                );
            } else if (tabProperties.containsKey("colorResource")) {
                tabStrip.setTextColorResource(
                        Utilities.getResource(
                                tabProperties.getString("colorResource"),
                                android.R.color.primary_text_dark
                        )
                );
            }


            if (tabProperties.containsKey("indicatorColor")) {
                tabStrip.setIndicatorColor(
                        Utilities.getColor(
                                tabProperties.getString("indicatorColor"),
                                Color.RED
                        )
                );
            } else if (tabProperties.containsKey("indicatorResource")) {
                tabStrip.setIndicatorColorResource(
                        Utilities.getResource(
                                tabProperties.getString("indicatorResource"),
                                android.R.color.holo_red_light
                        )
                );
            }

            if (tabProperties.containsKey("underlineColor")) {
                tabStrip.setUnderlineColor(
                        Utilities.getColor(
                                tabProperties.getString("underlineColor"),
                                Color.BLUE
                        )
                );
            } else if (tabProperties.containsKey("underlineResource")) {
                tabStrip.setUnderlineColorResource(
                        Utilities.getResource(
                                tabProperties.getString("underlineResource"),
                                android.R.color.holo_blue_bright
                        )
                );
            }

            if (tabProperties.containsKey("dividerColor")) {
                tabStrip.setDividerColor(
                        Utilities.getColor(
                                tabProperties.getString("dividerColor"),
                                Color.GRAY
                        )
                );
            } else if (tabProperties.containsKey("dividerResource")) {
                tabStrip.setDividerColorResource(
                        Utilities.getResource(
                                tabProperties.getString("dividerResource"),
                                android.R.color.darker_gray
                        )
                );
            }

            if (tabProperties.containsKey("backgroundColor")) {
                tabStrip.setTabBackgroundColor(
                        Utilities.getColor(
                                tabProperties.getString("backgroundColor"),
                                Color.WHITE
                        )
                );
            } else if (tabProperties.containsKey("backgroundResource")) {
                tabStrip.setTabBackground(
                        Utilities.getResource(
                                tabProperties.getString("backgroundResource"),
                                android.R.color.background_light
                        )
                );
            }

            if (tabProperties.containsKey("indicatorHeight")) {
                tabStrip.setIndicatorHeight(tabProperties.getInt("indicatorHeight"));
            }

            if (tabProperties.containsKey("underlineHeight")) {
                tabStrip.setUnderlineHeight(tabProperties.getInt("underlineHeight"));
            }

            if (tabProperties.containsKey("dividerPadding")) {
                tabStrip.setDividerPadding(tabProperties.getInt("dividerPadding"));
            }

            if (tabProperties.containsKey("upperCase")) {
                tabStrip.setAllCaps(tabProperties.getBoolean("upperCase"));
            }

            if (tabProperties.containsKey("shouldExpand")) {
                tabStrip.setShouldExpand(tabProperties.getBoolean("shouldExpand"));
            }

            if (tabProperties.containsKey("padding")) {
                tabStrip.setTabPaddingLeftRight(tabProperties.getInt("padding"));
            }

            if (tabProperties.containsKey("alignment")) {
                tabStrip.setTabAlignment(tabProperties.getInt("alignment"));
            }

            if (tabProperties.containsKey("font")) {
                KrollDict font = tabProperties.getKrollDict("font");
                String fontSize = font.getString("fontSize");
                String fontFamily = font.getString("fontFamily");
                String fontWeight = font.getString("fontWeight");
                String fontStyle = font.getString("fontStyle");

                int style = TiUIHelper.toTypefaceStyle(fontWeight, fontStyle);
                Typeface tf = TiUIHelper.toTypeface(tabStrip.getContext(), fontFamily);
                tabStrip.setTypeface(tf, style);
                tabStrip.setTextSize(TiUIHelper.getSizeUnits(fontSize), TiUIHelper.getSize(fontSize));
            }
        }

        if (runTimeViews != null && runTimeViews.size() > 0) {
            for (KrollDict runTimeView : runTimeViews) {
                addViewFromParameter(runTimeView);
            }
        }
        if (properties.containsKey("views")) {
            Object[] views = (Object[]) properties.get("views");
            for (Object view : views) {
                addViewFromParameter((HashMap) view);
            }
            properties.remove("views");
        }

        if (properties.containsKey("current")) {
            Integer current = properties.getInt("current");

            if (current < 1) {
                current = 1;
            } else if (current > getCount()) {
                current = getCount();
            }
            if (isTabRightAlignment()) {
                int newIndex = (getCount() - current);
                viewPager.setCurrentItem(newIndex);
            } else {
                viewPager.setCurrentItem((current - 1));
            }
        }
    }

    public int addView(String title, View v) {
        int index = adapter.addView(title, v);
        tabStrip.notifyDataSetChanged();
        return index;
    }

    public int addView(String title, View v, int position) {
        adapter.addView(title, v, position);
        tabStrip.notifyDataSetChanged();
        return position;
    }

    public int removeView(View v) {
        int index = adapter.removeView(viewPager, v);
        tabStrip.notifyDataSetChanged();
        return index;
    }

    public int removeView(int position) {
        adapter.removeView(viewPager, position);
        tabStrip.notifyDataSetChanged();
        return position;
    }

    public int getCount() {
        return adapter.getCount();
    }

    public View getView(int position) {
        return adapter.getView(position);
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    public ViewPagerDynamicAdapter getAdapter() {
        return adapter;
    }

    public PagerSlidingTabStrip getTabStrip() {
        return tabStrip;
    }

    public List<TiViewProxy> getViewProxies() {
        return viewProxies;
    }

    private boolean isTabRightAlignment() {
        return PagerTabsModule.ALIGNMENT_RIGHT == tabStrip.getTabAlignment();
    }

    private void addViewFromParameter(HashMap currentView) {
        if (currentView.get("view") instanceof TiViewProxy && !(currentView.get("view") instanceof TiBaseWindowProxy)) {
            String title = String.valueOf(currentView.get("title"));
            TiViewProxy viewProxy = (TiViewProxy) currentView.get("view");
            viewProxies.add(viewProxy);
            View nativeView = viewProxy.getOrCreateView().getNativeView();

            if (isTabRightAlignment()) {
                addView(title, nativeView, 0);
            } else {
                addView(title, nativeView);
            }
        }
    }
}
