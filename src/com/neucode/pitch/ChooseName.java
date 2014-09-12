package com.neucode.pitch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ChooseName extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_name);
	}
	
	protected void onResume() {
		super.onResume();
		SharedPreferences prefs = getSharedPreferences("pitchPreferences", Context.MODE_PRIVATE);
		if(prefs.getString("userName", "") != "") {
			//Go to choose table
			Intent intent = new Intent(this, ChoosePartner.class);
			startActivity(intent);
		}
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
		
		
		
		//choose partner will list available partners from a remote sql db (fake db for now). Selecting a partner goes to choose opponents
		//choose opponents will then pull from a remote sql db to find available teams and display them in a list
		//when the user chooses an opponent it will take them to another activity where we can start working on displaying the cards
		EditText name = (EditText) findViewById(R.id.user_name);
		
		editor.putString("userName", name.getText().toString());
		editor.commit();
		Intent intent = new Intent(this, ChoosePartner.class);
		startActivity(intent);
	}
}
