package sat.example.logindatabase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends Activity{
	Button b1,bc;
	EditText e1,e2;
	TextView t;
	String su,sp;
	SQLiteDatabase db ;
	Cursor c;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
 	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.signup);
	b1=(Button)findViewById(R.id.button1);
	bc=(Button)findViewById(R.id.bCheck);
	e1=(EditText)findViewById(R.id.editText1);
	e2=(EditText)findViewById(R.id.editText2);
	t=(TextView)findViewById(R.id.textView1);
	 db  = openOrCreateDatabase("login", MODE_WORLD_WRITEABLE,null);
	db.execSQL("create table if not exists logindetails(luser VARCHAR,lpass VARCHAR)");
	b1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			   //get the details from edit texts
			 su=e1.getText().toString().trim();
			 sp=e2.getText().toString().trim();
			 
			  //check if the username exists already
			 c=db.rawQuery("select * from logindetails", null); //get all the records
			  boolean flag=true;
			     while(c.moveToNext()){
			    	 if(c.getString(0).equals(su)){
			    		 Toast.makeText(getApplicationContext(), "username already exits", Toast.LENGTH_SHORT).show();
			    		 flag=false;
			    		 e1.setText("");
			    		 e1.setText("");
			    		 t.setText("Choose different username");
			    		 t.setTextColor(Color.RED);
			    		 break;
			    	 }
			     }
			     
			     // if the username does not exist create the record
			     if(flag){
			    	 db.execSQL("insert into logindetails values('"+su+"','"+sp+"')");
			    	 Toast.makeText(getApplicationContext(), "Account Created.", Toast.LENGTH_LONG).show();
			    	 Intent i = new Intent(SignupActivity.this,MainActivity.class);
			    	 startActivity(i);
			     }
			 
		
			 
		}
	});
	bc.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 c=db.rawQuery("select * from logindetails", null);
			 
			 while(c.moveToNext()){
				 su=c.getString(0);
				 sp=c.getString(1);
				 Toast.makeText(getApplicationContext(), "username: "+su+" pass: "+sp, Toast.LENGTH_SHORT).show();
			 }
		}
	});
	
   }
   
  
   
}
