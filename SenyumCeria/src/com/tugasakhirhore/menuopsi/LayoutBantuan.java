package com.tugasakhirhore.menuopsi;


import com.tugasakhirhore.senyumceria.Config;
import com.tugasakhirhore.senyumceria.R;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

public class LayoutBantuan extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bantuan);
        
        //perawatan
        
        TextView judulperawatan = (TextView)findViewById(R.id.textBantuanPerawatan);
        Config.configTitle(judulperawatan, LayoutBantuan.this);
        
        TextView perawatan = (TextView)findViewById(R.id.textperawatan);
        Config.configFont(perawatan, LayoutBantuan.this);
        
        //struktur
        
        TextView judulstruktur = (TextView)findViewById(R.id.textBantuanStruktur);
        Config.configTitle(judulstruktur, LayoutBantuan.this);
        
        TextView struktur = (TextView)findViewById(R.id.textstruktur);
        Config.configFont(struktur, LayoutBantuan.this);
        
        //pengingat
        
        TextView judulpengingat = (TextView)findViewById(R.id.textBantuanPengingat);
        Config.configTitle(judulpengingat, LayoutBantuan.this);
        
        TextView pengingat = (TextView)findViewById(R.id.textpengingat);
        Config.configFont(pengingat, LayoutBantuan.this);
        
        //tips
        
        TextView judultips = (TextView)findViewById(R.id.textBantuanTips);
        Config.configTitle(judultips, LayoutBantuan.this);
        
        TextView tips = (TextView)findViewById(R.id.texttips);
        Config.configFont(tips, LayoutBantuan.this);
        
        //video
        
        TextView judulvideo = (TextView)findViewById(R.id.textBantuanVideo);
        Config.configTitle(judulvideo, LayoutBantuan.this);
        
        TextView video = (TextView)findViewById(R.id.textvideo);
        Config.configFont(video, LayoutBantuan.this);
        
        //keluar
        
        TextView judulkeluar = (TextView)findViewById(R.id.textBantuanKeluar);
        Config.configTitle(judulkeluar, LayoutBantuan.this);
        
        TextView keluar = (TextView)findViewById(R.id.textkeluar);
        Config.configFont(keluar, LayoutBantuan.this);
        
        //bantuan
        
        TextView judulbantuan= (TextView)findViewById(R.id.textBantuanBantuan);
        Config.configTitle(judulbantuan, LayoutBantuan.this);
        
        TextView bantuan = (TextView)findViewById(R.id.textbantuan);
        Config.configFont(bantuan, LayoutBantuan.this);
        
        //tentang
        
        TextView judultentang = (TextView)findViewById(R.id.textBantuanTentang);
        Config.configTitle(judultentang, LayoutBantuan.this);
        
        TextView tentang = (TextView)findViewById(R.id.texttentang);
        Config.configFont(tentang, LayoutBantuan.this);
        
        //play
        
        TextView judulplay = (TextView)findViewById(R.id.textBantuanPlay);
        Config.configTitle(judulplay, LayoutBantuan.this);
        
        TextView play = (TextView)findViewById(R.id.textplay);
        Config.configFont(play, LayoutBantuan.this);
        
        //stop
        
        TextView judulstop = (TextView)findViewById(R.id.textBantuanStop);
        Config.configTitle(judulstop, LayoutBantuan.this);
        
        TextView stop = (TextView)findViewById(R.id.textstop);
        Config.configFont(stop, LayoutBantuan.this);
        
        //pause
        
        TextView juduljeda = (TextView)findViewById(R.id.textBantuanJeda);
        Config.configTitle(juduljeda, LayoutBantuan.this);
        
        TextView jeda = (TextView)findViewById(R.id.textjeda);
        Config.configFont(jeda, LayoutBantuan.this);
        
        
        
        
        
	}

  	
   	
}
