package com.ting.androidexample.util;

import java.io.File;
import java.util.LinkedList;

import android.util.Log;

public class FileUtil {

	private final static String TAG = "FileUtil";

	public static long getFileOrDirSize(String path) {
		long totalSize = 0;		
		LinkedList<File> list = new LinkedList<File>();
		
		File file = new File(path);
		if(file.isDirectory()) {
			list.add(file);
		} 
			
		totalSize += file.length();
		Log.d(TAG , "name:" + file.getName() + ", size:" + totalSize);

		
		File temp;
		while(!list.isEmpty()) {
			temp = list.removeFirst();
			File[] fileList = temp.listFiles();
			for(File i : fileList) {
				if(i.isDirectory()) {
					list.add(i);
				} 
					
				totalSize += i.length();
				Log.d(TAG, "name:" + i.getName() + ", size:" + i.length());
			}
		}
		
		return totalSize;
	}
}
