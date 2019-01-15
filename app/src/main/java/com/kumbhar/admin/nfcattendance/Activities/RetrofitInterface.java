package com.kumbhar.admin.nfcattendance.Activities;

import com.kumbhar.admin.nfcattendance.Models.ApiObject;
import com.kumbhar.admin.nfcattendance.Models.Data;
import com.kumbhar.admin.nfcattendance.Models.SOAnswersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @POST("v2/5a96abc232000057005e2ed7")
    Call<List<ApiObject>> getAllPost(@Field("user_name") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("bins/ymuug")
    Call<Data> login(@Field("user_name") String name, @Field("password") String password);

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswers(@Query("tagged") String tags);

    @FormUrlEncoded
    @POST("getUserData.php")
    Call<Data> getUserDetails(@Field("roll_number") String rollNumber);
}
