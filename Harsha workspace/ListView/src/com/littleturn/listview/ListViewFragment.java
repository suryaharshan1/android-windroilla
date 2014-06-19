package com.littleturn.listview;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewFragment extends ListFragment {
	ListViewListener activityCallback;
	
	public interface ListViewListener{
		public void askOpenDirectory(String directory);
		public void askOpenFile(String directory);
	}
	
	ArrayList<File> alf;
	ArrayList<String> als;
	File[] files;
	String[] filenames;
	String dir;
	ListAdapter ar;
	ListView lv;
	CustomList adapter;
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
		View rootView =  inflater.inflate(R.layout.fragment_main, container, false);
		setHasOptionsMenu(true);
		files = fp.listFiles(fnf);
		filenames = fp.list(fnf);
		alf = new ArrayList<File>(Arrays.asList(files));
		als = new ArrayList<String>(Arrays.asList(filenames));
		adapter = new CustomList(getActivity(), als, alf);
		ar = adapter;
		lv = (ListView) rootView.findViewById(android.R.id.list);
		lv.setAdapter(ar);
		
		return rootView;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				final int index = position;
				PopupMenu pop = new PopupMenu(getActivity(), view);
				MenuInflater mi = pop.getMenuInflater();
				mi.inflate(R.menu.file_manager, pop.getMenu());
				pop.show();
				pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
					
					@Override
					public boolean onMenuItemClick(MenuItem arg0) {
						// TODO Auto-generated method stub
						switch(arg0.getTitle().toString()){
						case "Delete":
								delete(index);
							break;
						case "Rename":
								adialog("RENAME", "ENTER NEW NAME", "rename", index);
							break;
						}
						return false;
					}
				});
				return false;
			}
		
		});
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		MenuItem addnew = menu.add("add");
		addnew.setIcon(android.R.drawable.ic_input_add);
		addnew.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getTitle().toString()){
		case "add":
			String s[] = {"ADD A FOLDER","ADD A FILE"};
			ArrayAdapter<String> ar = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, s);
			AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
			ab.setTitle("ADD");
			ab.setAdapter(ar, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					if(which == 0){
						adialog("NEW FOLDER","ENTER FOLDER NAME","folder",which);	
					}
					else
						adialog("NEW FILE","ENTER FILE NAME","file",which);
				}
			});
			ab.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			ab.setCancelable(true);
			ab.create();
			ab.show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		if(alf.get(position).isDirectory()){
			activityCallback.askOpenDirectory(alf.get(position).getAbsolutePath());
		}
		else{
			activityCallback.askOpenFile(alf.get(position).getAbsolutePath());
		}
	}
	
	public void delete(int index){
			if(alf.get(index).delete()){
				Toast.makeText(getActivity(),als.get(index) + " deleted", Toast.LENGTH_LONG).show();
				alf.remove(index);
				als.remove(index);
				adapter.notifyDataSetChanged();
			}
			else{
				deleteSubDirectories(alf.get(index));
				if(alf.get(index).delete()){
					Toast.makeText(getActivity(),als.get(index) + " deleted", Toast.LENGTH_LONG).show();
					alf.remove(index);
					als.remove(index);
					adapter.notifyDataSetChanged();
				}
				else
					Toast.makeText(getActivity(),als.get(index) + " is not deleted", Toast.LENGTH_LONG).show();
			}
		}
	
	public void deleteSubDirectories(File fp){
		File[] deleteFile = fp.listFiles();
		for(File s: deleteFile){
		    if(!s.delete()){
		    	deleteSubDirectories(s);
		    }
		    s.delete();
		}
	}
	
	public void rename(String fn,int index){
		File fp = new File(dir + "/" + fn);
		if(fp.exists())
			Toast.makeText(getActivity(), "File already exists", Toast.LENGTH_SHORT).show();
		else{
			alf.get(index).renameTo(fp);
			als.set(index, fn);
			adapter.notifyDataSetChanged();
		}
	}
	
	
	
	public void filecreate(String fn){
		try{
			File fp = new File(dir + "/" + fn);
			if(!fp.exists()){
			fp.createNewFile();
			alf.add(fp);
			als.add(fn);
			adapter.notifyDataSetChanged();
			}
			else
				Toast.makeText(getActivity(), "File already exists", Toast.LENGTH_SHORT).show();
			}
			catch(Exception e){
				Toast.makeText(getActivity(), "File cannot be created", Toast.LENGTH_SHORT).show();
			}
	}
	
	public void foldercreate(String fn){
		try{
			File fp = new File(dir + "/" + fn);
			if(!fp.exists()){
			fp.mkdir();
			alf.add(fp);
			als.add(fn);
			adapter.notifyDataSetChanged();
			}
			else
				Toast.makeText(getActivity(), "Folder already exists", Toast.LENGTH_SHORT).show();
			}
			catch(Exception e){
				Toast.makeText(getActivity(), "Folder cannot be created", Toast.LENGTH_SHORT).show();
			}
	}
	
	public void adialog(String title,String hint,String add, int which){
		AlertDialog.Builder folder = new AlertDialog.Builder(getActivity());
		folder.setTitle(title);
		final String addele = add; 
		final int index = which;
		final EditText input = new EditText(getActivity());  
		  LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
		                        LinearLayout.LayoutParams.MATCH_PARENT,
		                        LinearLayout.LayoutParams.MATCH_PARENT);
		  input.setLayoutParams(lp);
		  input.setHint(hint);
		  folder.setView(input);
		  folder.setCancelable(true);
		  folder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				String fn = input.getText().toString();
				switch(addele){
				case "folder":
					foldercreate(fn);
					break;
				case "file":
					filecreate(fn);
					break;
				case "rename":
					rename(fn,index);
					break;
				}
					
			}
		});
		folder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
		folder.create();
		folder.show();
	}

}
