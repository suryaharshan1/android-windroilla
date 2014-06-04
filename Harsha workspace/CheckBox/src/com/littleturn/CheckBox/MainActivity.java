package com.littleturn.CheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE =  "com.littleturn.CheckBox.MESSAGE"; 
	CheckBox cb1, cb2;
	Button bt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

		/*if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
		cb1 = (CheckBox) findViewById(R.id.j2ee);
		cb2 = (CheckBox) findViewById(R.id.android);
		bt = (Button) findViewById(R.id.submit);
	}
	
	public void check(View v){
		switch(v.getId()){
		case R.id.j2ee:
			if(cb1.isChecked()){
				cb2.setEnabled(false);
				bt.setVisibility(View.VISIBLE);
			}
			else{
				cb2.setEnabled(true);
				bt.setVisibility(View.INVISIBLE);
			}
			break;
		case R.id.android:
			if(cb2.isChecked()){
				cb1.setEnabled(false);
				bt.setVisibility(View.VISIBLE);
			}
			else{
				cb1.setEnabled(true);
				bt.setVisibility(View.INVISIBLE);
				}
			break;
		case R.id.submit:
			Intent it = new Intent(this,Welcome.class);				
			if(cb1.isEnabled())
				it.putExtra(EXTRA_MESSAGE, cb1.getText().toString());
			else 
				it.putExtra(EXTRA_MESSAGE, cb2.getText().toString());
			startActivity(it);
			break;
		}
	}

	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	/*
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}*/

}
