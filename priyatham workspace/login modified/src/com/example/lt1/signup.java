package com.example.lt1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends Activity{
	
	Button b1;
	EditText t1,t2,t3,t4,t5,t6;
	CheckBox c1;
	ProgressDialog barProgressDialog;
	Handler updateBarHandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		updateBarHandler = new Handler();
		b1=(Button)findViewById(R.id.button1);
		c1=(CheckBox)findViewById(R.id.checkBox1);
        t1=(EditText)findViewById(R.id.editText1);
        t2=(EditText)findViewById(R.id.editText2);
        t4=(EditText)findViewById(R.id.editText4);
        t5=(EditText)findViewById(R.id.editText5);
        t6=(EditText)findViewById(R.id.editText6);

       /* b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(c1.isChecked())
				{
					Intent i3=new Intent(signup.this,signupdetails.class);
					i3.putExtra("the key1",t1.getText().toString());
					i3.putExtra("the key2",t2.getText().toString());
					i3.putExtra("the key3",t3.getText().toString());
					i3.putExtra("the key4",t4.getText().toString());
					i3.putExtra("the key5",t5.getText().toString());
					i3.putExtra("the key6",t6.getText().toString());	
				startActivity(i3);
				}
				else
				{
				Toast.makeText(getApplicationContext(), "Please agree terms and conditions!!", Toast.LENGTH_LONG).show();
				}
				
			}	
		});*/
	}
		public void launchBarDialog(View view) {
			barProgressDialog = new ProgressDialog(signup.this);
			if(c1.isChecked())
			{
			barProgressDialog.setTitle("Please wait ...");
			barProgressDialog.setMessage("Uploading given Data ...");
			barProgressDialog.setProgressStyle(barProgressDialog.STYLE_HORIZONTAL);
			barProgressDialog.setProgress(0);
			barProgressDialog.setMax(100);
			barProgressDialog.show();	
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {

						// Here you should write your time consuming task...
						while (barProgressDialog.getProgress() <= barProgressDialog.getMax()) {

							Thread.sleep(2000);

							updateBarHandler.post(new Runnable() {

	                            public void run() {

	                            	barProgressDialog.incrementProgressBy(20);

	                              }

	                          });

							if (barProgressDialog.getProgress() == barProgressDialog.getMax()) {

								barProgressDialog.dismiss();

							}
						}
					} catch (Exception e) {
					}
				}
			}).start();
			}
			else if(!c1.isChecked())
			{
			Toast.makeText(getApplicationContext(), "Please agree terms and conditions!!", Toast.LENGTH_LONG).show();	
			}
		}
}
