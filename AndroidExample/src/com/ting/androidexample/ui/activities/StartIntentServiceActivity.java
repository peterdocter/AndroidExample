package com.ting.androidexample.ui.activities;

import com.ting.androidexample.services.IntentServiceDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StartIntentServiceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = new Intent(this, IntentServiceDemo.class);
		startService(intent);
		
	}

	
}
