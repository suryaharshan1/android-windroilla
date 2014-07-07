package com.chandu.dolist;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

import java.util.Calendar;
import java.util.Date;

public class AddNew extends ActionBarActivity {

	Button b;
	static final int DATE_DIALOG_ID = 1;
	static final int TIME_DIALOG_ID = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new);
		b = (Button) findViewById(R.id.button1);
		b.setBackgroundResource(R.drawable.ic_action_add_alarm);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_new, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void alarm(View v){
		final AlertDialog dialogDetails;
		LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
		View dialogview = inflater.inflate(R.layout.customdialog_view, null);
		AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(this);
		dialogbuilder.setTitle("Set Time");
		dialogbuilder.setNegativeButton("Ok", new OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		dialogbuilder.setIcon(R.drawable.ic_action_add_alarm);
		dialogbuilder.setView(dialogview);
		dialogDetails = dialogbuilder.create();
		dialogDetails.show();
	}
	

}
