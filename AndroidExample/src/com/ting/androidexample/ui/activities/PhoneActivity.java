package com.ting.androidexample.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneActivity extends Activity {

	private final static String TAG = "SimActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		testPhoneStatus();
	}

	private void testPhoneStatus() {
		TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		Log.d(TAG, "getSimState():" + tm.getSimState());
		Log.d(TAG, "getSimSerialNumber():" + tm.getSimSerialNumber());
		Log.d(TAG, "getSimOperator():" + tm.getSimOperator());
		Log.d(TAG, "getSimOperatorName():" + tm.getSimOperatorName());
		Log.d(TAG, "getSimCountryIso():" + tm.getSimCountryIso());

		Log.d(TAG, "getNetworkType():" + tm.getNetworkType());
		Log.d(TAG, "getNetworkOperator():" + tm.getNetworkOperator());
		Log.d(TAG, "getNetworkOperatorName():" + tm.getNetworkOperatorName());
		Log.d(TAG, "getNetworkCountryIso():" + tm.getNetworkCountryIso());
		Log.d(TAG, "isNetworkRoaming():" + tm.isNetworkRoaming());
		
		Log.d(TAG, "getLine1Number():" + tm.getLine1Number());
		Log.d(TAG, "getSubscriberId():" + tm.getSubscriberId());
		Log.d(TAG, "getPhoneType():" + tm.getPhoneType());
		Log.d(TAG, "getDeviceSoftwareVersion():" + tm.getDeviceSoftwareVersion());
		Log.d(TAG, "getCallState():" + tm.getCallState());
		Log.d(TAG, "getDataState():" + tm.getDataState());
		Log.d(TAG, "getDeviceId():" + tm.getDeviceId());
		Log.d(TAG, "getCellLocation():" + tm.getCellLocation());
		Log.d(TAG, "getVoiceMailAlphaTag():" + tm.getVoiceMailAlphaTag());
		Log.d(TAG, "getVoiceMailNumber():" + tm.getVoiceMailNumber());
		Log.d(TAG, "getNeighboringCellInfo():" + tm.getNeighboringCellInfo());
	}

	
}
