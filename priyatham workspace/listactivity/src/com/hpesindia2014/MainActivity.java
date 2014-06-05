package com.hpesindia2014;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	String s[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		s=getResources().getStringArray(R.array.string);
		setListAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,s));
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		switch (position) {
		case 0:
			Toast.makeText(getApplicationContext(), "selected item1", Toast.LENGTH_LONG).show();
			break;
		case 1:
			Toast.makeText(getApplicationContext(), "selected item2", Toast.LENGTH_LONG).show();
			break;
		case 2:
			Toast.makeText(getApplicationContext(), "selected item3", Toast.LENGTH_LONG).show();
			break;
		default:
			break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
