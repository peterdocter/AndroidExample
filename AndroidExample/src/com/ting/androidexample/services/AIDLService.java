package com.ting.androidexample.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class AIDLService extends Service {
	
	private final IAIDLService.Stub mBinder = new IAIDLService.Stub() {

		@Override
		public void show() throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void function(String packageName, IBinder binder)
				throws RemoteException {
			// TODO Auto-generated method stub
			
		}
		
	};

	@Override
	public IBinder onBind(Intent arg0) {
		return mBinder;
	}
		
}
