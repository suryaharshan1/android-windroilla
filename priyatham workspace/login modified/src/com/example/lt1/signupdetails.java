package com.example.lt1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class signupdetails extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signupdetails);
	EditText t1=(EditText)findViewById(R.id.editText1);
    t1.setText(getIntent().getExtras().getString("the key1"));
    EditText t2=(EditText)findViewById(R.id.editText2);
    t2.setText(getIntent().getExtras().getString("the key2"));
    EditText t4=(EditText)findViewById(R.id.editText4);
    t4.setText(getIntent().getExtras().getString("the key4"));
    EditText t5=(EditText)findViewById(R.id.editText5);
    t5.setText(getIntent().getExtras().getString("the key5"));
    EditText t6=(EditText)findViewById(R.id.editText6);
    t6.setText(getIntent().getExtras().getString("the key6"));
    Toast.makeText(getApplicationContext(), "Signup details", Toast.LENGTH_LONG).show();
}
}
