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
import android.widget.ProgressBar;

/**
 * Created by USER on 20-12-2017.
 */

public class VehicleNo extends Fragment {

    Button p, s;

    EditText veh;

    ProgressBar progress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_page11, container, false);


        s = view.findViewById(R.id.next);
        p = view.findViewById(R.id.previous);
        veh = view.findViewById(R.id.vehicle);
        progress = view.findViewById(R.id.progress);


        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String m = veh.getText().toString();

              /*  if (m.length() > 0) {


                    Bean b = (Bean) getContext().getApplicationContext();

                    b.answer11 = m;

                    Log.d("maaa", "nisha");

                    progress.setVisibility(View.VISIBLE);


                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://nationproducts.in/")
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();


                    AllAPI cr = retrofit.create(AllAPI.class);
                    Call<LoginBean> call = cr.login(b.name, b.mobile, b.email, b.answer1, b.answer2, b.answer3a, b.answer4, b.answer5, b.answer6, b.answer7, b.answer8, b.answer9, b.answer10, b.answer11);

                    Log.d("asdasd" , b.name);
                    Log.d("asdasd" , b.mobile);

                    call.enqueue(new Callback<LoginBean>() {
                        @Override
                        public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {

                            try {


                                Bean b = (Bean) getContext().getApplicationContext();
                                b.name = "";
                                b.mobile = "";
                                b.email = "";
                                b.answer1 = "";
                                b.answer2 = "";
                                b.answer3 = "";
                                b.answer4 = "";
                                b.answer5 = "";
                                b.answer6 = "";
                                b.answer7 = "";
                                b.answer8 = "";
                                b.answer9 = "";
                                b.answer10 = "";
                                b.answer11 = "";

                                Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getContext(), Login.class);
                                startActivity(i);
                                getActivity().finish();
                                Log.d("paaa", "mukul");


                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                            progress.setVisibility(View.GONE);


                        }

                        @Override
                        public void onFailure(Call<LoginBean> call, Throwable t) {

                            Log.d("sunny", t.toString());
                            progress.setVisibility(View.GONE);


                        }
                    });

                } else {

                    Toast.makeText(getContext(), "Invalid Answer", Toast.LENGTH_SHORT).show();                }

*/            }
        });

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fm.popBackStack();

            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        Bean b = (Bean)getContext().getApplicationContext();


        veh.setText(b.answer11);

    }

}
