package sat.example.progressbar;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static int myProgress=0;
	private ProgressBar progressBar;
	private int progressStatus=0;
	private Handler myHandler=new Handler();
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void beginYourTask(View view)
    {
    	myProgress=0;
        progressBar=(ProgressBar)findViewById(R.id.myProgress);
        progressBar.setMax(100);
        
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(progressStatus<100)
				{
					progressStatus=performTask();
					myHandler.post(new Runnable()
					{
					public void run() {
					progressBar.setProgress(progressStatus);
					}
					});
					
				}
				myHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					   Toast.makeText(getBaseContext(),"Task Completed",Toast.LENGTH_LONG).show();
	                   progressStatus=0; 
	                   myProgress=0;
						
					}
				});
				
			}
			private int performTask()
			{
				try {
					//---Do some task---
					Thread.sleep(100);
					} catch (InterruptedException e)
					{
					e.printStackTrace();
					}
					return ++myProgress;	
			}
		}).start();
   }
}
