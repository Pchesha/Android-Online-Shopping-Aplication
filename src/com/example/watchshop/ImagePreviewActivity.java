package com.example.watchshop;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ImagePreviewActivity extends Activity {

	
	ImageView image;
		Button b1,b2;
		//Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_preview);
		
		image=(ImageView)this.findViewById(R.id.imageView1);
		//rate=(RatingBar)this.findViewById(R.id.rate);
		//button1=(Button)this.findViewById(R.id.button1);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		Intent current=this.getIntent();
		Bundle b=current.getExtras();
		String b1=b.getString("cart");
		String b2=b.getString("buy");
		Bitmap bitmap = current.getParcelableExtra("bitmap");
		//int rid=b.getInt("rid");
		
		//Log.i("PICCCCC",rid+"");
		
		//BitmapDrawable pic=(BitmapDrawable)DesriptionActivity.this.getResources().getDrawable(rid);
		//image=new ImageView(this);
		image.setImageBitmap(bitmap);
		
		};
		
		
	
		/*
		rate.setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View arg0, boolean arg1) {
				// TODO Auto-generated method stub
				Log.i("RATINGGGGG", "inside the fxn.....");
			}
		
		}
		
		); 
		*/
	
	
	/*
	public void save(View view)
	{
			
			Toast.makeText(getApplicationContext(),tvname.getText()+" has a rating of "+r, Toast.LENGTH_SHORT).show();
			this.finish();
		
	}
	*/
	
	/*
	public class ratinglistener implements OnClickListener
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			float r=rate.getRating();
			Log.i("RATINGGGGG", "inside the fxn.....");
			Toast.makeText(getApplicationContext(),tvname.getText()+" has a rating of "+r, Toast.LENGTH_LONG).show();
		}
		
	}
	*/
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_preview, menu);
		return true;
	}

}
