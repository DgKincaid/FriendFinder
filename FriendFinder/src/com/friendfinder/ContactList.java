package com.friendfinder;

import java.util.Vector;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.util.Log;
import android.widget.Toast;

public class ContactList 
{
	private static ContactList contactList;
	
	private Vector<Contact> conList = new Vector<Contact>();
	
	private ContactList(){}
	
	public static ContactList getInstance()
	{
		if(contactList == null)
		{
			contactList = new ContactList();
		}
		return contactList;
	}
	
	public Vector<Contact> getContactList()
	{
		return conList;
	}
	
	public void populateList(Context context)
	{
		String contactName = null;
		String phoneNumber = null;
		
		Cursor cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
		
		while (cursor.moveToNext()) 
		{
		    contactName  = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
		    phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
		    
		    //Toast.makeText(context, "Contact Name" + contactName, Toast.LENGTH_LONG).show();
		    
		    Contact myContact = new Contact(contactName, phoneNumber);
		    
		    conList.addElement(myContact);
		}
	}
}
