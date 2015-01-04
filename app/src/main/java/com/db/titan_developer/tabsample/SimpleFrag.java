package com.db.titan_developer.tabsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SimpleFrag extends Fragment {
	
	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		if(container == null)
			return null;
		return inflater.inflate(R.layout.simple, container, false);
	}
	
	
	
	
}
