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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by USER on 20-12-2017.
 */

public class Fuel extends Fragment {

    RadioGroup group;

    Button p, n;

    String ques = "";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_page2, container, false);

        n = view.findViewById(R.id.next);
        p = view.findViewById(R.id.previous);
        group = (RadioGroup) view.findViewById(R.id.radio);


        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                Bean b = (Bean)getContext().getApplicationContext();

                int id = radioGroup.getCheckedRadioButtonId();

                RadioButton rb = (RadioButton) radioGroup.findViewById(id);



                ques = rb.getText().toString();



                b.id2 = id;

            }
        });

        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ques.length() > 0) {

                    Bean b = (Bean) getContext().getApplicationContext();

                    b.answer2 = ques;

                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    Model fragment = new Model();
                    fragmentTransaction.replace(R.id.replace, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


                } else {
                    Toast.makeText(getContext(), "Invalid Answer", Toast.LENGTH_SHORT).show();
                }


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
}
