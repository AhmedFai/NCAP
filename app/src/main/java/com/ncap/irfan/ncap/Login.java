package com.ncap.irfan.ncap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class Login extends AppCompatActivity {

    private static final String Tag = "LoginBean";

    private static final String BASE_URL = "http://iitapi.addotelinfra.com/";
    private static final String LOGIN_URL = "http://iitapi.addotelinfra.com/api/UserLogin";


    EditText etName, etMobile;
    Button btLogin, btCreate;

    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        etName = (EditText) findViewById(R.id.etName);
        etMobile = (EditText) findViewById(R.id.etMobile);
        btLogin = (Button) findViewById(R.id.btLogin);
        progress = findViewById(R.id.progress);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e = etName.getText().toString();
                String m = etMobile.getText().toString();
                
                if (e.length() > 0){
                    
                    if (Utils.isValidMobile(m)){


                        Bean b = (Bean)getApplicationContext();

                        b.name = e;
                        b.mobile = m;


                        Intent intent = new Intent(Login.this,Welcome.class);
                        startActivity(intent);
                        finish();


                    }
                    else {

                        //Toast.makeText(Login.this, "Please enter a valid Mobile No.", Toast.LENGTH_SHORT).show();
                        etMobile.setError("Enter Valid Mobile Number");
                        etMobile.requestFocus();
                    }
                    
                    
                }
                else {

                    //Toast.makeText(Login.this, "Please enter a valid Name", Toast.LENGTH_SHORT).show();
                    etName.setError("Enter Your Name");
                    etName.requestFocus();
                }




            }
        });


    }

    public void ClickGuest(View v) {
        Intent intent = new Intent(Login.this, Welcome.class);
        startActivity(intent);
        finish();
    }
}