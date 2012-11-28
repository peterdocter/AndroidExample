package com.ting.androidexample.ui.activities;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

public class AssetActivity extends Activity {

	private final static String TAG = "AssetActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getAssetPath(this);
	}

	private void getAssetPath(Context context) {
		AssetManager am = context.getAssets();
		try {
			String[] paths = am.list("www");
			for(String path: paths) {
				Log.d(TAG, "path:" + path);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}

}
