package com.hpesindia2014;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.ClipData.Item;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		MenuInflater m=getMenuInflater();
		m.inflate(R.menu.optional_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.item1:
			Intent i1=new Intent(MainActivity.this,first.class);
			startActivity(i1);
			break;
		case R.id.item2:
			Intent i2=new Intent(MainActivity.this,second.class);
			startActivity(i2);
			break;
		case R.id.item3:
			Intent i3=new Intent(MainActivity.this,third.class);
			startActivity(i3);
			break;	
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
