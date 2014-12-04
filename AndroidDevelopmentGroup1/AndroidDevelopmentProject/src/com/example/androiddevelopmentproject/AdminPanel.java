package com.example.androiddevelopmentproject;


import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class AdminPanel extends FragmentActivity {

	ArrayList<Player> PlayerList ;
	Player appUser;
	ListView playerList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_panel);
		playerList = (ListView) findViewById(R.id.list);
		PlayerList =(ArrayList<Player>) getIntent().getSerializableExtra("PlayerList");
		
		// 1. get passed intent 
	       Intent intent = getIntent();
	       appUser =  (Player) intent.getSerializableExtra("appUser");
	       
	       ArrayAdapter<Player> adapter
	       
	       = new ArrayAdapter<Player>(this,
	     
	            android.R.layout.simple_list_item_1,
	     
	            PlayerList);
	     
	       playerList.setAdapter(adapter);
		
		playerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(AdminPanel.this,AdminPlayerAttendance.class);
				Player player = (Player) playerList.getItemAtPosition(position);
				intent.putExtra("Player", player);
				intent.putExtra("AppUser", appUser);
		        startActivity(intent);
				
			}
		});
		
	}
	



}
