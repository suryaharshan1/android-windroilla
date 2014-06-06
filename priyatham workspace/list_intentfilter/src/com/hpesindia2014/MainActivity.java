package com.hpesindia2014;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity{

	String s[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		s=getResources().getStringArray(R.array.allapps);
		setListAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,s));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		switch (position) {
		case 0:
			//Toast.makeText(getApplicationContext(), "selected sum", Toast.LENGTH_LONG).show();
			Intent i1=new Intent("SUM");
			startActivity(i1);
			break;
		case 1:
			Intent i2=new Intent("swap");
			startActivity(i2);
			Toast.makeText(getApplicationContext(), "selected swap", Toast.LENGTH_LONG).show();
			break;
		case 2:
			Intent i3=new Intent("password");
			startActivity(i3);
			Toast.makeText(getApplicationContext(), "selected toggle password", Toast.LENGTH_LONG).show();
			break;
		case 3:
			Intent i4=new Intent("radiobutton");
			startActivity(i4);
			Toast.makeText(getApplicationContext(), "selected radio button", Toast.LENGTH_LONG).show();
			break;
		case 4:
			Intent i5=new Intent("CHECKBOX");
			startActivity(i5);
			Toast.makeText(getApplicationContext(), "selected checkbox", Toast.LENGTH_LONG).show();
			break;
		case 5:
			Intent i6=new Intent("seekbar");
			startActivity(i6);
			Toast.makeText(getApplicationContext(), "selected seekbar", Toast.LENGTH_LONG).show();
			break;
		case 6:
			Intent i7=new Intent("progressbar");
			startActivity(i7);
			Toast.makeText(getApplicationContext(), "selected progressbar", Toast.LENGTH_LONG).show();
			break;
		case 7:
			Intent i8=new Intent("notification");
			startActivity(i8);
			Toast.makeText(getApplicationContext(), "selected notification", Toast.LENGTH_LONG).show();
			break;
		case 8:
			Intent i9=new Intent("notificationbuilder");
			startActivity(i9);
			Toast.makeText(getApplicationContext(), "selected notification builder", Toast.LENGTH_LONG).show();
			break;
		case 9:
			Intent i10=new Intent("login");
			startActivity(i10);
			Toast.makeText(getApplicationContext(), "selected login", Toast.LENGTH_LONG).show();
			break;
		case 10:
			Intent i11=new Intent("optionalmenu");
			startActivity(i11);
			Toast.makeText(getApplicationContext(), "selected optional menu", Toast.LENGTH_LONG).show();
			break;
		case 11:
			Intent i12=new Intent("optionalmenuhelper");
			startActivity(i12);
			Toast.makeText(getApplicationContext(), "selected optional menu-helper", Toast.LENGTH_LONG).show();
			break;
		case 12:
			Intent i13=new Intent("contextmenu");
			startActivity(i13);
			Toast.makeText(getApplicationContext(), "selected context menu", Toast.LENGTH_LONG).show();
			break;
		case 13:
			Intent i14=new Intent("contextmenuhelper");
			startActivity(i14);
			Toast.makeText(getApplicationContext(), "selected contextmenu-helper", Toast.LENGTH_LONG).show();
			break;
		case 14:
			Intent i15=new Intent("lifecycle");
			startActivity(i15);
			Toast.makeText(getApplicationContext(), "selected life cycle", Toast.LENGTH_LONG).show();
			break;
		case 15:
			Intent i16=new Intent("listactivity");
			startActivity(i16);
			Toast.makeText(getApplicationContext(), "selected listactivity", Toast.LENGTH_LONG).show();
			break;
		case 16:
			Intent i17=new Intent("intent");
			startActivity(i17);
			Toast.makeText(getApplicationContext(), "selected intent", Toast.LENGTH_LONG).show();
			break;
		default:
			break;
		}
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
