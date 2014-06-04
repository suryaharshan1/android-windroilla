package com.littleturn.calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

	EditText ed;
	TextView tv,opc;
	Button plus,res;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed = (EditText)findViewById(R.id.input);
		tv = (TextView)findViewById(R.id.inter);
		opc = (TextView)findViewById(R.id.opcode);
}
	
	char opcode;
	public int calculate(){
		int x,y,z = 0;
		x = Integer.parseInt(tv.getText().toString().trim());
		y = Integer.parseInt(ed.getText().toString().trim());
		if(opcode == '+'){
			z = x + y;
		}
		else if(opcode == '-'){
			z = x - y;
		}
		else if(opcode == '*'){
			z = x * y;
		}
		else if(opcode == '/'){
			if(y != 0)
				z = x / y;
			else {
				Toast.makeText(this, "cannot divide by zero", Toast.LENGTH_LONG).show();
			}
		}
		return z;
	}
	
	public void operation(char symbol){
		int z;
		if(tv.getText().toString().isEmpty()){
			tv.setText(ed.getText().toString());
		}
		else if(!ed.getText().toString().isEmpty()){
			z = calculate();
			tv.setText("" + z);
		}
		opcode = symbol;
		opc.setText(opcode + "");
		ed.setText("");
	}
	
	public void btclick(View v){
		int z = 0;
		switch(v.getId())
		{
			case R.id.plus:
				operation('+');
				break;
			case R.id.subtract:
				operation('-');
				break;
			case R.id.multiply:
				operation('*');
				break;
			case R.id.divide:
				operation('/');
				break;
			
			case R.id.equal:
				if(ed.getText().toString().isEmpty()){
					ed.setText(tv.getText().toString());
				}
				else if(tv.getText().toString().isEmpty()){
					
				}
				else{
					z = calculate();
					ed.setText("" + z);
					
				}
				tv.setText("");
				opcode = ' ';
				opc.setText(opcode + "");
				break;
				
			case R.id.cancel:
				ed.setText("");
				tv.setText("");
				opc.setText("");
				break;
		}
	}
}