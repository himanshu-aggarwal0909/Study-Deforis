package com.example.himanshu.studydeforis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayUserData extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter contactAdapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user_data);
        listview= (ListView)findViewById(R.id.display_user_listview);

        contactAdapter= new ContactAdapter(DisplayUserData.this,R.layout.activity_display_user_data_row_layout);
        listview.setAdapter(contactAdapter);
        json_string= getIntent().getExtras().getString("result");
        listview.setOnItemClickListener(DisplayUserData.this);
        if(json_string==null)
        {
            Toast.makeText(DisplayUserData.this,"GGGGGGGGGGGG",Toast.LENGTH_LONG).show();
        }
        else {
            try {
                jsonObject = new JSONObject(json_string);
                jsonArray = jsonObject.getJSONArray("server_result");

                if (jsonArray.length()!=0) {
                    Toast.makeText(DisplayUserData.this, "ggggggghhhhhhhhhhh", Toast.LENGTH_LONG).show();
                }

                int count = 0;
                String name, email, username, password;
                while (count < jsonArray.length()) {
                    JSONObject JO = jsonArray.getJSONObject(count);
                    name = JO.getString("name");
                    email = JO.getString("email");
                    username = JO.getString("username");
                    password = JO.getString("password");
                    Contacts contacts = new Contacts(name, email, username, password);
                    contactAdapter.add(contacts);
                    count++;

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        JSONObject collegedata;
        String collegename;
        Intent i = new Intent(DisplayUserData.this , Eachentry.class);
        i.putExtra("position" , position);
        try {
            jsonArray = jsonObject.getJSONArray("server_result");
            collegedata=jsonArray.getJSONObject(position);
            collegename= collegedata.getString("name");
            i.putExtra("stringname",collegename);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        startActivity(i);


    }
}
