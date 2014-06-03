package com.example.intents;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class Second extends Activity{
	EditText t1,t2;
	   @Override
	   
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.second);
	        t1= (EditText) findViewById(R.id.editText21);
	        t2= (EditText) findViewById(R.id.editText22);
	        t1.setText(getIntent().getExtras().getString("username"));
	        t2.setText(getIntent().getExtras().getString("password"));
	        Toast.makeText(getApplicationContext(), "second intent with username and password", Toast.LENGTH_LONG).show();
	        
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	
	
}
