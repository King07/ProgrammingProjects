package com.example.political;

import java.util.ArrayList;

import android.content.Context;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapterView extends ArrayAdapter<PoliticalParty> {
	private ArrayList<PoliticalParty> objects;
	
	public MyListAdapterView(Context context, int textViewResourceId, ArrayList<PoliticalParty> objects) {
		super(context, textViewResourceId, objects);
		this.objects = objects; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View itemView = convertView;
		
		//Check if the view exist, if not create it to work with
		if(itemView == null){
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			itemView = inflater.inflate(R.layout.item_view, null);
		}
		
		//find the list to work with
		PoliticalParty politicalParty = objects.get(position);
		//fill the view
		
		
		ImageView imageView = (ImageView) itemView.findViewById(R.id.item_icon);
	
		imageView.setImageResource(politicalParty.getImage());
		
		TextView textPoliticianName = (TextView) itemView.findViewById(R.id.item_textName);
		textPoliticianName.setText(politicalParty.getNamet());
		
		// Year:
		TextView textPoliticianStatistic = (TextView) itemView.findViewById(R.id.item_textStatisc);
		textPoliticianStatistic.setText(politicalParty.getStatistic());
		
		
	
	
		
		return itemView;
	}
}
