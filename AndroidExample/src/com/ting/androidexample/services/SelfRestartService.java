package com.ting.androidexample.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SelfRestartService extends Service {

	private final static String TAG = "SelfRestartService";

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG , "intent:" + intent);
		Log.d(TAG, "flag:" + flags);
		Log.d(TAG, "startId:" + startId);
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		
		//don't kill service method
		Intent intent = new Intent();
		intent.setClass(this, SelfRestartService.class);
		startService(intent);
		
	}
	
	

}
