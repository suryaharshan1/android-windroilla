package com.example.tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.example.tasks.ReminderAlarm;
import com.example.tasks.categories.categories;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView l1;
	int mYear;
    int mMonth;
    int mDay;
    int mHour;
    int mMinute;
    Calendar c;
	static final int DATE_DIALOG_ID = 1;
	static final int TIME_DIALOG_ID = 0;
	boolean dateFlag=false;
	boolean timeFlag=false;
	int notificationCount;
	String time,contentTitle,Priority,selectedCategory,TIME;
	Context mContext;
	EditText e;    
	Button dt,tm,dialogButton;
	RadioGroup rg;
	RadioButton l,n,h,priority;
	Spinner categorySpinner;
	int selectedid; 
    List<RowItem> rowItems;
    RowItem itemData;
    CustomAdapter adapter;
    SQLiteDatabase db;
    Cursor cu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        
        rowItems = new ArrayList<RowItem>();
        l1=(ListView)findViewById(R.id.list);
        adapter = new CustomAdapter(this, rowItems);
        l1.setAdapter(adapter);
        
        //========================================
        db  = openOrCreateDatabase("tasks", MODE_WORLD_WRITEABLE,null);
        db.execSQL("create table if not exists tasksdetails(name VARCHAR,time VARCHAR,priority VARCHAR,category VARCHAR)");
        //db.execSQL("drop table tasksdetails");
        cu= db.rawQuery("select * from tasksdetails where priority = 'HIGH'", null); // null is for mode.
        
        while(cu.moveToNext()){
        	RowItem item = new RowItem(R.drawable.high,""+cu.getString(0),""+cu.getString(1),cu.getString(2),"("+cu.getString(3)+")");
        	rowItems.add(item);
        	adapter.notifyDataSetChanged();
        }
        cu= db.rawQuery("select * from tasksdetails where priority = 'NORMAL'", null); // null is for mode.
        
        while(cu.moveToNext()){
        	RowItem item = new RowItem(R.drawable.normal,""+cu.getString(0),""+cu.getString(1),cu.getString(2),"("+cu.getString(3)+")");
        	rowItems.add(item);
        	adapter.notifyDataSetChanged();
        }
        cu= db.rawQuery("select * from tasksdetails where priority = 'LOW'", null); // null is for mode.
        
        while(cu.moveToNext()){
        	RowItem item = new RowItem(R.drawable.low,""+cu.getString(0),""+cu.getString(1),cu.getString(2),"("+cu.getString(3)+")");
        	rowItems.add(item);
        	adapter.notifyDataSetChanged();
        }
        //==========================================
        l1.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub
				removeItemFromList(position);
				return false;
			}

			private void removeItemFromList(int position) {
				// TODO Auto-generated method stub
				final int deletePosition = position;
				 AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
				 	alert.setIcon(R.drawable.delete);
		            alert.setTitle("DELETE TASK");
		            alert.setMessage("Are you sure you want delete this Task?");
		            alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
		                public void onClick(DialogInterface dialog, int which) {
		                    // TOD O Auto-generated method stub
		                	
		                	Intent intentstop = new Intent(mContext, ReminderAlarm.class);
		                	PendingIntent senderstop = PendingIntent.getBroadcast(mContext,deletePosition+1, intentstop, 0);
		                	AlarmManager alarmManagerstop = (AlarmManager) getSystemService(ALARM_SERVICE);
		                	alarmManagerstop.cancel(senderstop);
		                	
		               //============deleting from database============ 
		                	itemData = rowItems.get(deletePosition);
		               
		                	db  = openOrCreateDatabase("tasks", MODE_WORLD_WRITEABLE,null);
		                	db.delete("tasksdetails", "name='"+itemData.getTitle()+"'",null);
		                	Toast.makeText(getApplicationContext(),"Task "+itemData.getTitle()+" deleted", Toast.LENGTH_SHORT).show();
		             //=====================================================================   	
		                        // main code on after clicking yes
		        
		                        rowItems.remove(deletePosition);
		                        adapter.notifyDataSetChanged();
		                        adapter.notifyDataSetInvalidated();
		          
		                }
		            });
		            alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
		                public void onClick(DialogInterface dialog, int which) {
		                    // TODO Auto-generated method stub
		                    dialog.dismiss();
		                }
		            });
		          
		            alert.show();
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	
    	switch (item.getItemId()) {
		case R.id.addicon:
			
			final AlertDialog dialogDetails;
			LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
			final View dialogview = inflater.inflate(R.layout.customdialog_layout, null);
			AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(this);
			dialogbuilder.setTitle("Add New Task");
			dialogbuilder.setView(dialogview);
			dialogDetails = dialogbuilder.create();
			dialogDetails.show();
			TextView t = (TextView)dialogview.findViewById(R.id.textView1);
			t.setText("Task :");
			e =(EditText) dialogview.findViewById(R.id.dialogTaskText); 
			dt=(Button)dialogview.findViewById(R.id.datebutton);
			tm=(Button)dialogview.findViewById(R.id.timebutton);
			rg=(RadioGroup)dialogview.findViewById(R.id.radioGroup1);
			l=(RadioButton)dialogview.findViewById(R.id.radio0);
			n=(RadioButton)dialogview.findViewById(R.id.radio1);
			h=(RadioButton)dialogview.findViewById(R.id.radio2);
			categorySpinner=(Spinner)dialogview.findViewById(R.id.spinnercategory);
			dialogButton = (Button) dialogview.findViewById(R.id.dialogButton);
			TextListener textListener=new TextListener();
			dt.setEnabled(false);
			tm.setEnabled(false);
			l.setEnabled(false);
			n.setEnabled(false);
			h.setEnabled(false);
			categorySpinner.setEnabled(false);
			dialogButton.setEnabled(false);
			e.addTextChangedListener(textListener);
			List<String> list = new ArrayList<String>();
	    	list.add("DAILY");
	    	list.add("WEEKLY");
	    	list.add("MONTHLY");
	    	list.add("YEARLY");
	    	list.add("BIRTHDAYS");
	    	list.add("ANIVERSARIES");
	    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
	    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    	categorySpinner.setAdapter(dataAdapter);
			tm.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
						showDialog(TIME_DIALOG_ID);
				}
			});
			dt.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
						showDialog(DATE_DIALOG_ID);
				}
			});
			categorySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> adapterView,
						View arg1, int position, long arg3) {
					// TODO Auto-generated method stub
					selectedCategory=adapterView.getItemAtPosition(position).toString();
					//Toast.makeText(adapterView.getContext(),adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

				}

				@Override
				public void onNothingSelected(
						AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			dialogButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
				if(dateFlag==true && timeFlag==true){
					notificationCount  = notificationCount+1;
				      dateFlag = false;
				      timeFlag = false;
				      time = mYear+"-"+mMonth+"-"+mDay+" "+mHour+"-"+mMinute;                                
				            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm");  
				            Date date = null;
				            try {
				            			date = df.parse(time);
				            	} catch (ParseException e) {
				            		// TODO Auto-generated catch block
				            		e.printStackTrace();
				            	}                                        
				            long when = date.getTime();            
				            selectedid=rg.getCheckedRadioButtonId();
						    priority=(RadioButton)dialogview.findViewById(selectedid);
				            contentTitle = e.getText().toString(); 
				            Priority = priority.getText().toString();
				            
				         AlarmManager mgr = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
				         Intent notificationIntent = new Intent(mContext, ReminderAlarm.class);
				         notificationIntent.putExtra("Name",contentTitle ); 
				         notificationIntent.putExtra("PRIORITY", Priority);
				         notificationIntent.putExtra("Category", selectedCategory);
				         notificationIntent.putExtra("Ringtonelow",getResources().getResourceName(R.raw.low));
				         notificationIntent.putExtra("Ringtonenormal",getResources().getResourceName(R.raw.normal));
				         notificationIntent.putExtra("Ringtonehigh",getResources().getResourceName(R.raw.high));
				         notificationIntent.putExtra("NotifyCount",notificationCount );
				         PendingIntent pi = PendingIntent.getBroadcast(mContext, notificationCount, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				         mgr.set(AlarmManager.RTC_WAKEUP,when, pi);
				         Toast.makeText(mContext, "A NEW TASK ADDED", Toast.LENGTH_LONG).show();
				   //================================================== 
				         TIME=mDay+"/"+mMonth+"/"+mYear+" "+mHour+":"+mMinute;
				         ContentValues values = new ContentValues();
				         values.put("name", contentTitle);
				         values.put("time", TIME);
				         values.put("priority", Priority);
				         values.put("category", selectedCategory);
				         db.insert("tasksDetails", null, values);
				   //===================================================
				    if(Priority.equals("HIGH")){     
					RowItem item = new RowItem(R.drawable.high, e.getText().toString(),""+TIME,""+Priority,"("+selectedCategory+")");
		            rowItems.add(item);
		            adapter.notifyDataSetChanged();
					dialogDetails.dismiss();
				    	}
				    if(Priority.equals("NORMAL")){     
						RowItem item = new RowItem(R.drawable.normal, e.getText().toString(),""+TIME,""+Priority,"("+selectedCategory+")");
			            rowItems.add(item);
			            adapter.notifyDataSetChanged();
						dialogDetails.dismiss();
					    }
				    if(Priority.equals("LOW")){     
						RowItem item = new RowItem(R.drawable.low, e.getText().toString(),""+TIME,""+Priority,"("+selectedCategory+")");
			            rowItems.add(item);
			            adapter.notifyDataSetChanged();
						dialogDetails.dismiss();
					    }
				}
				else if (dateFlag==false) {
					Toast.makeText(getApplicationContext(), "Please set Date!!", Toast.LENGTH_SHORT).show();
				}
				else if (timeFlag==false) {
					Toast.makeText(getApplicationContext(), "Please set Time!!", Toast.LENGTH_SHORT).show();
				}
				}
			});  
			
			break;
		case R.id.categories:
			{
				Intent i=new Intent(mContext,categories.class);
				startActivity(i);
			}
		default:
			break;
		}
    	
    	return super.onOptionsItemSelected(item);
    }
    public class TextListener implements TextWatcher{

    	   @Override
    	  public void afterTextChanged(Editable s) {
    	   // TODO Auto-generated method stub   
    	  }

    	   @Override
    	  public void beforeTextChanged(CharSequence s, int start, int count,
    	    int after) {
    	   // TODO Auto-generated method stub   
    	  }

    	   @Override
    	  public void onTextChanged(CharSequence s, int start, int before,
    	    int count) {
    	   // TODO Auto-generated method stub
    	   if(e.getText().length()==0){
    	    dt.setEnabled(false);
    	    tm.setEnabled(false);
    	    dialogButton.setEnabled(false);
    	    l.setEnabled(false);
			n.setEnabled(false);
			h.setEnabled(false);
			categorySpinner.setEnabled(false);
    	   }
    	   else if(e.getText().length()>0){
    	    dt.setEnabled(true);
    	    tm.setEnabled(true);
    	    dialogButton.setEnabled(true);
    	    l.setEnabled(true);
			n.setEnabled(true);
			h.setEnabled(true);
			categorySpinner.setEnabled(true);
    	   }
    	  }     
    }
  
    @Override
    protected Dialog onCreateDialog(int id) {
     // TODO Auto-generated method stub
     switch (id) {
      case TIME_DIALOG_ID:
         return new TimePickerDialog(this,
              mTimeSetListener, mHour, mMinute, false);
      case DATE_DIALOG_ID:
          return new DatePickerDialog(this,
                      mDateSetListener,
                      mYear, mMonth, mDay);
      }
     return super.onCreateDialog(id);
    }
    
    private DatePickerDialog.OnDateSetListener mDateSetListener =
        new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                    int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear+1;
                mDay = dayOfMonth;                
                dateFlag = true;
            }
    };
        
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
        new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mHour = hourOfDay;
                mMinute = minute;
                timeFlag = true;
            }
    };
     public void calendar(View view){
    	 Toast.makeText(mContext, "calendar", Toast.LENGTH_LONG).show();
     }
    
}
