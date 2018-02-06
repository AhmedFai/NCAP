package com.ncap.irfan.ncap;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class Survey extends AppCompatActivity {

    Toolbar toolbar;
    String location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        toolbar = findViewById(R.id.toolBar);

        location = getIntent().getStringExtra("location");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Survey.this , Welcome.class);
                startActivity(intent);
                finish();
            }
        });
        toolbar.setTitle("NCAP");



       FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        Vehicle fragment = new Vehicle();
        Bundle bundle = new Bundle();
        bundle.putString("location" , location);

        Log.d("location", location);

        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.replace , fragment);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(Survey.this , Welcome.class);
        startActivity(intent);
        finish();

    }
}
