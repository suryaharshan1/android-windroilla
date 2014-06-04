package com.littleturn.database;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LoggedInFragment extends Fragment {
	private static TextView tv;
	/*
	LoggedInListener activityCallback;
	
	public interface LoggedInListener{
		
	}
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		try{
			activityCallback = (LoggedInListener) activity;
		}
		catch(ClassCastException e){
			throw new ClassCastException(activity.toString() + " must implement LoggedInListener");
		}
	}
	*/
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_user_info, container, false);
		tv = (TextView) rootView.findViewById(R.id.welcomeuser);
		String username = ((MyApplicationData) getActivity().getApplication()).getUserName();
		tv.setText("Hello "+username);
		PlaceholderFragment.fa.finish();
		return rootView;
	}

}
