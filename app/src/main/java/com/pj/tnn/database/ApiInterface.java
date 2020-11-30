package com.pj.tnn.database;


import com.pj.tnn.database.model.Model;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/api/users/2")
    Observable<Model> getData();

}
