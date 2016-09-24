package com.example.watchshop;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

	public class SortBy1Fragment extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			int position=getArguments().getInt("position");
			String[] sortby1=getResources().getStringArray(R.array.SORT_BY1);
			View v1=inflater.inflate(R.layout.fragment1_layout, container,false);
			TextView tv1=(TextView)v1.findViewById(R.id.tv_content1);
			tv1.setText(sortby1[position]);
			getActivity().getActionBar().setTitle(sortby1[position]);
			return v1;
		}

	}

