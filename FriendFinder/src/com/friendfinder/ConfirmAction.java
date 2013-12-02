package com.friendfinder;

import java.util.Vector;

import SMSMessage.TextMessage;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ConfirmAction extends DialogFragment
{
	private int position;
	private Context context;
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) 
	{
		final TextMessage smsMessage = new TextMessage();
		
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
        ContactList myList = ContactList.getInstance();
        final Vector<Contact> list = myList.getContactList();
        
        builder.setMessage(list.elementAt(position).getName())
               .setPositiveButton(R.string.find, new DialogInterface.OnClickListener() 
               {
                   public void onClick(DialogInterface dialog, int id)
                   {
                       //call find function here using the int position to get number
                	   String body = smsMessage.readMessage(context, list.elementAt(position).getNumber());
                	   Intent intent = new Intent(context, MapActivity.class);
                	   intent.putExtra("body", body);
                	   startActivity(intent);
                   }
               })
               .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() 
               {
                   public void onClick(DialogInterface dialog, int id) 
                   {
                       // User cancelled the dialog
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
	
	//This function makes the choice whether the fragment is being build in the find or send activity
	// 0 means that it is the send and 1 is find
	public void choice(int choice)
	{
		
	}

	public void setPosition(int pos) 
	{
		position = pos;
	}
	
	public void getContext(Context con)
	{
		context = con;
	}
}
