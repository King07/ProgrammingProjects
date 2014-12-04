package com.example.androiddevelopmentproject;


import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class AppHelp extends FragmentActivity {

	ListView appHelp;
	ArrayList<String> appHelpString;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_help);
		appHelp = (ListView) findViewById(R.id.helpList);
		
	appHelpString = new ArrayList<String>();
	appHelpString.add("1: The app needs to be sync before it can be use. Press the Sync.");
	appHelpString.add("2: Syncing can take up too 5 minutes.");
	appHelpString.add("3: It is advised to use the sync button often.");
	appHelpString.add("3: Syncing generally takes at most 30 seconds after first time.");
	appHelpString.add("4: Green indicates internet/red indicates no internet light in the top right.");
	appHelpString.add("5: TOURNAMENT- P: gives the chance of facing this player next.");
	appHelpString.add("6: TOURNAMENT- C: gives the chance of winning.");
		ArrayAdapter<String> adapter
	       
	       = new ArrayAdapter<String>(this,
	     
	            android.R.layout.simple_list_item_1,
	     
	            appHelpString);
	     
	       appHelp.setAdapter(adapter);
		
		
	}



}
