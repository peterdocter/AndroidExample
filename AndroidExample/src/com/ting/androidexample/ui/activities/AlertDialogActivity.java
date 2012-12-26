package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class AlertDialogActivity extends Activity {

	protected static final String TAG = "AlertDialogActivity";

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
		
		dialog.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				Log.d(TAG, "keyCode:" + keyCode + "event:" + event);
				if(keyCode == 4) {
					Log.d(TAG, "you click back key");
				}
				return false;
			}
		
		});
		
	}
	
}
