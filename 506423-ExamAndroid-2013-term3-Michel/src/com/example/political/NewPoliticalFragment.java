package com.example.political;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class NewPoliticalFragment extends Fragment implements OnClickListener {
	EditText partyName;
	EditText partyNameDescription;
	ArrayList<PoliticalParty> politicalPartyList;
	PoliticalParty politicalParty;
	Button myButton;
	ImageButton logo_cda, logo_cu,logo_d66,logo_gl,logo_politiek,logo_pvda,logo_pvdd,logo_pvv,logo_sgp,logo_sp,logo_vijftigplus,logo_vvd;
	TodoSQLiteHelper db ;
	int image;
	public NewPoliticalFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/*//get add button reference
		 partyName = getActivity().findViewById(R.id.newPartyName) ; 
		 partyNameDescription = getActivity().findViewById(R.id.newPartyDescription) ;*/
		 db = new TodoSQLiteHelper(getActivity());
		
	   
		View myView = inflater.inflate(R.layout.fragment_new_political, container, false);
		 myButton = (Button) myView.findViewById(R.id.AddNewParty);
		 partyName = (EditText) myView.findViewById(R.id.newPartyName) ; 
		 partyNameDescription =  (EditText) myView.findViewById(R.id.newPartyDescription) ;
		 logo_cda = (ImageButton) myView.findViewById(R.id.cda);
		 logo_cu = (ImageButton) myView.findViewById(R.id.cu);
		 logo_d66 = (ImageButton) myView.findViewById(R.id.d66);
		 logo_gl = (ImageButton) myView.findViewById(R.id.gl);
		 logo_pvda = (ImageButton) myView.findViewById(R.id.pvda);
		 logo_pvdd = (ImageButton) myView.findViewById(R.id.pvdd);
		 logo_pvv = (ImageButton) myView.findViewById(R.id.pvv);
		 logo_sgp = (ImageButton) myView.findViewById(R.id.sgp);
		 logo_sp = (ImageButton) myView.findViewById(R.id.sp);
		 logo_vijftigplus = (ImageButton) myView.findViewById(R.id.vijftigplus);
		 logo_vvd = (ImageButton) myView.findViewById(R.id.vvd);
		 logo_politiek = (ImageButton) myView.findViewById(R.id.politiek);
		 
		 myButton.setOnClickListener(this);
		 logo_cda.setOnClickListener(this);
		 logo_cu.setOnClickListener(this);
		 logo_d66.setOnClickListener(this);
		 logo_gl.setOnClickListener(this);
		 logo_pvda.setOnClickListener(this);
		 logo_pvdd.setOnClickListener(this);
		 logo_pvv.setOnClickListener(this);
		 logo_sgp.setOnClickListener(this);
		 logo_sp.setOnClickListener(this);
		 logo_vijftigplus.setOnClickListener(this);
		 logo_vvd.setOnClickListener(this);
		 logo_politiek.setOnClickListener(this);
		 
		 image = R.drawable.politiek;
		 
		
		// Inflate the layout for this fragment
		return myView;
		
			
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		switch (v.getId()) {
		case R.id.AddNewParty:
			// create dialog if all information are not entered
			if (partyName.getText().toString().isEmpty()
					|| partyNameDescription.getText().toString().isEmpty()) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						getActivity());

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
				PoliticalListFragment list = new PoliticalListFragment();

				politicalParty = new PoliticalParty(partyName.getText().toString(),
						partyNameDescription.getText().toString(),image);
				Log.d("image", politicalParty.toString());
				db.addPoliticalItem(politicalParty);
				politicalPartyList = db.getPoliticalParties();
				MyListAdapterView la = new MyListAdapterView(getActivity(),
						R.layout.item_view, politicalPartyList);
				list.updateList(la);

				partyName.setText("");
				partyNameDescription.setText("");
			}
			
			
			break;
		case R.id.cda:
			image = R.drawable.cda;
			Log.d("image", "id "+image);
			break;
		case R.id.cu:
			image = R.drawable.cu;
			Log.d("image", "id "+image);
			break;
		case R.id.d66:
			image = R.drawable.d66;
			Log.d("image", "id "+image);
			break;
		case R.id.gl:
			image = R.drawable.gl;
			Log.d("image", "id "+image);
			break;
		case R.id.politiek:
			image = R.drawable.politiek;
			Log.d("image", "id "+image);
			break;
		case R.id.pvda:
			image = R.drawable.pvda;
			Log.d("image", "id "+image);
			break;
		case R.id.pvdd:
			image = R.drawable.pvdd;
			Log.d("image", "id "+image);
			break;
		case R.id.pvv:
			image = R.drawable.pvv;
			Log.d("image", "id "+image);
			break;
		case R.id.sgp:
			image = R.drawable.sgp;
			Log.d("image", "id "+image);
			break;
		case R.id.sp:
			image = R.drawable.sp;
			Log.d("image", "id "+image);
			break;
		case R.id.vijftigplus:
			image = R.drawable.vijftigplus;
			Log.d("image", "id "+image);
			break;
		case R.id.vvd:
			image = R.drawable.vvd;
			Log.d("image", "id "+image);
			break;
		
		default:
			image = R.drawable.politiek;
			Log.d("image", "id "+image);
			break;
		}
	}
	


	

}
