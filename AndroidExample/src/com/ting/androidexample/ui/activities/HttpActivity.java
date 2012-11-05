package com.ting.androidexample.ui.activities;

import com.ting.androidexample.util.HttpGetTask;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HttpActivity extends BaseActivity {
	
	private static final String url = "http://pan.baidu.com/share/link?shareid=120760&uk=2047143133";
	
	@Override
	protected void setupButtons() {
		super.setupButtons();
		
		Button button = addButton("下载");
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				HttpGetTask task = new HttpGetTask();
				task.execute(url);
			}
			
		});
		
	}
	
}
