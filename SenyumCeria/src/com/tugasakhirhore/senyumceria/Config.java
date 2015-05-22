package com.tugasakhirhore.senyumceria;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class Config {
	
	
	public static void configFont (TextView tv, Context context){
		
		tv.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(),
				"font/SF_Cartoonist_Hand_Bold.ttf"));
		
	}

	public static void configTitle (TextView tv, Context context){
		
		tv.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(),
				"font/comics.ttf"));
		
	}
	
	public static void configTitleSplash (TextView tv, Context context){
		
		tv.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(),
				"font/casual.ttf"));
		
	}
	
}
