package com.tugasakhirhore.pengingat;

import java.util.Calendar;

import com.tugasakhirhore.senyumceria.R;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * class untuk menghandle pengaturan alar start/stop
 * @author Dyah Litaa
 *
 */
public class JadwalAlarmReceiver extends WakefulBroadcastReceiver {
	private AlarmManager alarmMgr;
	private PendingIntent alarmIntent;
	private String TAG = "alarmReceiver";
	MediaPlayer suara;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Intent intentService = new Intent(context,
				JadwalSchedulingService.class);
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
	public void startAlarm(Context context, Calendar calender) {
		alarmMgr = (AlarmManager) context
				.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(context, JadwalAlarmReceiver.class);
		
		final int pagi = (int) System.currentTimeMillis(); 
		 
		alarmIntent = PendingIntent.getBroadcast(context, pagi, intent, PendingIntent.FLAG_ONE_SHOT);
		
		alarmMgr.set(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis(),alarmIntent );
		
		alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP,calender.getTimeInMillis(), 1000 * 60 * 1 * 60 * 24,alarmIntent);
		
		/*alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, alarmIntent);
		*/
		/*alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
			    SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_DAY,
			    AlarmManager.INTERVAL_DAY,alarmIntent);*/
		
        
		
		
		/*long startUpTime = calender.getTimeInMillis();
	    System.out.println(startUpTime + "time" + System.currentTimeMillis());
	        if (System.currentTimeMillis() > startUpTime) {
	            startUpTime = startUpTime + AlarmManager.INTERVAL_DAY;
	        }
	        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, startUpTime, AlarmManager.INTERVAL_DAY , alarmIntent);*/


		// restart alarm when device reboot
		ComponentName receiver = new ComponentName(context,
				JadwalBootReceiver.class);
		PackageManager pm = context.getPackageManager();

		pm.setComponentEnabledSetting(receiver,
				PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
				PackageManager.DONT_KILL_APP);
	}

	/**
	 * stop alarm
	 * 
	 * @param context
	 */
	public void stopAlarm(Context context) {
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







	
	
	
	
