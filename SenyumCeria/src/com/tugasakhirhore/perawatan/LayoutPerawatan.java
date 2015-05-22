package com.tugasakhirhore.perawatan;

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




public class LayoutPerawatan extends ListActivity {
	
	private ItemAdapter adapter;
	private ItemModel model;
	private List<ItemModel> list;
	
	
	 protected void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	        //setContentView(R.layout.layout_penyakit);
	      
	        
	        String[] menu = new String[]{
	        		"Sikat Gigi",
	        		"Periksa Gigi",
	        		
	        };
	        
	        int[] icon = new int[]{
	        		R.drawable.sikatgigi,
	        		R.drawable.periksa,
	        		
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
//	        getListView().setOnItemClickListener(new OnItemClickListener() {
//
//				@Override
//				public void onItemClick(AdapterView<?> arg0, View arg1,
//						int position, long arg3) {
//					// TODO Auto-generated method stub
///*					Object o = getListAdapter().getItem(position);*/
////					 String pilihan = o.toString();
//					String pilihan = list.get(position).getTitle();
//					Log.d("dg", "item "+pilihan);
//					 tampilkanPilihan(pilihan);
//				}
//			});
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
				 if (pilihan.equals("Sikat Gigi")){
					 i = new Intent (this, LayoutSikatGigi.class);
				 }
				 else {
					 i = new Intent (this, LayoutPeriksaGigi.class);

				 }
				 startActivity(i); 
			}
			catch (Exception e){
				e.printStackTrace();
			}
			
			
			
			
		 }

	
	}
        
 
	 
