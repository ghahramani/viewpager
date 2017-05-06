var win = Ti.UI.createWindow({
    backgroundColor: "#EDEDED"
});
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
    current: 1,
    tab: {
        //indicatorResource: "holo_blue_dark",
        indicatorColor: "#BE1B1B",
        //colorResource: "holo_blue_dark",
        color: "#000000",
        backgroundColor: "#DDDDDD",
        alignment: tabs.ALIGNMENT_LEFT,
        font:{
            fontWeight: 'normal',
            fontSize: 13
        }
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

//tabs.add("Dynamic Tab", Ti.UI.createView({backgroundColor: "#FFFFFF"}));
//tabs.add("Dynamic Tab 2", Ti.UI.createView({backgroundColor: "#FFFFFF"}));


tabs.addEventListener(tabs.PAGE_SCROLLED_EVENT_NAME, function () {
    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
});
tabs.addEventListener(tabs.PAGE_SELECTED_EVENT_NAME, function () {
    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
});
tabs.addEventListener(tabs.PAGE_SCROLL_STATE_CHANGED_EVENT_NAME, function () {
    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
});
tabs.addEventListener(tabs.CLICK_EVENT_NAME, function () {
    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
});
tabs.addEventListener(tabs.LONG_CLICK_EVENT_NAME, function () {
    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
});
tabs.addEventListener(tabs.TOUCH_EVENT_NAME, function () {
    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
});
tabs.addEventListener(tabs.FOCUS_CHANGE_EVENT_NAME, function () {
    Ti.API.info("TAG: ", arguments.length, JSON.stringify(arguments));
});

win.add(tabs);