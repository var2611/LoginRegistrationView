package com.example.admin.loginregistrationview;

import android.content.Intent;
import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    EditText FN, LN, EM, PS, PS2, PN, DOB;
    String name, lname, email, password, cpassword, phonenumber, dob;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        FN = (EditText) findViewById(R.id.etFN);
        LN = (EditText) findViewById(R.id.etLN);
        EM = (EditText) findViewById(R.id.etEM);
        PS = (EditText) findViewById(R.id.etPS);
        PS2 = (EditText) findViewById(R.id.etPS2);
        PN = (EditText) findViewById(R.id.etPN);
        DOB = (EditText) findViewById(R.id.etDOB);

        submit = (Button) findViewById(R.id.Bsbmt);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == submit) {
            register();

        }
    }

    private void register() {
        initialize();
        if (!validate()) {
            Toast.makeText(this, "RegistrationFail", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(this, Status.class);
            i.putExtra("name", name);
            i.putExtra("lname", lname);
            i.putExtra("email", email);
            i.putExtra("password", password);
            i.putExtra("phone_number", phonenumber);
            i.putExtra("dob", dob);
            startActivity(i);

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
        boolean valid = true;
        if (name.isEmpty() || name.length() > 15) {
            FN.setError(getText(R.string.name_error));
            valid = false;
        } else if (lname.isEmpty() || name.length() > 10) {
            LN.setError(getText(R.string.name_error));
            valid = false;
        } else if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            EM.setError(getText(R.string.email_error));
            valid = false;
        } else if (password.isEmpty() || password.length() < 5) {
            PS.setError(getText(R.string.password_error));
            valid = false;
        } else if (cpassword.isEmpty() || cpassword.equals(password)) {
            PS2.setError(getText(R.string.password_error));
            valid = false;
        } else if (phonenumber.isEmpty() || phonenumber.length() == 9) {
            PN.setError(getText(R.string.phone_error));
            valid = false;
        }

        return valid;

    }
}
