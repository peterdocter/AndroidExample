package com.ting.androidexample.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class AIDLService extends Service {
	
	private final IAIDLService.Stub mBinder = new IAIDLService.Stub() {

		private final static String TAG = "AIDLService";

		@Override
		public void show() throws RemoteException {
			Log.d(TAG , "aidl service show()");
		}

		@Override
		public void function(String packageName, IBinder binder)
				throws RemoteException {
			// TODO Auto-generated method stub
			
		}
		
	};

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}
		
}
