package com.ting.androidexample.ui.widget;

import android.content.Context;
import android.webkit.WebView;

public class JavascriptWebView extends WebView {

	public JavascriptWebView(Context context) {
		super(context);
	}

	@Override
	public void addJavascriptInterface(Object object, String name) {
		super.addJavascriptInterface(object, name);
	}
	
	

}
