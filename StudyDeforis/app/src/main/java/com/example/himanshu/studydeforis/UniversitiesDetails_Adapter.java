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
 * Created by Himanshu on 19-10-2016.
 */
public class UniversitiesDetails_Adapter extends ArrayAdapter{
    List list=new ArrayList();

    public UniversitiesDetails_Adapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        list.add(object);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row=convertView;
        Universityholder universityholder;
        if(row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.activity_display_universities__each_row,parent,false);
            universityholder = new Universityholder();
            universityholder.name=(TextView)row.findViewById(R.id.activity_display_universities_each_row_collegename);
            universityholder.country=(TextView)row.findViewById(R.id.activity_display_universities_each_row_collegecountry);
            universityholder.type=(TextView)row.findViewById(R.id.activity_display_universities_each_row_collegetype);
            universityholder.fees=(TextView)row.findViewById(R.id.activity_display_universities_each_row_collegefees);
            row.setTag(universityholder);

        }
        else
        {
            universityholder=(Universityholder)row.getTag();
        }

        UniversitiesDetails universitiesDetails = (UniversitiesDetails) this.getItem(position);
        universityholder.name.setText(universitiesDetails.getName());
        universityholder.country.setText(universitiesDetails.getCountry());
        universityholder.type.setText(universitiesDetails.getType());
        universityholder.fees.setText(universitiesDetails.getFees());

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

    static class Universityholder{
        TextView name , country , type , fees;
    }
}
