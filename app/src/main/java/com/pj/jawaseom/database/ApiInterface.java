package com.pj.jawaseom.database;


import com.pj.jawaseom.database.model.Model;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/api/users/2")
    Observable<Model> getData();

}
