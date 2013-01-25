package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class NewThreadActivity extends Activity {
	private final static String TAG = "NewThreadActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		new Thread() {
			
			@Override
			public void run() {
				while(true) {
					Log.d(TAG, "new thread is running!");
				}
			}
			
		}.start();
	}
	
	

}
