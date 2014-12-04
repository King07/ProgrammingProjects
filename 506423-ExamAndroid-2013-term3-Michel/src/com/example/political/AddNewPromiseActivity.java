package com.example.political;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class AddNewPromiseActivity extends FragmentActivity implements OnClickListener  {
	EditText partyName;
	EditText partyNameDescription;
	Button myButton;
	
	 PoliticalListFragment politicalListFragment;
	 PoliticalParty politicalParty;
	 PoliticalPartyPromise Promise;
	ImageButton plus, equal, minus;
	    TextView stat, description,name,Partyname;
	    TodoSQLiteHelper db;
	    // Tab titles
	    
	   

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_promises);
		 myButton = (Button) findViewById(R.id.AddNewParty);
		 partyName = (EditText)findViewById(R.id.newPartyName) ; 
		 partyNameDescription =  (EditText) findViewById(R.id.newPartyDescription) ;
		 db = new TodoSQLiteHelper(this);
		 myButton.setOnClickListener(this);
		 
			// 1. get passed intent 
	        Intent intent = getIntent();
	 
	        // 2. get person object from intent
	        politicalParty = (PoliticalParty) intent.getSerializableExtra("politicalParty");
	}

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
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// create dialog if all information are not entered
		if (partyName.getText().toString().isEmpty()
				|| partyNameDescription.getText().toString().isEmpty()) {
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					AddNewPromiseActivity.this);

			// set title
			alertDialogBuilder.setTitle("Feilds are empty");

			// set dialog message
			alertDialogBuilder
					.setMessage("Click cancel to exit!")
					.setCancelable(false)

					.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// if this button is clicked, just close
									// the dialog box and do nothing
									dialog.cancel();
								}
							});

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// show it
			alertDialog.show();
		} else {
			Promise = new PoliticalPartyPromise(partyName.getText().toString(),
					partyNameDescription.getText().toString());
			db.addPoliticalPromiseItem(Promise, politicalParty.getId());
			partyName.setText("");
			partyNameDescription.setText("");
			

		}
	}
		

}
