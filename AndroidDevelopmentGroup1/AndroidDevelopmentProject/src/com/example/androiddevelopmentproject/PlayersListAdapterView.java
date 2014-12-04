package com.example.androiddevelopmentproject;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayersListAdapterView extends ArrayAdapter<Player> {
	private ArrayList<Player> objects;
	
	public PlayersListAdapterView(Context context, int textViewResourceId, ArrayList<Player> objects) {
		super(context, textViewResourceId, objects);
		this.objects = objects; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View itemView = convertView;
		//find the list to work with
				Player player = objects.get(position);
		//Check if the view exist, if not create it to work with
		if(itemView == null){
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			itemView = inflater.inflate(R.layout.players_listview, null);
			
		}
		
		//find the list to work with
		
		
		
		//fill the view
		position++;
		
		String PlayerFullName = position+": "+player.getFirstName()+" "+player.getLastName();
		if(PlayerFullName.length() >16)
		{
			PlayerFullName = PlayerFullName.substring(0, 13)+"..";
		}
		
		TextView fullName = (TextView) itemView.findViewById(R.id.textViewPlayerFullName);
		
		fullName.setText(PlayerFullName);
		
		TextView rating = (TextView) itemView.findViewById(R.id.textViewPlayerRating);
		rating.setText(player.getCurrentRating()+"");
		
		
		
		
	
	
		
		return itemView;
	}
}
