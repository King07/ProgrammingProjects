package com.example.political;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class PartyDetailActivity extends BaseActivity {
	TextView stat;
	TextView description,name;
	PoliticalParty politicalParty;
	TodoSQLiteHelper db;
	ArrayAdapter<String> aa;
	ArrayList<String> promiseStringList;
	ArrayList<PoliticalPartyPromise> politicalPartyPromise;
	ListView listView;
	ImageView politicalIcon;
	PoliticalPartyPromise promise ;
	 ImageButton addNewPromise;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.political_detail_activity_main);
		politicalPartyPromise = new ArrayList<PoliticalPartyPromise>();
		stat = (TextView) findViewById(R.id.textPolicalName);
		  description = (TextView) findViewById(R.id.textPolicalDescription);
		  name = (TextView) findViewById(R.id.TextViewPolitical);
		  politicalIcon = (ImageView) findViewById(R.id.iconImage);
		  addNewPromise = (ImageButton) findViewById(R.id.imageButtonAddPromises);
		  
			
			// 1. get passed intent 
	        Intent intent = getIntent();
	 
	        // 2. get person object from intent
	        politicalParty = (PoliticalParty) intent.getSerializableExtra("politicalParty");
	        stat.setText(politicalParty.getStatistic());
	        description.setText(politicalParty.getDecription());
	        name.setText(politicalParty.getNamet());
	        politicalIcon.setImageResource(politicalParty.getImage());
	        db = new TodoSQLiteHelper(this);
	        
	        politicalPartyPromise = db.getPoliticalPromise(politicalParty.getId());
	        promiseStringList = new ArrayList<String>();
	        for(int i = 0; i < politicalPartyPromise.size(); i++)
	        {
	        	 promise = politicalPartyPromise.get(i);
	        	promiseStringList.add(promise.getPromise());
	        	System.out.println(politicalPartyPromise.get(i).toString());
	        	promise = new PoliticalPartyPromise();
	        	
	        }
	        
	        aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,promiseStringList);	   

			listView = (ListView)findViewById(R.id.listViewPromises);
			listView.setAdapter(aa);
			listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					// TODO Auto-generated method stub
					
					Intent intent = new Intent(PartyDetailActivity.this,PromiseDetailActivity.class);
					intent.putExtra("politicalParty", politicalParty);
					intent.putExtra("PoliticalPartyPromise", politicalPartyPromise.get(position));
			        startActivityForResult(intent, 1);
					
				}
			});
			
			listView.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					// TODO Auto-generated method stub

					db.deletePoliticalPartyPromises(politicalPartyPromise.get(position));
					promiseStringList.remove(position);
			        aa.notifyDataSetChanged();

					return false;
				}
			});
			
			addNewPromise.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(PartyDetailActivity.this,AddNewPromiseActivity.class);
		intent.putExtra("politicalParty", politicalParty);
        startActivity(intent);
		
	}
});
	        
		}

	
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Bundle b = data.getExtras();
                if (b != null) {
                     politicalParty = (PoliticalParty) b.getSerializable("political");
                    stat.setText(politicalParty.getStatistic());
                }  
            } else if (resultCode == 0) {
                System.out.println("RESULT CANCELLED");    
            }
        }
    }  
	

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		
		
		db = new TodoSQLiteHelper(this);
        
        politicalPartyPromise = db.getPoliticalPromise(politicalParty.getId());
        promiseStringList = new ArrayList<String>();
        
        for(int i = 0; i < politicalPartyPromise.size(); i++)
        {
        	promise = politicalPartyPromise.get(i);
        	promiseStringList.add(promise.getPromise());
        	//System.out.println(politicalPartyPromise.get(i).toString());
        	promise = new PoliticalPartyPromise();
        	
        }
        
        aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,promiseStringList);	   
        
		listView = (ListView)findViewById(R.id.listViewPromises);
		listView.setAdapter(aa);
		//Toast.makeText(PartyDetailActivity.this,"onRestart", Toast.LENGTH_LONG).show();

	}




	

	


	

}
