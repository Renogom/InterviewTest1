package com.m.edutabtest.networkss;

import com.m.edutabtest.models.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIService {

    @GET("https://api.instantwebtools.net/v1/passenger?")
    Call<BaseResponse> getPassengers(@Query("page") String page,
                                     @Query("size") String size);


    @GET
    Call<BaseResponse> getPassengersDetails(@Url String url);

}
