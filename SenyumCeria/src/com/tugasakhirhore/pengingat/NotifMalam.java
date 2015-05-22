package com.tugasakhirhore.pengingat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.tugasakhirhore.senyumceria.Config;
import com.tugasakhirhore.senyumceria.R;

public class NotifMalam extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifsikatmalam);
        
        TextView judulnotifmalam= (TextView)findViewById(R.id.NotifMalam);
        Config.configTitleSplash(judulnotifmalam, NotifMalam.this);
        
        TextView notifmalam = (TextView)findViewById(R.id.textnotifMalam);
        Config.configFont(notifmalam, NotifMalam.this);
        
        JadwalSchedulingServiceMalam.clearNotification(NotifMalam.this);
	}

}
