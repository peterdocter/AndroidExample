package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class AlertDialogActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setupViews();
	}

	private void setupViews() {
		AlertDialog dialog = new AlertDialog.Builder(this)
		.setTitle("AlertDialog示例")
		.setMessage("消息")
		.setNegativeButton("退出", new DialogInterface.OnClickListener() {
						
			@Override
			public void onClick(DialogInterface dialog, int which) {	
			}
		})
		.setPositiveButton("保存", new DialogInterface.OnClickListener() {
						
			@Override
			public void onClick(DialogInterface dialog, int which) {				
			}
		})
		.create();
		dialog.show();
		
	}
	
}
