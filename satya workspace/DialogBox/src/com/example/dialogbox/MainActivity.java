package com.example.dialogbox;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
 Button b;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder ab= new AlertDialog.Builder(MainActivity.this);
				
				ab.setTitle("Dialog Box Title");
				ab.setMessage("Message content");
				ab.setCancelable(false);    // true to close the Dialog box if touched outside it 
				                           // false it will not close until you select some option
				
				ab.setIcon(android.R.drawable.ic_dialog_alert);
				ab.setPositiveButton("new", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), "positive.", Toast.LENGTH_SHORT).show();
						Intent i = new Intent(MainActivity.this,Profile.class);
						startActivity(i);
					}
				});
				ab.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					   
						dialog.dismiss();   // to close the dialog.. which is even closing without this :P
						
						// to close the application
						// MainActivity.this.finish();  
					}
				});
				
				ab.setNeutralButton("never", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});
				// ab.show(); // and this is magically working :P
				AlertDialog a = ab.create();
				a.show();	
			}
		});
        
    }
   
    
    @Override
    	public void onBackPressed() {
    		// TODO Auto-generated method stub
    	//	super.onBackPressed();
    		
    		AlertDialog.Builder ab2= new AlertDialog.Builder(MainActivity.this);
    		ab2.setTitle("App closing..");
    		ab2.setMessage("Are you sure you want to exit?");
    		ab2.setCancelable(false);
    		ab2.setIcon(android.R.drawable.ic_dialog_alert);
    		ab2.setPositiveButton("Close", new DialogInterface.OnClickListener() {
    			
    			@Override
    			public void onClick(DialogInterface dialog, int which) {
    				// TODO Auto-generated method stub
    			   MainActivity.this.finish();
    			}
    		});
    		ab2.setNegativeButton("Çancel", new DialogInterface.OnClickListener() {
    			
    			@Override
    			public void onClick(DialogInterface dialog, int which) {
    				// TODO Auto-generated method stub
    				MainActivity.this.onResume();
    			}
    		});
    		
    		AlertDialog a = ab2.create();
			a.show();	
    	}
    

    
   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    
}
