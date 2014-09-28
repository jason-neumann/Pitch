package com.neucode.pitch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ChoosePartner extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_partner);

		//get the name for the welcome message
	    SharedPreferences prefs = this.getSharedPreferences("pitchPreferences", Context.MODE_PRIVATE);
	    String msg = "Welcome " + prefs.getString("userName","") + ". Select a partner.";
	    
	    // Create the text view
	    TextView welcome = (TextView) findViewById(R.id.welcome);
	    welcome.setText(msg);
	    final String[] opponents = getResources().getStringArray(R.array.partners);
	    final ChoosePartner activityReference = this;
	    
	    //add people to list view
	    ListView partnersList = (ListView) findViewById(R.id.availablePartners);
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
	    		this,
	    		android.R.layout.simple_list_item_1,
	    		android.R.id.text1,
	    		opponents
	    );
	    partnersList.setAdapter(adapter);
	    
	    partnersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	    	 
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	//I'm assuming the id passed in will be the id from the db, too lazy to create a hashmap to test it
            	
            	//@todo send data to remote db, wait for other player to confirm partnership
            	
            	//save the data in preferences
            	SharedPreferences prefs = getBaseContext().getSharedPreferences("pitchPreferences", Context.MODE_PRIVATE);
            	SharedPreferences.Editor editor = prefs.edit();
            	editor.putString("partner", opponents[(int) id]);
            	editor.commit();
            	
            	Intent chooseOpponent = new Intent(activityReference, ChooseOpponent.class);
            	startActivity(chooseOpponent);
			}
		});
	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.choose_name, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
	
	public void resetName(View view) {
		SharedPreferences prefs = this.getSharedPreferences("pitchPreferences", Context.MODE_PRIVATE);
	    SharedPreferences.Editor editor = prefs.edit();
	    editor.remove("userName");
	    editor.commit();

	    Intent chooseName = new Intent(this,ChooseName.class);
	    startActivity(chooseName);
	    finish();
	}
}


