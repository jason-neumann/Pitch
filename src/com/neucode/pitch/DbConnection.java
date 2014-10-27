package com.neucode.pitch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import android.os.AsyncTask;
import android.util.Log;

public class DbConnection extends AsyncTask<String, Void, Void> {
	private static Connection conn;

	@Override
	protected Void doInBackground(String... arg0) {
		try {
			if(!(conn instanceof Connection)) {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection(
					"jdbc:mysql://pitch.cnqz7c8pzmnz.us-east-1.rds.amazonaws.com:3306/pitch",
					"jason_neumann",
					"laserbunny"
				);
			}
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(arg0[0]);
			while(rset.next()) {
				Log.d("pitchRESULT", rset.getString("userName"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
