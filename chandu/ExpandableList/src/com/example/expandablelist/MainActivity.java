package com.example.expandablelist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		expListView=(ExpandableListView) findViewById(R.id.lvExp);
		prepareListData();
		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
		expListView.setAdapter(listAdapter);

	}

	private void prepareListData(){
		listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        
        listDataHeader.add("LittleTurn");
        listDataHeader.add("android");
        List<String> LittleTurn = new ArrayList<String>();
        LittleTurn.add("Harsha");
        LittleTurn.add("VishnuPriya");
        LittleTurn.add("Chandra Sekhar");
        LittleTurn.add("SatyKumar");
        LittleTurn.add("Lakshya Garg");
        LittleTurn.add("Nandini");
        LittleTurn.add("Abhishek Anand");
        LittleTurn.add("Priyatham Kumar");
        
        List<String> Android = new ArrayList<String>();
        Android.add("Chandu");
        Android.add("Satya");
        Android.add("Priyatham");
        Android.add("Harsha");
        
        listDataChild.put(listDataHeader.get(0), LittleTurn);
        listDataChild.put(listDataHeader.get(1), Android);
	}

}
