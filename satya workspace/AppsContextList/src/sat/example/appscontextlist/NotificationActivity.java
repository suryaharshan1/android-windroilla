package sat.example.appscontextlist;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NotificationActivity extends Activity{
	Button b,b2;
	  EditText e;
	  int count;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification_layout);
		  b= (Button) findViewById(R.id.button1);
	        b2= (Button) findViewById(R.id.button2);
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
				      n.setLatestEventInfo(getApplicationContext(), "hi i am notification", "notification is done.", pd);
				      for(int c=0;c<count;c++){
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
	        
	        b2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

				    NotificationCompat.Builder builder =  
				            new NotificationCompat.Builder(getApplicationContext())  	
				            .setSmallIcon(R.drawable.ic_launcher)  
				            .setContentTitle("Notifications Example")  
				            .setContentText("This is a test notification");  

				    Intent i2 = new Intent(getApplicationContext(), MainActivity.class);  
				    PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, i2,0);  
				    builder.setContentIntent(contentIntent);  

				    // Add as notification  
				    NotificationManager manager = (NotificationManager) getSystemService(getApplication().NOTIFICATION_SERVICE);  
				    manager.notify(0, builder.build()); 
				}
			});
	        
	}

}
