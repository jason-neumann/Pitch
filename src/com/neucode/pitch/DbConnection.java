package com.neucode.pitch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import android.os.AsyncTask;
import android.util.Log;

public class DbConnection extends AsyncTask<Object, Object, Object> {

	@Override
	protected Object doInBackground(Object... arg0) {
		try {
			Log.d("pitch","trying async");
			String pdriver = "com.mysql.jdbc.Driver";
			Class.forName(pdriver).newInstance();
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://pitch.cnqz7c8pzmnz.us-east-1.rds.amazonaws.com:3306/pitch",
				"jason_neumann",
				"laserbunny"
			);
			Log.d("pitch","connected? YES!");
			Statement stmt = conn.createStatement();
			Log.d("pitch","stmt");
			ResultSet rset = stmt.executeQuery("select userName from users");
			while(rset.next()) {
				Log.d("pitchRESULT", rset.getString("userName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Log.d("pitch", e.getMessage());
			e.printStackTrace();
		} catch (InstantiationException e) {
			Log.d("pitch", e.getMessage()+ "3");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
		Log.d("pitch", e.getMessage()+ "2");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			Log.d("pitch", e.getMessage() + "1=new");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
