package com.tugasakhirhore.tips;

import java.util.ArrayList;
import java.util.List;
import com.tugasakhirhore.adapter.ItemAdapter;
import com.tugasakhirhore.model.ItemModel;
import com.tugasakhirhore.senyumceria.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
//import android.widget.ArrayAdapter;
import android.widget.ListView;


public class LayoutTips extends ListActivity {
	
	private ItemAdapter adapter;
	private ItemModel model;
	private List<ItemModel> list;
	
	
	 protected void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	        //setContentView(R.layout.layout_penyakit);
	      
	        
	        String[] menu = new String[]{
	        		"Waktu Tepat Sikat Gigi",
	        		"Makanan Yang Tidak Baik Untuk Gigi",
	        		"Makanan Yang Baik Untuk Gigi",
	        		"Tips Memilih Sikat Gigi",
	        		"Tips Memilih Pasta Gigi",
	        };
	        
	        int[] icon = new int[]{
	        		R.drawable.waktu,
	        		R.drawable.permen,
	        		R.drawable.tomat,
	        		R.drawable.sikat,
	        		R.drawable.pasta_gigi
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
	        
	        //perubahan data di list view
	        adapter.notifyDataSetChanged();
	 }
	 
	 protected void onListItemClick(ListView satu, View v, int position,long id){
		 super.onListItemClick(satu, v, position, id);
		 //menangkap nilai text yang diklik
		 
		 //Object o = this.getListAdapter().getItem(position);
		 Object o = list.get(position).getTitle();
		 String pilihan = o.toString();
		 tampilkanPilihan(pilihan);
	 }
	 protected void tampilkanPilihan(String pilihan){
		try{
			 Intent i = null;
			 
			 if (pilihan.equals("Waktu Tepat Sikat Gigi")){
			 i = new Intent (this, LayoutWaktuSikatGigi.class);
			 }
			 	
			 else if (pilihan.equals("Makanan Yang Tidak Baik Untuk Gigi")){
			 i = new Intent (this, LayoutMakanan.class);
			 }
			 
			 else if (pilihan.equals("Makanan Yang Baik Untuk Gigi")){
				 i = new Intent (this, LayoutTipsMakanan.class);
			 }
			 
			 else if (pilihan.equals("Tips Memilih Sikat Gigi")){
				 i = new Intent (this, LayoutTipsMemilihSikat.class);
			 }
			 
			 else {
				 i = new Intent (this, LayoutTipsMemilihOdol.class);
			 }
			 
			 
			 startActivity(i); 
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	 }
	 
	
	 }

				 
			 



