package com.friendfinder;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TextMessage 
{
	public void sendMessage(String text, String number, Context context)
	{
		try
		{
			Intent intent = new Intent(Intent.ACTION_VIEW);
			
			intent.putExtra("sms_body", text); 
	        intent.putExtra("address", number);
	        intent.setType("vnd.android-dir/mms-sms");
			
		} catch (Exception e)
		{
			Toast.makeText(context, "Error sending text message", Toast.LENGTH_SHORT).show();
		}
	}
}
