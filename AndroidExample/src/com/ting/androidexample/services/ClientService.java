package com.ting.androidexample.services;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class ClientService extends Service {
	
	private IAIDLService mIAIDLService;
	
	private ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			 mIAIDLService = IAIDLService.Stub.asInterface(service);
			 try {
				mIAIDLService.show();
				mIAIDLService.function(getPackageName(), mBinder);
			} catch (RemoteException e) {
				e.printStackTrace();
			}		 
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			mIAIDLService = null;
		}
		
	};
	
	private final IClientService.Stub mBinder = new IClientService.Stub() {
		
		@Override
		public void test() throws RemoteException {
			// TODO Auto-generated method stub
			
		}
	};
		
	@Override
	public void onCreate() {
		super.onCreate();
		Intent intent = new Intent();
		bindService(intent, conn, Context.BIND_AUTO_CREATE);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		unbindService(conn);
	}	

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
