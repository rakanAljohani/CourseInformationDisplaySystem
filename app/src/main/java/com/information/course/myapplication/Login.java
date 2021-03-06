package com.information.course.myapplication;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private static Login mInstance;

    String url = "http://bugshan.96.lt/login.php";
     Button buttonLogin;
    EditText _id,pass;
    TextView create;
    String id,password;
    ProgressDialog PD;
    Button about,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mInstance = this;

        PD = new ProgressDialog(this);
        PD.setMessage("Loading.....");
        PD.setCancelable(false);

        _id=(EditText)findViewById(R.id.enterid);
        pass=(EditText)findViewById(R.id.enterPassword);
        create=(TextView)findViewById(R.id.account);
        buttonLogin=(Button)findViewById(R.id.login);
        about=(Button)findViewById(R.id.about);
        contact=(Button)findViewById(R.id.contact);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Login.this,Registeration.class));

            }
        });





        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id = _id.getText().toString();
                password = pass.getText().toString();

                if(_id.getText().toString().equals("")){
                    Toast.makeText(Login.this,"ID Empty",Toast.LENGTH_SHORT).show();

                }else if(pass.getText().toString().equals("")){
                    Toast.makeText(Login.this,"Password Empty",Toast.LENGTH_SHORT).show();

                }else {


                    PD.show();

                    StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    PD.dismiss();

                                    JSONObject Json = null;
                                    try {
                                         Json = new JSONObject(response);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                    int res = 0;
                                    try {
                                        res = Json.getInt("id");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                    // int res=Integer.parseInt(response);
                                    if(res !=0) {

                                        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString("id", response);
                                        editor.commit();

                                        Toast.makeText(getApplicationContext(), "Login Successed"+res, Toast.LENGTH_LONG).show();
                                     startActivity(new Intent(Login.this,MainActivity.class));
                                        finish();

                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(), "Login Failed ... Try Again", Toast.LENGTH_LONG).show();

                                    }

                                }
                            }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            PD.dismiss();
                            Toast.makeText(getApplicationContext(),"Fail", Toast.LENGTH_LONG).show();
                        }
                    })

                    {

                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("number", id);
                            params.put("password", password);
                            return params;
                        }
                    };


                    // Adding request to request queue
                    Login.getInstance().addToReqQueue(postRequest);

                }



            }
        });




    }

    public static synchronized Login getInstance() {
        return mInstance;
    }

    public RequestQueue getReqQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());

        }

        return mRequestQueue;
    }

    public <T> void addToReqQueue(Request<T> req, String tag) {

        getReqQueue().add(req);
    }

    public <T> void addToReqQueue(Request<T> req) {

        getReqQueue().add(req);
    }

    public void cancelPendingReq(Object tag) {

        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }






}
