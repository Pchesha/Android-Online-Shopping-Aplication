package com.example.watchshop;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

public class Watch {
	public static Activity activity;
	BitmapDrawable pictures;
	String b1;
	String b2;

	
	public Watch(String c,String b,int rid)
	{
		b1=c;
		b2=b;
		pictures=(BitmapDrawable)activity.getResources().getDrawable(rid);
		//pictures=rid;
	}
	public Watch(int w4) {
		// TODO Auto-generated constructor stub
	}
	public static void setActivity(Activity a) {
		Watch.activity=a;
	}
	public String getCartButton() {
		return b1;
	}
	public String getBuyButton() {
		return b2;
	}
	
	/*
	public int getPictures() {
		//Log.i("SSSSSSSSS", "INSIDE");
		return pictures;
	}
	*/
	
	
	
	public BitmapDrawable getPictures(){
		return pictures;
	}

	
}
