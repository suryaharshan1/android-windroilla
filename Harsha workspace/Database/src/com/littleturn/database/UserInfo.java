package com.littleturn.database;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class UserInfo extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_info);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new LoggedInFragment()).commit();
		}
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		switch(item.getTitle().toString()){
		case "Change Password":
			//Toast.makeText(this, "Changed your Password", Toast.LENGTH_SHORT).show();
			ft.replace(R.id.container, new ChangePasswordFragment());
			ft.addToBackStack(null);
			ft.commit();
			break;
		case "Update Profile":
			Toast.makeText(this, "Updated your Profile", Toast.LENGTH_SHORT).show();
			
			break;
		case "Other Users":
			Toast.makeText(this, "No users Available", Toast.LENGTH_SHORT).show();
			break;
		case "Logout":
			Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	/*
	public static class LoggedInFragment extends Fragment {

		public LoggedInFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_user_info,
					container, false);
			return rootView;
		}
	}*/

}
