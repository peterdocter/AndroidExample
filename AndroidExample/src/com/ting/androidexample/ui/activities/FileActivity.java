package com.ting.androidexample.ui.activities;

import java.io.File;

import com.ting.androidexample.util.FileUtil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class FileActivity extends Activity {

	private final static String TAG = "StorageActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		testFileStorage();
		
		long size = FileUtil.getFileOrDirSize("/data/data/com.ting.androidexample/");
		Log.d(TAG, "/data/data/com.ting.androidexample/ size:" + ((double)size/(1024*1024)) + "M");
		
		long databasesize = FileUtil.getFileOrDirSize("/data/data/com.ting.androidexample/databases/");
		Log.d(TAG, "/data/data/com.ting.androidexample/databases/ size:" + ((double)databasesize/(1024*1024)) + "M");
	}

	@SuppressLint("NewApi")
	private void testFileStorage() {
		File file = new File("/data/data/com.ting.androidexample/");
		Log.d(TAG, "total size:" + file.getTotalSpace()/1024/1024 + "M");
		Log.d(TAG, "free size:" + file.getFreeSpace()/1024/1024 + "M");
		Log.d(TAG, "usable size:" + file.getUsableSpace()/1024/1024 + "M");
		
	}
	
}
