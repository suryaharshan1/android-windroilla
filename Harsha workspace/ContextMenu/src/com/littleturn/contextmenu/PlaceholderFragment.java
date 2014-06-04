package com.littleturn.contextmenu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class PlaceholderFragment extends Fragment{
	PlaceholderListener activityCallback;
	
	public interface PlaceholderListener{
		
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		try{
			activityCallback = (PlaceholderListener) activity;
		}
		catch(ClassCastException e){
			throw new ClassCastException(activity.toString()+" must implement Placeholder interface");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		final Button bt = (Button) rootView.findViewById(R.id.button1);
		registerForContextMenu(bt);
		return rootView;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflat = getActivity().getMenuInflater();
		inflat.inflate(R.menu.main, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), item.getTitle().toString(), Toast.LENGTH_LONG).show();
		return super.onContextItemSelected(item);
	}
}
