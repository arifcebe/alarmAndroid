package com.tugasakhirhore.model;

/**
 * Untuk membuat model pada tampilan listview
 * struktur yang dihasilkan berupa icon dan judul
 * 
 * @author Dyah Litaa
 *
 */

public class ItemModel {
	private int icon;
	private String title;
	
	public ItemModel(int icon, String title) {
		// TODO Auto-generated constructor stub
		super();
		this.icon = icon;
		this.title = title;
	}
	
	//get unutk mengambil icon
	public int getIcon() {
		return icon;
	}
	
	//setter untuk mengubah gambar yang tercantum dalam setiap list
	public void setIcon(int icon) {
		this.icon = icon;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
