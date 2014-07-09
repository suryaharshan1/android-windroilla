package com.example.tasks.categories;

import com.example.tasks.R;
import com.example.tasks.categories.TabsPagerAdapter;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB) public class categories extends FragmentActivity implements
ActionBar.TabListener{
	private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
   
    
    @TargetApi(Build.VERSION_CODES.HONEYCOMB) @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);
     // Initilisation
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
 
        viewPager.setAdapter(mAdapter);
        
     //   actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Yearly").setTabListener((TabListener) this));
        actionBar.addTab(actionBar.newTab().setText("Monthly").setTabListener((TabListener) this));
        actionBar.addTab(actionBar.newTab().setText("Weekly").setTabListener((TabListener) this));
        actionBar.addTab(actionBar.newTab().setText("Dialy").setTabListener((TabListener) this));
        actionBar.addTab(actionBar.newTab().setText("Birthdays").setTabListener((TabListener) this));
        actionBar.addTab(actionBar.newTab().setText("Aniversaries").setTabListener((TabListener) this));
      
        
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
        
        viewPager.setCurrentItem(3);      // to set the 4 tab as the default tab
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	switch (item.getItemId()) {
		case R.id.addcategory:
			{
				Toast.makeText(getApplicationContext(), "category needs to be added", Toast.LENGTH_LONG).show();
			}
			break;

		default:
			break;
		}
    	return super.onOptionsItemSelected(item);
    }
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}


	@TargetApi(Build.VERSION_CODES.HONEYCOMB) @Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
		viewPager.setCurrentItem(arg0.getPosition());
	}


	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
    
}
