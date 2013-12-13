package com.friendfinder1600;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactAdapter extends ArrayAdapter<Contact>
{
	int resource;
    String response;
    Context context;
    
	public ContactAdapter(Context context, int resource, List<Contact> items) 
	{
        super(context, resource, items);
        this.resource = resource;
    }
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LinearLayout contactView;
        //Get the current alert object
        Contact al = getItem(position);
         
        //Inflate the view
        if(convertView==null)
        {
            contactView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater)getContext().getSystemService(inflater);
            vi.inflate(resource, contactView, true);
        }
        else
        {
            contactView = (LinearLayout) convertView;
        }
        //Get the text boxes from the listitem.xml file
        TextView alertText = (TextView)contactView.findViewById(R.id.contactName);
        
        //Assign the appropriate data from our alert object above
        alertText.setText(al.getName());
        
        return contactView;
    }
}
