package com.example.gallery;

import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.ImageColumns;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ListActivity implements OnItemClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		ListView lv;
		File f1 = Environment.getExternalStorageDirectory();
		File f = new File(f1.getPath()+ "/DCIM/Camera/");
		String arr[] = f.list();
		ArrayAdapter<String> ar = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
		try{
			setListAdapter(ar);
			lv = getListView();
			lv.setOnItemClickListener(this);
		}
		catch(Exception e){
			Toast.makeText(this, e.toString(), 500).show();
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		try{
			Intent it = new Intent(getBaseContext(),Vew.class);
			it.putExtra("name", arg2+" ");
			startActivity(it);
		}
		catch(Exception e){
			Toast.makeText(this, e.toString(), 500).show();
		}
		
	}

}

