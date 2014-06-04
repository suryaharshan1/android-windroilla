package com.example.gallery;

import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

public class Vew extends Activity {

	ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		iv = (ImageView) findViewById(R.id.imageView1);
		try{
			Intent i = getIntent();
			String s = i.getStringExtra("name");
			String str = s.trim();
			int index = Integer.parseInt(str);
			Toast.makeText(this, index+"", 500).show();
			File f1 = Environment.getExternalStorageDirectory();
			File f = new File(f1.getPath()+ "/DCIM/Camera/");
			String array[] = f.list();
			Bitmap bmp = BitmapFactory.decodeFile(f.getAbsolutePath()+ "/" + array[index]);
			iv.setImageBitmap(bmp);
		}
		catch(Exception e){
			Toast.makeText(this, e.toString(), 500).show();
		}
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish();
	}

}
