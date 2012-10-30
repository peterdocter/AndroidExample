package com.ting.androidexample.receivers;

import com.ting.androidexample.services.AIDLService;
import com.ting.androidexample.services.ClientService;
import com.ting.androidexample.util.Constants;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

	private final static String TAG = "PackageRemoveReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
	
		String action = intent.getAction();
		
		 if (action.equals(Intent.ACTION_PACKAGE_REMOVED)) {
     		Log.d(TAG , "Intent.ACTION_PACKAGE_REMOVED");
		 } else if (action.equals(Intent.ACTION_PACKAGE_ADDED)) {
			 Log.d(TAG , "Intent.ACTION_PACKAGE_ADDED");
			 Log.d(TAG, "package:" + intent.getData().getSchemeSpecificPart());
		 } else if (action.equals(Intent.ACTION_SHUTDOWN)) {
			 Log.d(TAG , "Intent.ACTION_SHUTDOWN");
		 } else if (action.equals(Intent.ACTION_BOOT_COMPLETED)) {
			 Log.d(TAG , "Intent.ACTION_BOOT_COMPLETED");
			 Intent intent1 = new Intent();
			 intent1.setClass(context, ClientService.class);
			 context.startService(intent1);
		 } else if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
			 Log.d(TAG , "Intent.CONNECTIVITY_ACTION");
			 Intent intent1 = new Intent();
			 intent1.setClass(context, AIDLService.class);
			 context.startService(intent1);
		 }else if (action.equals(Constants.RECEIVER_ACTION)) {
			 Log.d(TAG , "Constants.RECEIVER_ACTION");
			 Toast.makeText(context, "Constants.RECEIVER_ACTION", Toast.LENGTH_LONG).show();
		 }
	}

}
