package com.pj.tnn.database;

import android.util.Log;

import com.pj.tnn.MainActivity;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.pj.tnn.MainActivity.setDataBase;
import static com.pj.tnn.MainActivity.variable;

public class ApiClient {

    public Retrofit retrofit = null;

    public Retrofit getAPiClient() {
        String tempUrl = "";
        int state = MainActivity.variable.apiState;

        switch (state) {
            case 0:
                tempUrl = setDataBase.getUserListUrl();
                break;
            case 1:
                tempUrl = setDataBase.getUserInfoUrl();
                break;
            case 2:
                tempUrl = setDataBase.getUserAddUrl();
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
