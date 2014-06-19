package com.littleturn.listview;

import java.io.IOException;

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
import android.widget.TextView;
import android.widget.Toast;

public class MediaViewFragment extends Fragment implements OnPreparedListener, MediaController.MediaPlayerControl {
	private String dir;
	MediaPlayer mp;
	MediaController mc;
	TextView song;
	Handler handler = new Handler();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View rootView = inflater.inflate(R.layout.audio_view, container, false);
		Bundle args = getArguments();
		dir = args.getString("directory");
		
		song = (TextView)rootView.findViewById(R.id.songname);
		song.setText(dir.substring(dir.lastIndexOf('/') + 1));
		
		mp = new MediaPlayer();
		mp.setOnPreparedListener(this);
		
		 mc = new MediaController(getActivity());
		
		 try{
		 mp.setDataSource(dir);
		 mp.prepare();
		 mp.start();
		 }
		 catch(IOException e){
			 Toast.makeText(getActivity(), "FILE CANNOT BE OPENED", Toast.LENGTH_SHORT).show();
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
		mc.setMediaPlayer(this);
		mc.setAnchorView(getView().findViewById(R.id.main_audio_view));
		
		handler.post(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mc.setEnabled(true);
				mc.show();
			}
		});
	}
	
	@Override
	public void onStop() {
	    super.onStop();
	    mc.hide();
	    mp.stop();
	    mp.release();
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		mp.start();
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		mp.pause();
	}
	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return mp.getDuration();
	}
	@Override
	public int getCurrentPosition() {
		// TODO Auto-generated method stub
		return mp.getCurrentPosition();
	}
	@Override
	public void seekTo(int pos) {
		// TODO Auto-generated method stub
		mp.seekTo(pos);
	}
	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return mp.isPlaying();
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
