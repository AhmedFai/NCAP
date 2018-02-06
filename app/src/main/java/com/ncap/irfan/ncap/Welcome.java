package com.ncap.irfan.ncap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class Welcome extends AppCompatActivity {

    Button StartSurvey;
    EditText loc;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        StartSurvey = (Button) findViewById(R.id.StartSurvey);
        loc = (EditText) findViewById(R.id.location);
        progress = (ProgressBar) findViewById(R.id.progress);
        StartSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent=new Intent(Welcome.this,Survey.class);
                startActivity(intent);
                finish();*/

                String lo = loc.getText().toString();

                if (!TextUtils.isEmpty(lo)){
                    Intent intent = new Intent(Welcome.this, Survey.class);
                    intent.putExtra("location", lo);
                    startActivity(intent);




                    finish();
                    Log.d("paaa", "mukul");
                }else {
                    loc.setError("Field is Empty");
                    loc.requestFocus();

                }


            }
        });


    }
}
