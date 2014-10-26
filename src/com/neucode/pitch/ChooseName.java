package com.neucode.pitch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.twodee.android.utils.log.LogPrintStream;
import org.twodee.android.utils.log.Priority;

public class ChooseName extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_name);
	}
	
	protected void onResume() {
		super.onResume();

		//basic db call
		new DbConnection().execute(new Object());
		
		
//		SharedPreferences prefs = getSharedPreferences("pitchPreferences", Context.MODE_PRIVATE);
//		if(prefs.getString("userName", "") != "") {
//			//Go to choose table
//			Intent intent = new Intent(this, ChoosePartner.class);
//			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//			startActivity(intent);
//			finish();
//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choose_name, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void saveName(View view) {
		SharedPreferences prefs = this.getSharedPreferences("pitchPreferences", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();

		EditText name = (EditText) findViewById(R.id.user_name);
		
		editor.putString("userName", name.getText().toString());
		editor.commit();
		Intent intent = new Intent(this, ChoosePartner.class);
		startActivity(intent);
	}
}
