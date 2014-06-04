package com.hpesindia2014;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void CreateMenu(Menu m)  //helper function for making items in java code
	{
		MenuItem m1=m.add(0,1,1,"item1");
		{
			m1.setIcon(R.drawable.ic_launcher);
		}
		MenuItem m2=m.add(0,2,2,"item2");
		{
			m2.setIcon(R.drawable.ic_launcher);
		}
		MenuItem m3=m.add(0,3,3,"item3");
		{
			m3.setIcon(R.drawable.ic_launcher);
		}
	}
	public boolean ItemSelected(MenuItem m1)
	{
		switch (m1.getItemId()) {
		case 1:
			Toast.makeText(getApplicationContext(), "selected item1",Toast.LENGTH_LONG).show();
			break;
		case 2:
			Toast.makeText(getApplicationContext(), "selected item2",Toast.LENGTH_LONG).show();
			break;
		case 3:
			Toast.makeText(getApplicationContext(), "selected item3",Toast.LENGTH_LONG).show();
			break;		
		default:
			break;
		}
		return true;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		CreateMenu(menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem m1) {
		// TODO Auto-generated method stub
		
		return ItemSelected(m1);
	}

}
