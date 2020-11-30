package com.pj.tnn.database;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public Retrofit retrofit = null;

    public Retrofit getAPiClient() {
        if(retrofit == null)
            retrofit = new Retrofit.Builder().baseUrl(DataBase.setDataBase.getURL())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();


        return retrofit;
    }
}
