package com.ncap.irfan.ncap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ncap.irfan.ncap.LoginPOJO.LoginBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by USER on 20-12-2017.
 */

public class Vehicle extends Fragment {


    Button btn;

    String answer = "";
    String ques = "";

    String location;

    RadioGroup group, groupFuel;
    EditText modela, modelb, modelc, mileage, odo, d, c, f, e, s, veh;
    ProgressBar progress;
    TextView ques1, ques2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_page1, container, false);

        location = getArguments().getString("location");

        btn = (Button) view.findViewById(R.id.next);
        ques1 = (TextView) view.findViewById(R.id.Q1);
        ques2 = (TextView) view.findViewById(R.id.Q2);
        group = (RadioGroup) view.findViewById(R.id.radio);
        groupFuel = (RadioGroup) view.findViewById(R.id.radio2);
        modela = view.findViewById(R.id.modelA);
        modelb = view.findViewById(R.id.modelB);
        modelc = view.findViewById(R.id.modelC);
        mileage = view.findViewById(R.id.mileage);
        odo = view.findViewById(R.id.odo);
        d = view.findViewById(R.id.dis);
        c = view.findViewById(R.id.cons);
        f = view.findViewById(R.id.freq);
        e = view.findViewById(R.id.eng);
        s = view.findViewById(R.id.speed);
        veh = view.findViewById(R.id.vehicle);
        progress = view.findViewById(R.id.progress);


        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                Bean b = (Bean) getContext().getApplicationContext();

                int id = radioGroup.getCheckedRadioButtonId();

                RadioButton rb = (RadioButton) radioGroup.findViewById(id);


                answer = rb.getText().toString();

                ques1.clearFocus();
                ques1.setError(null);


                b.id1 = id;

            }
        });

        groupFuel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                Bean b = (Bean) getContext().getApplicationContext();

                int idr2 = radioGroup.getCheckedRadioButtonId();

                RadioButton rb1 = (RadioButton) radioGroup.findViewById(idr2);

                ques2.clearFocus();
                ques2.setError(null);

                ques = rb1.getText().toString();


                b.id2 = idr2;

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!TextUtils.isEmpty(answer)) {

                    Bean b = (Bean) getContext().getApplicationContext();
                    b.answer1 = answer;


                    if (!TextUtils.isEmpty(ques)) {

                        b.answer2 = ques;


                        final String m = modela.getText().toString();

                        if (!TextUtils.isEmpty(m)) {


                            b.answer3a = m;

                            final String mb = modelb.getText().toString();

                            if (!TextUtils.isEmpty(mb)) {
                                b.answer3b = mb;

                                final String mc = modelc.getText().toString();
                                if (!TextUtils.isEmpty(mc)) {
                                    b.answer3c = mc;

                                    final String mil = mileage.getText().toString();

                                    if (!TextUtils.isEmpty(mil)) {

                                        b.answer4 = mil;

                                        final String odm = odo.getText().toString();

                                        if (!TextUtils.isEmpty(odm)) {


                                            b.answer5 = odm;

                                            final String dis = d.getText().toString();

                                            if (!TextUtils.isEmpty(dis)) {


                                                b.answer6 = dis;

                                                final String con = c.getText().toString();

                                                if (!TextUtils.isEmpty(con)) {

                                                    b.answer7 = con;

                                                    final String fre = f.getText().toString();

                                                    if (!TextUtils.isEmpty(fre)) {

                                                        b.answer8 = fre;

                                                        final String eng = e.getText().toString();

                                                        if (!TextUtils.isEmpty(eng)) {


                                                            b.answer9 = eng;

                                                            final String sp = s.getText().toString();

                                                            if (!TextUtils.isEmpty(sp)) {


                                                                b.answer10 = sp;

                                                                String vc = veh.getText().toString();

                                                                if (!TextUtils.isEmpty(vc)) {

                                                                    b.answer11 = vc;

                                                                    final String lc = location;
                                                                    b.location = lc;


                                                                    progress.setVisibility(View.VISIBLE);


                                                                    Retrofit retrofit = new Retrofit.Builder()
                                                                            .baseUrl("http://nationproducts.in/")
                                                                            .addConverterFactory(ScalarsConverterFactory.create())
                                                                            .addConverterFactory(GsonConverterFactory.create())
                                                                            .build();


                                                                    AllAPI cr = retrofit.create(AllAPI.class);
                                                                    Call<LoginBean> call = cr.login(b.name, b.mobile, b.email, b.answer1, b.answer2, b.answer3a, b.answer3b, b.answer3c, b.answer4, b.answer5, b.answer6, b.answer7, b.answer8, b.answer9, b.answer10, b.answer11, b.location);


                                                                    Log.d("location", location);


                                                                    Log.d("asdasd", b.name);
                                                                    Log.d("asdasd", b.mobile);

                                                                    call.enqueue(new Callback<LoginBean>() {
                                                                        @Override
                                                                        public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {

                                                                            try {


                                                                                Bean b = (Bean) getContext().getApplicationContext();
                                                                               /* b.name = "";
                                                                                b.mobile = "";
                                                                                b.email = "";*/
                                                                                b.answer1 = "";
                                                                                b.answer2 = "";
                                                                                b.answer3a = "";
                                                                                b.answer3b = "";
                                                                                b.answer3c = "";
                                                                                b.answer4 = "";
                                                                                b.answer5 = "";
                                                                                b.answer6 = "";
                                                                                b.answer7 = "";
                                                                                b.answer8 = "";
                                                                                b.answer9 = "";
                                                                                b.answer10 = "";
                                                                                b.answer11 = "";
                                                                                b.location = "";


                                                                                Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                                                                Intent i = new Intent(getContext(), Welcome.class);
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
                                                                    veh.setError("Field is Empty");
                                                                    veh.requestFocus();
                                                                }


                                                            } else {
                                                                s.setError("Feild is Empty");
                                                                s.requestFocus();
                                                            }


                                                        } else {
                                                            e.setError("Feild is Empty");
                                                            e.requestFocus();
                                                        }


                                                    } else {
                                                        f.setError("Feild is Empty");
                                                        f.requestFocus();
                                                    }


                                                } else {
                                                    c.setError("Feild is Empty");
                                                    c.requestFocus();
                                                }


                                            } else {
                                                d.setError("Feild is Empty");
                                                d.requestFocus();
                                            }


                                        } else {
                                            odo.setError("Feild is Emprty");
                                            odo.requestFocus();
                                        }


                                    } else {
                                        mileage.setError("Feild is Empty");
                                        mileage.requestFocus();
                                    }


                                } else {
                                    modelc.setError("Field is Empty");
                                    modelc.requestFocus();
                                }

                            } else {
                                modelb.setError("Field is Empty");
                                modelb.requestFocus();
                            }


                        } else {
                            modela.setError("Feild is Empty");
                            modela.requestFocus();
                        }


                    } else {
                        ques2.setError("Feild is Empty");
                        ques2.requestFocus();

                    }

                } else {
                    ques1.setError("Feild is Empty");
                    ques1.requestFocus();
                }


            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();


    }
}
