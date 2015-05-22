package com.tugasakhirhore.perawatan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tugasakhirhore.senyumceria.Config;
import com.tugasakhirhore.senyumceria.R;
import android.app.AlertDialog;
import android.widget.ImageButton;
import android.media.MediaPlayer;

public class LayoutSikatGigi  extends Activity implements MediaPlayer.OnCompletionListener {
	
	private ImageButton play;
	private ImageButton pause;
	private ImageButton stop;
	private MediaPlayer mp;
	
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sikatgigi);
        
        TextView sikatgigi = (TextView)findViewById(R.id.textviewSikatGigi);
        Config.configFont(sikatgigi, LayoutSikatGigi.this);
        
        TextView sikatgigidua = (TextView)findViewById(R.id.textviewSikatGigi2);
        Config.configFont(sikatgigidua, LayoutSikatGigi.this);
        
        TextView sikatgigitiga = (TextView)findViewById(R.id.textviewSikatGigi3);
        Config.configFont(sikatgigitiga, LayoutSikatGigi.this);
        
        play = (ImageButton)findViewById(R.id.play);
        pause = (ImageButton)findViewById(R.id.pause);
        stop = (ImageButton)findViewById(R.id.stop);
        
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
				mp=MediaPlayer.create(this, R.raw.sikatfix);
				
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
