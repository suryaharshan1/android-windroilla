package sat.example.appscontextlist;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

public class SwapActivity extends Activity{
	Button b;
	ToggleButton t1,t2;
	EditText text1,text2;
	String s1,s2;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.swap_layout);
        t1=(ToggleButton) findViewById(R.id.toggleButton1);
        t2=(ToggleButton) findViewById(R.id.toggleButton2);
        text1=(EditText) findViewById(R.id.editText1);
        text2=(EditText) findViewById(R.id.editText2);
       t2.setChecked(true);
    	b= (Button)findViewById(R.id.button1);
    	b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    Intent i = new Intent(SwapActivity.this,MainActivity.class);
			    startActivity(i);
			}
		});
    	
    	
    	 t1.setOnClickListener(new  View.OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				 s1=text1.getText().toString();
 			        s2=text2.getText().toString();
 				// TODO Auto-generated method stub
 				if(t1.isChecked()){
 					t2.setChecked(false);
 					text1.setText(s2);
 					text2.setText(s1);
 				}else{
 					t2.setChecked(true);
 					text1.setText(s2);
 					text2.setText(s1);
 				}
 				
 			}
 		});
         
        t2.setOnClickListener(new  View.OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				 s1=text1.getText().toString();
 			        s2=text2.getText().toString();
 				if(t2.isChecked()){
 					t1.setChecked(false);
 					text1.setText(s2);
 					text2.setText(s1);
 				}else{
 					t1.setChecked(true);
 					text1.setText(s2);
 					text2.setText(s1);
 				}
 				
 			}
 		});
         
         
     
    }
}
