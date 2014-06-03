package sat.example.notification;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
  Button b;
  EditText e;
  int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b= (Button) findViewById(R.id.button1); 
        e= (EditText) findViewById(R.id.editText1);
        e.setText("0");
        
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				  count=Integer.parseInt(e.getText().toString());
			      NotificationManager nm = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
			      Notification n = new Notification(android.R.drawable.stat_notify_more, "This is a notifiaction", System.currentTimeMillis());
			      Intent i = new Intent(getApplicationContext(),MainActivity.class);
			      PendingIntent pd = PendingIntent.getActivity(getApplicationContext(),0,i,0);
			      
			      for(int c=0;c<count;c++){
			    	  n.setLatestEventInfo(getApplicationContext(), "notification #0"+c, "notification from notification flooder", pd);
			    	  nm.notify(c,n);
			    	  try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
