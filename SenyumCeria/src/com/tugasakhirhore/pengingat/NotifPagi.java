package com.tugasakhirhore.pengingat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.tugasakhirhore.anatomidanfungsi.LayoutFungsiGigi;
import com.tugasakhirhore.senyumceria.Config;
import com.tugasakhirhore.senyumceria.LayoutBeranda;
import com.tugasakhirhore.senyumceria.R;

public class NotifPagi extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifsikatpagi);
        
        TextView judulnotifpagi= (TextView)findViewById(R.id.NotifPagi);
        Config.configTitleSplash(judulnotifpagi, NotifPagi.this);
        
        TextView notifpagi = (TextView)findViewById(R.id.textnotifPagi);
        Config.configFont(notifpagi, NotifPagi.this);
        
        JadwalSchedulingService.clearNotification(NotifPagi.this);
	}
	
}
