package com.hpesindia2014;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class second extends Activity{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Toast.makeText(getApplicationContext(), "you selected item2", Toast.LENGTH_LONG).show();
    }
}