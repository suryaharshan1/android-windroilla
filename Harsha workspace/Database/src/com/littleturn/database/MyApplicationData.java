package com.littleturn.database;

import android.app.Application;

public class MyApplicationData extends Application {
	private String userName;
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String uid){
		this.userName = uid;
	}
}
