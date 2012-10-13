package com.ting.androidexample.ui.activities;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class ResolveInfoActivity extends Activity {

private PackageManager packageManager;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        packageManager = (PackageManager) getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, 0);
        
        for(ResolveInfo info : list) {
        	Log.d("packageName", info.activityInfo.packageName);
        }
        
    }
}
