package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		WebView webView = new WebView(this);
		webView.loadUrl("http://map.baidu.com/mobile");
		setContentView(webView);
		WebSettings webSettings = webView.getSettings();
		webSettings.setCacheMode(WebSettings.LOAD_NORMAL);
		webSettings.setAppCacheEnabled(true);
		webSettings.setJavaScriptEnabled(true);
	}

	
}
