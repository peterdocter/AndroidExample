package com.ting.androidexample.activities;

import com.ting.androidexample.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class NotificationActivity extends Activity {

	private static int mIncrement;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        
        Button button = new Button(this);
        button.setText("Click");
        button.setClickable(true);
        button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("Notification", "Notification");
				showNotification(NotificationActivity.this);	
			}
        	
        });
        
        linearLayout.addView(button);
        setContentView(linearLayout);
      
    }

	private void showNotification(Context context) {
		NotificationManager nm = (NotificationManager) context.getSystemService(
				Context.NOTIFICATION_SERVICE);
		
		Intent intent = new Intent(Intent.ACTION_MAIN);	
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		Notification notification = new Notification(R.drawable.ic_launcher,"ticker",System.currentTimeMillis());
		notification.setLatestEventInfo(context, "title", "describe", pendingIntent);
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.defaults |= Notification.DEFAULT_VIBRATE;
		notification.defaults |= Notification.DEFAULT_SOUND;
		notification.defaults |= Notification.DEFAULT_LIGHTS;
		
		nm.notify(mIncrement++, notification);
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
