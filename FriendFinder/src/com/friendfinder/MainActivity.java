package com.friendfinder;

import java.util.Vector;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button myButton;
	public ContactList newList = ContactList.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myButton = (Button) findViewById(R.id.button1);
		newList.populateList(getApplicationContext());
		
		final Vector<Contact> sList = newList.getContactList();
		
		myButton.setOnClickListener(new View.OnClickListener() 
		{	
			@Override
			public void onClick(View v)
			{
				/*Intent intent = new Intent(getApplicationContext(), MapActivity.class);
				startActivity(intent);*/
				
				for(int i = 0; i < sList.size(); i++)
				{
					Toast.makeText(getApplicationContext(), "Contact:	" + sList.elementAt(i).getName() + "	Number:		" + sList.elementAt(0).getNumber(), Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
