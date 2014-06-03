package com.sat.firstapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{
	
	Button Go,sub,mul,div,res;
	TextView Display;
	EditText string1,string2;
    int n1,n2,result;
    String s1,s2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Go = (Button) findViewById(R.id.addb);
        sub = (Button) findViewById(R.id.subb);
        mul = (Button) findViewById(R.id.mulb);
        div = (Button) findViewById(R.id.divb);
        res = (Button) findViewById(R.id.resb);
        Display = (TextView) findViewById(R.id.textView1);
        string1 = (EditText) findViewById(R.id.editText1);
        string2 = (EditText) findViewById(R.id.editText3);
       
       
        Go.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 s1=string1.getText().toString();
			     s2=string2.getText().toString();
			  
				 n1=Integer.parseInt(s1);
			     n2=Integer.parseInt(s2);
				result=n1+n2;
				Display.setText("Result : "+result);
				Toast.makeText(getApplicationContext(), "addition performed and result is "+result, Toast.LENGTH_LONG).show();
			    
			}
		});
        
        sub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 s1=string1.getText().toString();
			     s2=string2.getText().toString();
			  
				 n1=Integer.parseInt(s1);
			     n2=Integer.parseInt(s2);
				result=n1-n2;
				Display.setText("Result : "+result);
				Toast.makeText(getApplicationContext(), "subtraction performed and result is "+result, Toast.LENGTH_LONG).show();
			   
			}
		});
        
        mul.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 s1=string1.getText().toString();
			     s2=string2.getText().toString();
			    
				 n1=Integer.parseInt(s1);
			     n2=Integer.parseInt(s2);
				result=n1*n2;
				Display.setText("Result : "+result);
				Toast.makeText(getApplicationContext(), "multiplication performed and result is "+result, Toast.LENGTH_LONG).show();
			
			}
		});
        
        
       div.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 s1=string1.getText().toString();
			     s2=string2.getText().toString();
			    
			    	 if(s2=="0"){
			    		 Toast.makeText(getApplicationContext(), "division by zero is not possible"+result, Toast.LENGTH_LONG).show();
			    	 }else{
				 n1=Integer.parseInt(s1);
			     n2=Integer.parseInt(s2);
				result=n1/n2;
				Display.setText("Result : "+result);
				Toast.makeText(getApplicationContext(), "division performed and result is "+result, Toast.LENGTH_LONG).show();
			    	 }
			   
			}
		});
       
       res.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			string1.setText("");
			string2.setText("");
			Display.setText("Result : ");
		}
	});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
    
}
