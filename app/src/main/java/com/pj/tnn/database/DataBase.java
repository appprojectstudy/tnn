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

import static com.pj.tnn.MainActivity.setDataBase;

public class DataBase {

    private String myJson;
    private ArrayList<HashMap<String, String>> userList;
    private JSONArray users = null;
    private ApiInterface apiInterface;
    private ApiClient apiClient;

    public void showList() {
        try {
            JSONObject jsonObject = new JSONObject(myJson);
            users = jsonObject.getJSONArray(setDataBase.getTagResult());

            for(int i = 0; i < users.length(); i++) {
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

    public void init() {
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
}



