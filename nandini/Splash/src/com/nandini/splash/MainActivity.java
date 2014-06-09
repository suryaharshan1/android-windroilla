package com.nandini.splash;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	
	int counter;
	
	Button add, sub;
	TextView display;
	
	public void updateDisplay(){
		this.display.setText("Your total is: " + this.counter);
	}
	
	
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        
        counter = 0;
        add = (Button) findViewById(R.id.bAdd);
        sub = (Button) findViewById(R.id.bSub);
        display = (TextView) findViewById(R.id.tvDisplay);
        
        add.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				counter++;
				display.setText("Your total is: " + counter);
			}
		});
        
        sub.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				counter--;
				display.setText("Your total is: " + counter);
			}
		});
        
    }
}
