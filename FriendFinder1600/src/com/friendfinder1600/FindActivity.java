package com.friendfinder1600;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FindActivity extends FragmentActivity 
{
	public ContactList contactList = ContactList.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find);
		
		ListView listview = (ListView) findViewById(R.id.listView1);
		ContactAdapter contactAdapter;
		
		contactList.populateList(getApplicationContext());
		Vector<Contact> list = contactList.getContactList();
		
		List<Contact> arrayList = new ArrayList<Contact>(list);
		contactAdapter = new ContactAdapter(FindActivity.this, R.layout.listitem, arrayList);
		listview.setAdapter(contactAdapter);
		
		listview.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				//Toast.makeText(getApplicationContext(), "Position:  " + arg2, Toast.LENGTH_SHORT).show();
				
				ConfirmAction temp = new ConfirmAction();
				temp.setPosition(arg2);
				temp.getContext(getApplicationContext());
				
				temp.show(getSupportFragmentManager(), "Find Contact");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.find, menu);
		return true;
	}
}
