package com.example.notificationdemo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.util.ByteArrayBuffer;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText ed;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed = (EditText) findViewById(R.id.editText1);
		try{
			AssetManager mngr = getAssets();
			InputStream path = mngr.open("music/chilipiga.mp3"); 

			                    BufferedInputStream bis = new BufferedInputStream(path,1024);

			                    //get the bytes one by one
			                    int current = 0;
		ByteArrayBuffer baf = new ByteArrayBuffer(1024); 
			                    while ((current = bis.read()) != -1) {

			                        baf.append((byte) current);
			                    }
			byte[] bitmapdata  = baf.toByteArray();
			
			File file=new File(Environment.getExternalStorageDirectory()+"/mysounds", "chilipiga.mp3");
			FileOutputStream fos;
			fos=new FileOutputStream(file);
			fos.write(bitmapdata);
			fos.flush();
			fos.close();
		}
		catch(Exception e){
			Toast.makeText(this, e.toString(), 200);
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
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_settings:
	            Intent i=new Intent(this,SettingsActivity.class);
	            startActivity(i);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	public void notify(View v){
		String tonotify = ed.getText().toString();
		String u = "Unexpected Note";
		String head = "Note";
		NotificationManager nm =  (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		//Notification n1 = new Notification(android.R.drawable.btn_plus, "Alert", System.currentTimeMillis());
		//n1.defaults = Notification.DEFAULT_SOUND;
		Notification n2 = new Notification(android.R.drawable.btn_plus, "Alert", System.currentTimeMillis());
		n2.sound = Uri.parse("/mnt/sdcard/mysounds/chilipiga.mp3");
		Intent i = new Intent(this,Alert.class);
		PendingIntent pi = PendingIntent.getActivity(this, 0, i, 1);
		//n1.setLatestEventInfo(this, head, tonotify, pi);
		n2.setLatestEventInfo(this, head, u, pi);
		//nm.notify(0,n1);
		nm.notify(1,n2);
	}

}
