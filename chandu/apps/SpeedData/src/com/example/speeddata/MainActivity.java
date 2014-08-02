package com.example.speeddata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	GridView grid;
	Button startbt,stopbt;
	boolean flag = false;
	File f,file;
	FileOutputStream fos;
	int i=1;
	long startTime;
	MediaPlayer mp;
	int cp = -1;
	String stime = null;
	CustomGrid adapter;
	public static final String DEFAULT_STORAGE_LOCATION = Environment.getExternalStorageDirectory().getPath()+"/SpeedData/";
	String[] web = {
		    "CY",
			"TW",
			"AR",
			"PC",
			"JP ",
			"MB",
			"BS",
			"MT",
			"TR",
	} ;
	int[] imageId = {
			R.drawable.image1,
			R.drawable.image2,
			R.drawable.image3,
			R.drawable.image4,
			R.drawable.image5,
			R.drawable.image6,
			R.drawable.image7,
			R.drawable.image8,
			R.drawable.image9,
	};
	int[] opflags = {0,0,0,0,0,0,0,0,0};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startbt = (Button) findViewById(R.id.start);
		stopbt = (Button) findViewById(R.id.stop);
		adapter = new CustomGrid(MainActivity.this,web, imageId,opflags);
		grid=(GridView)findViewById(R.id.grid);
				grid.setAdapter(adapter);
				grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		            @Override
		            public void onItemClick(AdapterView<?> parent, View view,
		                                    int position, long id) {
		                //Toast.makeText(MainActivity.this, "You Clicked at " +web[position], Toast.LENGTH_SHORT).show();
		            	mp=MediaPlayer.create(getApplicationContext(), R.raw.switchon);
		            	
		            	mp.setOnCompletionListener(new OnCompletionListener() {
							
							@Override
							public void onCompletion(MediaPlayer mp) {
								// TODO Auto-generated method stub
								mp.reset();
								mp.release();
							}
						});
		            	
		            	mp.start();
		            	
		            	if(!flag){
		            		for(int i = 0; i < 9; i++)
		            			opflags[i] = 1;
		            		opflags[position] = 0;
		            		adapter.notifyDataSetChanged();
		            		cp = position;
		            		flag = true;
		            		startTime = System.currentTimeMillis();
		            		DateFormat dft = new SimpleDateFormat("HH:mm:ss");
			                  Calendar calen = Calendar.getInstance();
			                  calen.setTimeInMillis(startTime);
			                  stime = dft.format(calen.getTime());
			                  Toast.makeText(getApplicationContext(), "Start time Recorded for: "+web[position], 100).show();
		            	}
		            	else if(cp==position){
		            		for(int i=0;i<9;i++)
			        	    	opflags[i] = 0;
			        	    adapter.notifyDataSetChanged();
		            		Toast.makeText(getApplicationContext(), "End time Recorded: "+web[position], 100).show();
		            		long time = System.currentTimeMillis();
			        		DateFormat dft = new SimpleDateFormat("HH:mm:ss");
			                  Calendar calen = Calendar.getInstance();
			                  calen.setTimeInMillis(time);
			        	    String fname = i+"\t"+web[position]+"\t"+stime+"\t"+dft.format(calen.getTime())+"\n";
			        	    try {
								int a = 0;
								FileInputStream fis = new FileInputStream(file);
								Scanner sc = new Scanner(fis);
								String content = "";
								while((a = fis.read())>-1){
									content +=  (char)a + "";
								}
								content+=fname;
								fis.close();
								byte be[] = content.getBytes();
								fos = new FileOutputStream(file);
								fos.write(be);
								fos.close();
								i++;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			        	    cp =-1;
			        	    flag = false;
		            	}
		            	else{
		            		Toast.makeText(getApplicationContext(), web[cp]+" is already active ", 100).show();
		            	}
		            	
		            	
		            }
		        });

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	//	mp.release();
	}
	public void startser(View v) {
		grid.setVisibility(View.VISIBLE);
		v.setVisibility(View.GONE);
		SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String s = now.format(date);
		long tm = System.currentTimeMillis();
		DateFormat dft = new SimpleDateFormat("HH:mm:ss");
          Calendar calen = Calendar.getInstance();
          calen.setTimeInMillis(tm);
	    String fname = dft.format(calen.getTime());
	    f = new File(DEFAULT_STORAGE_LOCATION+s);
		if(!f.exists()){
			f.mkdirs();
		}
		file = new File(f.getAbsolutePath()+"/"+fname+".txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Toast.makeText(getApplicationContext(), e.toString(), 200).show();
		}
		stopbt.setVisibility(View.VISIBLE);
	}

	public void stopser(View v) {
		grid.setVisibility(View.GONE);
		v.setVisibility(View.GONE);
		startbt.setVisibility(View.VISIBLE);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
	}

}


