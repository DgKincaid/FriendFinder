package GPSTracker;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;

import com.friendfinder1600.ContactList;

public class GPSLocation 
{
	private static GPSLocation location;
	
	private String longitude = "";
	private String latitude = "";
	
	public static GPSLocation getInstance()
	{
		if(location == null)
		{
			location = new GPSLocation();
		}
		return location;
	}
	
	public void addLongitude(String lon)
	{
		longitude = lon;
	}
	public void addLatitude(String lat)
	{
		latitude = lat;
	}
	
	public String getLongitude()
	{
		return longitude;
	}
	public String getLatitude()
	{
		return latitude;
	}
}
