package com.littleturn.listview;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewFragment extends ListFragment {
	ListViewListener activityCallback;
	
	public interface ListViewListener{
		public void askOpenDirectory(String directory);
		public void askOpenFile(String directory);
	}
	
	public ListViewFragment(){
		 	
	}
	
	List<File> alf;
	List<String> als;
	File[] files;
	String[] filenames;
	String dir;
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		try{
			activityCallback = (ListViewListener) activity;
		}
		catch(ClassCastException e){
			throw new ClassCastException(activity.toString() + " must implement ListFragmentListener");
		}
	}
	
	@Override  
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		Bundle args = getArguments();
		dir = args.getString("directory");
		File fp = new File(dir);
		
		FilenameFilter fnf = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String filename) {
				// TODO Auto-generated method stub
					if(filename.lastIndexOf('.') != 0)
						return true;
				return false;
			}
		};
		
		files = fp.listFiles(fnf);
		filenames = fp.list(fnf);
		alf = Arrays.asList(files);
		als = Arrays.asList(filenames);
		ListAdapter ar = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1,als);
		setListAdapter(ar);
	
		return inflater.inflate(R.layout.fragment_main, container, false);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		if(files[position].isDirectory()){
			activityCallback.askOpenDirectory(files[position].getAbsolutePath());
		}
		else{
			activityCallback.askOpenFile(files[position].getAbsolutePath());
		}
	}
}
