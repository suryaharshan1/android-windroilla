package com.littleturn.listview;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageViewFragment extends Fragment {
	
	ImageView iv;
	String dir;
	ImageButton bt;
	Bitmap bmp;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.image_view, container, false);
		Bundle args = getArguments();
		dir = args.getString("directory");
		iv = (ImageView) rootView.findViewById(R.id.imageview);
		BitmapFactory.Options bto = new BitmapFactory.Options();
		bto.inMutable = true;
		bmp = BitmapFactory.decodeFile(dir, bto)
;		iv.setImageBitmap(bmp);
		bt = (ImageButton) rootView.findViewById(R.id.rotate);
		bt.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Matrix mat = new Matrix();
				
				Display display = getActivity().getWindowManager().getDefaultDisplay();
				Point size = new Point();
				display.getSize(size);
				float vw = size.x;
				float vh = size.y;
				float hvw = vw/2;
				float hvh = vh/2;
				mat.postTranslate(-hvw,-hvh);
				mat.postRotate(90);
				try{
				bmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(),mat,true);
				iv.setImageBitmap(bmp);
				}
				catch(OutOfMemoryError e){
					float bw = (float) bmp.getWidth();
					float bh = (float) bmp.getHeight();
					
					float s1x = vw/ bw;
					float s1y = vh / bh;
					float s1 = (s1x < s1y) ? s1x : s1y;
					mat.postScale(s1, s1);
					bmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(),mat,true);
					iv.setImageBitmap(bmp);
				}
				}
		});
		final Button wall = (Button) rootView.findViewById(R.id.setwall);
		wall.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SetWallpaperTask wall = new SetWallpaperTask(iv);
				wall.execute();
				/*new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						try{
							WallpaperManager wm = WallpaperManager.getInstance(getActivity());
							Bitmap bt = ((BitmapDrawable)iv.getDrawable()).getBitmap();
							if(bt != null)
								wm.setBitmap(bt);
						}catch(Exception e){
							Toast.makeText(getActivity(), "Cannot set as wallpaper", Toast.LENGTH_SHORT).show();
						}
					}
				}).start();*/
			}
		});
	
		final Button effect = (Button) rootView.findViewById(R.id.seteffect);
		effect.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				convertToMutable(bmp);	
				if(bmp.isMutable()){
						iv.setColorFilter(Color.RED);
					}
					else{
						Toast.makeText(getActivity(), "Not a mutable image", Toast.LENGTH_SHORT).show();
					}
				}
		});
	
		return rootView;
	}
	
	
	public Bitmap convertToMutable(Bitmap imgIn){
		try{
		File file = new File(Environment.getExternalStorageDirectory()+ File.separator + "temp.jpg");
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
		int width = imgIn.getWidth();
		int height = imgIn.getHeight();
		Config type = imgIn.getConfig();
		FileChannel channel = randomAccessFile.getChannel();
		MappedByteBuffer map = channel.map(MapMode.READ_WRITE, 0, imgIn.getRowBytes() * height);
		imgIn.copyPixelsToBuffer(map);
		imgIn.recycle();
		System.gc();
		imgIn = Bitmap.createBitmap(width, height, type);
		map.position(0);
		imgIn.copyPixelsFromBuffer(map);
		channel.close();
		randomAccessFile.close();
		//file.delete();
		}catch(Exception e){
			Toast.makeText(getActivity(), "tmp file not found", Toast.LENGTH_SHORT).show();
		}
		
		return imgIn;
	}
	
	private class SetWallpaperTask extends AsyncTask<Void, Void, Void> {
		
			private Bitmap bt;
			private ImageView iview;
			ProgressDialog ring;
			public SetWallpaperTask(ImageView iview){
			  this.iview = iview;
		  }

		  @Override
		  protected void onPreExecute() {
		      ring = ProgressDialog.show(
			  			getActivity(), 
			  			"Please wait ...", 
			  			"Setting Wallpaper ...", true, false);
		  }

		  @Override
			protected Void doInBackground(Void... params) {
				// TODO Auto-generated method stub
			  bt = ((BitmapDrawable)iview.getDrawable()).getBitmap();
			  WallpaperManager wallpaperManager = WallpaperManager.getInstance
					      (getActivity());
					    try{
					    wallpaperManager.setBitmap(bt);
					    }catch(Exception e){
					    }
				return null;
			}

			@Override
		  protected void onPostExecute(Void res) {
		    	ring.dismiss();
			}

		
	}
}