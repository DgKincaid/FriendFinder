package com.friendfinder;

import java.util.ArrayList;
import java.util.Vector;

import GPSTracker.GPSCoordinates;
import GPSTracker.MyLocationListener;
import SMSMessage.TextMessage;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	private Button sendButton;
	private Button findButton;
	public ContactList list = ContactList.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sendButton = (Button) findViewById(R.id.button1);
		findButton = (Button) findViewById(R.id.button2);
		
		list.populateList(getApplicationContext());
		final Vector<Contact> temp = list.getContactList();
		final TextMessage mes = new TextMessage();
		
		LocationManager locManager = (LocationManager)getSystemService(getApplicationContext().LOCATION_SERVICE);

		LocationListener mlocListener = new MyLocationListener(locManager);
		locManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
		
		sendButton.setOnClickListener(new View.OnClickListener() 
		{	
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(getApplicationContext(), SendActivity.class);
				startActivity(intent);
				
				//Toast.makeText(getApplicationContext(), "Contact" , Toast.LENGTH_SHORT).show();
			}
		});
		
		findButton.setOnClickListener(new View.OnClickListener() 
		{	
			@Override
			public void onClick(View v) 
			{	
				Intent intent = new Intent(getApplicationContext(), FindActivity.class);
				startActivity(intent);
				
				//Toast.makeText(getApplicationContext(), "Contact" + temp.elementAt(1).getName(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
