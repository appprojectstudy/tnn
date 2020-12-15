package com.pj.tnn.database;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.pj.tnn.database.model.Model;
import com.pj.tnn.thread.AleadyClosedException;
import com.pj.tnn.thread.ThreadPool;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class DataBase {

    private ApiInterface apiInterface = null;
    private ApiClient apiClient = null;

    private ThreadPool threadPool = new ThreadPool(1, 8, 4, 6);

    public void initLoadJSON(Context context, int state) {
        apiInterface = apiClient.getAPiClient(state).create(ApiInterface.class);


        productData(context, apiInterface, state);
    }

    public void productData(Context context, ApiInterface apiInterface, int state) {
        Observable<Model> signInData = apiInterface.getData();

        signInData.subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.computation())
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

    public void userSignIn() {

    }

    public void userSignUp() {

    }


    public void init(Context context, int state) {
        initLoadJSON(context, state);
    }
}
