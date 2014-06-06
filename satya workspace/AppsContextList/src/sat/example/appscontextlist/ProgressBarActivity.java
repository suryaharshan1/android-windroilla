package sat.example.appscontextlist;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarActivity extends Activity{
	Button b,b2;
    EditText e;
    TextView t;
    int max;
    ProgressBar p;
    int progress=0,status=0;
    Handler myHandler=new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressbar_layout);
		  b= (Button) findViewById(R.id.button1);
	        b2= (Button) findViewById(R.id.button2);
	        e= (EditText)findViewById(R.id.editText1);
	        t= (TextView) findViewById(R.id.textView2);
	        p=(ProgressBar) findViewById(R.id.myProgress);
	        e.setText("100"); 
	       
	        b.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					status=0;
					progress=0;
				max=Integer.parseInt(e.getText().toString());
				 p.setMax(max);
					new Thread(new Runnable(){
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							while(status<max)
							{
								status=performTask();
								myHandler.post(new Runnable()
								{
								public void run() {
								p.setProgress(status);
								}
								});
								
							}
							myHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
								   Toast.makeText(getBaseContext(),"Task Completed",Toast.LENGTH_LONG).show();
				                //   status=0; 
				                   progress=0;
									
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
								return ++progress;	
						}
						
					}).start();
				}
			});
	        
	        
	        b2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					t.setText(status+"/"+max);
				}
			});

		
	}

}
