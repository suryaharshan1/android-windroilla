package com.hpesindia2014;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class notification extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        Button b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				NotificationManager nm=(NotificationManager)getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
				Notification n=new Notification(android.R.drawable.stat_notify_more ,"got a new notification",System.currentTimeMillis());
				Intent i=new Intent(getApplicationContext(), MainActivity.class);
				PendingIntent pd=PendingIntent.getActivity(getApplicationContext(), 0, i, 0);
				n.setLatestEventInfo(getApplicationContext(), "HI i'm new notification", "notification is done by me", pd);
				nm.notify(0,n);
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
