package com.hpesindia2014;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class second extends Activity{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        EditText t1=(EditText)findViewById(R.id.editText1);
        t1.setText(getIntent().getExtras().getString("the key"));
        Toast.makeText(getApplicationContext(), "hi second activity", Toast.LENGTH_LONG).show();
    }

}
