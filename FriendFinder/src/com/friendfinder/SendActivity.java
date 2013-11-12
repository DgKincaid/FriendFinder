package com.friendfinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SendActivity extends Activity 
{
	private Button backButton;
	public ContactList contactList = ContactList.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send);
		
		ListView listview = (ListView) findViewById(R.id.listView1);
		ContactAdapter contactAdapter;
		
		contactList.populateList(getApplicationContext());
		Vector<Contact> list = contactList.getContactList();
		
		/*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactList.getContactNames());
		listview.setAdapter(adapter);*/
		
		List<Contact> arrayList = new ArrayList<Contact>(list);
		contactAdapter = new ContactAdapter(SendActivity.this, R.layout.listitem, arrayList);
		listview.setAdapter(contactAdapter);
		
		backButton = (Button) findViewById(R.id.button1);
		
		backButton.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.send, menu);
		return true;
	}
}
