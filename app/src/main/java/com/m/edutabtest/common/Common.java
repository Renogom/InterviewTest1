package com.m.edutabtest.common;

import com.m.edutabtest.networkss.APIService;
import com.m.edutabtest.networkss.RetrofitClient;

public class Common {
    private static final String BASE_URL="https://api.instantwebtools.net/v1/passenger/";
    public static APIService getPassenger(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

}
