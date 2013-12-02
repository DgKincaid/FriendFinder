package SMSMessage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

public class TextMessage extends Activity
{
	public void sendMessage(String message, String number)
	{
		if(!message.equals(null))
		{
			//PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, TextMessage.class), 0);                
			SmsManager sms = SmsManager.getDefault();
			sms.sendTextMessage(number, null, message, null, null);    
		}
		else
		{
			Toast.makeText(getApplicationContext(), "Message is null", Toast.LENGTH_LONG).show();
		}
	}
	
	public String readMessage(Context context, String number)
	{
		String n = "9785182318";
		
		//change this to get the last 3 messages and also see if message contains the identifiing detail
		Uri uriSMSURI = Uri.parse("content://sms/inbox");
        Cursor cur = context.getContentResolver().query(uriSMSURI, null, "address='" + number.replaceAll("[^0-9]", "") + "'", null,null);
        String sms = "";
        if (cur.moveToNext()) 
        {
            sms += cur.getString(cur.getColumnIndex("body"))+"\n";         
        }
        
        Toast.makeText(context, "Number:  " + number.replaceAll("[^0-9]", "") + " Body:  " + sms, Toast.LENGTH_LONG).show();
        return sms;
	}
}
