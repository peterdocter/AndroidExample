package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class BaseActivity extends Activity {

	private LinearLayout linearLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setupViews();
	}

	private void setupViews() {
		linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		
		setupButtons();
		
		setContentView(linearLayout);
	}
	
	protected void setupButtons() {
		
	}

	protected Button addButton(String text) {
		Button button = new Button(this);
		button.setText(text);
		
		linearLayout.addView(button);
		
		return button;
	}

	
}
