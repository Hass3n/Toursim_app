package com.example.hassan.toursim.userlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.hassan.toursim.ApiMange.ApiManager;
import com.example.hassan.toursim.Trip.Token;
import com.example.hassan.toursim.Trip.Trip;
import com.example.hassan.toursim.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends AppCompatActivity {

    EditText ed1_email,ed2_passwod;
    Button bn_login;
    String emailpattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed1_email=findViewById(R.id.login_email);
        ed2_passwod=findViewById(R.id.login_passwod);
        bn_login=findViewById(R.id.Login);

        bn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login_email=ed1_email.getText().toString().trim();
                String login_passwod=ed2_passwod.getText().toString().trim();
                if(Validate(login_email,login_passwod))
                {
                    SetuserLogin(login_email,login_passwod);


                }
            }
        });

    }

    private void SetuserLogin(final String login_email, final String login_passwod) {

        ApiManager.getAPIs().SetUserLogin(login_email,login_passwod).enqueue(new Callback<UserLogin>() {
            @Override
            public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {

                SharedPreferences.Editor sharedPreferences =
                        getSharedPreferences("touism",MODE_PRIVATE).edit();

                sharedPreferences.putString("email",login_email);
                sharedPreferences.putString("passwod",login_passwod);
                sharedPreferences.apply();
                Intent in=new Intent(Login.this,Trip.class);
                in.putExtra("token",response.body().getData().getToken());
                String token=response.body().getData().getToken();
                Token t=new Token(token);
                startActivity(in);
            }

            @Override
            public void onFailure(Call<UserLogin> call, Throwable t) {

                Toast.makeText(Login.this,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }


    public boolean Validate(String email,String passwod) {

      if (email.equals("")) {
          ed1_email.setError("required");

          return false;
      }

      ed1_email.setError(null);
      if (!email.matches(emailpattern)) {
          ed1_email.setError("not valid");
          return false;
      }
      if (passwod.length() < 6) {
          ed2_passwod.setError("min 6 cha");
          return false;
      }
      ed2_passwod.setError(null);


      return true;

  }


}

