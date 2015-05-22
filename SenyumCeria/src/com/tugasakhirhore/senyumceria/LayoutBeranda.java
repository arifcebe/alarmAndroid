package com.tugasakhirhore.senyumceria;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.app.AlertDialog;

import com.tugasakhirhore.anatomidanfungsi.LayoutAnatomidanFungsi;
import com.tugasakhirhore.menuopsi.LayoutBantuan;
import com.tugasakhirhore.pengingat.JadwalAlarmReceiver;
import com.tugasakhirhore.pengingat.JadwalSchedulingService;
import com.tugasakhirhore.pengingat.LayoutPengingatJadwal;
import com.tugasakhirhore.perawatan.LayoutPerawatan;
import com.tugasakhirhore.tips.LayoutTips;
import com.tugasakhirhore.video.LayoutVideo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class LayoutBeranda extends Activity {
	
	
	private AlertDialog.Builder builder;
	 private AlertDialog aboutDialog;
	   	

	 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_beranda);
        
        addListenerOnButton();
        
        TextView judulberanda = (TextView)findViewById(R.id.Beranda);
        Config.configTitleSplash(judulberanda, LayoutBeranda.this);
        
        
        
       	}
	
	
	//fungsi image button pengingat
	private void addListenerOnButton(){
		
		ImageButton button_pengingat = (ImageButton)findViewById(R.id.ButtonPengingat);
		ImageButton button_penyakit = (ImageButton)findViewById(R.id.ButtonVideo);
		ImageButton button_perawatan = (ImageButton)findViewById(R.id.ButtonPerawatan);
		ImageButton button_tips = (ImageButton)findViewById(R.id.ButtonTips);
		ImageButton button_keluar = (ImageButton)findViewById(R.id.ButtonKeluar);
		ImageButton button_anatomi = (ImageButton)findViewById(R.id.ButtonAnatomiGigi);
		
		
		//untuk button pengingat
		
	       button_pengingat.setOnClickListener(new View.OnClickListener() {
	 
	          public void onClick(View button_pengingat) {
	                //TODO Auto-generated method stub
	               Intent i = new Intent(getApplicationContext(), LayoutPengingatJadwal.class);
	             
	                startActivity(i);
	           }
	       });
	       
	   	//untuk button penyakit
	       
	       button_penyakit.setOnClickListener(new View.OnClickListener() {
	    		 
		          public void onClick(View button_penyakit) {
		                //TODO Auto-generated method stub
		               Intent i = new Intent(getApplicationContext(), LayoutVideo.class);
		                startActivity(i);
		           }
		       });
	       
	       button_tips.setOnClickListener(new View.OnClickListener() {
	    		 
		          public void onClick(View button_penyakit) {
		                //TODO Auto-generated method stub
		               Intent i = new Intent(getApplicationContext(), LayoutTips.class);
		             
		                startActivity(i);
		           }
		       });
	       
	   	//untuk button perawatan
	       
	       button_perawatan.setOnClickListener(new View.OnClickListener() {
	    		 
		          public void onClick(View button_perawatan) {
		                //TODO Auto-generated method stub
		               Intent i = new Intent(getApplicationContext(), LayoutPerawatan.class);
		             
		                startActivity(i);
		           }
		       });
	       
	//untuk button anatomi
	       
	       button_anatomi.setOnClickListener(new View.OnClickListener() {
	    		 
		          public void onClick(View button_perawatan) {
		                //TODO Auto-generated method stub
		               Intent i = new Intent(getApplicationContext(), LayoutAnatomidanFungsi.class);
		             
		                startActivity(i);
		           }
		       });
	       
	   	//untuk button perawatan
	       button_keluar.setOnClickListener(new View.OnClickListener() {
	    		 
		          public void onClick(View view) {
		        	  close();
		             
		           }
		       });		
	       
	       // membuat dialog box tentang
	      
	       LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
	        View layout = inflater.inflate(R.layout.about, (ViewGroup) findViewById(R.id.layout_root));
	        builder = new AlertDialog.Builder(this)
	        .setView(layout)
	        .setTitle("Tentang")
	        .setNeutralButton("OK", null);
	        builder.setIcon(android.R.drawable.ic_dialog_info);
	        aboutDialog = builder.create();
	       
    }
	
	 public void close(){

         AlertDialog.Builder builder = new AlertDialog.Builder(this);
         builder.setMessage("Anda Yakin Ingin Menutup Aplikasi?")
         .setCancelable(false)
         .setPositiveButton("Ya",
         new DialogInterface.OnClickListener() {
         public void onClick(DialogInterface dialog,
         int id) {
         LayoutBeranda.this.finish();
         }
         })
         .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
         public void onClick(DialogInterface dialog,
         int id) {
         dialog.cancel();

         }
         }).show();
         } 
        
        
	
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
		case R.id.satu :
			Intent a = new Intent(getApplicationContext(), LayoutBantuan.class);
			startActivity(a);
			break;
		case R.id.dua :
			aboutDialog.show();
			break;
			default :
				return super.onOptionsItemSelected(item);
		}
		return true;
	}
	
	
}
