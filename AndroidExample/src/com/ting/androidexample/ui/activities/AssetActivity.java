package com.ting.androidexample.ui.activities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

public class AssetActivity extends Activity {

	private final static String TAG = "AssetActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
//		getAssetPath(this);
		
		dumpNoRecursive(this, "visitAsset");
		
	}

	private void getAssetPath(Context context) {
		AssetManager am = context.getAssets();
		try {
			String[] paths = am.list("www");
			for(String path: paths) {
				Log.d(TAG, "path:" + path);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
    private static boolean dumpNoRecursive(Context context, String assetDir) {
    	String[] files = null;
    	String prePath = context.getFilesDir().getParent();
    	LinkedList<String> dirs = new LinkedList<String>();
    	
    	AssetManager assetManager = context.getAssets();
    	
    	dirs.add(assetDir);
    	
    	while(!dirs.isEmpty()) {
    		String dir = dirs.removeFirst();
    		try 
    		{
    			Log.d(TAG, "dir:" + dir);
    			files = assetManager.list(dir);
    			Log.d(TAG, "files count:" + files.length);
    		} 
    		catch (IOException e) 
    		{
    			Log.d(TAG, "Assets list exception: " + e);
    		}
        
    		if (files.length == 0)
    		{
    			Log.d(TAG, "enter file");
    			if (!dumpOneFile(context, dir, prePath + "/" + dir))
    			{
    				Log.e(TAG, String.format("dump file(%s) fail.", assetDir));
    				return false;
    			}
            
    		}
    		else
    		{
    			Log.d(TAG, "enter dir");
    			File destDir = new File(prePath + "/" + dir);
    			Log.d(TAG, "destDir:" + prePath + "/" + dir);
    	//		Log.d(TAG, "create dir:" + destDir.mkdirs());
    			if (destDir.mkdirs())
    			{
    				Log.d(TAG, files + "");
    				for(String file : files) {
    					Log.d(TAG, "file:" + file);
    					dirs.add(dir + "/" + file);
    				}
    			}
    		}
    	}
    	
    	return true;
    }
    
    private static boolean dumpOneFile(Context context, String assetFile, String targetFile)
    {
        boolean ret = false;
        InputStream is = null;
        OutputStream os = null;
        File outFile = null;
        AssetManager assetManager = context.getAssets();
        
        //Log.d(TAG, "dumpOneFile, Form: " + assetFile + " To: " + targetFile);
        try
        {
            do
            {
                is = assetManager.open(assetFile);
                if (null == is)    break;
               /* 
                outFile = new File(targetFile);
                outFile.createNewFile();
                // TODO: set mode in AssetPorter. to move this to parameter of dumpAssets if needed
                outFile.setReadable(true, false);
                outFile.setWritable(true);
                
                os = new FileOutputStream(outFile);
                */
                // use openFileOutput method to compatible API 8 and below
                os = context.openFileOutput("asset.mid.file", Context.MODE_WORLD_READABLE);
                int length = 0;
                byte[] buffer = new byte[1024];
                while ((length = is.read(buffer)) > 0)
                {
                    os.write(buffer, 0, length);
                }
                if (null != is)
                {
                    is.close();
                }
                if (null != os)
                {
                    os.flush();
                    os.close();
                }
                String tempStr = context.getFilesDir() + "/asset.mid.file";
                File temp = new File(tempStr);
                File target = new File(targetFile);
                if (temp.renameTo(target))
                {
                    ret = true;            
                }
                else
                {
                    Log.e(TAG, String.format("Dump one file rename error, from %s to %s", tempStr, targetFile));
                }
            } while (false);
        }
        catch (Exception e) 
        {
            Log.e(TAG, "Dump one file error, exception: " + e);
        }

        return ret;
    }

}
