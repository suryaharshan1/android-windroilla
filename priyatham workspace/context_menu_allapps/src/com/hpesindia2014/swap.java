package com.hpesindia2014;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class swap extends Activity {

	ToggleButton tb1,tb2;
	EditText t1,t2;
	String s1,s2,temp;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swap);
        tb1=(ToggleButton) findViewById(R.id.toggleButton1);
        tb2=(ToggleButton) findViewById(R.id.toggleButton2);
        t1=(EditText) findViewById(R.id.editText1);
        t2=(EditText) findViewById(R.id.editText2);
        tb2.setChecked(true);
        tb1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=t1.getText().toString();
		        s2=t2.getText().toString();
				if(tb1.isChecked())
				{	
					tb2.setChecked(false);
					t1.setText(s2);
					t2.setText(s1);
					Toast.makeText(getApplicationContext(), "exchanged first with second!!", Toast.LENGTH_LONG).show();
				}
				else
				{
					tb2.setChecked(true);
					t2.setText(s1);
					t1.setText(s2);
					Toast.makeText(getApplicationContext(), "exchanged second with first!!", Toast.LENGTH_LONG).show();
				}
			}
		});
        tb2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=t1.getText().toString();
		        s2=t2.getText().toString();
				if(tb2.isChecked())					
				{	
					tb1.setChecked(false);
					t2.setText(s1);
					t1.setText(s2);
					Toast.makeText(getApplicationContext(), "exchanged second with first!!", Toast.LENGTH_LONG).show();
				}
				else
				{
					tb1.setChecked(false);
					t1.setText(s2);
					t2.setText(s1);
					Toast.makeText(getApplicationContext(), "exchanged first with second!!", Toast.LENGTH_LONG).show();
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
