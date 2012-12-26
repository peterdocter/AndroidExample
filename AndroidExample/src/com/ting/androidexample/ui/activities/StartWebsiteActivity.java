package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class StartWebsiteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
		startActivity(it);

	}

	
}
