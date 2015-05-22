package com.tugasakhirhore.pengingat;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.tugasakhirhore.senyumceria.R;

public class JadwalAlarmReceiverCheckUp extends WakefulBroadcastReceiver {
	private AlarmManager alarmMgr;
	private PendingIntent alarmIntent;
	private String TAG = "alarmReceiver";
	MediaPlayer suara;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Intent intentService = new Intent(context,
				JadwalSchedulingServiceCheckUp.class);
		/*suara = MediaPlayer.create(context, R.raw.burung_prenjak);
		suara.start();*/
		
		// start service
		startWakefulService(context, intentService);
	}
	

	/**
	 * set to start alarm
	 * 
	 * @param context
	 */
	public void startAlarmCheckUp(Context context, Calendar calender) {
		alarmMgr = (AlarmManager) context
				.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(context, JadwalAlarmReceiverCheckUp.class);
		
		final int check = (int) System.currentTimeMillis(); 
		 
		alarmIntent = PendingIntent.getBroadcast(context, check, intent, PendingIntent.FLAG_ONE_SHOT);
		
		
		alarmMgr.set(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis(),alarmIntent);
		
	
		// restart alarm when device reboot
		ComponentName receiver = new ComponentName(context,
				JadwalBootReceiver.class);
		PackageManager pm = context.getPackageManager();

		pm.setComponentEnabledSetting(receiver,
				PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
				PackageManager.DONT_KILL_APP);
	}
	
	
	public void stopAlarmCheckUp(Context context) {
		if (alarmMgr != null) {
			alarmMgr.cancel(alarmIntent);
		}

		ComponentName receiver = new ComponentName(context,
				JadwalBootReceiver.class);
		PackageManager pm = context.getPackageManager();

		pm.setComponentEnabledSetting(receiver,
				PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
				PackageManager.DONT_KILL_APP);
	}
}
