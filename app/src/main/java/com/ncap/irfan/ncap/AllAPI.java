package com.ncap.irfan.ncap;

import com.ncap.irfan.ncap.LoginPOJO.LoginBean;

import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by TBX on 12/25/2017.
 */

public interface AllAPI  {


    @Multipart
    @POST("ncap/apiapp/answer_data.php")
    Call<LoginBean> login (
            @Part("name") String m ,
            @Part("mobile_no") String mm,
            @Part("email_id") String mr ,
            @Part("answer1") String my ,
            @Part("answer2") String mu ,
            @Part("answer3a") String mi ,
            @Part("answer3b") String mia ,
            @Part("answer3c") String mib ,
            @Part("answer4") String mo ,
            @Part("answer5") String mp ,
            @Part("answer6") String ml,
            @Part("answer7") String mh,
            @Part("answer8") String mkw ,
            @Part("answer9") String mw ,
            @Part("answer10") String me ,
            @Part("answer11") String mty,
            @Part("location") String mtl

    );
}
