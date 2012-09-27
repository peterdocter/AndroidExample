package com.ting.androidexample;

import com.ting.androidexample.activities.AlertDialogActivity;
import com.ting.androidexample.activities.DownloadActivity;
import com.ting.androidexample.activities.DragListViewActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class ExampleActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setupViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_example, menu);
        return true;
    }
    
    private void setupViews() {
    	LinearLayout linearLayout = new LinearLayout(this);
    	linearLayout.setOrientation(LinearLayout.VERTICAL);
  
    	//add button1
    	Button button1 = new Button(this);
    	button1.setText("Download");
    	button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), DownloadActivity.class);
				startActivity(intent);
			}
    		
    	});
    	linearLayout.addView(button1);
    	
    	//add button2
    	Button button2 = new Button(this);
    	button2.setText("AlertDialog");
    	button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), AlertDialogActivity.class);
				startActivity(intent);
			}
    		
    	});
    	linearLayout.addView(button2);
    	
    	//add button2
    	Button button3 = new Button(this);
    	button3.setText("DragListView");
    	button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), DragListViewActivity.class);
				startActivity(intent);
			}
    		
    	});
    	linearLayout.addView(button3);
    	
    	setContentView(linearLayout);
    }
}
