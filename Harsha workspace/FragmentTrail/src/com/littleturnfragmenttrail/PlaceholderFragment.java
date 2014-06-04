package com.littleturnfragmenttrail;
import com.littleturnfragmenttrail.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class PlaceholderFragment extends Fragment implements OnSeekBarChangeListener{
	private static int seekvalue = 10;
	private static EditText edittext;
	private static TextView textview;
	PlaceholderListener activityCallback;
	
	public interface PlaceholderListener{
		
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		try{
			activityCallback = (PlaceholderListener) activity;
		}
		catch(Exception e){
			throw new ClassCastException(activity.toString() + " must implement ToolbarListener");
		}
	}

	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		edittext = (EditText) rootView.findViewById(R.id.editText1);
		textview = (TextView) rootView.findViewById(R.id.textView1);
		final SeekBar seekbar = (SeekBar) rootView.findViewById(R.id.seekBar1);
		seekbar.setOnSeekBarChangeListener(this);
		final Button button = (Button) rootView.findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textview.setTextSize(seekvalue);
				textview.setText(edittext.getText().toString());
			}
		});
		return rootView;
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		seekvalue = progress;
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
}
