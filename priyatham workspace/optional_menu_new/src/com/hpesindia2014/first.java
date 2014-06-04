package com.hpesindia2014;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class first extends Activity{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        Toast.makeText(getApplicationContext(), "you selected item1", Toast.LENGTH_LONG).show();
    }
}
