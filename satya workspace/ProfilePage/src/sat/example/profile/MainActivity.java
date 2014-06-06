package sat.example.profile;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button bDial,bFb,bTwt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bDial=(Button)findViewById(R.id.button1);
        bFb=(Button)findViewById(R.id.button2);
        bTwt=(Button)findViewById(R.id.button3);
        
        bDial.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//will actually requires permission in manifest file
				// <uses-permission android:name="android.permission.CALL_PHONE"></uses-permission> 
			  Intent i1=new Intent(Intent.ACTION_CALL,Uri.parse("tel:+919633779370"));
			  startActivity(i1);
			}
		});
        
       bFb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  Intent i2=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.facebook.com/satya.darls"));
			  startActivity(i2);
			}
		});
       
       bTwt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  Intent i3=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.twitter.com/satyakoppisetti"));
			  startActivity(i3);
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
