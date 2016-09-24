package com.example.watchshop;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SortByFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		int position=getArguments().getInt("position");
		String[] sortby=getResources().getStringArray(R.array.SORT_BY);
		View v=inflater.inflate(R.layout.fragment_layout, container,false);
		TextView tv=(TextView)v.findViewById(R.id.tv_content);
		tv.setText(sortby[position]);
		getActivity().getActionBar().setTitle(sortby[position]);
		return v;
	}

}
