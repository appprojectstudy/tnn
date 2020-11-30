package com.pj.tnn.database;

import android.util.Log;

import com.pj.tnn.database.model.Model;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {
    String myJson;
    ArrayList<HashMap<String, String>> userList;
    JSONArray users = null;

    public static SetDataBase setDataBase = new SetDataBase("name", "id", "pw");
    private ApiInterface apiInterface;
    private ApiClient apiClient;

    public void showList() {
        try {
            JSONObject jsonObject = new JSONObject(myJson);
            users = jsonObject.getJSONArray(setDataBase.getTagResult());

            for(int i=0; i<users.length(); i++) {
                JSONObject jb = users.getJSONObject(i);

                String name = jb.getString(setDataBase.getTagName());
                String id = jb.getString(setDataBase.getTagId());
                String pw = jb.getString(setDataBase.getTagPw());

                HashMap<String, String> users = new HashMap<String, String>();

                users.put(setDataBase.getTagName(), name);
                users.put(setDataBase.getTagId(), id);
                users.put(setDataBase.getTagPw(), pw);

                userList.add(users);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(String url) {
        apiInterface = apiClient.getAPiClient().create(ApiInterface.class);

        Observable<Model> observable = apiInterface.getData();

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Model>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Model model) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }

                });
    }
}



