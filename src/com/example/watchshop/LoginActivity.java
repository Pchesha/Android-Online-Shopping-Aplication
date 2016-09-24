package com.example.watchshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.ActionBar;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

Button b1;
EditText e1,e2;
JSONParser jsonParser = new JSONParser();
private static final String TAG_SUCCESS = "success";
private static final String TAG_MESSAGE = "message";
String LOGIN_URL = "http://192.168.43.157/watchShopAdmin/userlogin.php";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar=getActionBar();
		actionBar.hide();
		setContentView(R.layout.activity_login);
		Intent i=getIntent();
		b1=(Button) findViewById(R.id.sendButton);
		e1=(EditText) findViewById(R.id.displaymessage);
		e2=(EditText) findViewById(R.id.editText2);
	      
	}
	
	 
	

	public void send(View v) {
	
		
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
			String username=e1.getText().toString();
			String password=e2.getText().toString();
		 
			try 
			{
				// Building Parameters
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("username", username));
				params.add(new BasicNameValuePair("password", password));

				Log.d("request!", "starting");
				// getting product details by making HTTP request
				JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL,"GET",params);

				// check your log for json response
				Log.d("Login attempt", json.toString());

				// json success tag
				success = json.getInt(TAG_SUCCESS);
				if (success == 1) 
				{
					Log.d("Login Successful!", json.toString());
					// save user data
					SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
					Editor edit = sp.edit();
					edit.putString("username", username);
					edit.commit();
					
					Intent i = new Intent(LoginActivity.this, Home1Activity.class);
					i.putExtra("Username",e1.getText().toString());
					finish();
					startActivity(i);
					return json.getString(TAG_MESSAGE);
				} 
				else 
				{
					Log.d("Login Failure!", json.getString(TAG_MESSAGE));
					return json.getString(TAG_MESSAGE);
				}
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
				Toast.makeText(LoginActivity.this, file_url, Toast.LENGTH_LONG).show();
			}

		}

	}
	
	
 
	    }
 
