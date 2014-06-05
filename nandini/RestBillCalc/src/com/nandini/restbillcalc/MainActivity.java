// You have to change this to YOUR own package name
package com.nandini.restbillcalc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        Button calc = (Button)findViewById(R.id.btnCalculate);
        calc.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText number = (EditText)findViewById(R.id.num);
                TextView display = (TextView)findViewById(R.id.display);

                double num = Double.parseDouble(number.getText().toString());

                // first option
                num = num * 5;

                // second option (using static method)
                num = Double.parseDouble(samplecalc.multNum(num));

                // third option (using instance method)
                samplecalc x = new samplecalc(num);
                num = x.multNum2();

                display.setText(num + "");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}

