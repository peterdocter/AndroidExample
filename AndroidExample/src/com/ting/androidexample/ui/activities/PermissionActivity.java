package com.ting.androidexample.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class PermissionActivity extends BaseActivity {
	
	private final static String TAG = "PermissionActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG , "onCreate PermissionActivity has been started");
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Log.d(TAG , "onNewIntent PermissionActivity has been started");
	}
	
	

	
}
