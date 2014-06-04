package com.littleturn.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.littleturn.quiz.MESSAGE";
	int score = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	//Method to count the score of a individual question
	//Pass the correct answers as arg[0] and arg[2]
	public void count(CheckBox a1,CheckBox a2,CheckBox a3,CheckBox a4){
		if(a1.isChecked() && !a2.isChecked() && a3.isChecked() && !a4.isChecked()){
			score += 2;
		}
		else if(a1.isChecked() && !a2.isChecked() && !a3.isChecked() && !a4.isChecked()){
			score++;
		}
		else if(!a1.isChecked() && !a2.isChecked() && a3.isChecked() && !a4.isChecked()){
			score++;
		}
	}
	
	public void check(View v){
	
			count((CheckBox)findViewById(R.id.q1a),
					(CheckBox)findViewById(R.id.q1b),
					(CheckBox)findViewById(R.id.q1c),
					(CheckBox)findViewById(R.id.q1d));
			
			count((CheckBox)findViewById(R.id.q2a),
					(CheckBox)findViewById(R.id.q2b),
					(CheckBox)findViewById(R.id.q2c),
					(CheckBox)findViewById(R.id.q2d));
			
			count((CheckBox)findViewById(R.id.q3a),
					(CheckBox)findViewById(R.id.q3b),
					(CheckBox)findViewById(R.id.q3c),
					(CheckBox)findViewById(R.id.q3d));
			
			count((CheckBox)findViewById(R.id.q4a),
					(CheckBox)findViewById(R.id.q4b),
					(CheckBox)findViewById(R.id.q4c),
					(CheckBox)findViewById(R.id.q4d));
			
			//Toast.makeText(this, "Your Score is " + score, Toast.LENGTH_LONG).show();
			Intent it = new Intent(this,ResultActivity.class);
			it.putExtra(EXTRA_MESSAGE,"Your score is " + score);
			startActivity(it);
			score = 0;
	}

}
