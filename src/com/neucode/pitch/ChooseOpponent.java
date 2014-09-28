/**
 * 
 */
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

/**
 * @author neubie
 *
 */
public class ChooseOpponent extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_opponent);

		//get the name for the welcome message
	    SharedPreferences prefs = this.getSharedPreferences("pitchPreferences", Context.MODE_PRIVATE);
	    String msg = "Alright " + prefs.getString("userName","") + " and " + prefs.getString("partner", "") + ", who would you like to play against?";
	    
	    //set the text view's text
	    TextView welcome = (TextView) findViewById(R.id.welcome);
	    welcome.setText(msg);
	    
	    //add people to list view
	    ListView opponentList = (ListView) findViewById(R.id.availableOpponents);
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
	    		this,
	    		android.R.layout.simple_list_item_1,
	    		android.R.id.text1,
	    		getResources().getStringArray(R.array.opponents)
	    );
	    opponentList.setAdapter(adapter);
	    final Activity opponentReference = this;
	    
	    opponentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	    	 
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	//@todo send data to remote db, wait for other players to confirm game
            	
            	//save the data in preferences
            	SharedPreferences prefs = getBaseContext().getSharedPreferences("pitchPreferences", Context.MODE_PRIVATE);
            	SharedPreferences.Editor editor = prefs.edit();
            	editor.putLong("opponent", id);
            	editor.commit();
            	
            	//create the table activity
            	Intent table = new Intent(opponentReference,Table.class);
            	startActivity(table);
			}
		});
	}

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
	
	public void chooseNewPartner(View view) {
		SharedPreferences prefs = this.getSharedPreferences("pitchPreferences", Context.MODE_PRIVATE);
	    SharedPreferences.Editor editor = prefs.edit();
	    editor.remove("partner");
	    editor.commit();

	    Intent choosePartner = new Intent(this,ChoosePartner.class);
	    startActivity(choosePartner);
	    finish();
	}
}
