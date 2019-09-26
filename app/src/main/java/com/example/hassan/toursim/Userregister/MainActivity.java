package com.example.hassan.toursim.Userregister;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hassan.toursim.ApiMange.ApiManager;
import com.example.hassan.toursim.R;
import com.example.hassan.toursim.userlogin.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText Name,Mail,Passwod,C_passwod;
    Button register;
    String emailpattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=findViewById(R.id.name);
        Mail=findViewById(R.id.email);
        Passwod=findViewById(R.id.passwod);
        C_passwod=findViewById(R.id.c_passwod);
        register =findViewById(R.id.register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u_name=Name.getText().toString().trim();
                String u_mail=Mail.getText().toString().trim();
               String u_passwod=Passwod.getText().toString().trim();
                 String uc_passwod=C_passwod.getText().toString().trim();
                if(u_passwod.equals(uc_passwod)) {

                    if (Validate(u_name, u_mail, u_passwod, uc_passwod)) {
                        userRegister(u_name, u_mail, u_passwod, uc_passwod);

                    }
                }
                else {

                    C_passwod.setError("passwod must muth with c_passwod");

                }
            }
        });


    }






    public void userRegister(final String name, final String email, final String passwod, final String C_passwod)
    {

        ApiManager.getAPIs().SetUserregistr(name,email,passwod,C_passwod).enqueue(
                new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {

                        Log.e("scuess",response.toString());

                    Toast.makeText(MainActivity.this,"Register sucess",Toast.LENGTH_LONG).show();


                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        Toast.makeText(MainActivity.this,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public boolean Validate(String name,String email,String passwod,String c_passwod){
        if(name.equals("")){
            Name.setError("required");
            return false;
        }
       Name.setError(null);

        if(email.equals("")){
         Mail.setError("required");

            return false;
        }

        Mail.setError(null);
        if(!email.matches(emailpattern)){
            Mail.setError("not valid");
            return false;
        }
        if(passwod.length()<6){
            Passwod.setError("min 6 cha");
            return false;
        }
        Passwod.setError(null);

        if(c_passwod.length()<6)

        {
            C_passwod.setError("min 6 cha ");


            return false;
        }
       C_passwod.setError(null);


        return true;

    }

   /* public  void SaveString(String key,String value){
        SharedPreferences.Editor sharedPreferences =
                getSharedPreferences("survey",MODE_PRIVATE).edit();

        sharedPreferences.putString(key,value);
        sharedPreferences.apply();
    }
    public String getString(String key){
        SharedPreferences sharedPreferences = getSharedPreferences("touism",MODE_PRIVATE);
        return   sharedPreferences.getString(key,null);

    }*/

}
