package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class MutiParamActivity extends Activity {

	private final static String TAG = "MutiParamActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		testMutiParam("a","b");
		testMutiParam("a","b","c");
	}

	private void testMutiParam(String... strings) { //==String[] strings
		for(int i=0; i<strings.length; i++){
			Log.d(TAG , strings[i]);
		}
	}
	
}
