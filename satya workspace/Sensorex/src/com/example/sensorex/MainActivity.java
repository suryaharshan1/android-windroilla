package com.example.sensorex;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener{
	SensorManager sm;
	TextView t;
	Sensor s;
	Button b1;
	
    @SuppressWarnings("static-access")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(TextView)findViewById(R.id.textView2);
        b1=(Button)findViewById(R.id.button1);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);  // dont forget type casting
       s= sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
       sm.registerListener(this, s, sm.SENSOR_DELAY_NORMAL);
       
        
        
        
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		
		t.setText("X : "+event.values[0]+"\nY : "+event.values[1]+"\nZ : "+event.values[2]);
		
	/*	if(event.values[1]<0){
			temp=-(1)*event.values[1];
		}else{
			temp=event.values[1];
		}*/
		b1.setWidth(Math.abs((int)event.values[1]*50));
	}
    
}
