# Google Play View Pager And Tabs Module

##Copyright
This module is base on the android module from [Astuetz](https://github.com/astuetz/PagerSlidingTabStrip) with some changes
<br>Thanks astuetz for greate solution.

## Description

This module is like Google Play tabs and ViewPager whit:

- Support RTL ( Right To Left )
- Customizing color of ( Indicator, Underline, Text, Tabs Background, Separator )
- Add or Remove tabs in runtime
- Changed all color in runtime
- Using custom font and style ( Appcelerator font object )
- Set current tab ( only creation time yet )
- show tabs in two style ( Scrolling, Adjust with screen width )
- set padding
- 4 events supported ( Touch, Page Scrolled, Page Selected, Page Scroll State Changed )
- Supported all UI element that it extends of View object except Ti.UI.Window ( ex. TextField, Button, View, Scroll View, etc. )
- Set Tab height
- supported android theme resource like Holo theme for all colors

###if you like the module please donate.
###<br>BitCoint Address: <br>1NLwq7hGahzHHnsAAD6P7kZ9RSKk4ReBCH<br>
<img src="http://chart.googleapis.com/chart?cht=qr&chs=200x200&chl=1NLwq7hGahzHHnsAAD6P7kZ9RSKk4ReBCH"/>


## Accessing the tabs Module

To access this module from JavaScript, you would do the following:

	var module = require("com.navid.tabs");
    var tabs = module.createPagerTabs();

The module variable is a reference to the Module object.

The tabs variable is a instance of viewpager

## Reference

This module use https://github.com/astuetz/PagerSlidingTabStrip with some changes

Fork repository is here:
https://github.com/dreamlearn/PagerSlidingTabStrip

### module.createPagerTabs

	var win = Ti.UI.createWindow();
	win.open();
	var module = require('com.navid.tabs');
	var tabs = tabs.createPagerTabs();
	win.add(tabs);

### module.property

- tab ( Object)
    - color ( Text color )
    - colorResource ( Android resource string, ex. "holo_blue_dark" )
    - indicatorColor
    - indicatorResource
    - underlineColor
    - underlineResource
    - dividerColor
    - dividerResource
    - backgroundColor
    - backgroundResource
    - indicatorHeight
    - underlineHeight
    - dividerPadding
    - upperCase ( if set true all tabs title will show capital case, default is false )
    - shouldExpand ( if set true the width tabs adjusted with screen width, if set false the tab enabled scrolling. default is false )
    - padding  ( only right padding and left padding )
    - alignment ( module.ALIGNMENT_RIGHT or module.ALIGNMENT_LEFT, default is  module.ALIGNMENT_LEFT )
    - font ( same as Appcelerator font object )
- views
    - array
        - [0]
           - title ( Title of tab )
           - view ( Object of Appcelerator view ( Button, Label, View, ImageView and etc... except Window )
- current ( set current tab in first time, if alignment set with ALIGNMENT_RIGHT detects itself and select tab from right to left, ex. the 1 index is first tab in right )

The priority of color and color resource is with Color, if color not set use its resource if it set
ex.<br>

	{
 	   color: "red",
  	  colorResource: "holo_blue_light"
	}

text will be red and colorResource will be ignored
}
## Usage

	var win = Ti.UI.createWindow();
	win.open();

	var tabs = require('com.navid.tabs');

	var text = Ti.UI.createTableView({
    	title: "NAVID",
	    backgroundColor: "white",
    	data: [
        	{title: "1"},
	        {title: "2"},
    	    {title: "3"},
        	{title: "4"},
	        {title: "5"}
    	]
	});

	var text2 = Ti.UI.createTableView({
    	title: "NAVID",
	    backgroundColor: "white",
	    data: [
    	    {title: "1"},
        	{title: "2"},
	        {title: "3"},
    	    {title: "4"},
        	{title: "5"},
	        {title: "6"}
    	]
	});

	var text3 = Ti.UI.createTableView({
	    title: "NAVID",
	    backgroundColor: "white",
	    data: [
	        {title: "1"},
	        {title: "2"}
	    ]
	});

	var tabs = tabs.createPagerTabs({
	    current: 4,
	    tab: {
	        indicatorResource: "holo_blue_light",
	        colorResource: "holo_blue_light",
	        backgroundColor: "white",
	        alignment: tabs.ALIGNMENT_RIGHT
	    },
	    views: [
	        {
	            title: "Test1",
	            view: text
	        },
	        {
	            title: "Test2",
	            view: text2
	        },
	        {
	            title: "Test3",
	            view: text3
	        }
	    ]
	});
	
	tabs.add("Dynamic Tab", Ti.UI.createLabel({text:"Label 1"}));
	tabs.add("Dynamic Tab 2", Ti.UI.createLabel({text:"Position 2"}), 2);
	tabs.remove(1);
	
	proxy.addEventListener(tabs.PAGE_SCROLLED_EVENT_NAME, function () {
	    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
	});
	proxy.addEventListener(tabs.PAGE_SELECTED_EVENT_NAME, function () {
	    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
	});
	proxy.addEventListener(tabs.PAGE_SCROLL_STATE_CHANGED_EVENT_NAME, function () {
	    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
	});
	proxy.addEventListener(tabs.CLICK_EVENT_NAME, function () {
	    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
	});
	proxy.addEventListener(tabs.LONG_CLICK_EVENT_NAME, function () {
	    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
	});
	proxy.addEventListener(tabs.TOUCH_EVENT_NAME, function () {
	    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
	});
	proxy.addEventListener(tabs.FOCUS_CHANGE_EVENT_NAME, function () {
	    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
	});
	
	win.add(tabs);

## Author

Full Name: Navid Ghahramani

Email: ghahramani.navid@gmail.com

Please fill free to contact and share your idea with me ( Add new feature, fixing bug, get some help and etc... )

## License

It's open source and it's under Apache licenses
