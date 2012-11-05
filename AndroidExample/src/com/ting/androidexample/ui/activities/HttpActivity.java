package com.ting.androidexample.ui.activities;

import com.ting.androidexample.http.HttpGetTask;
import com.ting.androidexample.http.HttpGetToFileTask;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HttpActivity extends BaseActivity {
	
	private static final String url = "https://github.com/tingzi/NodeExample/archive/master.zip";
	
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
		
		Button button1 = addButton("下载并保存到文件");
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				HttpGetToFileTask task = new HttpGetToFileTask();
				task.execute(url, getFilesDir().getParent() + "/master.zip");
			}
			
		});
		
	}
	
}
