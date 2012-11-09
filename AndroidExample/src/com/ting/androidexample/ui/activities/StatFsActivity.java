package com.ting.androidexample.ui.activities;

import android.os.Bundle;
import android.os.StatFs;
import android.util.Log;

public class StatFsActivity extends BaseActivity {

	private final static String TAG = "StatFsActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		test();
	}

	private void test() {
		StatFs sf = new StatFs(getFilesDir().getParent());
		Log.d(TAG , "getFilesDir().getParent():" + getFilesDir().getParent());
		Log.d(TAG, "sf.getAvailableBlocks():" + sf.getAvailableBlocks());
		Log.d(TAG, "sf.getBlockCount()" + (double)sf.getBlockCount());
		Log.d(TAG, "sf.getBlockSize()" + (double)sf.getBlockSize());
		Log.d(TAG, "sf.getFreeBlocks()" + (double)sf.getFreeBlocks());
		
	}

	
}
