package com.tugasakhirhore.anatomidanfungsi;

import java.util.ArrayList;
import java.util.List;
import com.tugasakhirhore.adapter.ItemAdapter;
import com.tugasakhirhore.model.ItemModel;
import com.tugasakhirhore.senyumceria.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;

public class LayoutAnatomidanFungsi extends ListActivity {
	
	private ItemAdapter adapter;
	private ItemModel model;
	private List<ItemModel> list;
	
	
	 protected void onCreate(Bundle icicle) {
	        super.onCreate(icicle);

	        String[] menu = new String[]{
	        		"Anatomi Gigi",
	        		"Fungsi Gigi",
	        };
	        
	        int[] icon = new int[]{
	        		R.drawable.anatomigigi,
	        		R.drawable.fungsigigi,
	        	
	        };
	        list = new ArrayList<ItemModel>();
	        adapter = new ItemAdapter(this, list);
	        
	        getListView().setBackgroundResource(R.color.bg_main);
	        getListView().setAdapter(adapter);
	        
	        //perulangan untuk memasukkan ke listview
	        
	        for (int i = 0; i<menu.length;i++){
	        	model = new ItemModel(icon [i], menu[i]);
	        	list.add(model);
	        } 
	        adapter.notifyDataSetChanged();
	        }
	   	 
	   	 protected void onListItemClick(ListView satu, View v, int position,long id){
	   		 super.onListItemClick(satu, v, position, id);
	   		 //menangkap nilai text yang diklik
	   		 
	   		 //instansiasi
	   		 Object o = list.get(position).getTitle();
	   		 String pilihan = o.toString();
	   		 tampilkanPilihan(pilihan);
	   	 }
	   	 
	   	 protected void tampilkanPilihan(String pilihan){
	   			try{
	   				 Intent i = null;
	   				 if (pilihan.equals("Anatomi Gigi")){
	   					 i = new Intent (this, LayoutAnatomi.class);
	   				 }
	   				 else {
	   					 i = new Intent (this, LayoutFungsiGigi.class);
	   					 
	   					
	   					
	   				 }
	   				 startActivity(i); 
	   			}
	   			catch (Exception e){
	   				e.printStackTrace();
	   			}
	   			
	   			
	   			
	   			
	   		 }

	   
	        }


