package com.littleturn.listview;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {
	private final Activity context;
	private final ArrayList<String> web;
	private final ArrayList<File> file;
	public CustomList(Activity context,ArrayList<String> web,ArrayList<File> file){
		super(context,R.layout.custom_listitem, web);
		this.context = context;
		this.web = web;
		this.file = file;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.custom_listitem, null, true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.itemtxt);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.itemimg);
		txtTitle.setText(web.get(position));
		String path = file.get(position).getPath();
		if(file.get(position).isDirectory())
			imageView.setImageResource(R.drawable.folder);
		else if(path.endsWith(".txt") || path.endsWith(".c")
				|| path.endsWith(".cpp") || path.endsWith(".java")
				|| path.endsWith(".py") || path.endsWith(".xml"))
			imageView.setImageResource(R.drawable.text);
		else if(path.endsWith(".jpg") || path.endsWith(".png"))
			imageView.setImageResource(R.drawable.image);
		else if(path.endsWith(".mp4"))
			imageView.setImageResource(R.drawable.videos);
		else if(path.endsWith(".mp3") || path.endsWith(".m4a"))
			imageView.setImageResource(R.drawable.music);
		else
			imageView.setImageResource(R.drawable.file);
		
		return rowView;
	}
}
