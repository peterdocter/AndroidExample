package com.ting.androidexample.services;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class InnerReceiverService extends Service {

	private final static String TAG = "IntentReceiverService";
	
	private BroadcastReceiver mReceiver;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		mReceiver = new Receiver();
		
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
		filter.addDataScheme("package");
		registerReceiver(mReceiver, filter);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		
		unregisterReceiver(mReceiver);
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	class Receiver extends BroadcastReceiver {


		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals(Intent.ACTION_PACKAGE_REMOVED)) {
        		Log.d(TAG, "Intent.ACTION_PACKAGE_REMOVED");	
        	}
		}
		
	}
}
