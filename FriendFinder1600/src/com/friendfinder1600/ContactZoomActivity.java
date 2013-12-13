package com.friendfinder1600;

import java.util.Vector;

//import com.google.android.gms.location.LocationListener;

import GPSTracker.GPSLocation;
import GPSTracker.MyLocationListener;
import SMSMessage.TextMessage;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ContactZoomActivity extends Activity 
{
	public ContactList contactList = ContactList.getInstance();
	public GPSLocation gpsLoc = GPSLocation.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_zoom);
		
		contactList.populateList(getApplicationContext());
		final Vector<Contact> list = contactList.getContactList();
		
		Button sendButton = (Button) findViewById(R.id.button2);
		
		TextView itemName = (TextView) findViewById(R.id.textView2);
		TextView itemNum = (TextView) findViewById(R.id.textView1);
		
		Bundle extras = getIntent().getExtras();
		int value = -1;
		
		if (extras != null) 
		{
		    value = extras.getInt("position");
		}
		final int pos = value;
		
		itemName.setText(list.elementAt(value).getName());
		itemNum.setText(list.elementAt(value).getNumber());
		
		final TextMessage myMessage = new TextMessage();
		
		sendButton.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				//This is where the text will be sent
				//Will also get the long and lat of user
				
				LocationManager locManager = (LocationManager)getSystemService(getApplicationContext().LOCATION_SERVICE);

				LocationListener mlocListener = new MyLocationListener(locManager);
				locManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
				
				String cor = "Coordinates:" +  gpsLoc.getLatitude() + ":" + gpsLoc.getLongitude();
				
				//Toast.makeText(getApplicationContext(), cor, Toast.LENGTH_LONG).show();
				
				//Toast.makeText(getApplicationContext(), "Number:	" + list.elementAt(pos).getNumber(), Toast.LENGTH_LONG).show();
				//sendSMS(gpsLoc.getLatitude() + ":" + gpsLoc.getLongitude(), list.elementAt(pos).getNumber());
				myMessage.sendMessage(cor, list.elementAt(pos).getNumber());
				//sendSMS("test", list.elementAt(pos).getNumber());
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_zoom, menu);
		return true;
	}
	
	/*
	private void sendSMS(String message, String number)
    {        
        PendingIntent pi = PendingIntent.getActivity(this, 0,
            new Intent(this, MainActivity.class), 0);                
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(number, null, message, pi, null);        
    }  
    */
}
