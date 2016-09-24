package com.example.watchshop;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity implements OnClickListener {
	Button login,signup;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		ActionBar actionBar=getActionBar();
		actionBar.hide();
		login=(Button) findViewById(R.id.button1);
		signup=(Button) findViewById(R.id.button2);
		login.setOnClickListener(this);
		signup.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			Intent i=new Intent(this,LoginActivity.class);
			startActivity(i);
			
			break;
		case R.id.button2:
			Intent i1=new Intent(this,SignUpActivity.class);
			startActivity(i1);
		default:
			break;
		}
		
	}

}
