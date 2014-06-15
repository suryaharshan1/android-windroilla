package sat.example.logindatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class ProfileActivity extends Activity{
	
	Button b1; // work button
	TextView t1,t2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		t1=(TextView)findViewById(R.id.ptUser);
		t2=(TextView)findViewById(R.id.ptPass);
		t1.setText(getIntent().getExtras().getString("user"));
		t2.setText(getIntent().getExtras().getString("pass"));
		
	}
}
