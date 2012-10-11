package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class MultiParamActivity extends Activity {

	private final static String TAG = "MultiParamActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		testMultiParam("a","b");
		testMultiParam("a","b","c");
		testMultiParam(1,"ab",'c',12.5);
	}

	private void testMultiParam(String... strings) { //==String[] strings
		for(int i=0; i<strings.length; i++){
			Log.d(TAG , strings[i]);
		}
	}
	
	private void testMultiParam(Object... objects) { //==Object[] objects
		for(int i=0; i<objects.length; i++){
			Log.d(TAG , objects[i] + "");
		}
	}
	
}
