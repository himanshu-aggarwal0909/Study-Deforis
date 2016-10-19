package com.example.himanshu.studydeforis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CollegeProfile extends AppCompatActivity {

    TextView tv_name;
    TextView tv_type;
    TextView tv_fees;

    String name;
    String type;
    String country;
    String fees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_profile);
        Intent i = getIntent();
        name=i.getExtras().getString("Name");
        type=i.getExtras().getString("Type");
        country=i.getExtras().getString("Country");
        fees=i.getExtras().getString("Fees");
        tv_name=(TextView)findViewById(R.id.collegeprofile_name);
        tv_type=(TextView)findViewById(R.id.collegeprofile_type);
        tv_fees=(TextView)findViewById(R.id.collegeprofile_fees);

        tv_fees.setText(fees);
        tv_name.setText(name);
        tv_type.setText(type);

    }
}
