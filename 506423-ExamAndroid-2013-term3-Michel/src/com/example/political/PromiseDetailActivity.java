package com.example.political;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class PromiseDetailActivity extends BaseActivity implements OnClickListener  {
	
	
	 PoliticalListFragment politicalListFragment;
	 PoliticalParty politicalParty;
	 PoliticalPartyPromise Promise;
	ImageButton plus, equal, minus;
	    TextView stat, description,name,Partyname;
	    ImageView politicalIcon;
	    TodoSQLiteHelper db;
	    // Tab titles
	    Intent intent;
	   

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.political_promises_activity_main);
		db = new TodoSQLiteHelper(this);
		stat = (TextView) findViewById(R.id.textPolicalName);
		name = (TextView) findViewById(R.id.textPolicalPromise);
		Partyname = (TextView) findViewById(R.id.TextViewPolitical);
		description = (TextView) findViewById(R.id.textPolicalDescription);
		politicalIcon = (ImageView) findViewById(R.id.iconImage);
		
		plus = (ImageButton) findViewById(R.id.imageButtonPlus);
		minus = (ImageButton) findViewById(R.id.imageButtonMinus);
		equal = (ImageButton) findViewById(R.id.imageButtonEqual);
		
		plus.setOnClickListener(this);
		minus.setOnClickListener(this);
		equal.setOnClickListener(this);
			
			// 1. get passed intent 
	         intent = getIntent();
	 
	        // 2. get person object from intent
	        politicalParty = (PoliticalParty) intent.getSerializableExtra("politicalParty");
	        Promise = (PoliticalPartyPromise) intent.getSerializableExtra("PoliticalPartyPromise");
	        stat.setText(politicalParty.getStatistic());
	        politicalIcon.setImageResource(politicalParty.getImage());
	        Partyname.setText(politicalParty.getNamet());
	        name.setText(Promise.getPromise());
	        description.setText(Promise.getDecription());
	       
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imageButtonPlus:
			politicalParty.setPlus(politicalParty.getPlus()+1);
			politicalParty.getStatistic();
			stat.setText(politicalParty.getStatistic());
			break;
		case R.id.imageButtonMinus:
			politicalParty.setMinus(politicalParty.getMinus()+1);
			politicalParty.getStatistic();
			stat.setText(politicalParty.getStatistic());
			break;
		case R.id.imageButtonEqual:
			politicalParty.setEqual(politicalParty.getEqual()+1);
			politicalParty.getStatistic();
			stat.setText(politicalParty.getStatistic());
			
			break;

		default:
			break;
		}
		
		
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		
		
		politicalParty.setStatistic(politicalParty.getStatistic());
		System.out.println("On back press :"+politicalParty.toString());
		db.updatePoliticalParty(politicalParty);
		 Intent intent = new Intent();
        intent.putExtra("political", politicalParty);
        setResult(Activity.RESULT_OK, intent);
        finish();
        super.onBackPressed();
		Toast.makeText(PromiseDetailActivity.this,"Back Press", Toast.LENGTH_LONG).show();
		
	}
	
	
	

}
