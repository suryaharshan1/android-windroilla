package com.littleturn.listview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageViewFragment extends Fragment {
	ImageView iv;
	String dir;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.image_view, container, false);
		Bundle args = getArguments();
		dir = args.getString("directory");
		iv = (ImageView) rootView.findViewById(R.id.imageview);
		Bitmap bmp = BitmapFactory.decodeFile(dir);
		iv.setImageBitmap(bmp);
		return rootView;
	}
	
}
