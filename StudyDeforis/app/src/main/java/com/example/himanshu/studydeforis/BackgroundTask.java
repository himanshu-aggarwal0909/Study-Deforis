package com.example.himanshu.studydeforis;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Himanshu on 10-10-2016.
 */
public class BackgroundTask extends AsyncTask<String , Void , String>{
    String reg_url;
    String login_url;
    AlertDialog alertDialog;
    String method;
    String get_user_data_url;
    String universityname_url;
    String userdetails_save_url;
    String universities_detail_url;
    //ProgressDialog progressDialog;

    Context context;

    BackgroundTask(Context context)
    {
        this.context=context;
    }

    @Override
    protected String doInBackground(String ... params) {


        method = params[0];
        if(method.equals("account creation"))
        {

            String name = params[1];
            String email = params[2];
            String username = params[3];
            String password = params[4];
            String con_password = params[5];



            try {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream OS= httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS , "UTF-8"));
                String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name, "UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("con_password","UTF-8")+"="+URLEncoder.encode(con_password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS= httpURLConnection.getInputStream();
                IS.close();
                return username;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else if(method.equals("login"))
        {
            String login_username=params[1];
            String login_password=params[2];

            try {
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream= httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data=URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(login_username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(login_password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response ="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(method.equals("universities_select"))
        {
            try {
                URL url=new URL(universityname_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setDoInput(true);
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                List list=new ArrayList();
                while((response =bufferedReader.readLine())!=null)
                {
                    list.add(response);
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return String.valueOf(list);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("userdetailsregistration"))
        {
            String collegename=params[1];
            String collegecourse=params[2];
            String workexp=params[3];
            String dreamcollege=params[4];
            String dreamcourse=params[5];
            String username=params[6];
            try {
                URL url=new URL(userdetails_save_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream , "UTF-8"));
                String data= URLEncoder.encode("College_name","UTF-8")+"="+URLEncoder.encode(collegename, "UTF-8")+"&"+
                        URLEncoder.encode("College_course","UTF-8")+"="+URLEncoder.encode(collegecourse,"UTF-8")+"&"+
                        URLEncoder.encode("Work_exp","UTF-8")+"="+URLEncoder.encode(workexp,"UTF-8")+"&"+
                        URLEncoder.encode("Dreamcollege_name","UTF-8")+"="+URLEncoder.encode(dreamcollege,"UTF-8")+"&"+
                        URLEncoder.encode("Dream_course","UTF-8")+"="+URLEncoder.encode(dreamcourse,"UTF-8")+"&"+
                        URLEncoder.encode("User_name","UTF-8")+"="+URLEncoder.encode(username,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream IS= httpURLConnection.getInputStream();
                IS.close();
                return "YOU ARE ALL SET TO GO!";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if(method.equals("getuserdatasimilarprofiles"))
        {
            try {
                URL url=new URL(get_user_data_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setDoInput(true);
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream , "iso-8859-1"));
                String response="";
                StringBuilder stringBuilder=new StringBuilder();
                while((response =bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(response+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else if(method.equals("universitiesdetails_display"))
        {

            try {
                URL url= new URL(universities_detail_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setDoInput(true);
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream , "iso-8859-1"));
                String response="";
                StringBuilder stringBuilder=new StringBuilder();
                while((response =bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(response+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        reg_url="http://studydeforis.net23.net/registeruser.php";
        login_url="http://studydeforis.net23.net/loginuser.php";
        get_user_data_url="http://studydeforis.net23.net/get_the_user_json.php";
        universityname_url="http://studydeforis.net23.net/Universitynames.php";
        userdetails_save_url="http://studydeforis.net23.net/Register_userdetails.php";
        universities_detail_url="http://studydeforis.net23.net/Universities_details.php";
        alertDialog = new AlertDialog.Builder(context).create();
        //progressDialog=new ProgressDialog(context);
        //progressDialog.setMessage("...processing");
        //progressDialog.show();
        alertDialog.setTitle("Login message..");

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate();

    }

    @Override
    protected void onPostExecute(String result) {
        if(method.equals("account creation"))

        {

            Intent i = new Intent(context, SignUpUserDetails.class);
            i.putExtra("name",result);
            context.startActivity(i);
            //progressDialog.dismiss();
            Toast.makeText(context,"ACCOUNT CREATED", Toast.LENGTH_LONG).show();

        }
        else if(method.equals("login"))
        {
            if(( (result.contains("login success"))))
            {

                Intent i = new Intent(context ,Dashboard.class );
                context.startActivity(i);
                //progressDialog.dismiss();
                Toast.makeText(context,"LOGGED IN",Toast.LENGTH_LONG).show();
                //alertDialog.setMessage("LOGIN SUCCESS");
                //alertDialog.show();
            }
            else
            {
                Toast.makeText(context,"LOGIN ERROR",Toast.LENGTH_LONG).show();
            }
        }
        else if(method.equals("universitiesdetails_display"))
        {
            Intent i = new Intent(context ,DisplayUnversityNames.class);
            i.putExtra("result",result);
            alertDialog.setMessage(result);
            alertDialog.show();
            context.startActivity(i);

        }
        else if(method.equals("getuserdatasimilarprofiles"))
        {
            Intent i =new Intent(context , DisplayUserData.class);
            i.putExtra("result",result);
            context.startActivity(i);
            //alertDialog.setMessage(result);
            //alertDialog.show();
        }
        else if(method.equals("universities_select"))
        {
            Intent i = new Intent(context , SignUpUserDetails.class);
            i.putExtra("name",result);
        }
        else if(method.equals("userdetailsregistration"))
        {
            Toast.makeText(context,result,Toast.LENGTH_LONG).show();
            Intent i = new Intent(context , LoginActivity.class);
            context.startActivity(i);
        }
    }
}
