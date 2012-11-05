package com.ting.androidexample.ui.activities;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipException;

import com.ting.androidexample.util.Zip;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class ZipActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setupViews();
	}

	private void setupViews() {
		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		
		Button button1 = new Button(this);
		button1.setText("压缩");
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
			}
			
		});
		linearLayout.addView(button1);
		
		Button button2 = new Button(this);
		button2.setText("解压缩");
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					Zip.upZipFile(new File("/data/data/com.ting.androidexample/test.zip"), "/data/data/com.ting.androidexample/");
				} catch (ZipException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
		linearLayout.addView(button2);
		
		setContentView(linearLayout);	
	}

	
}
