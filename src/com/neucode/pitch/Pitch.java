package com.neucode.pitch;

import android.app.Application;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Pitch extends Application {
	public void onCreate(){
		super.onCreate();
		Log.d("pitch", "starting");
		LocalDb dbObj = new LocalDb(getBaseContext());
		SQLiteDatabase db = dbObj.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("userName","blah");
		values.put("password", "other thing");
		values.put("userId", 2);

		// Insert the new row, returning the primary key value of the new row
		long newRowId;
		newRowId = db.insert(
		         "users",
		         "",
		         values);
		Log.d("pitch", "created row id: " + newRowId);
		;
	}
}
