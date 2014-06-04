package com.hpesindia2014;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	EditText string1,string2;
	Button add;
	int n1,n2,sum;
	String s1,s2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=(Button) findViewById(R.id.button1);
        string1=(EditText) findViewById(R.id.editText1);
        string2=(EditText) findViewById(R.id.editText2);
        add.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			s1=string1.getText().toString();
			s2=string2.getText().toString();
			n1=Integer.parseInt(s1);
			n2=Integer.parseInt(s2);
			sum=n1+n2;
			Toast.makeText(getApplicationContext(),"sum is "+sum  ,Toast.LENGTH_LONG).show();
		}
	});   
      
    }

    
}
