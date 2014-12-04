package com.example.androiddevelopmentproject;



import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;



public class AdminPlayerAttendance extends FragmentActivity {

	Switch playerAttendance;
	Player appUser;
	Player player;
	DBHelper dbHelper;
	public static final String AppPlayerAttendance = "http://www.loodgietersbedrijfvantol.nl/api/change_absent_admin.php?hash=";
	 public static final String AppAdmin = "http://www.loodgietersbedrijfvantol.nl/api/change_absent_personal.php?hash=[hash]&state=[true/false]&id=[player_id]";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_player_profile);
		playerAttendance = (Switch) findViewById(R.id.adminPlayerAttendance);
		
		// 1. get passed intent 
	       Intent intent = getIntent();
	        appUser = (Player) intent.getSerializableExtra("AppUser");
	       player =  (Player) intent.getSerializableExtra("Player");
	       System.out.println("appuser :"+appUser.getFirstName()+"player :"+player.getNextPairing());
	        if(player.getNextPairing().contains("A") || player.getNextPairing().contains("E"))
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
						player.setNextPairing(" ");
					}else{
						player.setNextPairing("A");
					}
					dbHelper = new DBHelper(getApplicationContext());
					dbHelper.updatePlayer(player);
					new HttpAsyncTask().execute(AppPlayerAttendance+appUser.getPlayerSecretHash()+"&state="+isChecked+"&id="+player.getId());
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



}
