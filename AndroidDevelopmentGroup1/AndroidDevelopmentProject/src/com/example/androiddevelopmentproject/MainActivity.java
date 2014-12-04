package com.example.androiddevelopmentproject;



import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends FragmentActivity  implements android.view.View.OnClickListener{
	
	public static final String AppHash = "http://www.loodgietersbedrijfvantol.nl/api/verify.php?hash="; 
	Button login;
	EditText id;
	EditText secret;
	String playerId;
	String playerSecret;
	String hashMd5;
	String appUserAuth;
	
	 public static final String MyPREFERENCES = "AppUserPrefs" ;
	   public static final String ID = "id"; 
	   public static final String SECRET = "secret"; 
	   public static final String SECRET_HASH = "hash";
	   public static final String AppUserAuth = "auth";
	   public static final String TIMESTAMP_LAST_UPDATE = "timeStampUpdate"; 
	   SharedPreferences sharedpreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//check if the player already logged in
		AuthCheck();
		
		//Remove title bar before set in the view
	    RemoveTitleBar();
	    setContentView(R.layout.login_screen);
		//get reference of all views
		login = (Button) findViewById(R.id.button_enter);
		login.setOnClickListener(this);
		id = (EditText) findViewById(R.id.playerId);
		secret = (EditText) findViewById(R.id.playerSecret);

		
		
	}
	
	// if the login button is clicked
	//get the player id and secret
	//hash md5 the secret and a background get request 

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 playerId  = id.getText().toString();
	     playerSecret  = secret.getText().toString();
	     hashMd5 =md5Java(playerSecret).substring(0, 30);
	     System.out.println("hashMd5: "+hashMd5);
	     new HttpAsyncTask().execute(AppHash+hashMd5);
	    
	
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
	        	
	        	if (result.contains("true") || result.contains("admin")) {
	        		Player appUser = new Player(playerId, playerSecret,hashMd5);
	        		
		        		  Editor editor = sharedpreferences.edit();
		        	      editor.putString(ID, playerId);
		        	      editor.putString(SECRET, playerSecret);
		        	      editor.putString(SECRET_HASH, hashMd5);
		        	      if(result.contains("admin")){
		        	    	  editor.putString(AppUserAuth, "1");
		        	    	  appUser.setIsAdmin(1);
		        	      }
		        	      editor.putString(TIMESTAMP_LAST_UPDATE, "0");
		        	      editor.commit(); 
	        		
	        	      
	        		Intent intent = new Intent(getApplicationContext(),MainMenuActivity.class);
	        		intent.putExtra("appUser", appUser);
	                startActivity(intent);
	                finish();
				}else{
					Toast.makeText(getBaseContext(), "Incorrect ID or Secret", Toast.LENGTH_LONG).show();
					id.setText("");
					secret.setText("");
				}
	        	
	        	
	       }
	 }
	 
	 //Method to has the player secret key to md5 hashing
	 public static String md5Java(String message){ 
			String digest = null; 
			try { MessageDigest md = MessageDigest.getInstance("MD5"); 
			byte[] hash = md.digest(message.getBytes("UTF-8")); 
			//converting byte array to Hexadecimal String 
			StringBuilder sb = new StringBuilder(2*hash.length); 
			for(byte b : hash){ 
				sb.append(String.format("%02x", b&0xff)); 
				} 
			digest = sb.toString();
			} catch (UnsupportedEncodingException ex) 
			{ 
				//Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE, null, ex); 
				} catch (NoSuchAlgorithmException ex) { 
					//Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE, null, ex); 
					} 
			return digest; 
			} 
	 
	 private void AuthCheck() {
		 sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			if (sharedpreferences.contains(SECRET))
		      {
				 playerId  = sharedpreferences.getString(ID, "");
			     playerSecret  = sharedpreferences.getString(SECRET, "");
			     hashMd5 = sharedpreferences.getString(SECRET_HASH, "");
			     
			     Player appUser = new Player(playerId, playerSecret,hashMd5);
			     if (sharedpreferences.contains(AppUserAuth))
			      {
			    	 appUserAuth = sharedpreferences.getString(AppUserAuth, "");
			    	 appUser.setIsAdmin(Integer.parseInt(appUserAuth));
			      }
			     Intent intent = new Intent(getApplicationContext(),MainMenuActivity.class);
			     intent.putExtra("appUser", appUser);
	             startActivity(intent);
	             finish();

		      }
	}
	 
	 private void RemoveTitleBar() {
		 this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
	 

}
