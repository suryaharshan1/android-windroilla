package com.littleturn.listview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoViewFragment extends Fragment implements OnPreparedListener, MediaController.MediaPlayerControl{
	VideoView vv;
	String dir;
	MediaController mc;
	Handler handler = new Handler();
	int stopDuration = 0;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Bundle args = getArguments();
		dir = args.getString("directory");
		View rootView = inflater.inflate(R.layout.video_view, container, false);
		
		mc = new MediaController(getActivity());
		
		vv = (VideoView) rootView.findViewById(R.id.videoView);
		vv.setMediaController(mc);
		try{
		vv.setVideoPath(dir);
		vv.start();
		}
		catch(Exception e){
			Toast.makeText(getActivity(), "Video cannot be played", Toast.LENGTH_SHORT).show();
		}
		
		rootView.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				mc.show();
				return false;
			}
		});

		return rootView;
	}
	
	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		mc.setMediaPlayer(vv);
		mc.setAnchorView(vv);
		handler.post(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mc.setEnabled(true);
				mc.show();
			}
		});
		
	}
	
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		stopDuration = vv.getCurrentPosition();
		vv.pause();
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		vv.seekTo(stopDuration);
		vv.start();
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		vv.start();
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		vv.pause();
	}
	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return vv.getDuration();
	}
	@Override
	public int getCurrentPosition() {
		// TODO Auto-generated method stub
		return vv.getCurrentPosition();
	}
	@Override
	public void seekTo(int pos) {
		// TODO Auto-generated method stub
		vv.seekTo(pos);
	}
	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return vv.isPlaying();
	}
	@Override
	public int getBufferPercentage() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean canPause() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean canSeekBackward() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean canSeekForward() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public int getAudioSessionId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
