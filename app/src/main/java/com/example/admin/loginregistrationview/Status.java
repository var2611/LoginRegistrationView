package com.example.admin.loginregistrationview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Status extends AppCompatActivity {
    EditText FN, LN, EM, PS,CPS, PN, DOB;
    TextView CITY,SEX;
    String name, lname, email, password,password2, phonenumber, dob, city, sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        FN = (EditText) findViewById(R.id.tv_fn);
        LN = (EditText) findViewById(R.id.tv_ln);
        EM = (EditText) findViewById(R.id.tv_em);
        PS = (EditText) findViewById(R.id.tv_ps);
        CPS = (EditText) findViewById(R.id.tv_ps2);
        PN = (EditText) findViewById(R.id.tv_pn);
        DOB = (EditText) findViewById(R.id.tv_db);
        CITY = (TextView) findViewById(R.id.tv_city);
        SEX = (TextView) findViewById(R.id.tv_sx);

        Intent i = getIntent();

        name = i.getStringExtra("name");
        lname = i.getStringExtra("lname");
        email = i.getStringExtra("email");
        password = i.getStringExtra("password");
        password2 = i.getStringExtra("password2");
        phonenumber = i.getStringExtra("phone_number");
        dob = i.getStringExtra("dob");
        sex = i.getStringExtra("sex");
        city = i.getStringExtra("city");


        FN.setText(name);
        LN.setText(lname);
        EM.setText(email);
        PS.setText(password);
        CPS.setText(password2);
        PN.setText(phonenumber);
        DOB.setText(dob);
        SEX.setText(sex);
        CITY.setText(city);

    }
}
