package com.littleturn.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {

	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		Intent previous = getIntent();
		String show = previous.getStringExtra(MainActivity.EXTRA_MESSAGE);
		tv = (TextView) findViewById(R.id.show);
		tv.setText(show);
	}

	
}
