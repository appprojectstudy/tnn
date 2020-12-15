package com.pj.tnn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.pj.tnn.database.DataBase;
import com.pj.tnn.database.SetDataBase;
import com.pj.tnn.thread.ThreadPool;

public class MainActivity extends AppCompatActivity {

    public static Context context;
    public static SetDataBase setDataBase = new SetDataBase("name", "id", "pw");

    public DataBase dataBase = new DataBase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}