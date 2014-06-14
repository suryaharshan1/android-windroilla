package com.nandini.introscreen;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {
	
	EditText personsEmail, intro, personsName, Things, Action,
			outro;
	String emailAdd, beginning, name, sAction, Act, out;
	Button sendEmail;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVars();
		sendEmail.setOnClickListener(this);
	}
	private void initializeVars() {
		// TODO Auto-generated method stub
		personsEmail = (EditText) findViewById(R.id.etEmails);
		intro = (EditText) findViewById(R.id.etIntro);
		personsName = (EditText) findViewById(R.id.etName);
		Things = (EditText) findViewById(R.id.etThings);
		Action = (EditText) findViewById(R.id.etAction);
		outro = (EditText) findViewById(R.id.etOutro);
		sendEmail = (Button) findViewById(R.id.bSentEmail);
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		convertEditTextVarsIntoStrings();
		String emailaddress[] = { emailAdd };
		String message = "Well hello "
				+ name
				+ beginning
				+ Action
				+ Act
				+ out;
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Complaint");
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		
		
		
	try{
			startActivity(emailIntent);
		}catch(Exception e){
			e.printStackTrace();
		}
			
			
	}
	private void convertEditTextVarsIntoStrings() {
		// TODO Auto-generated method stub
		emailAdd = personsEmail.getText().toString();
		beginning = intro.getText().toString();
		name = personsName.getText().toString();
	    sAction = Things.getText().toString();
		Act = Action.getText().toString();
		out = outro.getText().toString();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
