package com.hpesindia2014;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b=(Button)findViewById(R.id.button1);
		registerForContextMenu(b);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater m=getMenuInflater();
		m.inflate(R.menu.list, menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.item1:
			Intent i1=new Intent(MainActivity.this,sum.class);
			startActivity(i1);
			break;
		case R.id.item2:
			Intent i2=new Intent(MainActivity.this,swap.class);
			startActivity(i2);
			break;
		case R.id.item3:
			Intent i3=new Intent(MainActivity.this,seekbar.class);
			startActivity(i3);
			break;	
		case R.id.item4:
			Intent i4=new Intent(MainActivity.this,progressbar.class);
			startActivity(i4);
			break;
		case R.id.item5:
			Intent i5=new Intent(MainActivity.this,notification.class);
			startActivity(i5);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
