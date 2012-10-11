package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class StringBuilderActivity extends Activity {

	private final static String TAG = "StringBuilderActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		testStringBuilder();
		testStringBuilder(1);
		testStringBuilder("abc");
	}

	private void testStringBuilder(String string) {
		String str = new StringBuilder(string)
							.append(12)
							.append('a')
							.append("abc")
							.append(14)
							.append(123)
							.toString();
		Log.d(TAG, str);
	}

	private void testStringBuilder(int count) {
		String str = new StringBuilder(count)
							.append(12)
							.append('a')
							.append("abc")
							.append(14)
							.append(123)
							.toString();
		Log.d(TAG, str);
	}

	private void testStringBuilder() {
		StringBuilder builder = new StringBuilder();
		String str = builder.append(1)
							.append("abc")
							.append('d')
							.append(12.2)
							.toString();
		Log.d(TAG, str);
	}

	
}
