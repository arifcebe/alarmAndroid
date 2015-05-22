package com.tugasakhirhore.pengingat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.tugasakhirhore.senyumceria.R;

public class LayoutReminder extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_reminder);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		
		// TODO Auto-generated method stub
		
		getMenuInflater().inflate(R.menu.menu_home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()){
		
		case R.id.menu_home:
			onBackPressed();
			return true;
		
		}
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}
}
