


package com.example.androiddevelopmentproject;
import java.util.ArrayList;





import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;



public class PlayerListFragment extends ListFragment {
	ArrayList<Player> playerList;
	PlayersListAdapterView myListAdapter;
	View v;
	Context context;
	ArrayList<Player> PlayerList;
	ArrayList<Player> PlayerPair;
	Spinner spinner;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 v = (View) inflater.inflate(R.layout.player_list_sort,container,false);
		 
		return v;
	}
	
	
	
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		
		Intent intent = new Intent(getActivity(),OpponentProfilePlayer.class);
		Player player = (Player) getListView().getItemAtPosition(position);
		intent.putExtra("Player", player);
        startActivity(intent);
		
	}

	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		savedInstanceState = this.getArguments();
		
		try {
			 //get the player and set the views
			context = (TournamentActivity)getActivity();
			PlayerList = ((TournamentActivity)context).getPlayerList();
			Collections.sort(PlayerList); 
			
			if(PlayerList.isEmpty()){
				PlayerList.add(new Player());
			}
			
			  myListAdapter = new PlayersListAdapterView(getActivity(), R.layout.players_listview, PlayerList);
				setListAdapter(myListAdapter);
				myListAdapter.notifyDataSetChanged();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		 super.onActivityCreated(savedInstanceState);
	}


}

