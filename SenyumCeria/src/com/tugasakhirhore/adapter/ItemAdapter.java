package com.tugasakhirhore.adapter;

/**
 * untuk menghubungkan activity utama dengan 
 * layout yang ada gambar dan teksnya
 */

import java.util.List;
import com.tugasakhirhore.model.ItemModel;
import com.tugasakhirhore.senyumceria.R;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter{
	
	private LayoutInflater inflater;
	private List<ItemModel> list;
	private ViewHolder holder;
	
	
	public ItemAdapter (Context context, List<ItemModel> list){
		this.inflater = LayoutInflater.from(context);
		this.list = list;
	}

	// jumlah datanya ada berapa
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	
	//Fungsi holder untuk mengidentifikasi icon dan title
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null){
			convertView = inflater.inflate(R.layout.item_list, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.titletips);
			holder.icon = (ImageView)convertView.findViewById(R.id.icon);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}
		Log.d("adapter", "icon "+list.get(position).getIcon());
		Log.d("adapter", "title "+list.get(position).getTitle());
		
		holder.title.setText(list.get(position).getTitle());
		holder.icon.setImageResource(list.get(position).getIcon());
		
		
		return convertView;
	}
	
	private class ViewHolder{
		ImageView icon;
		TextView title;
	}

}
