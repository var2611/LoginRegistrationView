package com.example.admin.loginregistrationview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Status extends AppCompatActivity {
    TextView FN;
    String name, lname, email, password, phonenumber, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        FN = (TextView) findViewById(R.id.tv_fn);

        Intent i = getIntent();

        name = i.getStringExtra("name");
        lname = i.getStringExtra("lname");
        email = i.getStringExtra("email");
        password = i.getStringExtra("password");
        phonenumber = i.getStringExtra("phone_number");
        dob = i.getStringExtra("dob");


        FN.setText(name);


    }
}
