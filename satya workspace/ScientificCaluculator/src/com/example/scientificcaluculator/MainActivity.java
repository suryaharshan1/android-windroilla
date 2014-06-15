package com.example.scientificcaluculator;

import java.util.Stack;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,badd,bsub,bmul,bdiv,bclr,bdel,bsos,bpnt,bmc,bmr,bmp,beql;
    EditText t;
    String s="";
    int answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0=(Button)findViewById(R.id.button0);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        b7=(Button)findViewById(R.id.button7);
        b8=(Button)findViewById(R.id.button8);
        b9=(Button)findViewById(R.id.button9);
        badd=(Button)findViewById(R.id.buttonplus);
        bsub=(Button)findViewById(R.id.buttonsub);
        bmul=(Button)findViewById(R.id.buttonmul);
        bdiv=(Button)findViewById(R.id.buttondiv);
        bclr=(Button)findViewById(R.id.buttonclr);
        bdel=(Button)findViewById(R.id.buttondel);
        bsos=(Button)findViewById(R.id.buttonsos);
        bpnt=(Button)findViewById(R.id.buttonprcnt);
        bmc=(Button)findViewById(R.id.buttonmc);
        bmr=(Button)findViewById(R.id.buttonmr);
        bmp=(Button)findViewById(R.id.buttonmplus);
        beql=(Button)findViewById(R.id.buttoneql);
        
        t=(EditText)findViewById(R.id.textView1);
        b0.setOnClickListener(new View.OnClickListener() {

			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"0";
			  t.setText(s);
			}
		});
        
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"1";
			  t.setText(s);
			}
		});
        
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"2";
			  t.setText(s);
			}
		});
    
        b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"3";
			  t.setText(s);
			}
		});
    
        b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"4";
			  t.setText(s);
			}
		});
        
        b5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"5";
			  t.setText(s);
			}
		}); 

        b6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"6";
			  t.setText(s);
			}
		});
        
        b7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"7";
			  t.setText(s);
			}
		});

        b8.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"8";
			  t.setText(s);
			}
		});

        b9.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"9";
			  t.setText(s);
			}
		});

        badd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"+";
			  t.setText(s);
			}
		});

        bsub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"-";
			  t.setText(s);
			}
		});

        bmul.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"*";
			  t.setText(s);
			}
		});
        
        bdiv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"/";
			  t.setText(s);
			}
		});
        
        bclr.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s="";
			  t.setText(s);
			}
		});

        bdel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(s.length()>0){
					s=s.substring(0, s.length()-1);
				}
			  
			  t.setText(s);
			}
		});

        bpnt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  s=s+"%";
			  t.setText(s);
			}
		});
        
        beql.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		/*		 Toast.makeText(getApplicationContext(), "before scripts loaded", Toast.LENGTH_SHORT).show();
				ScriptEngineManager mgr = new ScriptEngineManager();
			    ScriptEngine engine = mgr.getEngineByName("JavaScript");
			    Toast.makeText(getApplicationContext(), "scripts loaded", Toast.LENGTH_SHORT).show();
			  try {
				  answer = ((Number)engine.eval("2+3")).intValue();
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  s=""+answer;
			  t.setText(s); */
				s=""+calculate(t.getText().toString());
				t.setText(s);
				Toast.makeText(getApplicationContext(), "equal to", Toast.LENGTH_SHORT).show();
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public String calculate(String input){
    	
    	
    	Stack<Integer> op  = new Stack<Integer>();
        Stack<Double> val = new Stack<Double>();
        /* Create temporary stacks for operators and operands */
        Stack<Integer> optmp  = new Stack<Integer>();
        Stack<Double> valtmp = new Stack<Double>();
        /* Accept expression */
        
    //    String input = scan.next();
      //  input = "0" + input;
        input = input.replaceAll("-","+-");
        /* Store operands and operators in respective stacks */
        String temp = "";
        for (int i = 0;i < input.length();i++)
        {
            char ch = input.charAt(i);
            if (ch == '-')
                temp = "-" + temp;
            else if (ch != '+' &&  ch != '*' && ch != '/')
               temp = temp + ch;
            else
            {
                val.push(Double.parseDouble(temp));
                op.push((int)ch);
                temp = "";
            }
        }
        val.push(Double.parseDouble(temp));
        /* Create char array of operators as per precedence */
        /* -ve sign is already taken care of while storing */
        char operators[] = {'/','*','+'};
        /* Evaluation of expression */
        for (int i = 0; i < 3; i++)
        {
            boolean it = false;
            while (!op.isEmpty())
            {
                int optr = op.pop();
                double v1 = val.pop();
                double v2 = val.pop();
                if (optr == operators[i])
                {
                    /* if operator matches evaluate and store in temporary stack */
                    if (i == 0)
                    {
                        valtmp.push(v2 / v1);
                        it = true;
                        break;
                    }
                    else if (i == 1)
                    {
                        valtmp.push(v2 * v1);
                        it = true;
                        break;
                    }
                    else if (i == 2)
                    {
                        valtmp.push(v2 + v1);
                        it = true;
                        break;
                    }                                        
                }
                else
                {
                    valtmp.push(v1);
                    val.push(v2);
                    optmp.push(optr);
                }                
            }    
            /* Push back all elements from temporary stacks to main stacks */            
            while (!valtmp.isEmpty())
                val.push(valtmp.pop());
            while (!optmp.isEmpty())
                op.push(optmp.pop());
            /* Iterate again for same operator */
            if (it)
                i--;                            
        }    
     //   System.out.println("\nResult = "+val.pop()); 
    	
    	
		return ""+val.pop();
    	
    }
    
}
