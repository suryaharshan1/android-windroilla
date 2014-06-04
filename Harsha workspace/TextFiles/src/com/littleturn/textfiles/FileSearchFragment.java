package com.littleturn.textfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FileSearchFragment extends Fragment {
		private static EditText filename;
		private static EditText findtext;
		private static int count = 0;
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			//return super.onCreateView(inflater, container, savedInstanceState);
			View rootView = inflater.inflate(R.layout.fragment_main, container,false);
			filename = (EditText) rootView.findViewById(R.id.filename);
			findtext = (EditText) rootView.findViewById(R.id.findtext);
			final Button submit = (Button) rootView.findViewById(R.id.submit);
			submit.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String fn = filename.getText().toString();
					String st = findtext.getText().toString();
					File fp = Environment.getExternalStorageDirectory();
					try{
						File file = new File(fp.getPath() + "/" + fn);
						FileInputStream fis = new FileInputStream(file);
						Toast.makeText(getActivity(), "FILE OPENED", Toast.LENGTH_SHORT).show();
						Scanner s = new Scanner(fis);
						if(file.length() == 0)
							Toast.makeText(getActivity(), "EMPTY FILE", Toast.LENGTH_SHORT).show();
						else{
							String ft = s.nextLine();
							int a = 0;
							while(a > -1){
								ft += " " + s.nextLine();
								a = fis.read();
							}
							Toast.makeText(getActivity(), ft, Toast.LENGTH_SHORT).show();
							String word[] = ft.split(" ");
							for(int i = 0; i < word.length; i++){
								if(word[i].equals(st))
									count++;
							}
							Toast.makeText(getActivity(), count + "", Toast.LENGTH_SHORT).show();
							count = 0;
						}
						s.close();
						fis.close();
					}
					catch(FileNotFoundException e){
						Toast.makeText(getActivity(), "FILE NOT FOUND", Toast.LENGTH_SHORT).show();
					}
					catch(Exception e){
						
					}
				}
			});
			return rootView;
		}
}
