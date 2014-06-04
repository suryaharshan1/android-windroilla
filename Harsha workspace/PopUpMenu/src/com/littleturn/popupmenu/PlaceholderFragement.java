package com.littleturn.popupmenu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class PlaceholderFragement extends Fragment {
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
			throw new ClassCastException(activity.toString()+" must implement a PlaceholderListener");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		final Button bt = (Button) rootView.findViewById(R.id.button1);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pop(v);
			}
		});
		return rootView;
	}
	
	public void pop(View v){
		PopupMenu pop = new PopupMenu(getActivity(), v);
		MenuInflater mi = pop.getMenuInflater();
		mi.inflate(R.menu.main, pop.getMenu());
		pop.show();
		pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), arg0.getTitle().toString(), Toast.LENGTH_LONG).show();
				return false;
			}
		});
	}
	
}
