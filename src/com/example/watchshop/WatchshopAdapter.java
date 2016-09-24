package com.example.watchshop;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WatchshopAdapter extends ArrayAdapter<String> {
	int images[];

	public WatchshopAdapter(Context context,int imgs[],String x[]) {
		super(context,R.layout.watchshopview,x);
		images=imgs;
		// TODO Auto-generated constructor stub
	}

		// TODO Auto-generated constructor stub
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		LayoutInflater inflater=  ((Activity)super.getContext()).getLayoutInflater();
		View rowview=inflater.inflate(R.layout.watchshopview, null, true);
		
		ImageView imageView = (ImageView) rowview.findViewById(R.id.imageView1);
		imageView.setImageResource(images[position]);
	
		return rowview;
	}

}
