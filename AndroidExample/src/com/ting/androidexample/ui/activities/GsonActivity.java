package com.ting.androidexample.ui.activities;

import com.google.gson.Gson;
import com.ting.androidexample.util.JsonMessage;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class GsonActivity extends Activity {

	private final static String TAG = "GsonActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
				
		testToJson();
		
		testFromJson();
		
		testFromJson2();
		
		testFromJson3();
	}
	
	

	private void testFromJson3() {
		String json = "{category:1, content:哈哈哈}";
		Gson gson = new Gson();
		JsonMessage jsonMessage = gson.fromJson(json, JsonMessage.class);
		Log.d(TAG , "category:" + jsonMessage.category + ", notification:" + jsonMessage.notification);
		Log.d(TAG, "json:" + gson.toJson(jsonMessage));	
	}



	private void testFromJson2() {
		String json = "{category:1,notification:{ticker:test,title:testtitle," +
		"describe:describe,vibrate:true,sound:true},content:哈哈哈}";
		Gson gson = new Gson();
		JsonMessage jsonMessage = gson.fromJson(json, JsonMessage.class);
		Log.d(TAG , "category:" + jsonMessage.category + ", ticker:" + jsonMessage.notification.ticker
				+ ", icon:" + jsonMessage.notification.icon);
		Log.d(TAG, "json:" + gson.toJson(jsonMessage));		
	}

	private void testFromJson() {
		String json = "{category:1,notification:{ticker:test,title:testtitle," +
				"describe:describe,icon:ic_launcher,vibrate:true,sound:true},content:哈哈哈}";
		Gson gson = new Gson();
		JsonMessage jsonMessage = gson.fromJson(json, JsonMessage.class);
		Log.d(TAG , "category:" + jsonMessage.category + ", ticker:" + jsonMessage.notification.ticker
				+ ", icon:" + jsonMessage.notification.icon);
		Log.d(TAG, "json:" + gson.toJson(jsonMessage));
	}

	private void testToJson() {
		Gson gson = new Gson();
		int[] ints = {1, 2, 3, 4, 5};
		Toast.makeText(this, gson.toJson(ints), Toast.LENGTH_LONG).show();
	}

	
}
