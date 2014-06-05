package com.littleturn.listview;

import java.io.File;
import java.io.FilenameFilter;
import java.security.acl.LastOwnerException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ListFragment;
import android.support.v4.os.EnvironmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewFragment extends ListFragment {
	
	/*private static ListView lv;*/
	public ListViewFragment(){
		 
		
	}
	//File[] files;
	String[] filenames;
	
	@Override  
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		File fp = Environment.getExternalStorageDirectory();
		//File fp = Environment.getRootDirectory();
		//File fp = Environment.getDownloadCacheDirectory();
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
		//files = fp.listFiles(fnf);
		filenames = fp.list(fnf);
		//Map<String, File> map = new HashMap<String, File>();
		/*Dictionary<File, String> mydic = new Dictionary<File, String>() {

			@Override
			public Enumeration<String> elements() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String get(Object key) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Enumeration<File> keys() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String put(File key, String value) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String remove(Object key) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};*/
		ListAdapter ar = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1,filenames);
		setListAdapter(ar);
	
		return inflater.inflate(R.layout.fragment_main, container, false);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		//super.onListItemClick(l, v, position, id);
		
		Toast.makeText(getActivity(), getListView().getItemAtPosition(position).toString()	, Toast.LENGTH_SHORT).show();
	}
}
