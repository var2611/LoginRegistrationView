package com.example.admin.loginregistrationview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Status extends AppCompatActivity {
    TextView FN, LN, EM, PS, PN, DOB;
    String name, lname, email, password, phonenumber, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        FN = (TextView) findViewById(R.id.tv_fn);
        LN = (TextView) findViewById(R.id.tv_ln);
        EM = (TextView) findViewById(R.id.tv_em);
        PS = (TextView) findViewById(R.id.tv_ps);
        PN = (TextView) findViewById(R.id.tv_pn);
        DOB = (TextView) findViewById(R.id.tv_db);

        Intent i = getIntent();

        name = i.getStringExtra("name");
        lname = i.getStringExtra("lname");
        email = i.getStringExtra("email");
        password = i.getStringExtra("password");
        phonenumber = i.getStringExtra("phone_number");
        dob = i.getStringExtra("dob");


        FN.setText(name);
        LN.setText(lname);
        EM.setText(email);
        PS.setText(password);
        PN.setText(phonenumber);
        DOB.setText(dob);

    }
}
