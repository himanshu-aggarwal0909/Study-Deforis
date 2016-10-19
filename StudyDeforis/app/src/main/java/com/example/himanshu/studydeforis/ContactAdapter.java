package com.example.himanshu.studydeforis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Himanshu on 12-10-2016.
 */

public class ContactAdapter extends ArrayAdapter{
    List list = new ArrayList();

    public ContactAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Contacts object)
    {
        list.add(object);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row=convertView;
        ContactHolder contactHolder;
        if(row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.activity_display_user_data_row_layout,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.name=(TextView)row.findViewById(R.id.activity_displayuserdata_row_layout_username);
            contactHolder.email=(TextView)row.findViewById(R.id.activity_displayuserdata_row_layout_useremail);
            contactHolder.username=(TextView)row.findViewById(R.id.activity_displayuserdata_row_layout_user_username);
            contactHolder.password=(TextView)row.findViewById(R.id.activity_displayuserdata_row_layout_userpassword);
            row.setTag(contactHolder);

        }
        else
        {
            contactHolder=(ContactHolder)row.getTag();
        }

        Contacts contacts = (Contacts)this.getItem(position);
        contactHolder.name.setText(contacts.getName());
        contactHolder.email.setText(contacts.getEmail());
        contactHolder.username.setText(contacts.getUsername());
        contactHolder.password.setText(contacts.getPassword());

        return row;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {

        return list.size();
    }

    static class ContactHolder {
        TextView name , email , username , password ;


    }


}
