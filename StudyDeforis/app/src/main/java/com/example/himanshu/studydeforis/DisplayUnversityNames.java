package com.example.himanshu.studydeforis;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayUnversityNames extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String details;
    JSONObject jsonObject;
    JSONArray jsonArray;
    JSONObject Jo;
    ListView listView;
    UniversitiesDetails_Adapter universitiesDetails_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_unversity_names);
        details=getIntent().getExtras().getString("result");
        listView=(ListView)findViewById(R.id.display_universities_listview);
        universitiesDetails_adapter=new UniversitiesDetails_Adapter(DisplayUnversityNames.this , R.layout.activity_display_universities__each_row);
        listView.setAdapter(universitiesDetails_adapter);
        listView.setOnItemClickListener(DisplayUnversityNames.this);
        if(details==null)
        {
            Toast.makeText(DisplayUnversityNames.this ,"Error in getting data" , Toast.LENGTH_LONG).show();
        }

        try {
            jsonObject = new JSONObject(details);
            jsonArray=jsonObject.getJSONArray("server_result");
            int count=0;
            String Name , Country , Type , Fees;
            while(count<jsonArray.length())
            {
                Jo =jsonArray.getJSONObject(count);
                Name=Jo.getString("Name");
                Country=Jo.getString("Country");
                Type=Jo.getString("Type");
                Fees=Jo.getString("Fees");
                if(Type==null)
                {
                    Toast.makeText(DisplayUnversityNames.this ,"Error in gettingType" , Toast.LENGTH_LONG).show();
                }
                UniversitiesDetails universitiesDetails = new UniversitiesDetails(Name,Country,Type,Fees);
                universitiesDetails_adapter.add(universitiesDetails);
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        JSONObject collegedata;
        String collegename;
        String collegetype;
        String fees;
        String country;
        Intent i = new Intent(DisplayUnversityNames.this , CollegeProfile.class);
        i.putExtra("position" , position);
        try {
            jsonArray = jsonObject.getJSONArray("server_result");
            collegedata=jsonArray.getJSONObject(position);
            collegename= collegedata.getString("Name");
            collegetype=collegedata.getString("Type");
            country=collegedata.getString("Country");
            fees=collegedata.getString("Fees");
            i.putExtra("Name",collegename);
            i.putExtra("Country",country);
            i.putExtra("Type",collegetype);
            i.putExtra("Fess",fees);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        startActivity(i);
    }
}
