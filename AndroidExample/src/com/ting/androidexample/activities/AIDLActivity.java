package com.ting.androidexample.activities;

import com.ting.androidexample.services.IAIDLService;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

public class AIDLActivity extends Activity {
	
	private IAIDLService mIAIDLService;
	
	private ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			 mIAIDLService = IAIDLService.Stub.asInterface(service);
			 try {
				mIAIDLService.show();
			} catch (RemoteException e) {
				e.printStackTrace();
			}		 
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			mIAIDLService = null;
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = new Intent();
		bindService(intent, conn, Context.BIND_AUTO_CREATE);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unbindService(conn);
	}	
}
