package sat.example.appscontextlist;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarActivity extends Activity{
	Button b;
	 SeekBar s,s2;
	   TextView t,t2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seekbar_layout);
		 s=(SeekBar) findViewById(R.id.seekBar1);
	        s2=(SeekBar) findViewById(R.id.seekBar2);
	        //android:max="10" in xml file to set the limit
	        t=(TextView) findViewById(R.id.textView2);
	        t2=(TextView) findViewById(R.id.textView3);
		b=(Button) findViewById(R.id.button1);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  Intent i=new Intent(SeekBarActivity.this,MainActivity.class);
			  startActivity(i);
			}
		});
		
		 s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					// TODO Auto-generated method stub
					 t.setText("" + progress + "%");
				}
			});
	 s2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					// TODO Auto-generated method stub
					 t2.setText("" + progress);
				}
			});
		
	}
}
