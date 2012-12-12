package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ExportedActivity extends Activity {

	private final String TAG = "ExportedActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG , "start ExportedActivity success!");
	}

	
}
