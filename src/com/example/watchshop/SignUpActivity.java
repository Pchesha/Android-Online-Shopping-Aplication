package com.example.watchshop;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.watchshop.LoginActivity.AttemptLogin;

import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
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

public class SignUpActivity extends Activity implements OnClickListener {
	Button signUp;
	EditText e1,e2,e3,e4;
	JSONParser jsonParser = new JSONParser();
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_MESSAGE = "message";
	String LOGIN_URL = "http://192.168.43.157/watchShopAdmin/userregister.php";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setTitle("Create Account");
		setContentView(R.layout.activity_sign_up);
		e1=(EditText) findViewById(R.id.editText1);
		e2=(EditText) findViewById(R.id.editText2);
		e3=(EditText) findViewById(R.id.editText3);
		e4=(EditText) findViewById(R.id.editText4);
		Intent i1=getIntent();
		signUp=(Button) findViewById(R.id.button1);
		signUp.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		new AttemptLogin().execute();
		//Toast.makeText(getApplicationContext(), "Your account has been successfully created",Toast.LENGTH_LONG).show();
		
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
			String name=e1.getText().toString();
			String email=e2.getText().toString();
			String password=e4.getText().toString();
			String mobile=e3.getText().toString();

		 
			try 
			{
				// Building Parameters
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("name",name));
				params.add(new BasicNameValuePair("password", password));
				params.add(new BasicNameValuePair("username", email));
				params.add(new BasicNameValuePair("mobile", mobile));

				Log.d("request!", "starting");
				// getting product details by making HTTP request
				JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL,"GET",params);

				// check your log for json response
				 

				// json success tag
				success = json.getInt(TAG_SUCCESS);
				if (success == 1) 
				{
					Log.d("Login Successful!", json.toString());
					// save user data
					SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
					
					//Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
				
					//finish();
					//startActivity(i);
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
				Toast.makeText(SignUpActivity.this, file_url, Toast.LENGTH_LONG).show();
			}

		}

	}
	
	
	
}
