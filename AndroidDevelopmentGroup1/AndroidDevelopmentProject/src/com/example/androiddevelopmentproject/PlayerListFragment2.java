


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
import android.widget.TextView;
import android.widget.Toast;



public class PlayerListFragment2 extends ListFragment {
	ArrayList<Player> playerList;
	PlayersListPointAdapterView myListAdapter;
	View v;
	Context context;
	ArrayList<Player> PlayerList;
	ArrayList<Player> PlayerPair;
	TextView title;
	TextView titleRanking;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 v = (View) inflater.inflate(R.layout.player_list_sort,container,false);
		 /*spinner = (Spinner) v.findViewById(R.id.spinnerSortPlayers);
		 List<String> list = new ArrayList<String>();
			list.add("Players Rank by Ratings");
			list.add("Players Rank by Points");
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
				R.layout.spinner_item, list);
			dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
			spinner.setAdapter(dataAdapter);*/
		 title = (TextView) v.findViewById(R.id.SortPlayers);
		 title.setText("RANKING BY POINTS");
		 titleRanking = (TextView) v.findViewById(R.id.textViewPlayerRanking);
		 titleRanking.setText("POINTS");
		 
		return v;
	}
	
	
	/*@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		playerList = new ArrayList<Player>();
		
	    
		playerList.add(new Player("Kinson", "Michel", "2176", 0, 76));
		playerList.add(new Player("Daniel", "Jeantihome", "1136", 1, 32));
		playerList.add(new Player("Nirajan", "Pokharel", "1110", 0,89 ));
	    myListAdapter = new MyListAdapterView(getActivity(), R.layout.opponent_listview, playerList);
		
		setListAdapter(myListAdapter);
		myListAdapter.notifyDataSetChanged();
	}*/
	
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
			Collections.sort(PlayerList, new Player()); 
			for (Player p : PlayerList) {
				System.out.println(p.getFirstName()+" "+p.getPoints());
			}
			if(PlayerList.isEmpty()){
				PlayerList.add(new Player());
			}
			
			  myListAdapter = new PlayersListPointAdapterView(getActivity(), R.layout.players_listview, PlayerList);
				setListAdapter(myListAdapter);
				myListAdapter.notifyDataSetChanged();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		 super.onActivityCreated(savedInstanceState);
	}


}


