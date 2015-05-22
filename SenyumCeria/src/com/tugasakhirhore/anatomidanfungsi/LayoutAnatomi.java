package com.tugasakhirhore.anatomidanfungsi;

/**
 * class ini dipake buat ganti huruf juga
 * @author Dyah Litaa
 */

import android.app.Activity;
import android.app.AlertDialog; 
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tugasakhirhore.senyumceria.Config;
import com.tugasakhirhore.senyumceria.R;

public class LayoutAnatomi extends Activity implements MediaPlayer.OnCompletionListener {
	
	private ImageButton play;
	private ImageButton pause;
	private ImageButton stop;
	private MediaPlayer mp;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_anatomi);
        
        //Mahkota Gigi
        
        TextView judulmahkota = (TextView)findViewById(R.id.MahkotaGigi);
        Config.configTitle(judulmahkota, LayoutAnatomi.this);
        
        TextView mahkota = (TextView)findViewById(R.id.textmahkotaGigi);
        Config.configFont(mahkota, LayoutAnatomi.this);
        
        //Akar Gigi
        
        TextView judulakar = (TextView)findViewById(R.id.AkarGigi);
        Config.configTitle(judulakar, LayoutAnatomi.this);
        
        TextView akar = (TextView)findViewById(R.id.textakarGigi);
        Config.configFont(akar, LayoutAnatomi.this);
        
        //Email
        
        TextView judulemail = (TextView)findViewById(R.id.EmailGigi);
        Config.configTitle(judulemail, LayoutAnatomi.this);
        
        TextView email = (TextView)findViewById(R.id.textemailGigi);
        Config.configFont(email, LayoutAnatomi.this);
        
        //Dentin
        
        TextView juduldentin = (TextView)findViewById(R.id.DentinGigi);
        Config.configTitle(juduldentin, LayoutAnatomi.this);
        
        TextView dentin = (TextView)findViewById(R.id.textdentinGigi);
        Config.configFont(dentin, LayoutAnatomi.this);
        
        //Pulpa
        
        TextView judulpulpa = (TextView)findViewById(R.id.PulpaGigi);
        Config.configTitle(judulpulpa, LayoutAnatomi.this);
        
        TextView pulpa = (TextView)findViewById(R.id.textpulpaGigi);
        Config.configFont(pulpa, LayoutAnatomi.this);
        
        //Gusi
        
        TextView judulgusi = (TextView)findViewById(R.id.GusiGigi);
        Config.configTitle(judulgusi, LayoutAnatomi.this);
        
        TextView gusi= (TextView)findViewById(R.id.textgusiGigi);
        Config.configFont(gusi, LayoutAnatomi.this);
        
        //Sementum
        
        TextView judulsementum = (TextView)findViewById(R.id.SementumGigi);
        Config.configTitle(judulsementum, LayoutAnatomi.this);
        
        TextView sementum = (TextView)findViewById(R.id.textsementumGigi);
        Config.configFont(sementum, LayoutAnatomi.this);
        
        //Tulang Alveolar
        
        TextView judultulang = (TextView)findViewById(R.id.TulangGigi);
        Config.configTitle(judultulang, LayoutAnatomi.this);
        
        TextView tulang = (TextView)findViewById(R.id.texttulangGigi);
        Config.configFont(tulang, LayoutAnatomi.this);
        
        //Ligamen
        
        TextView judulligamen = (TextView)findViewById(R.id.LigamenGigi);
        Config.configTitle(judulligamen, LayoutAnatomi.this);
        
        TextView ligamen = (TextView)findViewById(R.id.textligamenGigi);
        Config.configFont(ligamen, LayoutAnatomi.this);
        
        
        
        /**
         * ini buat ngasi suara
         * @author Dyah Litaa
         */
        
        play = (ImageButton)findViewById(R.id.playanatomi);
        pause = (ImageButton)findViewById(R.id.pauseanatomi);
        stop = (ImageButton)findViewById(R.id.stopanatomi);
        
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
	 * method buat menjalankan voice
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
			mp=MediaPlayer.create(this, R.raw.strukturfix);
			
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
