package com.hpesindia2014;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class third extends Activity{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        Toast.makeText(getApplicationContext(), "you selected item3", Toast.LENGTH_LONG).show();
    }
}
