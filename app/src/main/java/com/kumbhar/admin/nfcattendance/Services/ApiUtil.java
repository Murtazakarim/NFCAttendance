package com.kumbhar.admin.nfcattendance.Services;

import com.kumbhar.admin.nfcattendance.Activities.RetrofitInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtil {
    private static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static RetrofitInterface getServiceClass(){
        Retrofit retrofitAPI = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofitAPI.create(RetrofitInterface.class);
        return retrofitInterface;
    }
}
