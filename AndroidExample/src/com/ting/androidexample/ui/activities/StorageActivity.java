package com.ting.androidexample.ui.activities;

import java.io.File;
import java.util.LinkedList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class StorageActivity extends Activity {

	private final static String TAG = "StorageActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		testFileStorage();
		
		long size = getFileSize("/data/data/com.ting.androidexample/");
		Log.d(TAG, "file size:" + ((double)size/(1024*1024)) + "M");
	}

	@SuppressLint("NewApi")
	private void testFileStorage() {
		File file = new File("/data/data/com.ting.androidexample/");
		Log.d(TAG, "total size:" + file.getTotalSpace()/1024/1024 + "M");
		Log.d(TAG, "free size:" + file.getFreeSpace()/1024/1024 + "M");
		Log.d(TAG, "usable size:" + file.getUsableSpace()/1024/1024 + "M");
		
	}

	private long getFileSize(String path) {
		long totalSize = 0;		
		LinkedList<File> list = new LinkedList<File>();
		
		File file = new File(path);
		if(file.isDirectory()) {
			list.add(file);
		} 
			
		totalSize += file.length();
		Log.d(TAG, "name:" + file.getName() + ", size:" + totalSize);

		
		File temp;
		while(!list.isEmpty()) {
			temp = list.removeFirst();
			File[] fileList = temp.listFiles();
			for(File i : fileList) {
				if(i.isDirectory()) {
					list.add(i);
				} 
					
				totalSize += i.length();
				Log.d(TAG, "name:" + i.getName() + ", size:" + i.length());
			}
		}
		
		return totalSize;
	}
	
}
