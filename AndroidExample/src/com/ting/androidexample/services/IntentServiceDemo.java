package com.ting.androidexample.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class IntentServiceDemo extends IntentService {

	private final static String TAG = "IntentServiceDemo";

	public IntentServiceDemo() {
		super("name");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.d(TAG , "onHandleIntent");
	}



}
