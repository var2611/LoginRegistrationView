package com.example.admin.loginregistrationview;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.MediaCodec;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    EditText FN, LN, EM, PS, PS2, PN, DOB;
    /*TextView DOB;*/
    String name, lname, email, password, cpassword, phonenumber, dob;
    Button submit, dateb;
    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {


        @Override
        public void onDateSet(DatePicker view, int i, int i1, int i2) {
            myCalendar.set(Calendar.YEAR, i);
            myCalendar.set(Calendar.MONTH, i1);
            myCalendar.set(Calendar.DAY_OF_MONTH, i2);
            updateLabel();
        }
    };

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
/*
        DOB = (TextView) findViewById(R.id.tvDOB);
*/

        DOB.setOnClickListener(this);

        /*dateb = (Button) findViewById(R.id.date);
        dateb.setOnClickListener(this);*/
        submit = (Button) findViewById(R.id.Bsbmt);
        submit.setOnClickListener(this);


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        if (view == submit) {
            register();

        } else if (view == DOB) {
            new DatePickerDialog(Registration.this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();

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
        if (name.isEmpty() || lname.isEmpty() || email.isEmpty() || password.isEmpty() || phonenumber.isEmpty()) {

            Toast.makeText(this, "Enter In Empty Field", Toast.LENGTH_SHORT).show();
        } else if (name.length() > 15) {
            FN.setError(getText(R.string.name_error));
            valid = false;
        } else if (name.length() > 10) {
            LN.setError(getText(R.string.name_error));
            valid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            EM.setError(getText(R.string.email_error));
            valid = false;
        } else if (password.length() < 5) {
            PS.setError(getText(R.string.password_error));
            valid = false;
        }/* else if (!PS2.getText().toString().equals(PN.getText().toString())) {
            PS2.setError(getText(R.string.password_error_2));
            valid = false;*/
         else if (!Patterns.PHONE.matcher(phonenumber).matches()) {
            PN.setError(getText(R.string.phone_error));
            valid = false;
        }

        return valid;

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        DOB.setText(sdf.format(myCalendar.getTime()));
    }


}
