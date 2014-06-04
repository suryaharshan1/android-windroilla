package com.example.optionalmenunew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class FirstActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.first);
		 Toast.makeText(getApplicationContext(), "In FirstACtivity", Toast.LENGTH_LONG).show();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater m = getMenuInflater();
        m.inflate(R.menu.optional_menu, menu);
		return super.onCreateOptionsMenu(menu);
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.item1:
			Intent i1=new Intent(FirstActivity.this,MainActivity.class);
			startActivity(i1);
			break;

		default:
			break;
		}
		
		
		return super.onOptionsItemSelected(item);
		
	}

}
