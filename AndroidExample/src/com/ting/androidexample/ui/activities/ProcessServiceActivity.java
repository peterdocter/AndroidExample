package com.ting.androidexample.ui.activities;

import com.ting.androidexample.services.ProcessService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ProcessServiceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = new Intent();
		intent.setClass(this, ProcessService.class);
		startService(intent);
	}

	
}
