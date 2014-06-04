package com.littleturn.database;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlaceholderFragment extends Fragment {
	private static EditText ed1,ed2;
	public static Activity fa;
	
	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		fa = getActivity();
		final Button signin =  (Button) rootView.findViewById(R.id.signin);
		final Button signup = (Button) rootView.findViewById(R.id.signup);
		ed1 = (EditText) rootView.findViewById(R.id.editText1);
		ed2 = (EditText) rootView.findViewById(R.id.editText2);
		signin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SQLiteDatabase db = getActivity().openOrCreateDatabase("userinfo", 0, null);
				
				db.execSQL("create table if not exists signin (uname varchar ,pass varchar);");
				String un = ed1.getText().toString();
				String pw = ed2.getText().toString();
				Cursor cs = db.rawQuery("select * from signin where uname = '"+un+"' and pass = '"+pw+"'" , null);
				if (cs.getCount() > 0){
					Toast.makeText(getActivity(), "LOGGED IN", Toast.LENGTH_LONG).show();
					((MyApplicationData) getActivity().getApplication()).setUserName(un);
					Intent it = new Intent(getActivity(),UserInfo.class);
					startActivity(it);
				}
				else
					Toast.makeText(getActivity(), "INVALID USERNAME OR PASSWORD", Toast.LENGTH_LONG).show();
				db.close();
			}
		});
		signup.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SQLiteDatabase db = getActivity().openOrCreateDatabase("userinfo", 0, null);
				
				db.execSQL("create table if not exists signin (uname varchar ,pass varchar);");
				String un = ed1.getText().toString();
				String pw = ed2.getText().toString();
				int check = db.rawQuery("select * from signin where uname = '"+un+"' " , null).getCount();
				if (check > 0)
					Toast.makeText(getActivity(), "USERNAME ALREADY EXISTS, TRY ANOTHER", Toast.LENGTH_LONG).show();
				else{
					db.execSQL("insert into signin values('"+un+"','"+pw+"')");
					Toast.makeText(getActivity(), "SIGNED UP SUCCESSFULLY", Toast.LENGTH_LONG).show();
					}
				db.close();
			}
		});
		return rootView;
	}

}
