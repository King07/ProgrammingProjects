package com.example.political;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;



public class BaseActivity extends FragmentActivity {
	TodoSQLiteHelper db;
	PoliticalParty politicalParty;
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
			
			// TODO Auto-generated method stub
			switch (item.getItemId()) {
			case R.id.RI:
			new MyAsyncTask().execute();
		        	return true;
			

			default:
				return super.onOptionsItemSelected(item);
				}
			
		
		
	}
	public class MyAsyncTask extends AsyncTask<Void, Void, Void> {

		@SuppressWarnings("unchecked")
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			db = new TodoSQLiteHelper(getApplicationContext());
			ArrayList<PoliticalParty> politicalPartyList = new ArrayList<PoliticalParty>();
			List<PoliticalParty> list = new ArrayList<PoliticalParty>();
			politicalPartyList = db.getPoliticalParties();
			politicalParty = new PoliticalParty();
			list = politicalPartyList;
			SharedPreferences sharepref =  getSharedPreferences("PoliticalpartiesRI", Context.MODE_APPEND);
			SharedPreferences.Editor editor = sharepref.edit();
			Collections.sort(list);
			for (PoliticalParty politicalParty : list) {
				editor.putInt(politicalParty.getNamet(), politicalParty.getReliableIndex());
				editor.clear();
				politicalParty = null;
				
			}
			editor.commit();
			return null;
		}
			
		
			@Override
			protected void onPostExecute(Void result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
				Toast.makeText(getApplicationContext(),"The Reliable Index file has been generated", Toast.LENGTH_LONG).show();
			}
			
			

	}
}
