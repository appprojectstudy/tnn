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

        try {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    signInData.subscribe(new Observer<Model>() {
                        @Override
                        public void onSubscribe(Disposable d) { }

                        @Override
                        public void onNext(Model model) {
                            if(state == 1) {

                            } else {

                            }
                        }

                        @Override
                        public void onError(Throwable e) {
//                    Log.d("TEST", "error : " + e.toString());
                            Toast toast = Toast.makeText(context, "error : " + e.toString(), Toast.LENGTH_SHORT);
                            toast.show();
                        }

                        @Override
                        public void onComplete() {
                            Log.d("TEST", "called");
                        }
                    });
                }
            });
        } catch (AleadyClosedException e) {
            e.printStackTrace();
        }
    }

    public void userSignIn() {

    }

    public void userSignUp() {

    }


    public void initAddUserInfo(Context context, int state) {
        initLoadJSON(context, state);
    }
}
