package com.example.androiddevelopmentproject;
import java.util.ArrayList;






import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;



public class OpponentListFragment extends ListFragment {
	ArrayList<Player> playerList;
	MyListAdapterView myListAdapter;
	View v;
	Context context;
	ArrayList<Player> PlayerList;
	ArrayList<Player> PlayerPair;
	ArrayList<MatchBeker> MatchBaker;
	 ArrayList<MatchInternal> MatchInternal;
	 ArrayList<MatchKroongroup> MatchKroongroup;
	 
	
	
	
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
			MatchBaker = ((TournamentActivity)context).getMatchBeker();
			MatchKroongroup = ((TournamentActivity)context).getMatchKroongroup();
			GameManager gm = new GameManager(PlayerList,MatchBaker,MatchKroongroup);
			//gm.getPlayers(PlayerList);
			Player appUser = ((TournamentActivity)context).getPlayer();
			PlayerPair = gm.GetPairedPlayers(appUser);
			
			
			if(PlayerList.isEmpty()){
				PlayerList.add(new Player());
			}
			
			  myListAdapter = new MyListAdapterView(getActivity(), R.layout.opponent_listview, PlayerPair);
				setListAdapter(myListAdapter);
				myListAdapter.notifyDataSetChanged();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		 super.onActivityCreated(savedInstanceState);
	}


}
