package com.example.himanshu.studydeforis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Eachentry extends AppCompatActivity {
    String result_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eachentry);

        result_name = getIntent().getExtras().getString("stringname");

        TextView tx = (TextView)findViewById(R.id.eachentry_txcollegename);
        tx.setText(result_name);

    }
}
