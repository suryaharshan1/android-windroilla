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
		
		if (savedInstanceState == null) {
			Bundle args = new Bundle();
			args.putString("directory", Environment.getExternalStorageDirectory().getAbsolutePath());
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
		Bundle args = new Bundle();
		args.putString("directory", dir);
		ListViewFragment lvf = new ListViewFragment();
		lvf.setArguments(args);
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.container, lvf);
		ft.addToBackStack(null);
		ft.commit();
		
	}

	@Override
	public void askOpenFile(String directory) {
		// TODO Auto-generated method stub
		if(directory.endsWith(".txt")){
			Toast.makeText(this, "Text File", Toast.LENGTH_SHORT).show();
		}
		else if(directory.endsWith(".mp3")){
			//Toast.makeText(this, "Music File", Toast.LENGTH_SHORT).show();
			Bundle args = new Bundle();
			args.putString("directory", directory);
			MediaViewFragment mvf = new MediaViewFragment();
			mvf.setArguments(args);
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.container, mvf);
			ft.addToBackStack(null);
			ft.commit();
		}
		else if(directory.endsWith(".mp4")){
			//Toast.makeText(this, "Video File", Toast.LENGTH_SHORT).show();
			Bundle args = new Bundle();
			args.putString("directory", directory);
			VideoViewFragment vvf = new VideoViewFragment();
			vvf.setArguments(args);
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.container, vvf);
			ft.addToBackStack(null);
			ft.commit();
		}
		else if(directory.endsWith(".jpg")){
			//Toast.makeText(this, "Image File", Toast.LENGTH_SHORT).show();
			Bundle args = new Bundle();
			args.putString("directory", directory);
			ImageViewFragment ivf = new ImageViewFragment();
			ivf.setArguments(args);
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.container, ivf);
			ft.addToBackStack(null);
			ft.commit();
		}
		else {
			Toast.makeText(this, "UNKNOWN FILE", Toast.LENGTH_SHORT).show();
		}
	}

}
