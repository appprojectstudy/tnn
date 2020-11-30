package com.pj.tnn.database;

import android.util.Log;

import com.pj.tnn.database.model.Model;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;


public class DataBase {

    private String myJson;
    private ArrayList<HashMap<String, String>> userList;
    private JSONArray users = null;
    private ApiInterface apiInterface;
    private ApiClient apiClient;

    public void initLoadJSON() {
        apiInterface = apiClient.getAPiClient().create(ApiInterface.class);

        Observable<Model> observable = apiInterface.getData();

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Model>() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onNext(Model model) {
                        Log.d("TEST", "name : " + model.getData().getUserName() + "\n"
                                    + "id : " + model.getData().getUserId()  + "\n"
                                    + "pw : " + model.getData().getPassWord()
                        );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TEST", "error : " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TEST", "called");
                    }

                });
    }

    public void initAddUserInfo() {

    }
}



