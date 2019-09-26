package com.example.hassan.toursim.Trip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hassan.toursim.ApiMange.ApiManager;
import com.example.hassan.toursim.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Trip extends AppCompatActivity {
    RecyclerView recyclerView;
    TripAdapter adapter;
    ProgressBar progressBar;
  LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalis);
        progressBar=findViewById(R.id.progressBar);

        recyclerView=findViewById(R.id.RecyclerView);
        getTrips();

    }

    public  void setData()
    {
        //adapter=new TripAdapter(data);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        progressBar.setVisibility(View.INVISIBLE);

    }

    public void getTrips()
    {

        ApiManager.getAPIs().GetAllTrip().enqueue(new Callback<Datum>() {
            @Override
            public void onResponse(Call<Datum> call, Response<Datum> response) {
                Log.e("qom",response.toString());
               // Log.e("qom",response.body().getId());

            }

            @Override
            public void onFailure(Call<Datum> call, Throwable t) {

                Toast.makeText(Trip.this,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });

    }


}
