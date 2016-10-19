package com.example.himanshu.studydeforis;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignUpActivity extends AppCompatActivity {
    EditText enter_Name;
    EditText enter_Email;
    EditText enter_Username;
    EditText enter_Password;
    EditText enter_ConPassword;
    Button signInButton;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,9}$", Pattern.CASE_INSENSITIVE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState );
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign_up);

        enter_Name = (EditText) findViewById(R.id.register_enter_name_text);
        enter_Email = (EditText) findViewById(R.id.register_enter_email_text);
        enter_Username = (EditText) findViewById(R.id.register_enter_username_text);
        enter_Password = (EditText) findViewById(R.id.register_enter_password_text);
        enter_ConPassword = (EditText) findViewById(R.id.register_confirm_password_text);
        signInButton = (Button) findViewById(R.id.register_signin_button);




        signInButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = enter_Name.getText().toString();
                        String email = enter_Email.getText().toString();
                        String username = enter_Username.getText().toString();
                        String password = enter_Password.getText().toString();
                        String con_password = enter_ConPassword.getText().toString();
                        String method = "account creation";

                        if(name.equals(""))
                        {
                            enter_Name.setError("Name not entered");
                            enter_Name.requestFocus();

                        }
                        else if(email.equals("") || !validateemail(email))
                        {
                            enter_Email.setError("Invalid email");
                            enter_Email.requestFocus();
                        }
                        else if(username.equals(""))
                        {
                            enter_Username.setError("Username not entered");
                            enter_Username.requestFocus();
                        }
                        else if(!(password.length()>6))
                        {
                            enter_Password.setError("Password not entered");
                            enter_Password.requestFocus();
                        }
                        else if(password.equals(con_password))
                        {
                            BackgroundTask backgroundTask= new BackgroundTask(SignUpActivity.this);
                            backgroundTask.execute(method,name,email,username,password,con_password);





                        }
                        else {

                            Toast.makeText(SignUpActivity.this, "Password doesn't match! Enter Again!", Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );




}
    public static boolean validateemail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }


}



