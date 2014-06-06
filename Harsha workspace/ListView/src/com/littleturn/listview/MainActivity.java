package com.littleturn.listview;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.littleturn.listview.ListViewFragment.ListViewListener;


public class MainActivity extends ActionBarActivity implements ListViewListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	/*	File fp = Environment.getExternalStorageDirectory();
		FilenameFilter fnf = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String filename) {
				// TODO Auto-generated method stub
				if(filename.lastIndexOf('.') >= 0){
					return false;
				}
				return true;
			}
		};
		String[] files = fp.list(fnf);
		
		ArrayAdapter<String> ar = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,files);
		setListAdapter(ar);
		lv = getListView();
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getApplication(), lv.getItemAtPosition(position).toString()	, Toast.LENGTH_SHORT).show();
			}
		});*/
		if (savedInstanceState == null) {
			Bundle args = new Bundle();
			args.putString("directory", Environment.getExternalStorageDirectory().getAbsolutePath());
			
		    //  ListFragment listFragment = new ListFragment();
		      
			ListViewFragment lvf = new ListViewFragment();
			lvf.setArguments(args);
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.add(R.id.container, lvf).commit();

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

	@Override
	public void askOpenDirectory(String dir) {
		// TODO Auto-generated method stub
		Toast.makeText(this, dir, Toast.LENGTH_SHORT).show();
		Bundle args = new Bundle();
		args.putString("directory", dir);
		ListViewFragment lvf = new ListViewFragment();
		lvf.setArguments(args);
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.container, lvf);
		ft.addToBackStack(null);
		ft.commit();
		
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
