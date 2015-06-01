package com.example.reminder;

import java.util.Calendar;




import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;


public class MainActivity extends Activity {
	TimePicker timePicker;
	EditText edSikatPagi;
	ToggleButton tglBtnSikatPagi;
	
	TimePicker timePickerMalam;
	EditText edSikatMalam;
	ToggleButton tglBtnSikatMalam;
	
	DatePicker datePickerCheckUp;
	EditText edCheckUp;
	ToggleButton tglBtnCheckUp;
	
	TimePickerDialog timePickerDialog;
	TimePickerDialog timePickerDialogMalam;
	DatePickerDialog datePickerDialogCheckUp;
	
	private String[] arrMonth = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	
	final static int RQS_1 = 1;
	
	JadwalAlarmReceiver alarm;
	Editor editor;
	
	
protected void onCreate(Bundle savedInstanceState) {
		
		
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edSikatPagi = (EditText) findViewById(R.id.editPagi);
		tglBtnSikatPagi = (ToggleButton) findViewById(R.id.togglePagi);
		
		edSikatMalam = (EditText) findViewById(R.id.editMalam);
		tglBtnSikatMalam = (ToggleButton) findViewById(R.id.toggleMalam);
		
		edCheckUp = (EditText) findViewById(R.id.editPeriksa);
		tglBtnCheckUp= (ToggleButton) findViewById(R.id.togglePeriksa);
		

		alarm = new JadwalAlarmReceiver();
		
		//call shared preference to save actived status
		// sikat pagi
		SharedPreferences pref = PreferenceManager
				.getDefaultSharedPreferences(this); // ini nama variabelnya jugak
		editor = pref.edit();
		boolean isChecked = pref.getBoolean("isChecked", false); // ini harus dirubah
		String jadwalPagi = pref.getString("jadwalPagi", null); // ini jugak
		/* end set preference sikat gigi pagi */

		if (isChecked == false) {
			tglBtnSikatPagi.setChecked(false);
		} else {
			tglBtnSikatPagi.setChecked(true);
		}

		if (jadwalPagi == null) {
			edSikatPagi.setText("");
		} else {
			edSikatPagi.setText(jadwalPagi);
		}

		edSikatPagi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				openTimePickerDialog(false);
			}
		});

		tglBtnSikatPagi
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton btn,
							boolean isChecked) {
						// TODO Auto-generated method stub
						Log.d("tag", "ischek "+isChecked);
						if (isChecked) {
							//edSikatPagi.setEnabled(true);
							editor.putBoolean("isChecked", true);

						} else {
							alarm.stopAlarm(MainActivity.this);
							//edSikatPagi.setEnabled(false);
							editor.putBoolean("isChecked", false);
						}
						editor.commit();
					}
				});
		
		
		
		//call shared preference to save actived status
				// SIKAT MALAM
				SharedPreferences prefMalam = PreferenceManager
						.getDefaultSharedPreferences(this); // ini nama variabelnya jugak
				editor = prefMalam.edit();
				boolean isCheckedMalam = prefMalam.getBoolean("isCheckedMalam", false); // ini harus dirubah
				String jadwalMalam = prefMalam.getString("jadwalMalam", null); // ini jugak
				/* end set preference SIKAT GIGI MALAM */

				if (isCheckedMalam == false) {
					tglBtnSikatMalam.setChecked(false);
				} else {
					tglBtnSikatMalam.setChecked(true);
				}

				if (jadwalMalam == null) {
					edSikatMalam.setText("");
				} else {
					edSikatMalam.setText(jadwalMalam);
				}

				edSikatMalam.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						openTimePickerDialogMalam(false);
					}
				});

				tglBtnSikatMalam
						.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

							@Override
							public void onCheckedChanged(CompoundButton btn,
									boolean isCheckedMalam) {
								// TODO Auto-generated method stub
								Log.d("tag", "ischek "+isCheckedMalam);
								if (isCheckedMalam) {
									//edSikatPagi.setEnabled(true);
									editor.putBoolean("isCheckedMalam", true);

								} else {
									alarm.stopAlarm(MainActivity.this);
									//edSikatPagi.setEnabled(false);
									editor.putBoolean("isCheckedMalam", false);
								}
								editor.commit();
							}
						});

				

				//call shared preference to save actived status
						// CHECK UP
						SharedPreferences prefCheck = PreferenceManager
								.getDefaultSharedPreferences(this); // ini nama variabelnya jugak
						editor = prefCheck.edit();
						boolean isCheckedCheck = prefCheck.getBoolean("isCheckedCheck", false); // ini harus dirubah
						String jadwalCheck = prefCheck.getString("jadwalCheck", null); // ini jugak
						/* end set preference CHECK UP */

						if (isCheckedCheck == false) {
							tglBtnCheckUp.setChecked(false);
						} else {
							tglBtnCheckUp.setChecked(true);
						}

						if (jadwalCheck == null) {
							edCheckUp.setText("");
						} else {
							edCheckUp.setText(jadwalCheck);
						}

						edCheckUp.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View arg0) {
								// TODO Auto-generated method stub
								openDatePickerDialogCheckUp(false);
							}
						});

						tglBtnCheckUp
								.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

									@Override
									public void onCheckedChanged(CompoundButton btn,
											boolean isCheckedCheck) {
										// TODO Auto-generated method stub
										Log.d("tag", "ischek "+isCheckedCheck);
										if (isCheckedCheck) {
											//edSikatPagi.setEnabled(true);
											editor.putBoolean("isCheckedCheck", true);

										} else {
											alarm.stopAlarm(MainActivity.this);
											//edSikatPagi.setEnabled(false);
											editor.putBoolean("isCheckedCheck", false);
										}
										editor.commit();
									}
								});
						
						


	}
	

	/**
	 * handle pilih jam kemudian langsung diset ke alarm
	 */
	OnTimeSetListener onTimeSetListener = new OnTimeSetListener() {

		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

			Calendar calNow = Calendar.getInstance();
			Calendar calSet = (Calendar) calNow.clone();

			calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
			calSet.set(Calendar.MINUTE, minute);
			calSet.set(Calendar.SECOND, 0);
			calSet.set(Calendar.MILLISECOND, 0);
			String jam = hourOfDay + ":" + minute;

			edSikatPagi.setText(jam);
			
			// menyimpan jam ke shared preference
			editor.putString("jadwalPagi", jam);
			editor.commit();
			
			// kirim jam untuk disetting sebagai alarm
			alarm.startAlarm(MainActivity.this, calSet);
		}
	};

	/**
	 * handle pilih jam kemudian langsung diset ke alarm
	 */
	OnTimeSetListener onTimeSetListenerMalam = new OnTimeSetListener() {

		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

			Calendar calNow = Calendar.getInstance();
			Calendar calSet = (Calendar) calNow.clone();

			calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
			calSet.set(Calendar.MINUTE, minute);
			calSet.set(Calendar.SECOND, 0);
			calSet.set(Calendar.MILLISECOND, 0);
			String jam = hourOfDay + ":" + minute;

			edSikatMalam.setText(jam);
			
			// menyimpan jam ke shared preference
			editor.putString("jadwalMalam", jam);
			editor.commit();
			
			// kirim jam untuk disetting sebagai alarm
			alarm.startAlarm(MainActivity.this, calSet);
		}
	};

	
	
	/**
	 * handle pilih jam kemudian langsung diset ke alarm
	 */
	OnDateSetListener onDateSetListenerCheckUp = new OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {

			Calendar calNow = Calendar.getInstance();
			Calendar calSet = (Calendar) calNow.clone();

			calSet.set(Calendar.YEAR, year);
			calSet.set(Calendar.MONTH, monthOfYear);
			calSet.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			String jam = dayOfMonth + "-" + arrMonth[monthOfYear] + "-" + year;

			edCheckUp.setText(jam);
			
			// menyimpan jam ke shared preference
			editor.putString("jadwalCheck", jam);
			editor.commit();
			
			// kirim jam untuk disetting sebagai alarm
			alarm.startAlarm(MainActivity.this, calSet);
			
		}
	};

	
	private void openTimePickerDialog(boolean is24r) {
		Calendar calendar = Calendar.getInstance();

		timePickerDialog = new TimePickerDialog(MainActivity.this,
				onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY),
				calendar.get(Calendar.MINUTE), true);
		timePickerDialog.setTitle("Set Alarm!");

		timePickerDialog.show();

	}
	
	
	private void openTimePickerDialogMalam(boolean is24r) {
		
		Calendar calendar = Calendar.getInstance();

		timePickerDialogMalam = new TimePickerDialog(MainActivity.this,
				onTimeSetListenerMalam, calendar.get(Calendar.HOUR_OF_DAY),
				calendar.get(Calendar.MINUTE), true);
		timePickerDialogMalam.setTitle("Set Alarm!");

		timePickerDialogMalam.show();

	}
	
	private void openDatePickerDialogCheckUp(boolean b) {
		
		Calendar calendar = Calendar.getInstance();
		
		datePickerDialogCheckUp = new DatePickerDialog(MainActivity.this, onDateSetListenerCheckUp, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
		datePickerDialogCheckUp.setTitle("Set Alarm!");
		 
		datePickerDialogCheckUp.show();

		/*datePickerDialogCheckUp = new DatePickerDialog(LayoutPengingatJadwal.this,
				onDateSetListenerCheckUp, calendar.get(Calendar.YEAR),
				calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH),true);*/
		 
		//datePickerDialogCheckUp.setTitle("Set Alarm!");

		//datePickerDialogCheckUp.show();

	}
	
	


}
