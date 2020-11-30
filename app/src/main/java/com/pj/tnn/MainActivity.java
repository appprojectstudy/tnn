package com.pj.tnn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.pj.tnn.database.SetDataBase;

public class MainActivity extends AppCompatActivity {

    public Context context = MainActivity.this;
    public static SetDataBase setDataBase = new SetDataBase("name", "id", "pw");
    public static Variable variable = new Variable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}