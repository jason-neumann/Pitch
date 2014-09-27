package com.neucode.pitch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Table extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table);
		
		TextView welcome = (TextView) findViewById(R.id.table);
	    welcome.setText("jtest");
	}
}
