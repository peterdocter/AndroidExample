package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.app.KeyguardManager;
import android.os.Bundle;
import android.util.Log;

public class KeyguardActivity extends Activity {

	private final static String TAG = "KeyguardActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG , "" + isScreenLock());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(isScreenLock()){
			Log.d(TAG, "screen lock");
		}
	}
	
	private boolean isScreenLock() {
		KeyguardManager mKeyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);   
	      
		if (mKeyguardManager.inKeyguardRestrictedInputMode()) {  
			return true;  
		} else {
			return false;
		}
	}

	
}
