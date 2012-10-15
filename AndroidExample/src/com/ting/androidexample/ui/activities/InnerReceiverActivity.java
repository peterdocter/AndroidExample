package com.ting.androidexample.ui.activities;

import com.ting.androidexample.services.InnerReceiverService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class InnerReceiverActivity extends Activity {


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = new Intent();
		intent.setClass(getApplicationContext(), InnerReceiverService.class);
		startService(intent);
		
	}
	


	
}
