package GPSTracker;

public class GPSCoordinates 
{
	//this will parse out the long
	//Format is Coordinates:latitude:longitude
	public static Double getLongitude(String coordinates)
	{
		String[] longitude = coordinates.split(":");
		
		return Double.parseDouble(longitude[2]);
	}
	
	public static Double getLatitude(String coordinates)
	{
		String[] latitude = coordinates.split(":");
		
		return Double.parseDouble(latitude[1]);
	}
}
