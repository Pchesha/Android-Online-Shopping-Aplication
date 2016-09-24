package com.example.watchshop;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class LaunchingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launching);
		ActionBar actionBar=getActionBar();
		actionBar.hide();
		Thread t=new Thread()
		{
			public void run()
			{
				try
				{
					sleep(2000);
					Intent i=new Intent(getBaseContext(),HomeActivity.class);
					startActivity(i);
					finish();
				}catch(Exception e)
				{
					
				}
			}
		};
		t.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.launching, menu);
		return true;
	}

}
