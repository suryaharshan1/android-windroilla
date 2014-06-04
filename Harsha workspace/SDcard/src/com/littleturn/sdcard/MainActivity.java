package com.littleturn.sdcard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		
		private static EditText ed;
		private static TextView tv;
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			ed = (EditText) rootView.findViewById(R.id.editText1);
			tv = (TextView) rootView.findViewById(R.id.textView1);
			final Button bt = (Button) rootView.findViewById(R.id.button1);
			bt.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String text = ed.getText().toString();
					byte b[] =  text.getBytes();
					tv.setText("");
					File fe = Environment.getExternalStorageDirectory();
					File fp = new File(fe.getPath() + "/sdcarddata.txt");
					try{
					FileOutputStream fos = new FileOutputStream(fp);
					fos.write(b);
					fos.close();
					FileInputStream fis = new FileInputStream(fp);
					if(fp.length() > 0){
					int a = 0;
					while((a = fis.read()) > -1){
						tv.append((char) a + "");
					}
					}
					else
						Toast.makeText(getActivity(), "No Data Available", Toast.LENGTH_SHORT).show();
					
					fis.close();
					}
					catch(Exception e){}
					
				}
			});
			return rootView;
		}
	}

}
