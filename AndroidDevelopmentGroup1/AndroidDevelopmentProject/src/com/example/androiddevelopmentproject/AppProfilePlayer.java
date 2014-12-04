package com.example.androiddevelopmentproject;


import java.util.ArrayList;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;


public class AppProfilePlayer extends FragmentActivity {

	 Player appUser ;
	 Player player ;
	 ArrayList<Player> Players;
	 Switch playerAttendance;
	 DBHelper dbHelper;
	 public static final String AppPlayerAttendance = "http://www.loodgietersbedrijfvantol.nl/api/change_absent_personal.php?hash=";
	 public static final String AppAdmin = "http://www.loodgietersbedrijfvantol.nl/api/change_absent_personal.php?hash=[hash]&state=[true/false]&id=[player_id]";
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.player_profile);
			playerAttendance = (Switch) findViewById(R.id.switchPlayerAttendance);
			
			
	      
	    	   // 1. get passed intent 
		       Intent intent = getIntent();
		       appUser =  (Player) intent.getSerializableExtra("appUser");
		   //    player =  (Player) intent.getSerializableExtra("Player");
		       Players = (ArrayList<Player>) intent.getSerializableExtra("Players");
		       if(appUser.getNextPairing().contains("A") || appUser.getNextPairing().contains("E"))
		       {
		    	   playerAttendance.setChecked(false);
		       }else{
		    	   playerAttendance.setChecked(true); 
		       }
		
			       playerAttendance.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						// TODO Auto-generated method stub
						System.out.println(isChecked+"Player hash: "+appUser.getPlayerSecretHash());
						if(isChecked)
						{
							appUser.setNextPairing(" ");
						}else{
							appUser.setNextPairing("A");
						}
						dbHelper = new DBHelper(getApplicationContext());
						dbHelper.updatePlayer(appUser);
						new HttpAsyncTask().execute(AppPlayerAttendance+appUser.getPlayerSecretHash()+"&state="+isChecked);
					}
				});
	       
	       
	   
	       
	       
	       
		}
		//background task checking a get request to the given url
		 private class HttpAsyncTask extends AsyncTask<String, Void, String> {
		        @Override
		        protected String doInBackground(String... urls) {
		        	JsonHelper jsonHelper = new JsonHelper();
		            return jsonHelper.GET(urls[0]);
		        }
		        // onPostExecute check if the result of the AsyncTask is true then save the info and 
		        //move to the next screen (MainMenuActivity)
		        //else password was incorrect
		        @Override
		        protected void onPostExecute(String result) {
		        	
		        	if (result.contains("true")) {
		        		
					}else{
						
					}
		        	
		        	
		       }
		 }
		
		public Player getPlayer() {
			return appUser;
			
		}
		
		
		
		
		
}