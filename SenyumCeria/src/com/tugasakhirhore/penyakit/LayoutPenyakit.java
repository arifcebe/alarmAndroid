/*package com.tugasakhirhore.penyakit;

import com.tugasakhirhore.senyumceria.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class LayoutPenyakit extends ListActivity {
	
	 protected void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	        //setContentView(R.layout.layout_penyakit);
	      
	        
	        String[] menu = new String[]{
	        		"Karies Gigi","Gusi Bengkak"
	        };
	        
	        this.setListAdapter(new ArrayAdapter<String>(this,
	        		android.R.layout.simple_list_item_1,menu));
	        
	        getListView().setBackgroundResource(R.color.bg_main);
	 }
	 

	 //method ini akan mengoverride method onListItemClick yang ada pada class ListActivity
	 
	 //method ini akan dipanggil apabila ada salah satu item yang dipilih
	 
	 protected void onListItemClick(ListView satu, View v, int position,long id){
		 super.onListItemClick(satu, v, position, id);
		 //menangkap nilai text yang diklik
		 
		 Object o = this.getListAdapter().getItem(position);
		 String pilihan = o.toString();
		 tampilkanPilihan(pilihan);
	 }
	 protected void tampilkanPilihan(String pilihan){
		try{
			 Intent i = null;
			 if (pilihan.equals("Karies Gigi")){
				 i = new Intent (this, LayoutKaries.class);
			 }
			 else {
				 i = new Intent (this, LayoutGusiBengkak.class);
				 
				
				
			 }
			 startActivity(i); 
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	 }
	 }

				 
			 
		 
	 
	 

*/