package com.ting.androidexample.databases;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {
	
	private static DbOpenHelper mDbHelper;
	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "databaseName.db";

	public static final int TYPE_INNER_FILE = 1;
	public static final int TYPE_OUTER_FILE = 2;

	public static void close() {
		if(mDbHelper != null) {
			mDbHelper.close();
			mDbHelper = null;
		}
	}
	
	public static SQLiteDatabase getDb(Context context) {
		DbOpenHelper helper = getDbOpenHelper(context);
		return helper.getWritableDatabase();
	}
	
	public static List<Log> selectLog(SQLiteDatabase db) {
		Cursor cursor = db.query(LogEnum.TABLE_NAME, null, null, null, null, null, null);
		List<Log> values = new ArrayList<Log>();
		
		while(cursor.moveToNext()) {
			Log log = new Log();
			log.path = cursor.getString(cursor.getColumnIndex(LogEnum.path.name()));
			log.changeType = cursor.getInt(cursor.getColumnIndex(LogEnum.changeType.name()));
			log.deviceId = cursor.getString(cursor.getColumnIndex(LogEnum.deviceId.name()));
			log.dataType = cursor.getInt(cursor.getColumnIndex(LogEnum.dataType.name()));
			values.add(log);
		}
		cursor.close();
		return values;
	}
	
	public static long insertLog(SQLiteDatabase db, String path, 
			int changeType, String deviceId, int dataType) {
		ContentValues values = new ContentValues();
		values.put(LogEnum.path.name(), path);
		values.put(LogEnum.changeType.name(), changeType);
		values.put(LogEnum.deviceId.name(), deviceId);
		values.put(LogEnum.dataType.name(), dataType);
		return db.insert(LogEnum.TABLE_NAME, null, values);
	}
	
	public static long clearLog(SQLiteDatabase db) {
		return db.delete(LogEnum.TABLE_NAME, null, null);
	}
	
	public static int deleteLog(SQLiteDatabase db, String path) {
		String[] where = new String[] {path};
		return db.delete(LogEnum.TABLE_NAME, LogEnum.path.name() + "=?", where);
	}
	
	public static long updateLog(SQLiteDatabase db, String path, 
			int changeType, String deviceId, int dataType) {
		ContentValues values = new ContentValues();
		values.put(LogEnum.changeType.name(), changeType);
		values.put(LogEnum.changeType.name(), deviceId);
		values.put(LogEnum.dataType.name(), dataType);
		String[] where = new String[] {path};
		return db.update(LogEnum.TABLE_NAME, values, LogEnum.path.name() + "=?", where);
	}
	
	public static Cursor getRecordFromStringKey(SQLiteDatabase db, String tableName, String name, String value)
	{
		//final String selection = "("+SyncTablesEnum.tableName.name()+"==?"+")";
		final String selection = "("+name+"==?"+")";
		String[] selectionArgs = new String[] {value};
		
		Cursor cursor = db.query(tableName, null, selection, selectionArgs, null, null, null);
		return cursor;
	}
	
	public static long putLog(SQLiteDatabase db, String path, 
			int changeType, String deviceId, int dataType) {
		Cursor cursor = Database.getRecordFromStringKey(db, 
				LogEnum.TABLE_NAME, LogEnum.path.name(), path);
		
		long res = 0;
		if (cursor!=null && cursor.getCount()>0)
		{
			res = Database.updateLog(db, path, changeType, deviceId, dataType);
		} else {
			res = Database.insertLog(db, path, changeType, deviceId, dataType);
		}
	    return res;
	}
	
	private static DbOpenHelper getDbOpenHelper(Context context) {
		if(mDbHelper == null)
			mDbHelper = new DbOpenHelper(context, DB_NAME, DB_VERSION);
		
		return mDbHelper;
	}
	
	private static class DbOpenHelper extends SQLiteOpenHelper {

		public DbOpenHelper(Context context, String name, int version) {
			super(context, name, null, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			
			db.execSQL("CREATE TABLE " + LogEnum.TABLE_NAME + " (" +
					LogEnum.path.name() + " TEXT NOT NULL PRIMARY KEY, " + 
					LogEnum.changeType.name() + " INTEGER NOT NULL, " +
					LogEnum.deviceId.name() + " TEXT NOT NULL, " +
					LogEnum.dataType.name() + " INTEGER NOT NULL" +
					");"
					);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			dropTables(db);
			onCreate(db);
		}

		private void dropTables(SQLiteDatabase db) {
			db.execSQL("DROP TABLE IF EXISTS " + LogEnum.TABLE_NAME);
		}	
	}
	
	enum LogEnum {
		path,
		changeType,
		deviceId,
		dataType;
		
		static final String TABLE_NAME = "LogEnum";
	}

	public static class Log {
		public String path;
		public int changeType;
		public String deviceId;
		public int dataType;
	}
}





