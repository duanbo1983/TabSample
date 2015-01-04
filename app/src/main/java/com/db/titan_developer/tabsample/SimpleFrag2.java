package com.db.titan_developer.tabsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleFrag2 extends Fragment {

	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		if (container == null)
			return null;
		return inflater.inflate(R.layout.simple_layout2, container, false);
	}
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	public void onStart(){
		super.onStart();
		Button button = (Button) getActivity().findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "lalalaskda", Toast.LENGTH_SHORT).show();
			}
		});
		
		LinearLayout layout = (LinearLayout) getActivity().findViewById(R.id.my_inner_layout);
		layout.addView(createViews());
		
	}
	
	
	public TextView createViews(){
		TextView view = new TextView(getActivity());
		view.setText("bababbabbababab");
		return view;
	}
	
	
}
