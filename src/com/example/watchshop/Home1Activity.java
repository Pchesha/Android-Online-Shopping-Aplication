package com.example.watchshop;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.watchshop.SignUpActivity.AttemptLogin;

import android.R.string;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Home1Activity extends Activity implements OnItemSelectedListener {
	AutoCompleteTextView t1;
	Spinner sp;
	 Bitmap bitmap;
	TextView tvv;
	ImageView img;
	JSONParser jsonParser = new JSONParser();
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_MESSAGE = "message";
	String LOGIN_URL = "http://192.168.43.157/watchShopAdmin/getallproduct.php";
	String watches[]={"Men","Women","Kids","Fastrack","Titan","Sonata"};
	Intent oldIntent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home1);
		img = (ImageView) findViewById(R.id.imview);
		/*Intent i1=getIntent();
		Intent x2=getIntent();
		String message=x2.getStringExtra(LoginActivity.EXTRA_MESSAGE);
		TextView tv1=new TextView(this);
		tv1.setTextSize(20);
		tv1.setText(message);
		setContentView(tv1);*/
		tvv=(TextView) findViewById(R.id.textView2);
		oldIntent=getIntent();
		tvv.setText(oldIntent.getStringExtra("Username"));
		
		setTitle("WATCHSHOP");
		sp=(Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> ar=ArrayAdapter.createFromResource(this,R.array.category,android.R.layout.simple_list_item_1);
		ar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		sp.setAdapter(ar);
		sp.setOnItemSelectedListener(this);
		t1=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,watches);
	 t1.setAdapter(adapter);
	 t1.setThreshold(1);
	  
	 new AttemptLogin().execute();
	 
	}
	
	class AttemptLogin extends AsyncTask<String, String, String> 
	{

		@Override
		protected void onPreExecute() 
		{
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... args) 
		{
			// TODO Auto-generated method stub
			// Check for success tag
			int success;
			

		 
			try 
			{
				// Building Parameters
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("cat","ALL"));
				 
				Log.d("request!", "starting");
				// getting product details by making HTTP request
				JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL,"GET",params);

					
				SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
					
					Log.d("return",json.getString("ProductLink").toString());
					 new LoadImage().execute(json.getString("ProductLink").toString());
					return json.getString(TAG_MESSAGE);
			
			}
			catch (JSONException e) 
			{
				e.printStackTrace();
			}

			return null;

		}

		protected void onPostExecute(String file_url) {
			// dismiss the dialog once product deleted
			if (file_url != null) 
			{
				//Toast.makeText(SignUpActivity.this, file_url, Toast.LENGTH_LONG).show();
			}

		}

	}
	
	
	
	public void start()
    {
	
    	int imgs[]={
R.drawable.w4,
R.drawable.f6,
R.drawable.w9,
R.drawable.k10,
R.drawable.w11,
R.drawable.f3,
R.drawable.f9,
R.drawable.k1,
R.drawable.k4,
R.drawable.f8,
R.drawable.f5,
R.drawable.w24,
R.drawable.f7,
R.drawable.k8,
R.drawable.k5,
R.drawable.w9,
R.drawable.f10 };
    	String[]x={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"};
    	WatchshopAdapter aa=new WatchshopAdapter(this,imgs,x);
		ListView list=(ListView)findViewById(R.id.listView1);
		list.setAdapter(aa);
		/*list.setOnItemClickListener
		(
				new OnItemClickListener()
				{
					public void onItemClick(AdapterView<?> arg0,View arg1,int arg2,long arg3)
					{
						Watch w = (Watch)list.getItemAtPosition(arg2);
						Bundle b=new Bundle();
						
						//b.putInt("rid",s.getPictures());
						Intent i=new Intent(Home1Activity.this,ImagePreviewActivity.class);
						i.putExtras(b);
						i.putExtra("bitmap",(w.getPictures()).getBitmap());
						//i.putExtra("Cart", (w.getCartButton()));
						//i.putExtra("Cart", (w.getCartButton()));
						
						//i.putExtra(name, value)
					Home1Activity.this.startActivity(i);
					}
				}
		
    );*/

		    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home1, menu);
		
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.m1:
			Intent p=new Intent(this,CartActivity.class);
			startActivity(p);
			break;
		case R.id.m2:
			Intent q=new Intent(this,HomeActivity.class);
			startActivity(q);
			break;
		case R.id.m3:
			Intent r=new Intent(this,About_usActivity.class);
			startActivity(r);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		switch(arg2){
		
		case 1: 
			Intent s=new Intent(this,MaleActivity.class);
			startActivity(s);
			break;
		case 2: 
			Intent s1=new Intent(this,FemaleActivity.class);
			startActivity(s1);
			break;
		case 3: 
			Intent s2=new Intent(this,KidsActivity.class);
			startActivity(s2);
			break;
			default:
				break;
			
		}
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	 private class LoadImage extends AsyncTask<String, String, Bitmap> {
	        @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	            
	 
	        }
	         protected Bitmap doInBackground(String... args) {
	             try {
	                   bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());
	 
	            } catch (Exception e) {
	                  e.printStackTrace();
	            }
	            return bitmap;
	         }
	 
	         protected void onPostExecute(Bitmap image) {
	 
	             if(image != null){
	             img.setImageBitmap(image);
	             Log.d("img","sucess");
	 
	             }else{
	 
	          
	             Toast.makeText(Home1Activity.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
	 
	             }
	         }
	     }

}
