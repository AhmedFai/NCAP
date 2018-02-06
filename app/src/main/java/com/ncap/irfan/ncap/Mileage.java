package com.ncap.irfan.ncap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by USER on 20-12-2017.
 */

public class Mileage extends Fragment{

    Button n , p;

    EditText mileage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.activity_page4 , container , false);



        n = view.findViewById(R.id.next);
        p = view.findViewById(R.id.previous);
        mileage = view.findViewById(R.id.mileage);







            n.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    final String m = mileage.getText().toString();

                    if (m.length() > 0) {

                        Bean b = (Bean)getContext().getApplicationContext();

                        b.answer4 = m;

                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();
                        Odometer fragment = new Odometer();
                        fragmentTransaction.replace(R.id.replace, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();


                    }

                    else {

                        Toast.makeText(getContext(), "Invalid Answer", Toast.LENGTH_SHORT).show();                    }

                }

            });





        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fm.popBackStack();

            }
        });


        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        Bean b = (Bean)getContext().getApplicationContext();


        mileage.setText(b.answer4);

    }
}
