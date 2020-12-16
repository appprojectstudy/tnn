package com.pj.jawaseom.database;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    public Retrofit retrofit = null;

    public Retrofit getAPiClient(int state) {
        String tempUrl = "";

        switch (state) {
            case 0:
//                tempUrl = setDataBase.getUserListUrl();
                break;
            case 1:
//                tempUrl = setDataBase.getUserInfoUrl();
                break;
            case 2:
//                tempUrl = setDataBase.getUserAddUrl();
                break;

            default:
                Log.d("TEST", "error!!");
        }

        retrofit = new Retrofit.Builder().baseUrl(tempUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        return retrofit;
    }
}
