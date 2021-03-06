package com.tugasakhirhore.pengingat;

/**
 * 
 * @author Dyah Litaa
 */

import com.tugasakhirhore.senyumceria.LayoutBeranda;
import com.tugasakhirhore.senyumceria.R;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class JadwalSchedulingService extends IntentService{
	public static final int NOTIF_ID = 1;
	//public static final int NOTIF_CHECKUP = 3;
	private NotificationManager mNotificationManager;
	private NotificationCompat.Builder builder;
	MediaPlayer suara;

	public JadwalSchedulingService() {
		super("SchedulingService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		sendNotification("Ayok sikat gigi pagi");
		JadwalAlarmReceiver.completeWakefulIntent(arg0);
	}
	
	/**
	 * kirim notifikasi
	 * @param pesan
	 */
	private void sendNotification(String pesan){
		mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, 
				new Intent(this, NotifPagi.class), 0);
		
		NotificationCompat.Builder mBuilder = 
				new NotificationCompat.Builder(this)
		.setSmallIcon(R.drawable.ic_iconpagi)
		.setContentTitle("Senyum Ceria")
		.setStyle(new NotificationCompat.BigTextStyle()
		.bigText(pesan))
		.setContentText(pesan);
		/*try {
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/"
                    + R.raw.burung_prenjak);
            mBuilder.setSound(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
		*/
		mBuilder.setContentIntent(contentIntent);
		mNotificationManager.notify(NOTIF_ID, mBuilder.build());
		
	}
	
	/**
	 * untuk hapus notifikasi
	 * @param context
	 */
	public static void clearNotification(Context context){
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.cancel(NOTIF_ID);
	}

}
