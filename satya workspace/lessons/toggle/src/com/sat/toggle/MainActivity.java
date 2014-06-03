package com.sat.toggle;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
//import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    ToggleButton t1,t2;
	EditText text1,text2;
	String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(ToggleButton) findViewById(R.id.toggleButton1);
        t2=(ToggleButton) findViewById(R.id.toggleButton2);
        text1=(EditText) findViewById(R.id.editText1);
        text2=(EditText) findViewById(R.id.editText2);
       t2.setChecked(true);
        
        t1.setOnClickListener(new  View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 s1=text1.getText().toString();
			        s2=text2.getText().toString();
				// TODO Auto-generated method stub
				if(t1.isChecked()){
					t2.setChecked(false);
					text1.setText(s2);
					text2.setText(s1);
				}else{
					t2.setChecked(true);
					text1.setText(s2);
					text2.setText(s1);
				}
				
			}
		});
        
       t2.setOnClickListener(new  View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 s1=text1.getText().toString();
			        s2=text2.getText().toString();
				if(t2.isChecked()){
					t1.setChecked(false);
					text1.setText(s2);
					text2.setText(s1);
				}else{
					t1.setChecked(true);
					text1.setText(s2);
					text2.setText(s1);
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
