package com.example.ali.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity implements View.OnClickListener {
    Button bRegister;
    EditText etName, etUserName, etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etName = (EditText) findViewById(R.id.etName);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        boolean errorFree = true;

        switch(v.getId()){
            case R.id.bRegister:
                if((etName.getText().toString()).equals("")){
                    //etName.setError("Please Enter Your Name");
                    Toast.makeText(getApplicationContext(), "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                    etName.requestFocus();
                    errorFree = false;
                }
                if((etUserName.getText().toString()).equals("")){
                    //etUserName.setError("Please Enter Your User Name");
                    Toast.makeText(getApplicationContext(), "Please Enter Your User Name", Toast.LENGTH_SHORT).show();
                    etUserName.requestFocus();
                    errorFree = false;
                }

                if(!validateEmail(etEmail.getText().toString())){
                    //etEmail.setError("Please Enter Valid Email");
                    Toast.makeText(getApplicationContext(), "Please Enter Valid Email", Toast.LENGTH_SHORT).show();
                    etEmail.requestFocus();
                    errorFree = false;
                } else if(!validateUnivEmail(etEmail.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please Enter Colorado Email id only", Toast.LENGTH_LONG).show();
                    etEmail.requestFocus();
                    errorFree = false;
                }

                if((etPassword.getText().toString()).equals("")){
                    //etPassword.setError("Please Enter Valid Password");
                    Toast.makeText(getApplicationContext(), "Please Enter Valid Password", Toast.LENGTH_SHORT).show();
                    etPassword.requestFocus();
                    errorFree = false;
                } else if((etPassword.getText().toString()).length()<6){
                    Toast.makeText(getApplicationContext(), "Password length must be at least 6 characters long", Toast.LENGTH_LONG).show();
                    etPassword.requestFocus();
                    errorFree = false;
                }

                if(errorFree) {
                    Toast.makeText(getApplicationContext(), "User Successfully Registered", Toast.LENGTH_SHORT).show();

                    String name = etName.getText().toString();
                    String username = etUserName.getText().toString();
                    String email = etEmail.getText().toString();
                    String password = etPassword.getText().toString();

                    User new_user = new User(name, username, password, email);
                    new_user.addUser();

                    startActivity(new Intent(this, Login.class));
                }

                break;
        }
    }
    protected boolean validateEmail(String email) {
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
    protected boolean validateUnivEmail(String email) {
        String[] tokens = email.split("@");
        String emailToken = tokens[1];
        if(emailToken.equals("colorado.edu"))
            return true;
        else
            return false;
    }
}
