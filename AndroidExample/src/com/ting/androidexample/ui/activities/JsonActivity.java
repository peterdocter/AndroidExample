package com.ting.androidexample.ui.activities;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class JsonActivity extends Activity {

	private final String TAG = "JsonActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		jsonParser("{category:{age:1}, name:ting}");
	}
	
	private void jsonParser(String content) {
		try {
			JSONObject json = new JSONObject(content);
			if(json.has("category")) {
				JSONObject category = (JSONObject)json.get("category");
				if(category.has("age")) {
					int age = category.getInt("age");
					Log.d(TAG , "age=" + age);
				}
			}
			if(json.has("name")) {
				String name = json.getString("name");
				Log.d(TAG, "name=" + name);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	
}
