package sat.example.appswithlist;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	String s[]={"(+)Sum","->Swap<-","-->Seekbar","--*ProgressBar","!!!Notification","|->Login",">>>LifeCycle","#OptionalMenu","||ContextMenu","**ssword"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.mylayout, s));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
   @Override
   protected void onListItemClick(ListView l, View v, int position, long id) {
	// TODO Auto-generated method stub
	   super.onListItemClick(l, v, position, id);
	   switch (position) {
	   case 0:
		 Intent i1=new Intent("SUM");
		 startActivity(i1);
		break;
	   case 1:
			 Intent i2=new Intent("SWAP");
			 startActivity(i2);
			break;
	   case 2:
			 Intent i3=new Intent("SEEK");
			 startActivity(i3);
			break;
	   case 3:
			 Intent i4=new Intent("PROG");
			 startActivity(i4);
			break;
	   case 4:
			 Intent i5=new Intent("NOTF");
			 startActivity(i5);
			break;
	   case 5:
			 Intent i6=new Intent("LOGI");
			 startActivity(i6);
			break;
	   case 6:
			 Intent i7=new Intent("LYCY");
			 startActivity(i7);
			break;
	   case 7:
			 Intent i8=new Intent("OPTN");
			 startActivity(i8);
			break;
	   case 8:
			 Intent i9=new Intent("CONT");
			 startActivity(i9);
			break;
	   case 9:
			 Intent i10=new Intent("PASS");
			 startActivity(i10);
			break;
	   default:
		break;
	   }
   }
    
}
