package com.example.political;
import java.util.ArrayList;









import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.AdapterView.OnItemLongClickListener;



public class PoliticalListFragment extends ListFragment {
	ArrayList<PoliticalParty> politicalPartyList;
	PoliticalParty politicalParty;
	TodoSQLiteHelper db;
	MyListAdapterView myListAdapter;
	View v;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 v = (View) inflater.inflate(R.layout.party_list_view,container,false);
		return v;
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		db = new TodoSQLiteHelper(getActivity());
		politicalPartyList = new ArrayList<PoliticalParty>();
		
	    
	    politicalPartyList = db.getPoliticalParties();
	    myListAdapter = new MyListAdapterView(getActivity(), R.layout.item_view, politicalPartyList);
		
		setListAdapter(myListAdapter);
		myListAdapter.notifyDataSetChanged();
	}
	

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		
		Intent intent = new Intent(getActivity(),PartyDetailActivity.class);
		PoliticalParty politicalParty = (PoliticalParty) getListView().getItemAtPosition(position);
		intent.putExtra("politicalParty", politicalParty);
        startActivityForResult(intent, 1);
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		getListView().setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				PoliticalParty politicalParty = (PoliticalParty) getListView().getItemAtPosition(position);
				politicalPartyList.remove(position);
				db.deletePoliticalParty(politicalParty);
			    myListAdapter = new MyListAdapterView(getActivity(), R.layout.item_view, politicalPartyList);
			    setListAdapter(myListAdapter);
			    myListAdapter.notifyDataSetChanged();
			    
				return false;
			}
		});
	}
	
	

	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		db = new TodoSQLiteHelper(getActivity());
		politicalPartyList = new ArrayList<PoliticalParty>();
		
	    
	    politicalPartyList = db.getPoliticalParties();
		
		
		setListAdapter(new MyListAdapterView(getActivity(), R.layout.item_view, politicalPartyList));
		Log.d("Activity", "Getting on on resume create");
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		//Toast.makeText(getActivity(),"The attach", Toast.LENGTH_LONG).show();
		Log.d("Tab pager", "Getting tab1 list fragmenet attach ");
	}

	

	
	public void updateList(MyListAdapterView adapter){

		setListAdapter(adapter);
		adapter.notifyDataSetChanged();
	}

	
	


}
