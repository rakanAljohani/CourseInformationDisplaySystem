package com.information.course.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText id,pass;
    TextView create;
    Button login,about,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id=(EditText)findViewById(R.id.enterID);
        pass=(EditText)findViewById(R.id.enterPassword);
        create=(TextView)findViewById(R.id.account);
        login=(Button)findViewById(R.id.login);
        about=(Button)findViewById(R.id.about);
        contact=(Button)findViewById(R.id.contact);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Login.this,Registeration.class));

            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        if(id.getText().toString().equals("")){
            Toast.makeText(Login.this,"ID Empty",Toast.LENGTH_SHORT).show();
        }else if(pass.getText().toString().equals("")){
            Toast.makeText(Login.this,"password Empty",Toast.LENGTH_SHORT).show();

        }else {
                startActivity(new Intent(Login.this,MainActivity.class));
            }


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




    }
}
