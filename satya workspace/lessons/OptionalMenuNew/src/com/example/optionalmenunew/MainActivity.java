package com.example.optionalmenunew;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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
       // getMenuInflater().inflate(R.menu.main, menu);
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.optional_menu, menu);  // the second argument menu should be same as the argument of oncreateoptionmenu
        
        
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	
    	switch (item.getItemId()) {
		case R.id.item1:
			//Toast.makeText(getApplicationContext(), "item 1 selected", Toast.LENGTH_LONG).show();
			Intent i1=new Intent(MainActivity.this,FirstActivity.class);
			startActivity(i1);
			break;
		case R.id.item2:
			Toast.makeText(getApplicationContext(), "item2 selected", Toast.LENGTH_LONG).show();
			break;
		case R.id.item3:
			Toast.makeText(getApplicationContext(), "item3 selected", Toast.LENGTH_LONG).show();
			break;
		default:
			break;
		}
    	
    	return super.onOptionsItemSelected(item);
    }
}
