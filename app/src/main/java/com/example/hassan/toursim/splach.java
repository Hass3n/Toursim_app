package com.example.hassan.toursim;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.hassan.toursim.ApiMange.ApiManager;
import com.example.hassan.toursim.Trip.Trip;
import com.example.hassan.toursim.userlogin.Login;
import com.example.hassan.toursim.userlogin.UserLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class splach extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("touism", MODE_PRIVATE);

                String mail = sharedPreferences.getString("email", null);
                String password = sharedPreferences.getString("passwod", null);
                if (mail == null) {
                    startActivity(new Intent(splach.this, Login.class));
                    finish();
                } else {
                    ApiManager.getAPIs().SetUserLogin(mail, password).enqueue(new Callback<UserLogin>() {
                        @Override
                        public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {

                            startActivity(new Intent(splach.this, Trip.class));
                            finish();
                        }

                        @Override
                        public void onFailure(Call<UserLogin> call, Throwable t) {
                            startActivity(new Intent(splach.this, Login.class));
                            finish();
                        }
                    });

                }
            }
        },2000);


    }
}
