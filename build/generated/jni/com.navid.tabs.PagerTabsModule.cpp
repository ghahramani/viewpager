/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

/** This code is generated, do not edit by hand. **/

#include "com.navid.tabs.PagerTabsModule.h"

#include "AndroidUtil.h"
#include "EventEmitter.h"
#include "JNIUtil.h"
#include "JSException.h"
#include "Proxy.h"
#include "ProxyFactory.h"
#include "TypeConverter.h"
#include "V8Util.h"



#include "com.navid.tabs.PagerTabsProxy.h"

#include "org.appcelerator.kroll.KrollModule.h"

#define TAG "PagerTabsModule"

using namespace v8;

		namespace com {
		namespace navid {
		namespace tabs {


Persistent<FunctionTemplate> PagerTabsModule::proxyTemplate = Persistent<FunctionTemplate>();
jclass PagerTabsModule::javaClass = NULL;

PagerTabsModule::PagerTabsModule(jobject javaObject) : titanium::Proxy(javaObject)
{
}

void PagerTabsModule::bindProxy(Handle<Object> exports)
{
	if (proxyTemplate.IsEmpty()) {
		getProxyTemplate();
	}

	// use symbol over string for efficiency
	Handle<String> nameSymbol = String::NewSymbol("Tabs");

	Local<Function> proxyConstructor = proxyTemplate->GetFunction();
	Local<Object> moduleInstance = proxyConstructor->NewInstance();
	exports->Set(nameSymbol, moduleInstance);
}

void PagerTabsModule::dispose()
{
	LOGD(TAG, "dispose()");
	if (!proxyTemplate.IsEmpty()) {
		proxyTemplate.Dispose();
		proxyTemplate = Persistent<FunctionTemplate>();
	}

	titanium::KrollModule::dispose();
}

Handle<FunctionTemplate> PagerTabsModule::getProxyTemplate()
{
	if (!proxyTemplate.IsEmpty()) {
		return proxyTemplate;
	}

	LOGD(TAG, "GetProxyTemplate");

	javaClass = titanium::JNIUtil::findClass("com/navid/tabs/PagerTabsModule");
	HandleScope scope;

	// use symbol over string for efficiency
	Handle<String> nameSymbol = String::NewSymbol("Tabs");

	Handle<FunctionTemplate> t = titanium::Proxy::inheritProxyTemplate(
		titanium::KrollModule::getProxyTemplate()
, javaClass, nameSymbol);

	proxyTemplate = Persistent<FunctionTemplate>::New(t);
	proxyTemplate->Set(titanium::Proxy::inheritSymbol,
		FunctionTemplate::New(titanium::Proxy::inherit<PagerTabsModule>)->GetFunction());

	titanium::ProxyFactory::registerProxyPair(javaClass, *proxyTemplate);

	// Method bindings --------------------------------------------------------

	Local<ObjectTemplate> prototypeTemplate = proxyTemplate->PrototypeTemplate();
	Local<ObjectTemplate> instanceTemplate = proxyTemplate->InstanceTemplate();

	// Delegate indexed property get and set to the Java proxy.
	instanceTemplate->SetIndexedPropertyHandler(titanium::Proxy::getIndexedProperty,
		titanium::Proxy::setIndexedProperty);

	// Constants --------------------------------------------------------------
	JNIEnv *env = titanium::JNIScope::getEnv();
	if (!env) {
		LOGE(TAG, "Failed to get environment in PagerTabsModule");
		//return;
	}


		DEFINE_STRING_CONSTANT(prototypeTemplate, "PAGE_SCROLLED_EVENT_NAME", "pageScrolled");

		DEFINE_STRING_CONSTANT(prototypeTemplate, "PAGE_SCROLL_STATE_CHANGED_EVENT_NAME", "pageScrollStateChanged");

		DEFINE_STRING_CONSTANT(prototypeTemplate, "CLICK_EVENT_NAME", "click");

		DEFINE_STRING_CONSTANT(prototypeTemplate, "LONG_CLICK_EVENT_NAME", "longClick");

		DEFINE_INT_CONSTANT(prototypeTemplate, "ALIGNMENT_RIGHT", 5);

		DEFINE_STRING_CONSTANT(prototypeTemplate, "TOUCH_EVENT_NAME", "touch");

		DEFINE_INT_CONSTANT(prototypeTemplate, "ALIGNMENT_LEFT", 3);

		DEFINE_STRING_CONSTANT(prototypeTemplate, "PAGE_SELECTED_EVENT_NAME", "pageSelected");

		DEFINE_STRING_CONSTANT(prototypeTemplate, "FOCUS_CHANGE_EVENT_NAME", "focusChange");


	// Dynamic properties -----------------------------------------------------

	// Accessors --------------------------------------------------------------

	return proxyTemplate;
}

// Methods --------------------------------------------------------------------

// Dynamic property accessors -------------------------------------------------


		} // tabs
		} // navid
		} // com
