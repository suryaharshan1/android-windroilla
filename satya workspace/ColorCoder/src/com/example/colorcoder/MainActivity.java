package com.example.colorcoder;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
   static	int rValue,gValue,bValue;
   SeekBar s1,s2,s3;    //s1 for red s2 for green s3 for blue
   TextView t1,t2,t3;   // t1 for red value t2 for green t3 for blue
   RelativeLayout rl;   // relative layout of activity_main.xml. required for changing background 
   Button b;    //the get hex value button
   Button b2;   //for setting background when details given
   EditText e1,e2,e3;
   String hex[]={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
   
   
   
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl=(RelativeLayout) findViewById(R.id.myLayout);
        s1=(SeekBar) findViewById(R.id.redSeekBar);
        s2=(SeekBar) findViewById(R.id.GreenSeekBar);
        s3=(SeekBar) findViewById(R.id.BlueSeekBar);
        t1=(TextView) findViewById(R.id.textRValue);
        t2=(TextView) findViewById(R.id.textGValue);
        t3=(TextView) findViewById(R.id.textBValue);
        e1=(EditText) findViewById(R.id.editText1);
        e2=(EditText) findViewById(R.id.editText2);
        e3=(EditText) findViewById(R.id.editText3);
        b=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        
        
        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				//progress is the slider value
				//rvalue stores the Red slider value so as blue and green 
				
				rValue=progress;
				t1.setText("R : "+rValue);  //setting the Rvalue Text
				e1.setText(""+rValue);
				rl.setBackgroundColor(Color.rgb(rValue, gValue,bValue)); //setting the color of background
			}
		});
        
        s2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				gValue=progress;
				t2.setText("G : "+gValue);
				e2.setText(""+gValue);
				rl.setBackgroundColor(Color.rgb(rValue, gValue,bValue));
			}
		});
        
        s3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
			   bValue=progress;
			   t3.setText("B : "+bValue);
			   e3.setText(""+bValue);
			   rl.setBackgroundColor(Color.rgb(rValue, gValue,bValue));
			}
		});
        
        
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast toast= Toast.makeText(getApplicationContext(), "Hex value: #"+getHex(rValue)+getHex(gValue)+getHex(bValue), Toast.LENGTH_LONG);
				toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
				toast.show();
			}
		});
        
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rValue=Integer.parseInt(e1.getText().toString());
				gValue=Integer.parseInt(e2.getText().toString());
				bValue=Integer.parseInt(e3.getText().toString());
				if(rValue>255){
					rValue=255;
					e1.setText("255");
				}
				if(bValue>255){
					bValue=255;
					e3.setText("255");
				}
				if(gValue>255){
					gValue=255;
					e2.setText("255");
				}
				s1.setProgress(rValue);
				s2.setProgress(gValue);
				s3.setProgress(bValue);
			  //  rl.setBackgroundColor(Color.rgb(Integer.parseInt(e1.getText().toString()),Integer.parseInt(e2.getText().toString()), Integer.parseInt(e3.getText().toString())));
				 rl.setBackgroundColor(Color.rgb(rValue, gValue,bValue));
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public String getHex(int value){
    	String result="";
    	while(value>=16){
    		result=hex[value%16]+result;
    		value=value/16;
    	}
    	result=hex[value%16]+result;
    	if(result.length()==1){
    		return "0"+result;
    	}else{
    		return result;
    	}
		
    }
    
}
