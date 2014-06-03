package com.example.checkbox;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	CheckBox c1,c2,c3;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        c1= (CheckBox) findViewById(R.id.checkBox1);
        c2= (CheckBox) findViewById(R.id.checkBox2);
        c3= (CheckBox) findViewById(R.id.checkBox3);
        b= (Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(c1.isChecked()){
					Toast.makeText(getApplicationContext(), "MUsic is Checked", Toast.LENGTH_LONG).show();
				}
				if(c2.isChecked()){
					Toast.makeText(getApplicationContext(), "Arts is Checked", Toast.LENGTH_LONG).show();
				}
				if(c3.isChecked()){
					Toast.makeText(getApplicationContext(), "Dance is Checked", Toast.LENGTH_LONG).show();
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
