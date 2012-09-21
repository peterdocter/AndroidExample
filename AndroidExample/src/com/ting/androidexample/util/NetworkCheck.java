package com.ting.androidexample.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class NetworkCheck {
	/**  
     * �����Ƿ����  
     */ 
	public static boolean isNetworkAvailable(Context context) {   
		ConnectivityManager connectivity = (ConnectivityManager) context   
	                .getSystemService(Context.CONNECTIVITY_SERVICE);   
	    if (connectivity == null) {   
	    } else {   
	    	NetworkInfo[] info = connectivity.getAllNetworkInfo();   
	        if (info != null) {   
	        	for (int i = 0; i < info.length; i++) {   
	            	if (info[i].getState() == NetworkInfo.State.CONNECTED) {   
	                	return true;   
	                }   
	            }   
	        }   
	    }   
	    return false;   
	}   
	
	/**  
     * wifi�Ƿ��  
     */   
	public static boolean isWifiEnabled(Context context) {   
		ConnectivityManager mgrConn = (ConnectivityManager) context   
	                .getSystemService(Context.CONNECTIVITY_SERVICE);   
	    TelephonyManager mgrTel = (TelephonyManager) context   
	                .getSystemService(Context.TELEPHONY_SERVICE);   
	    return ((mgrConn.getActiveNetworkInfo() != null && mgrConn   
	                .getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED) || mgrTel   
	                .getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS);
	}
	
	 /**  
     * �жϵ�ǰ�����Ƿ���wifi����  
     * if(activeNetInfo.getType()==ConnectivityManager.TYPE_MOBILE) { //�ж�3G��  
     *   
     * @param context  
     * @return boolean  
     */   
    public static boolean isWifi(Context context) {   
        ConnectivityManager connectivityManager = (ConnectivityManager) context   
                .getSystemService(Context.CONNECTIVITY_SERVICE);   
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();   
        if (activeNetInfo != null   
                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {   
            return true;   
        }   
        return false;   
    }   
    
    /**  
     * �жϵ�ǰ�����Ƿ���3G����  
     *   
     * @param context  
     * @return boolean  
     */   
    public static boolean is3G(Context context) {   
        ConnectivityManager connectivityManager = (ConnectivityManager) context   
                .getSystemService(Context.CONNECTIVITY_SERVICE);   
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();   
        if (activeNetInfo != null   
                && activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {   
            return true;   
        }   
        return false;   
    }   

}
