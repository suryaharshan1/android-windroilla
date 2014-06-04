package sat.example.optionalmenu_j;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button b;
    EditText e;
    int id=3;
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main, menu);
    	createMenu(menu);
    	b=(Button)findViewById(R.id.button1);
        e=(EditText)findViewById(R.id.editText1);
        
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				s1=e.getText().toString();
				createMenuItemOnClick(menu, id, s1);
				id++;
				e.setText("");
				Toast.makeText(getApplicationContext(), "item "+s1+" added", Toast.LENGTH_LONG).show();
			}
		});
    	
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	itemSelected(item);
    	return super.onOptionsItemSelected(item);
    }
    
    
   
    
    //helper function that creates menuitems
    public void createMenu(Menu menu){                //helper function
    	MenuItem m1=menu.add(0,1,1,"item1");
    	{                                             //braces here increases readability thats all :P
    		m1.setIcon(R.drawable.ic_launcher);
    	}
    	MenuItem m2=menu.add(0,2,2,"item2");
    	{
    		m2.setIcon(R.drawable.ic_launcher);
    	}
    }
    
    
    //helper function to respond on click of the menu item
    public void itemSelected(MenuItem mi){
    	switch (mi.getItemId()) {
		case 1:
			Toast.makeText(getApplicationContext(), "item1 Selected", Toast.LENGTH_LONG).show();
			break;
		case 2:
			Toast.makeText(getApplicationContext(), "item2 Selected", Toast.LENGTH_LONG).show();
			break;
		default:
			break;
		}
    }
    
    //function to add menuitem to menu on click of the button
    public void createMenuItemOnClick(Menu menu,int id,String Title){
    	MenuItem m=menu.add(0, id, id, Title);{
    		m.setIcon(R.drawable.ic_launcher);
    	}
    //	MenuItem n=menu.removeItem(id);      for removing the item
    }
    
}
