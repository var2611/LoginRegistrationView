package com.example.admin.loginregistrationview;

import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Registration extends AppCompatActivity implements View.OnClickListener{

    EditText FN,LN,EM,PS,PS2,PN,DOB;
    String name,lname,email,password,cpassword,phonenumber,dob;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        FN = (EditText)findViewById(R.id.etFN);
        LN = (EditText)findViewById(R.id.etLN);
        EM = (EditText)findViewById(R.id.etEM);
        PS = (EditText)findViewById(R.id.etPS);
        PS2 = (EditText)findViewById(R.id.etPS2);
        PN = (EditText)findViewById(R.id.etPN);
        DOB = (EditText)findViewById(R.id.etDOB);

        submit = (Button)findViewById(R.id.Bsbmt);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == submit){
            register();
        }
    }
    private void register() {
        initialize();
        if (!validate()){
            Toast.makeText(this, "RegistrationFail", Toast.LENGTH_SHORT).show();
        }
        else {

        }
    }

    private void initialize() {
        name = FN.getText().toString().trim();
        lname = LN.getText().toString().trim();
        email = EM.getText().toString().trim();
        password = PS.getText().toString().trim();
        cpassword = PS2.getText().toString().trim();
        phonenumber = PN.getText().toString().trim();
        dob = DOB.getText().toString().trim();

    }

    private boolean validate() {
        boolean valid =true;
        if (name.isEmpty()||name.length()>15){
            FN.setError("EnterValidName");
            valid=false;
        }
        else if (lname.isEmpty()||name.length()>10){
            FN.setError(R.string.nameerror);
            valid=false;
        }
        else if (email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            FN.setError("EnterValidEmailAddress");
            valid=false;
        }
        else if (name.isEmpty()||name.length()>25){
            FN.setError("EnterValidName");
            valid=false;
        }
        else if (name.isEmpty()||name.length()>25){
            FN.setError("EnterValidName");
            valid=false;
        }

        return valid;

    }
}
