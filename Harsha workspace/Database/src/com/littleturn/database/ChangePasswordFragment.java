package com.littleturn.database;

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

public class ChangePasswordFragment extends Fragment {
	private static EditText oldpass,newpass,repass;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.changepassword, container, false);
		oldpass = (EditText) rootView.findViewById(R.id.oldpassword);
		newpass = (EditText) rootView.findViewById(R.id.newpassword);
		repass = (EditText) rootView.findViewById(R.id.retypepassword);
		final Button changepass = (Button) rootView.findViewById(R.id.changepassword);
		changepass.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String uname = ((MyApplicationData)getActivity().getApplication()).getUserName();
				String upass = oldpass.getText().toString();
				String npass = newpass.getText().toString();
				String rpass = repass.getText().toString();
				
				SQLiteDatabase db = getActivity().openOrCreateDatabase("userinfo", 0, null);
				db.execSQL("create table if not exists signin (uname varchar ,pass varchar);");
				Cursor cs = db.rawQuery("select * from signin where uname = '"+uname+"' and pass = '"+upass+"'" , null);
				if (cs.getCount() > 0){
					if(npass.equals(rpass)){
						db.execSQL("update signin set pass = '"+npass+"' where uname = '"+uname+"'");
						Toast.makeText(getActivity(), "Password Changed", Toast.LENGTH_SHORT).show();
						getFragmentManager().popBackStackImmediate();
					}
					else 
						Toast.makeText(getActivity(), "NEW PASSWORDS DO NOT MATCH", Toast.LENGTH_LONG).show();
				}
				else
					Toast.makeText(getActivity(), "INCORRECT PASSWORD", Toast.LENGTH_LONG).show();
				db.close();
			
			}
		});
		return rootView;
	}
}
