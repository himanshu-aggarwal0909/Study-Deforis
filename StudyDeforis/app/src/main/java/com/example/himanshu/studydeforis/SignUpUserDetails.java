package com.example.himanshu.studydeforis;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignUpUserDetails extends AppCompatActivity {
    String method;
    String method1;
    AutoCompleteTextView et_collegename;
    AutoCompleteTextView et_coursename;
    EditText et_undescore;
    EditText et_workexp;
    AutoCompleteTextView et_dreamcollege;
    AutoCompleteTextView et_dreamcourse;
    Button savebutton;
    String username;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_user_details);
        et_collegename=(AutoCompleteTextView)findViewById(R.id.signupuserdetails_collegename);
        et_coursename=(AutoCompleteTextView)findViewById(R.id.signupuserdetails_course);
        et_undescore=(EditText)findViewById(R.id.signupuserdetails_collegescore);
        et_workexp=(EditText)findViewById(R.id.signupuserdetails_workexptime);
        et_dreamcollege=(AutoCompleteTextView)findViewById(R.id.signupuserdetails_Dreamcollegename);
        et_dreamcourse=(AutoCompleteTextView)findViewById(R.id.signupuserdetails_Dreamcourse);
        savebutton=(Button)findViewById(R.id.signupuserdetails_savebutton);
        username=getIntent().getStringExtra("name");



        method="userdetailsregistration";


        savebutton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              String user=username;
                                              String collegename=et_collegename.getText().toString();
                                              String course_name=et_coursename.getText().toString();
                                              String undescore=et_undescore.getText().toString();
                                              String workexp=et_workexp.getText().toString();
                                              String dreamcollege=et_dreamcollege.getText().toString();
                                              String dreamcourse=et_dreamcourse.getText().toString();


                                              if(collegename.equals(""))
                                              {
                                                  et_collegename.setError("Enter your college name");


                                              }
                                              else if(course_name.equals(""))
                                              {
                                                  et_coursename.setError("Enter your course name");
                                              }
                                              else if(undescore.equals(""))
                                              {
                                                  et_undescore.setError("Enter score");

                                              }
                                              else if(dreamcollege.equals(""))
                                              {
                                                  et_dreamcollege.setError("Enter your dream college");
                                              }
                                              else if(dreamcourse.equals(""))
                                              {
                                                  et_dreamcourse.setError("Enter your dream course");

                                              }
                                              else
                                              {


                                                  BackgroundTask backgroundTask = new BackgroundTask(SignUpUserDetails.this);
                                                  backgroundTask.execute(method,collegename,course_name,workexp,dreamcollege,dreamcourse,user);
                                              }




                                          }
                                      }
        );










    }
    private void requestFocus(View view){
        if(view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

    }
}

