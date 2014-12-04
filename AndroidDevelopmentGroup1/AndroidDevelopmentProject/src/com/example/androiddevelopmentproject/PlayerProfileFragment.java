package com.example.androiddevelopmentproject;



import java.util.ArrayList;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewDataInterface;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class PlayerProfileFragment extends Fragment implements OnClickListener {
	View v;
	Player appUser;
	TextView playerName;
	TextView playerRating;
	TextView playerRecord;
	TextView playerDescription;
	ImageButton resultRecordWhite;
	ImageButton resultRecordBlack;
	
	
	Context context;

	public PlayerProfileFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		 v = (View) inflater.inflate(R.layout.fragment_player_profile,container,false);
		 
		//get references to all views.
		 playerName = (TextView) v.findViewById(R.id.textViewPlayerName);
		 playerRating = (TextView) v.findViewById(R.id.textViewPlayerRating);
		 
		 
		// playerDescription = (TextView) v.findViewById(R.id.textViewDescription);
		 
		 /*GraphViewSeriesStyle seriesStyle = new GraphViewSeriesStyle();
		 seriesStyle.setValueDependentColor(new ValueDependentColor() {
			
			@Override
			public int get(GraphViewDataInterface data) {
				// the higher the more red
				return Color.RED;
			}
		});*/
		// init example series data
	      /* GraphViewSeries exampleSeries = new GraphViewSeries(new GraphViewData[] {
	           new GraphViewData(1, 5)
	           
	       });
	        
	       GraphView graphView = new BarGraphView(
	           getActivity() // context
	           , "Historical Results" // heading
	       );
	       
	      // graphView.getGraphViewStyle().setVerticalLabelsWidth(10000);
	       graphView.addSeries(exampleSeries); // data
	        
	       LinearLayout layout = (LinearLayout) v.findViewById(R.id.textViewDescription);
	       layout.addView(graphView);*/
		//
		 resultRecordWhite = (ImageButton) v.findViewById(R.id.btnResultsWhite);
		 resultRecordWhite.setOnClickListener(this);
		 
		 resultRecordBlack = (ImageButton) v.findViewById(R.id.btnResultsBlack);
		 resultRecordBlack.setOnClickListener(this);
		 
			return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		savedInstanceState = this.getArguments();
		 //get the player and set the views
		try {
			context = (AppProfilePlayer)getActivity();
			 appUser = ((AppProfilePlayer)context).getPlayer();
		     playerName.setText(appUser.getFirstName()+" "+appUser.getLastName());
			 playerRating.setText(appUser.getCurrentRating()+""); 
			 
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	
		try {
			context = (OpponentProfilePlayer)getActivity();
			 appUser = ((OpponentProfilePlayer)context).getPlayer();
			 System.out.println(appUser);
		     playerName.setText(appUser.getFirstName()+" "+appUser.getLastName());
			 playerRating.setText(appUser.currentRating+"");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		 super.onActivityCreated(savedInstanceState);
	}
	
	private void openChartWhite(Player appUser, String wins, String draw, String lost,String PlayedWith){
		 
        // Pie Chart Section Names
        String[] code = new String[] {
            wins+" = "+appUser.getMatchWhitePlayedWin(), draw+" = "+appUser.getMatchWhitePlayedDraw(), lost+" = "+appUser.getMatchWhitePlayedLost()
        };
        
        // Pie Chart Section Value
        
        	double[] distribution = { appUser.getMatchWhitePlayedWin(), appUser.getMatchWhitePlayedDraw(), appUser.getMatchWhitePlayedLost() } ;
        
        
        // Color of each Pie Chart Sections
        int[] colors = { Color.GREEN, Color.YELLOW,
                        Color.RED };
 
        // Instantiating CategorySeries to plot Pie Chart
        CategorySeries distributionSeries = new CategorySeries("Player Season Records Playing with "+PlayedWith);
        for(int i=0 ;i < distribution.length;i++){
            // Adding a slice with its values and name to the Pie Chart
            distributionSeries.add(code[i], distribution[i]);
        }
 
        // Instantiating a renderer for the Pie Chart
        DefaultRenderer defaultRenderer  = new DefaultRenderer();
        for(int i = 0 ;i<distribution.length;i++){
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(colors[i]);
            seriesRenderer.setDisplayChartValues(true);
            // Adding a renderer for a slice
            
            defaultRenderer.addSeriesRenderer(seriesRenderer);
        }
 
        defaultRenderer.setChartTitle("Player Season Records Playing with "+PlayedWith);
        defaultRenderer.setChartTitleTextSize(20);
        defaultRenderer.setBackgroundColor(Color.WHITE);
        defaultRenderer.setLabelsColor(Color.BLACK);
        defaultRenderer.setLabelsTextSize(15);
        defaultRenderer.setZoomButtonsVisible(true);
 
        // Creating an intent to plot bar chart using dataset and multipleRenderer
        Intent intent = ChartFactory.getPieChartIntent(getActivity(), distributionSeries , defaultRenderer, "ChessNuggets");
 
        // Start Activity
        startActivity(intent);
 
    }
	
	private void openChartBlack(Player appUser, String wins, String draw, String lost,String PlayedWith){
		 
        // Pie Chart Section Names
        String[] code = new String[] {
            wins+" = "+appUser.getMatchBlackPlayedWin(), draw+" = "+appUser.getMatchBlackPlayedDraw(), lost+" = "+appUser.getMatchBlackPlayedLost()
        };
        
        // Pie Chart Section Value
        
        	double[] distribution = { appUser.getMatchBlackPlayedWin(), appUser.getMatchBlackPlayedDraw(), appUser.getMatchBlackPlayedLost() } ;

       
        
        // Color of each Pie Chart Sections
        int[] colors = { Color.GREEN, Color.YELLOW,
                        Color.RED };
 
        // Instantiating CategorySeries to plot Pie Chart
        CategorySeries distributionSeries = new CategorySeries("Player Season Records Playing with "+PlayedWith);
        for(int i=0 ;i < distribution.length;i++){
            // Adding a slice with its values and name to the Pie Chart
            distributionSeries.add(code[i], distribution[i]);
        }
 
        // Instantiating a renderer for the Pie Chart
        DefaultRenderer defaultRenderer  = new DefaultRenderer();
        for(int i = 0 ;i<distribution.length;i++){
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(colors[i]);
            seriesRenderer.setDisplayChartValues(true);
            // Adding a renderer for a slice
            defaultRenderer.addSeriesRenderer(seriesRenderer);
        }
 
        defaultRenderer.setChartTitle("Player Season Records Playing with "+PlayedWith);
        defaultRenderer.setChartTitleTextSize(20);
        defaultRenderer.setBackgroundColor(Color.WHITE);
        defaultRenderer.setLabelsColor(Color.BLACK);
        defaultRenderer.setLabelsTextSize(15);
        defaultRenderer.setZoomButtonsVisible(true);
 
        // Creating an intent to plot bar chart using dataset and multipleRenderer
        Intent intent = ChartFactory.getPieChartIntent(getActivity(), distributionSeries , defaultRenderer, "ChessNuggets");
 
        // Start Activity
        startActivity(intent);
 
    }
	
	
	@Override
	public void onClick(View v) {
		//openChart();
		switch (v.getId()) {
		case R.id.btnResultsWhite:
			openChartWhite(appUser,"White Win","White Draw", "White Lost","White");
			break;
		case R.id.btnResultsBlack:
			openChartBlack(appUser,"Black Win","Black Draw", "Black Lost","Black");
			break;

		default:
			break;
		}
		
	}

	/*@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		Log.e("Player attendance", ":"+isChecked);
		
	}*/

}
