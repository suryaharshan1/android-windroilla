package com.example.radio;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
     RadioGroup rg;
     RadioButton r1,r2,r3;
 //    LinearLayout ll=(LinearLayout) findViewById(R.layout.activity_main);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   final LinearLayout ll=(LinearLayout) findViewById(R.layout.activity_main);
        rg=(RadioGroup) findViewById(R.id.radioGroup1);
        r1=(RadioButton) findViewById(R.id.radio0);
        r2=(RadioButton) findViewById(R.id.radio1);
        r3=(RadioButton) findViewById(R.id.radio2);
        
        OnClickListener ol= new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
		  /*     r1.setBackgroundColor(Color.RED);
		       r2.setBackgroundColor(Color.TRANSPARENT);
		       r3.setBackgroundColor(Color.TRANSPARENT); */
		//		ll.setBackgroundColor(Color.CYAN);
				RadioButton r=(RadioButton) v;
				r.setBackgroundColor(Color.RED);
			}
		};
		r1.setOnClickListener(ol);
		
		
		r2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 r2.setBackgroundColor(Color.BLUE);
				 r1.setBackgroundColor(Color.TRANSPARENT);
			       r3.setBackgroundColor(Color.TRANSPARENT);
			}
		});
		r3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 r3.setBackgroundColor(Color.GREEN);
				 r2.setBackgroundColor(Color.TRANSPARENT);
			       r1.setBackgroundColor(Color.TRANSPARENT);
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
