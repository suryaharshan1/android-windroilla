package com.example.tasks.categories;

import java.util.ArrayList;
import java.util.List;

import com.example.tasks.CustomAdapter;
import com.example.tasks.R;
import com.example.tasks.RowItem;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MonthlyCls extends Fragment {
	List<RowItem> rowItems;
    RowItem itemData;
    CustomAdapter adapter;
    SQLiteDatabase db;
    Cursor cu;
    View rootView;
    ListView l1;
	@Override
	   public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		  	rootView =inflater.inflate(R.layout.monthly, container,false);
		  	rowItems = new ArrayList<RowItem>();
	        l1=(ListView)rootView.findViewById(R.id.listmonthly);
	        adapter = new CustomAdapter(getActivity(), rowItems);
	        l1.setAdapter(adapter);
	        
	        //========================================
	        db  = getActivity().openOrCreateDatabase("tasks", getActivity().MODE_WORLD_WRITEABLE,null);
	        db.execSQL("create table if not exists tasksdetails(name VARCHAR,time VARCHAR,priority VARCHAR,category VARCHAR)");
	        //db.execSQL("drop table tasksdetails");
	        cu= db.rawQuery("select * from tasksdetails where category ='MONTHLY' and priority ='HIGH'", null); // null is for mode.
	        
	        while(cu.moveToNext()){
	        	RowItem item = new RowItem(R.drawable.high,""+cu.getString(0),""+cu.getString(1),cu.getString(2),"("+cu.getString(3)+")");
	        	rowItems.add(item);
	        	adapter.notifyDataSetChanged();
	        }
	        cu= db.rawQuery("select * from tasksdetails where category ='MONTHLY' and priority ='NORMAL'", null); // null is for mode.
	        
	        while(cu.moveToNext()){
	        	RowItem item = new RowItem(R.drawable.normal,""+cu.getString(0),""+cu.getString(1),cu.getString(2),"("+cu.getString(3)+")");
	        	rowItems.add(item);
	        	adapter.notifyDataSetChanged();
	        }
	        cu= db.rawQuery("select * from tasksdetails where category ='MONTHLY' and priority ='LOW'", null); // null is for mode.
	        
	        while(cu.moveToNext()){
	        	RowItem item = new RowItem(R.drawable.low,""+cu.getString(0),""+cu.getString(1),cu.getString(2),"("+cu.getString(3)+")");
	        	rowItems.add(item);
	        	adapter.notifyDataSetChanged();
	        }
		  return rootView;
	   }
}
