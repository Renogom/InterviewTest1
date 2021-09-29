package com.m.edutabtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.m.edutabtest.Databases.Database;
import com.m.edutabtest.adapter.PassengerAdapter;
import com.m.edutabtest.adapter.PassengerAdapterOffline;
import com.m.edutabtest.common.Common;
import com.m.edutabtest.models.BaseResponse;
import com.m.edutabtest.networkss.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    APIService mService;
    PassengerAdapter adapter;
    PassengerAdapterOffline adapterOffline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = Common.getPassenger();

        rv = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        loadData();
    }

    private void loadData() {

        if (checkInternetConnected(getApplicationContext())){
            mService.getPassengers("0", "102").enqueue(new Callback<BaseResponse>() {
                @Override
                public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {

                    if (response.body()!=null){

                        new Database(getApplicationContext()).addToCart(response.body().getData());

                        adapter = new PassengerAdapter(response.body().getData(),getApplicationContext());
                        rv.setAdapter(adapter);

                    }

                    Toast.makeText(getApplicationContext(), "SuccessFully Data Loaded...", Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<BaseResponse> call, Throwable t) {

                    Toast.makeText(getApplicationContext(), "Failed Data Loaded...", Toast.LENGTH_LONG).show();

                }
            });
        }else {


            Toast.makeText(getApplicationContext(),"Count"+new Database(getApplicationContext()).getCountCart(),Toast.LENGTH_LONG).show();
            adapterOffline = new PassengerAdapterOffline(new Database(getApplicationContext()).getCart(),getApplicationContext());
            rv.setAdapter(adapterOffline);
        }

    }


    public static boolean checkInternetConnected(Context context) {
        if (context != null) {
            ConnectivityManager
                    cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null
                    && activeNetwork.isConnectedOrConnecting();
        }
        return false;
    }

}