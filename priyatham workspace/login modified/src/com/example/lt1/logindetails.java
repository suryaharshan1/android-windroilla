package com.example.lt1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class logindetails extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.logindetails);
		EditText t1=(EditText)findViewById(R.id.editText1);
        t1.setText(getIntent().getExtras().getString("the key1"));
        EditText t2=(EditText)findViewById(R.id.editText2);
        t2.setText(getIntent().getExtras().getString("the key2"));
        Toast.makeText(getApplicationContext(), "login details", Toast.LENGTH_LONG).show();
	}
}
