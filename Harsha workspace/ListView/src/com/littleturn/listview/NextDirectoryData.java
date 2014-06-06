package com.littleturn.listview;

import android.app.Application;

public class NextDirectoryData extends Application {
	private String filename;
	
	public String getNextDirectory(){
		return filename;
	}
	
	public void setNextDirectory(String uid){
		this.filename = uid;
	}
}
