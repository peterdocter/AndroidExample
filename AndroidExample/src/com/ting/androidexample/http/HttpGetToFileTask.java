package com.ting.androidexample.http;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class HttpGetToFileTask extends AsyncTask<String, Object, String> {

	private final static String TAG = "HttpGetToFileTask";

	@Override
	protected String doInBackground(String... params) {
		doGetToFile(params[0], params[1]);
		return null;
	}
	
	public void doGetToFile(String url, String localFile) {
		try {
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response = new DefaultHttpClient().execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				FileOutputStream out = new FileOutputStream(localFile);
				response.getEntity().writeTo(out);
				out.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
