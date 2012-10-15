package com.ting.androidexample.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PackageRemoveReceiver extends BroadcastReceiver {

	private final static String TAG = "PackageRemoveReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
	
		String action = intent.getAction();
		
		 if (action.equals(Intent.ACTION_PACKAGE_REMOVED)) {
     		Log.d(TAG , "Intent.ACTION_PACKAGE_REMOVED");
		 }
	}

}
