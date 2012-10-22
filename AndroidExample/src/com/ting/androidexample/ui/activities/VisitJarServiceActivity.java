package com.ting.androidexample.ui.activities;

import com.ting.androidexample.services.JarService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class VisitJarServiceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = new Intent();
		intent.setClass(this, JarService.class);
		startService(intent);
	}

	
}
