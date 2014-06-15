package sat.example.logindatabase;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button b1,b2;
	EditText e1,e2;
	SQLiteDatabase db;
	Cursor c;
	String user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.bLogin);   // login button
        b2=(Button)findViewById(R.id.bSignup);  // signup button
        e1=(EditText)findViewById(R.id.eUser); // username field
        e2=(EditText)findViewById(R.id.ePass); // password field
        db  = openOrCreateDatabase("login", MODE_WORLD_WRITEABLE,null);
        db.execSQL("create table if not exists logindetails(luser VARCHAR,lpass VARCHAR)");
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//get the username and apswword from editexts
				user=e1.getText().toString();
				pass=e2.getText().toString();
				//creating cursor
				c=db.rawQuery("select * from logindetails", null);
				boolean flag=true;
				//checking login properties
				while(c.moveToNext()){
					if(c.getString(0).equals(user) && c.getString(1).equals(pass)){
						Toast.makeText(getApplicationContext(), "login suceesful", Toast.LENGTH_SHORT).show();
						Intent i = new Intent(MainActivity.this,ProfileActivity.class);
						i.putExtra("user", user);
						i.putExtra("pass", pass);
						startActivity(i);
						flag=false;
						break;
					}
				}
				
					if(flag){
						Toast.makeText(getApplicationContext(), "login unsuccesful", Toast.LENGTH_SHORT).show();	
					}
						
				
					
				
			}
		}); 
        
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity.this,SignupActivity.class);
				startActivity(i);
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
