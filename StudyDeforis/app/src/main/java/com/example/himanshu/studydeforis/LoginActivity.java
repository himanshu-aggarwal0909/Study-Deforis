package com.example.himanshu.studydeforis;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity{
    Button signInButton;
    Button logInButton;
    EditText etUsername;
    EditText etPassword;
    String username;
    String password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);


        setContentView(R.layout.activity_login);
        signInButton = (Button)findViewById(R.id.loginsigninbutton);
        logInButton = (Button)findViewById(R.id.loginbutton);
        etUsername = (EditText)findViewById(R.id.loginusernametext);
        etPassword = (EditText)findViewById(R.id.loginpasswordtext);

        signInButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(LoginActivity.this , SignUpActivity.class);
                        startActivity(i);

                    }
                }
        );

        logInButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        username=etUsername.getText().toString();
                        password=etPassword.getText().toString();
                        String method="login";
                        BackgroundTask backgroundTask=new BackgroundTask(LoginActivity.this);
                        backgroundTask.execute(method,username,password);


                    }
                }
        );

    }






}
