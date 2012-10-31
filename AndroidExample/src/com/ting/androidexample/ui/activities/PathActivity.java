package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class PathActivity extends Activity {

	private final static String TAG = "PathActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String fileDirName = getFilesDir().getName();
		Log.d(TAG , "fileDirName:" + fileDirName);
		String fileDirPath = getFilesDir().getPath();
		Log.d(TAG , "fileDirPath:" + fileDirPath);
		String parentDir = getFilesDir().getParent();
		Log.d(TAG , "parentDir:" + parentDir);
		
	}

	
}
