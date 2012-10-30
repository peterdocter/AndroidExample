package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ting.androidexample.R;
import com.ting.androidexample.util.Constants;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class NotificationActivity extends Activity {
	
	private final String TAG = "NotificationActivity";

	private static int mIncrement;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        
        Button button = new Button(this);
        button.setText("send Notification");
        button.setClickable(true);
        button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("Notification", "send Notification");
				sendNotification(NotificationActivity.this);	
			}
        	
        });
        linearLayout.addView(button);
        
        Button cancelButton = new Button(this);
        cancelButton.setText("cancel Notification");
        cancelButton.setClickable(true);
        cancelButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("Notification", "cancel Notification");
				cancelNotification(NotificationActivity.this);	
			}
        	
        });      
        linearLayout.addView(cancelButton);
        
        setContentView(linearLayout);
      
    }

	private void sendNotification(Context context) {
				
		Notification notification = new Notification();
		
		Intent intent = new Intent(Intent.ACTION_MAIN);	
		intent.putExtra("content", "test content");
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		notification.setLatestEventInfo(context, "title", "describe", contentIntent);
		notification.icon = R.drawable.ic_launcher;
		notification.tickerText = "ticker";
		notification.when = System.currentTimeMillis();
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.defaults |= Notification.DEFAULT_VIBRATE;
		notification.defaults |= Notification.DEFAULT_SOUND;
		notification.defaults |= Notification.DEFAULT_LIGHTS;
		
		//add contentIntent
/*		Intent intent = new Intent(Intent.ACTION_MAIN);	
		intent.putExtra("content", "test content");
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		notification.contentIntent = contentIntent;*/
		
		//add deleteIntent 
		intent = new Intent(Constants.RECEIVER_ACTION);     	
		intent.putExtra("delete", "delete");
		PendingIntent deleteIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
		notification.deleteIntent = deleteIntent;
		
		//add notification id
		int increment = ++mIncrement;
		Log.d(TAG, "send notification increment=" + increment);
		
		//send notification
		NotificationManager nm = (NotificationManager) context.getSystemService(
				Context.NOTIFICATION_SERVICE);
		nm.notify(increment, notification);
	}
	
	private void cancelNotification(Context context) {
		NotificationManager nm = (NotificationManager) context.getSystemService(
				Context.NOTIFICATION_SERVICE);
	/*	while(mIncrement != 0) {
			Log.d(TAG, "cancel notification mIncrement=" + mIncrement);
			nm.cancel(mIncrement);
			mIncrement--;
		}*/
		nm.cancelAll();
	}
	
/*
	@SuppressLint("NewApi")
	private void showNotificaionAPI16(Context context, int id) {
		NotificationManager nm = (NotificationManager) context.getSystemService(
				Context.NOTIFICATION_SERVICE);
		Intent intent = new Intent(Intent.ACTION_MAIN);	
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

		Notification notification = new Notification.Builder(context)
			.setAutoCancel(true)
			.setContentTitle("title")
			.setContentText("describe")
			.setContentIntent(pendingIntent)
			.setSmallIcon(R.drawable.ic_launcher)
			.setWhen(System.currentTimeMillis())
			.build();
			
		nm.notify(id, notification);
	}
*/
    
}
