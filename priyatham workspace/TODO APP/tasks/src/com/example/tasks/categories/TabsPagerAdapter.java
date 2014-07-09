package com.example.tasks.categories;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public  Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		switch (arg0) {
		case 0:
			return new YearlyCls();
		case 1:
			return new MonthlyCls();
		case 2:
			return new WeeklyCls();
		case 3:
			return new DialyCls();
		case 4:
			return new BirthdaysCls();
		case 5:
			return new AniversariesCls();	
		default:
			break;
		}
		
		
		
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 6;
	}
	
	

}
