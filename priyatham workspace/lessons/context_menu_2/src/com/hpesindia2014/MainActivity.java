package com.hpesindia2014;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b=(Button)findViewById(R.id.button1);
		registerForContextMenu(b);
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
	public void ItemSelected(MenuItem m1)
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
		
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		CreateMenu(menu);
	}
	public boolean onContextItemSelected(MenuItem m1) {
		// TODO Auto-generated method stub
		ItemSelected(m1);
		return true;
	}
}
