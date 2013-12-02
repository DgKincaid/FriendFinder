package GPSTracker;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class MyLocationListener implements LocationListener
{
	private LocationManager locManager;
	private GPSLocation gpsLoc = GPSLocation.getInstance();
	
	public MyLocationListener(LocationManager loc)
	{
		locManager = loc;
	}
	
	@Override
	public void onLocationChanged(Location loc) 
	{
		locManager.removeUpdates(this);
		
		String lat = Double.toString(loc.getLatitude());
		String lon = Double.toString(loc.getLongitude());
		
		gpsLoc.addLatitude(lat);
		gpsLoc.addLongitude(lon);
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}
