package com.example.msgviawhatsapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button b;
	EditText e1;
	String s1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b=(Button)findViewById(R.id.button1);
		e1=(EditText)findViewById(R.id.editText1);
		b.setOnClickListener(new View.OnClickListener() {
			
			@SuppressWarnings("unused")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent wa = new Intent(Intent.ACTION_SEND);
				wa.setType("text/plain");
				s1=e1.getText().toString();
				wa.setPackage("com.whatsapp");
				if(wa != null){
					wa.putExtra(Intent.EXTRA_TEXT, s1);
					startActivity(Intent.createChooser(wa, "share with"));
				}else{
					Toast.makeText(getApplicationContext(), "Whats app not installed", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
