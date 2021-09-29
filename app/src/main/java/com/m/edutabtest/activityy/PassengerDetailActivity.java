package com.m.edutabtest.activityy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m.edutabtest.R;
import com.m.edutabtest.adapter.PassengerAdapter;
import com.m.edutabtest.adapter.PassengerDetailAdapter;
import com.m.edutabtest.common.Common;
import com.m.edutabtest.models.BaseResponse;
import com.m.edutabtest.networkss.APIService;
import com.m.edutabtest.networkss.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PassengerDetailActivity extends AppCompatActivity {
    private RecyclerView rv;
    APIService mService;
    PassengerDetailAdapter adapter;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_detail);

        Intent intent = getIntent();
        id = intent.getExtras().getString("ID");


        mService = Common.getPassenger();

        rv = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        loadData();
    }
    private void loadData() {
        String url;
        url="https://api.instantwebtools.net/v1/passenger/:"+id;


        mService.getPassengersDetails(url).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {

                if (response.body()!=null){
                    adapter = new PassengerDetailAdapter(response.body().getData(),getApplicationContext());
                    rv.setAdapter(adapter);
                    Toast.makeText(getApplicationContext(), "SuccessFully Data Loaded...", Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(getApplicationContext(), "Response Code Error..."+response.code(), Toast.LENGTH_LONG).show();

                }


            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Failed Data Loaded...", Toast.LENGTH_LONG).show();

            }
        });

    }

}
