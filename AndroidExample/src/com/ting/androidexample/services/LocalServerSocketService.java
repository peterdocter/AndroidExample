package com.ting.androidexample.services;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.net.LocalServerSocket;
import android.os.IBinder;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class LocalServerSocketService extends Service {

	static LocalServerSocket mLocalSocket;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		if(mLocalSocket == null) {
			try {
				mLocalSocket = new LocalServerSocket("test");
			} catch (IOException e) {
				e.printStackTrace();
			}   
	    }
	        
	    if(mLocalSocket == null) {
	        stopSelf();
	        return;
	    }
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
