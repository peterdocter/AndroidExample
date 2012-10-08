package com.ting.androidexample.ui.activities;

import com.ting.androidexample.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class DownloadActivity extends Activity {
	
	private DownloadManager mDownloadManager = null;
	private long lastDownload = -1L;
	
	private String strUrl="http://dl.google.com/android/ndk/android-ndk-r6-linux-x86.tar.bz2";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download);
		
		setupViews();
		mDownloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
	}

    private void setupViews() {
    	Button button = (Button) findViewById(R.id.button_download);
    	button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startDownload(strUrl);
			}
    		
    	});
    }

	@SuppressLint("NewApi")
	public void startDownload(String strUrl) { 
        Uri uri=Uri.parse(strUrl); 
 
        Environment 
            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) 
            .mkdirs(); 
 
        Request req = new DownloadManager.Request(uri); 
 
        req.setTitle("Demo"); 
        req.setDescription("android-ndk-r6-linux-x86.tar.bz2"); 
        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"android-ndk-r6-linux-x86.tar.bz2"); 
        req.setNotificationVisibility(0); 
        req.setShowRunningNotification(true); 
 
        lastDownload = mDownloadManager.enqueue(req);  
    }    
	
}
