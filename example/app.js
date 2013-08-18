// This is a test harness for your module
// You should do something interesting in this harness 
// to test out the module and to provide instructions 
// to users on how to use it by example.


// open a single window
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