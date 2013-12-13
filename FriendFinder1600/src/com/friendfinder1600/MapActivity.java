package com.friendfinder1600;

import com.google.android.gms.maps.GoogleMap;

import GPSTracker.GPSCoordinates;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.Toast;

public class MapActivity extends FragmentActivity 
{
	GoogleMap mMap;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		Bundle extras = getIntent().getExtras();
		String body = "";
		
		if (extras != null) 
		{
		    body = extras.getString("body");
		}
		
		FragmentManager fmanager = getSupportFragmentManager();
        Fragment fragment = fmanager.findFragmentById(R.id.map);
        SupportMapFragment supportmapfragment = (SupportMapFragment)fragment;
        GoogleMap supportMap = supportmapfragment.getMap();
		
        supportMap.setMyLocationEnabled(true);
        supportMap.addMarker(new MarkerOptions().position(new LatLng(GPSCoordinates.getLatitude(body),GPSCoordinates.getLongitude(body))).title("Hello World"));
		//Toast.makeText(getApplicationContext(), "Lat:	" + GPSCoordinates.getLatitude(body), Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

}
