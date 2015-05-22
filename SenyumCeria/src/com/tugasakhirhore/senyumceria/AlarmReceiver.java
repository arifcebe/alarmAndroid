package com.tugasakhirhore.senyumceria;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

public class AlarmReceiver  extends BroadcastReceiver {
	MediaPlayer suara;
	
	
	public void onReceive(Context c, Intent arg1){
		suara = MediaPlayer.create(c, R.raw.burung_prenjak);
		suara.start();
	}

}
