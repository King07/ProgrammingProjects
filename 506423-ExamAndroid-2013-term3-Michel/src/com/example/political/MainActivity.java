package com.example.political;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ListView;


public class MainActivity extends BaseActivity implements TabListener {
	TodoSQLiteHelper db;
	String[] PartyStringList ;
	
	 PoliticalListFragment politicalListFragment;
	 PoliticalParty politicalParty;
	 private ActionBar actionBar;
	    private ViewPager viewPager;
	    private TabsPagerAdapter mAdapter;
	    // Tab titles
	    private String[] tabs = { "Political Parties", "Add Party"};
	    ListView lv;
	   

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    
	    viewPager = (ViewPager) findViewById(R.id.pager);
	    //viewPager.setOffscreenPageLimit(0);
	    //get the action bar
	    actionBar = getActionBar();
	    mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
	    
	    viewPager.setAdapter(mAdapter);
	    actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
 
        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }
        
        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
 
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
 
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        

		
	}




	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		
		switch (tab.getPosition()) {
		case 0:
			
			mAdapter.notifyDataSetChanged();
		    
		    break;

		default:
			break;
		}
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
		
		 mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(mAdapter);
		viewPager.invalidate();
		viewPager.setCurrentItem(tab.getPosition());

		
		
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
		
	
	

}
