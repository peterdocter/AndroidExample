package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

/**
 * @author tingzi [zhangjieting@gmail.com]
 * 
 */
public class WebViewActivity extends Activity {
	
	private LinearLayout mRootView;
	private WebView mWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setupViews();
		
		setWebViewClient();
		
		setWebSettings();
	}

	private void setupViews() {
		mWebView = new WebView(this);
		//经过了百度转码工具：http://gate.baidu.com/
		mWebView.loadUrl("http://gate.baidu.com/tc?bd_page_type=1&src=http%3A%2F%2Fwww.ruanyifeng.com%2Fblog%2Fnav%2Findex1.html");
		mWebView.setVerticalScrollBarEnabled(false);
		
		setContentView(mWebView);
		
	}

	private void setWebViewClient() {
		//在webview展示的页面点击新链接时，能够用该webview打开，而不是跳转到浏览器
		mWebView.setWebViewClient(new WebViewClient() {
					
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				mWebView.loadUrl(url);
		//		view.loadUrl(url);   //在当前的webview中跳转到新的url
				return true;
			}
		});
		
	}

	private void setWebSettings() {
		WebSettings webSettings = mWebView.getSettings();
		//enable application cache
		webSettings.setCacheMode(WebSettings.LOAD_NORMAL);
		webSettings.setAppCacheEnabled(true);
		//enable javascript
		webSettings.setJavaScriptEnabled(true);
		
	}

	
}
