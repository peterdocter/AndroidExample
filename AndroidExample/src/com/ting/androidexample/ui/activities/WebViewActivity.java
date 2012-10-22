package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * @author tingzi [zhangjieting@gmail.com]
 * 
 */
public class WebViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		WebView webView = new WebView(this);
		webView.loadUrl("http://www.baidu.com");
//		webView.loadUrl("http://map.baidu.com/mobile");
		setContentView(webView);
		
		//在webview展示的页面点击新链接时，能够用该webview打开，而不是跳转到浏览器
		webView.setWebViewClient(new WebViewClient() {
			
			@Override
	         public boolean shouldOverrideUrlLoading(WebView view, String url) {
	 
				view.loadUrl(url);   //在当前的webview中跳转到新的url
				return true;
	         }
		});
		
		WebSettings webSettings = webView.getSettings();
		//enable application cache
		webSettings.setCacheMode(WebSettings.LOAD_NORMAL);
		webSettings.setAppCacheEnabled(true);
		//enable javascript
		webSettings.setJavaScriptEnabled(true);
	}

	
}
