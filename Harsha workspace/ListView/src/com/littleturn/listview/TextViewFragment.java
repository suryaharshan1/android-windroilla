package com.littleturn.listview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class TextViewFragment extends Fragment {
	
	String dir;
	EditText et;
	MenuItem save;
	boolean saveStatus;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.text_view, container,false);
		setHasOptionsMenu(true);
		Bundle args = getArguments();
		dir = args.getString("directory");
		
		et = (EditText) rootView.findViewById(R.id.showfile);
		et.setText("");
		et.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				saveStatus = false;
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
			
		try{
		File fp = new File(dir);
		FileInputStream fis = new FileInputStream(fp);
		if(fp.length() > 0){
		int a = 0;
		while((a = fis.read()) > -1){
			et.append((char)a + "");
		}
		}
		fis.close();
		}
		catch(Exception e){
			Toast.makeText(getActivity(), "File Cannot Be Opened", Toast.LENGTH_SHORT).show();
		}
		return rootView;
		}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		save = menu.add("save");
		save.setIcon(android.R.drawable.ic_menu_save);
		save.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getTitle().toString()){
		case "save":
			try{
			File fp = new File(dir);
			String text = et.getText().toString();
			byte b[] =  text.getBytes();
			FileOutputStream fos = new FileOutputStream(fp);
			fos.write(b);
			fos.close();
			Toast.makeText(getActivity(), "SUCCESFULLY SAVED", Toast.LENGTH_SHORT).show();
			saveStatus = true;
			}
			catch(Exception e){
				Toast.makeText(getActivity(), "File Cannot be saved", Toast.LENGTH_SHORT).show();
				saveStatus = false;
			}
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void savedialog(){
		AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
		alert.setTitle("UNSAVED CHANGES");
		alert.setMessage("Do you want to save the changes to "+ dir);
		alert.setIcon(android.R.drawable.ic_menu_save);
		alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		alert.setNeutralButton("Don't save", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		alert.create();
		alert.show();
	
	}
}