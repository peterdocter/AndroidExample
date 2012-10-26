package com.ting.androidexample.ui.activities;

import com.ting.androidexample.services.SelfRestartService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class RestartServiceActivity extends Activity {

	private final static String TAG = "RestartServiceActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setupViews();
		

	}

	private void setupViews() {
		LinearLayout linearLayout = new LinearLayout(this);
		
		Button startButton = new Button(this);
		startButton.setText("Start Service");
		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Log.d(TAG, "click start service button");
				Intent intent = new Intent(RestartServiceActivity.this, SelfRestartService.class);
				startService(intent);
			}
			
		});
		linearLayout.addView(startButton);
		
		Button stopButton = new Button(this);
		stopButton.setText("Stop Service");
		stopButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Log.d(TAG, "click stop service button");
				Intent intent = new Intent(RestartServiceActivity.this, SelfRestartService.class);
				stopService(intent);		
			}
			
		});
		linearLayout.addView(stopButton);
		
		setContentView(linearLayout);
		
	}

	
}
