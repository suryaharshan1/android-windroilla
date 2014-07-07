package com.littleturn.todo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.widget.Toast;

public class ReminderAlarm extends BroadcastReceiver{
	private NotificationManager mNotificationManager;
	 private Notification notification;   

	@Override
	 public void onReceive(Context context, Intent intent) {
	  // TODO Auto-generated method stub       
		  CharSequence name = intent.getStringExtra("Name");
		  CharSequence priority = intent.getStringExtra("PRIORITY");
		  if(priority.equals("LOW")){
			  mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		      PendingIntent contentIntent = PendingIntent.getActivity(context, 0, new Intent(), 0);
		      notification = new Notification(R.drawable.ic_launcher,"Notification", System.currentTimeMillis());
		      notification.setLatestEventInfo(context, name, "("+priority+")"  , contentIntent);
		      notification.sound = (Uri)(Uri.parse(intent.getStringExtra("Ringtonelow")));
		      mNotificationManager.notify(Integer.parseInt(intent.getExtras().get("NotifyCount").toString()), notification);        
		      Toast.makeText(context, "ONE OF YOUR TASKS TIME'S UP!!!!", Toast.LENGTH_LONG).show(); 
		      Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
		      vibrator.vibrate(2000);
		  }
		  if(priority.equals("NORMAL")){
			  mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		      PendingIntent contentIntent = PendingIntent.getActivity(context, 0, new Intent(), 0);
		      notification = new Notification(R.drawable.ic_launcher,"Notification", System.currentTimeMillis());
		      notification.setLatestEventInfo(context, name, "("+priority+")" , contentIntent);
		      notification.sound = (Uri)(Uri.parse(intent.getStringExtra("Ringtonenormal")));
		      mNotificationManager.notify(Integer.parseInt(intent.getExtras().get("NotifyCount").toString()), notification);        
		      Toast.makeText(context, "ONE OF YOUR TASKS TIME'S UP!!!!", Toast.LENGTH_LONG).show(); 
		      Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
		      vibrator.vibrate(2000);
		  }
		  if(priority.equals("HIGH")){
			  mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		      PendingIntent contentIntent = PendingIntent.getActivity(context, 0, new Intent(), 0);
		      notification = new Notification(R.drawable.ic_launcher,"Notification", System.currentTimeMillis());
		      notification.setLatestEventInfo(context, name, "("+priority+")" , contentIntent);
		      notification.sound = (Uri)(Uri.parse(intent.getStringExtra("Ringtonehigh")));
		      mNotificationManager.notify(Integer.parseInt(intent.getExtras().get("NotifyCount").toString()), notification);        
		      Toast.makeText(context, "ONE OF YOUR TASKS TIME'S UP!!!!", Toast.LENGTH_LONG).show(); 
		      Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
		      vibrator.vibrate(2000);
		  }
	 }
}
