package com.littleturn.listview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

public class VideoViewFragment extends Fragment {
	VideoView vv;
	String dir;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Bundle args = getArguments();
		dir = args.getString("directory");
		View rootView = inflater.inflate(R.layout.video_view, container, false);
		vv = (VideoView) rootView.findViewById(R.id.videoView);
		vv.setVideoPath(dir);
		vv.start();
		return rootView;
	}
}
