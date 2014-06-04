package com.littleturn.popupmenu;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.littleturn.popupmenu.PlaceholderFragement.PlaceholderListener;

public class MainActivity extends ActionBarActivity implements PlaceholderListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragement()).commit();
		}
	}
}
