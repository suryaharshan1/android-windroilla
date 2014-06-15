package com.example.filehandlingex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText e;
    String s,s2="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e =(EditText)findViewById(R.id.editText1);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void load(View view){
    	s=e.getText().toString();
  /*  	try {
			FileOutputStream fo = openFileOutput("textfile.txt", MODE_WORLD_READABLE);
			OutputStreamWriter ow = new OutputStreamWriter(fo);
			try {
				ow.write(s);
				ow.flush();
				ow.close();
				Toast.makeText(getApplicationContext(),"Loaded", Toast.LENGTH_SHORT).show();
				e.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     */
    	
    	//File Dir = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), s);
    	
    }
    
  public void download(View view){
	/*  try {
		FileInputStream fi = openFileInput("textfile.txt");
		InputStreamReader ir = new InputStreamReader(fi);
		char [] c =new char[100];
		int ch;
		 try {
		//	s=Integer.toString(fi.read());
			while((ch=ir.read())>0){
				s=String.copyValueOf(c,0,ch);
				s2=s2+s;
			}
			e.setText(s2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    */
	  
  }
    
}
