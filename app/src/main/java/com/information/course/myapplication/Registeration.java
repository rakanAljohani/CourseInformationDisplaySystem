package com.information.course.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registeration extends AppCompatActivity {
    EditText name,id,pass,conpass;
    Button sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        name=(EditText)findViewById(R.id.enterName);
        id=(EditText)findViewById(R.id.enterID);
        pass=(EditText)findViewById(R.id.enterPassword);
        conpass=(EditText)findViewById(R.id.conPass);


        sign=(Button)findViewById(R.id.sign);


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")) {
                    Toast.makeText(Registeration.this, "Name Empty", Toast.LENGTH_SHORT).show();
                }
                else if(id.getText().toString().equals("")){
                    Toast.makeText(Registeration.this,"ID Empty",Toast.LENGTH_SHORT).show();
                }else if(pass.getText().toString().equals("")){
                    Toast.makeText(Registeration.this,"password Empty",Toast.LENGTH_SHORT).show();
                }
                else if(conpass.getText().toString().equals("")){
                    Toast.makeText(Registeration.this,"Confirm Password Empty",Toast.LENGTH_SHORT).show();

                }
                else {
                    startActivity(new Intent(Registeration.this,MainActivity.class));

                }


            }
        });

    }
}
