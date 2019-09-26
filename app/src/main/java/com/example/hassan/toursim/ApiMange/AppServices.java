package com.example.hassan.toursim.ApiMange;




import com.example.hassan.toursim.Trip.Datum;
import com.example.hassan.toursim.Userregister.Data;
import com.example.hassan.toursim.userlogin.UserLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AppServices {


    @FormUrlEncoded
    @POST("/api/oauth/register")
    Call<Data> SetUserregistr(@Field("name") String name, @Field("email") String email, @Field("password") String password, @Field("confirm_password") String confirm_password);

    @FormUrlEncoded
    @POST("/api/oauth/login")
    Call<UserLogin> SetUserLogin(@Field("email") String email, @Field("password") String password);


    @GET("/api/places")
    Call<Datum>GetAllTrip();





}
