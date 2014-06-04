package com.hpesindia2014;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				NotificationManager nm=(NotificationManager)getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
				NotificationCompat.Builder builder=
						new NotificationCompat.Builder(getApplicationContext())
							.setSmallIcon(R.drawable.ic_launcher)
							.setContentTitle("got a new notification")
							.setTicker("Notification!")
							.setContentText("this is new notification");
				Intent i=new Intent(getApplicationContext(), MainActivity.class);
				PendingIntent pd=PendingIntent.getActivity(getApplicationContext(), 0, i, 0);
				builder.setContentIntent(pd);
				nm.notify(0,builder.build());
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
