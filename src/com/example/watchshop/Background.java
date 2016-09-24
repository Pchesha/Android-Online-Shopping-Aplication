package com.example.watchshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

public class Background extends AsyncTask<String, Void,String> {
Context context;
AlertDialog alertDialog;
Background (Context ctx){
	context=ctx;
}

	@Override
	protected String doInBackground(String... params) {
		String type=params[0];
		String login_url="http://127.0.0.1/watchShopAdmin/userlogin.php";
		
		
		if(type.equals("login")){
			try {
				String user=params[1];
				String pass=params[2];
				URL url=new URL(login_url);
				HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
				httpURLConnection.setRequestMethod("GET");
				httpURLConnection.setDoOutput(true);
				httpURLConnection.setDoInput(true);
				OutputStream outputStream=httpURLConnection.getOutputStream();
				BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
				String post_data=URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(user,"UTF-8")+"&"+URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8")
		;
				bufferedWriter.write(post_data);
				bufferedWriter.flush();
				bufferedWriter.close();
				outputStream.close();
				InputStream inputStream=httpURLConnection.getInputStream();
				BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
				String result = "";
				String line="";
				while((line=bufferedReader.readLine())!=null)
				{
					result += line;
				}
				bufferedReader.close();
				inputStream.close();
				httpURLConnection.disconnect();
				return result;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		alertDialog.setMessage(result);
		alertDialog.show();
	}
	
	@Override
	protected void onPreExecute() {
		alertDialog=new AlertDialog.Builder(context).create();
		alertDialog.setTitle("Login Status");
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
}
