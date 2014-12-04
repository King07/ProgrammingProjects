package com.example.androiddevelopmentproject;


import java.util.ArrayList;






import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.CursorIndexOutOfBoundsException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainMenuActivity extends FragmentActivity implements OnClickListener {
	Button touuranment;
	Button HelpFaq;
	Button playerSearch;
	Button playerProfile;
	Button sync;
	ImageButton connect;
	ProgressBar progressBar;
	Player appUser;
	DBHelper dbHelper;
	ArrayList<Player> listPlayers;
	ArrayList<MatchInternal> matchInternal;
	ArrayList<MatchBeker> matchBaker;
	ArrayList<MatchKroongroup> matchKroongroup;
	ArrayList<NextFiveRound> nextFiveRound;
	ProgressDialog pDialog;
	SharedPreferences sharedpreferences;
	String hash;
	String unixTimeStamp;
	public static final String TIMESTAMP_LAST_UPDATE = "timeStampUpdate"; 
	public static final String MyPREFERENCES = "AppUserPrefs" ;
	public static final String AppUrl = "http://www.loodgietersbedrijfvantol.nl/api/upd_players_matches.php?t="; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
		
		//get reference of the views
		progressBar = (ProgressBar) findViewById(R.id.ProgressBar);
		
		//get reference of the views
		touuranment = (Button) findViewById(R.id.btn_tournament);
		touuranment.setOnClickListener(this);
		
		//get reference of the views
		connect = (ImageButton) findViewById(R.id.imageBtnConnected);
				
		//get reference of the views and set the onclick listener
		sync = (Button) findViewById(R.id.btn_sync);
		sync.setOnClickListener(this);
		
		//get reference of the help button and set the onclick listener
		HelpFaq = (Button) findViewById(R.id.btn_help);
		HelpFaq.setOnClickListener(this);
		
		//get reference of the player search button and set the onclick listener
		playerSearch = (Button) findViewById(R.id.btn_searchPlayer);
		playerSearch.setOnClickListener(this);
		
		//get reference of the player profile button and set the onclick listener
		playerProfile = (Button) findViewById(R.id.btn_profile);
		playerProfile.setOnClickListener(this);
		
		listPlayers = new ArrayList<Player>();
		matchInternal = new ArrayList<MatchInternal>();
		matchBaker = new ArrayList<MatchBeker>();
		matchKroongroup = new ArrayList<MatchKroongroup>();
		nextFiveRound = new ArrayList<NextFiveRound>();
		
		// check if you are connected or not
        if(isConnected()){
        	connect.setImageResource(R.drawable.circle_green);
            
        }
        else{
        	connect.setImageResource(R.drawable.circle_red);
        }
         
		
     // 1. get passed intent 
        Intent intent = getIntent();
       appUser =  (Player) intent.getSerializableExtra("appUser");
       hash = appUser.getPlayerSecretHash();
       Log.d("The palyer", appUser.toString());
       
		
     //save the player id and Secret
     		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
     		unixTimeStamp = "0";
   		 if (sharedpreferences.contains(TIMESTAMP_LAST_UPDATE))
   	      {
   	         unixTimeStamp = sharedpreferences.getString(TIMESTAMP_LAST_UPDATE, "");

   	      }
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_tournament:
			 Bundle bundle = new Bundle();
			 Intent intentTournament = new Intent(getApplicationContext(),TournamentActivity.class);
			
				try {
					dbHelper = new DBHelper(getApplicationContext());
					 listPlayers = dbHelper.getAllPlayer();
					 matchBaker = dbHelper.getAllMatchBaker();
					 matchInternal = dbHelper.getAllMatchInternal();
					 matchKroongroup = dbHelper.getAllMatchKroongroup();
					 appUser = dbHelper.getPlayer(appUser.getId());
					 
					 bundle.putSerializable("PlayerList", listPlayers);
					 bundle.putSerializable("MatchBaker", matchBaker);
					 bundle.putSerializable("MatchInternal", matchInternal);
					 bundle.putSerializable("MatchKroongroup", matchKroongroup);
					 intentTournament.putExtra("appUser", appUser);
					// System.out.println("btn_tournament: "+listPlayers);
					 intentTournament.putExtras(bundle);
					 startActivity(intentTournament);
					
				} catch (CursorIndexOutOfBoundsException c) {
					// TODO: handle exception
					Toast.makeText(getBaseContext(), "Please Sync First", Toast.LENGTH_LONG).show();
				}catch (Exception e) {
					// TODO: handle exception
					Toast.makeText(getBaseContext(), "Please Sync First", Toast.LENGTH_LONG).show();
				}
				 
			 
			 
	        break;
		case R.id.btn_sync:
			String unixTimeStamp = "0";
			 if (sharedpreferences.contains(TIMESTAMP_LAST_UPDATE))
		      {
		         unixTimeStamp = sharedpreferences.getString(TIMESTAMP_LAST_UPDATE, "");

		      }
			
			System.out.println("The current time is:  "+unixTimeStamp);
			System.out.println(AppUrl+unixTimeStamp);
			new HttpAsyncTask().execute(AppUrl+unixTimeStamp);
			unixTimeStamp = ""+System.currentTimeMillis()/1000;
			Editor editor = sharedpreferences.edit();
  	        editor.putString(TIMESTAMP_LAST_UPDATE, unixTimeStamp);
  	        editor.commit();
	        
	        break;
		case R.id.btn_help:
			 intent = new Intent(getApplicationContext(),AppHelp.class);
	        startActivity(intent);
	        break;
		case R.id.btn_searchPlayer:
			 intent = new Intent(getApplicationContext(),AppNews.class);
	        startActivity(intent);
	        break;
		case R.id.btn_profile:
			Intent intent_profile = new Intent(getApplicationContext(),AppProfilePlayer.class);
			try {
				
				dbHelper = new DBHelper(getApplicationContext());
				appUser = dbHelper.getPlayer(appUser.getId());
				listPlayers = dbHelper.getAllPlayer();
				appUser.setPlayerSecretHash(hash);
				 intent_profile.putExtra("appUser", appUser);
				 intent_profile.putExtra("Players", listPlayers);
		        startActivity(intent_profile);
			} catch (CursorIndexOutOfBoundsException c) {
				// TODO: handle exception
				Toast.makeText(getBaseContext(), "Please Sync First", Toast.LENGTH_LONG).show();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
	        break;

		default:
			break;
		}
		
		
	}
	
	 
	 
	    public boolean isConnected(){
	        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
	            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
	            if (networkInfo != null && networkInfo.isConnected()) 
	                return true;
	            else
	                return false;   
	    }
	    private class HttpAsyncTask extends AsyncTask<String, Integer, String> {
	        @Override
	        protected String doInBackground(String... urls) {
	        	JsonHelper jsonHelper = new JsonHelper();
	        	return jsonHelper.GET(urls[0]);
	        	
	        }
	       
	        @Override
	        protected void onPreExecute() {
	        	// TODO Auto-generated method stub
	        	super.onPreExecute();
	        	pDialog = new ProgressDialog(MainMenuActivity.this);
	            pDialog.setMessage("Getting Data ... \n This will take a while");
	            pDialog.setIndeterminate(false);
	            pDialog.setTitle("Please wait");
	            pDialog.setCancelable(true);
	            pDialog.show();
	        }
	        // onPostExecute displays the results of the AsyncTask.
	        @Override
	        protected void onPostExecute(String result) {
	        	//Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
	        	
	        	try {
	        		
	        		//Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
					JSONObject json = new JSONObject(result);
					JSONObject playerlist = json.getJSONObject("players");
					JSONObject matchinternal = json.getJSONObject("internal");
					JSONObject matchbaker = json.getJSONObject("beker");
					JSONObject matchkroongroup = json.getJSONObject("kroongroup");
					JSONObject next5 = json.getJSONObject("next5");
					
					
					//get all players
					for (int i = 0; i < playerlist.length();i++) {
						
						JSONObject playerInfo = json.getJSONObject("players").getJSONObject(""+i+"");
						//System.out.println(playerInfo.toString());
						 //playerInfo.getString("fname"), playerInfo.getString("lname"), Integer.parseInt(playerInfo.getString("current_rating"))
						Player player = new Player(playerInfo.getString("id"), playerInfo.getString("fname"), playerInfo.getString("lname"), playerInfo.getString("next_pairing"), Integer.parseInt(playerInfo.getString("points")), 
								Integer.parseInt(playerInfo.getString("current_rating")), 0,Integer.parseInt(playerInfo.getString("matcheswhite")),Integer.parseInt(playerInfo.getString("matcheswonwhite")),Integer.parseInt(playerInfo.getString("matchesdrawwhite")),
								Integer.parseInt(playerInfo.getString("matchesblack")),Integer.parseInt(playerInfo.getString("matcheswonblack")),Integer.parseInt(playerInfo.getString("matchesdrawblack")));
						dbHelper = new DBHelper(getApplicationContext());
						if(Integer.parseInt(unixTimeStamp) ==0)
						{
							System.out.println("unixTimeStamp: "+unixTimeStamp);
							dbHelper.createPlayer(player);
						}else{
							dbHelper.updatePlayer(player);
						}
						if((appUser.getId().equals(player.getId())))
						{
							appUser = player;
							System.out.println(appUser.toString());
						}
						listPlayers.add(player);
						
					}
					
					//get all match internal
					for (int i = 0; i < matchinternal.length();i++) {
						JSONObject internalInfo = json.getJSONObject("internal").getJSONObject(""+i+"");
						MatchInternal matchInternal = new MatchInternal(internalInfo.getString("id_player_white"), internalInfo.getString("id_player_black"), internalInfo.getString("id_player_black"), Integer.parseInt(internalInfo.getString("round")));
						dbHelper = new DBHelper(getApplicationContext());
						if(Integer.parseInt(unixTimeStamp) == 0)
						{
							dbHelper.createInternalMatch(matchInternal);
						}else{
							dbHelper.updateInternalMatch(matchInternal);
						}
						MainMenuActivity.this.matchInternal.add(matchInternal);
						
					}
					
					//get all match beker
					for (int i = 0; i < matchbaker.length();i++) {
						JSONObject bekerInfo = json.getJSONObject("beker").getJSONObject(""+i+"");
						MatchBeker matchBeker = new MatchBeker(bekerInfo.getString("id_player_white"), bekerInfo.getString("id_player_black"), bekerInfo.getString("winner_id"), Integer.parseInt(bekerInfo.getString("round")));
						dbHelper = new DBHelper(getApplicationContext());
						if(Integer.parseInt(unixTimeStamp) ==0)
						{
							dbHelper.createBekerMatch(matchBeker);
						}else{
							dbHelper.updateMatchBeker(matchBeker);
						}
						matchBaker.add(matchBeker);
						
					}
					
					//get all match matchKroongroup
					for (int i = 0; i < matchkroongroup.length();i++) {
						JSONObject kroongroupInfo = json.getJSONObject("beker").getJSONObject(""+i+"");
						MatchKroongroup matchKroongroup = new MatchKroongroup(kroongroupInfo.getString("id_player_white"), kroongroupInfo.getString("id_player_black"), kroongroupInfo.getString("winner_id"), Integer.parseInt(kroongroupInfo.getString("round")));
						dbHelper = new DBHelper(getApplicationContext());
						if(Integer.parseInt(unixTimeStamp) == 0)
						{
							dbHelper.createKroongroupMatch(matchKroongroup);
						}else{
							dbHelper.updateKroongroupMatch(matchKroongroup);
						}
						MainMenuActivity.this.matchKroongroup.add(matchKroongroup);
						
					}
					
					//get all next five matches
					for (int i = 0; i < next5.length();i++) {
						JSONObject next5Info = json.getJSONObject("next5").getJSONObject(""+i+"");
						NextFiveRound next5Round = new NextFiveRound(next5Info.getString("id"),next5Info.getString("first"),next5Info.getString("second"),next5Info.getString("third"),next5Info.getString("fourth"),next5Info.getString("fifth"));
						dbHelper = new DBHelper(getApplicationContext());
						if(Integer.parseInt(unixTimeStamp) ==0)
						{
							dbHelper.createNextFiveMatch(next5Round);
						}
						nextFiveRound.add(next5Round);
						
					}
					pDialog.dismiss();

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					Log.d("JSON error", "Error in the json");
				}
	       }
	    }
	    @Override
		public boolean onCreateOptionsMenu(Menu menu) {

			// Inflate the menu; this adds items to the action bar if it is present.
	    	if(appUser.isAdmin == 1){
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
	    	}
	    	return false;
		}
	    
	    @Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Handle action bar item clicks here. The action bar will
			// automatically handle clicks on the Home/Up button, so long
			// as you specify a parent activity in AndroidManifest.xml.
			
				
				// TODO Auto-generated method stub
				switch (item.getItemId()) {
				case R.id.usersProfile:
					 Bundle bundle = new Bundle();
					 Intent intentUserProfile = new Intent(getApplicationContext(),AdminPanel.class);
					if(listPlayers.isEmpty())
					 {
						try {
							dbHelper = new DBHelper(getApplicationContext());
							 listPlayers = dbHelper.getAllPlayer();
							 appUser = dbHelper.getPlayer(appUser.getId());
							
						} catch (CursorIndexOutOfBoundsException c) {
							// TODO: handle exception
						}catch (Exception e) {
							// TODO: handle exception
						}
						 
					 }
						appUser.setPlayerSecretHash(hash);
						bundle.putSerializable("PlayerList", listPlayers);
					
						intentUserProfile.putExtra("appUser", appUser);
					// System.out.println("btn_tournament: "+listPlayers);
						intentUserProfile.putExtras(bundle);
						startActivity(intentUserProfile);
			        	break;
				

				default:
					return super.onOptionsItemSelected(item);
					}
				return true;
				
			
			
		}


}
