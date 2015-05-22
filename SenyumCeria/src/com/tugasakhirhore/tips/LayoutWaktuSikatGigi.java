package com.tugasakhirhore.tips;

import android.app.Activity;
import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tugasakhirhore.senyumceria.Config;
import com.tugasakhirhore.senyumceria.R;

public class LayoutWaktuSikatGigi extends Activity implements MediaPlayer.OnCompletionListener {
	
	private ImageButton play;
	private ImageButton pause;
	private ImageButton stop;
	private MediaPlayer mp;
	
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_waktusikatgigi);
        
        //sikat gigi pagi
        
        TextView judulpagi = (TextView)findViewById(R.id.BangunTidur);
        Config.configTitle(judulpagi, LayoutWaktuSikatGigi.this);
        
        TextView pagi = (TextView)findViewById(R.id.textviewWaktuSikatGigi);
        Config.configFont(pagi, LayoutWaktuSikatGigi.this);
        
        //siang
        
        TextView judulsiang = (TextView)findViewById(R.id.SetelahMakan);
        Config.configTitle(judulsiang, LayoutWaktuSikatGigi.this);
        
        TextView siang = (TextView)findViewById(R.id.textviewWaktuSikatGigiMakan);
        Config.configFont(siang, LayoutWaktuSikatGigi.this);
        
        //malam
        
        TextView judulmalam = (TextView)findViewById(R.id.SebelumTidur);
        Config.configTitle(judulmalam, LayoutWaktuSikatGigi.this);
        
        TextView malam = (TextView)findViewById(R.id.textviewWaktuSikatGigiMalam);
        Config.configFont(malam, LayoutWaktuSikatGigi.this);
        
        
        /**
         * mulai audio
         * @author Dyah Litaa
         */
        
        play = (ImageButton)findViewById(R.id.playtipswaktu);
        pause = (ImageButton)findViewById(R.id.pausetipswaktu);
        stop = (ImageButton)findViewById(R.id.stoptipswaktu);
        
        play.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				play();
			}
		});
        
        
        pause.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pause();
			}
		});
        
        
        stop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				stop();
			}
		});
        
        setup();
        
        
        
	}
	
	
	/**
	 * 
	 * methodnya
	 */
	
	/**
	 * 
	 * @author Dyah Litaa
	 */
	
		public void onDestroy(){
		
			super.onDestroy();
		
			if(stop.isEnabled()){
			stop();
			}
		}
	
		public void onCompletion(MediaPlayer mp){
			stop();
		}
	
		
		// method untuk menjalankan tombol play
		
		private void play(){
			mp.start();
			
			play.setEnabled(false);
			pause.setEnabled(true);
			stop.setEnabled(true);
		}
		
		// method untuk menjalankan tombol pause
		
		
		private void pause(){
			mp.pause();
			
			play.setEnabled(true);
			pause.setEnabled(false);
			stop.setEnabled(true);
		}
		
		
		// method untuk menjalankan tombol stop
		
		
		private void stop(){
			mp.stop();
			
			pause.setEnabled(false);
			stop.setEnabled(false);
			
			try{
				mp.prepare();
				mp.seekTo(0);
				play.setEnabled(true);
				
			}
			
			catch (Throwable t){
				goBlooey(t);
			}
			
		}
		
		//memutar suara
		
		private void loadClip(){
			try{
				mp=MediaPlayer.create(this, R.raw.waktusikatfix);
				
				mp.setOnCompletionListener(this);
				}
			
			catch (Throwable t){
				
				goBlooey(t);
			}
		}
		
		private void setup(){
			loadClip();
			play.setEnabled(true);
			pause.setEnabled(false);
			stop.setEnabled(false);
			
		}
		
		private void goBlooey(Throwable t){
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
			
			builder.setTitle("Lita")
					.setMessage(t.toString())
					.setPositiveButton("OK", null)
					.show();
					
		}
	
}
