package com.pj.tnn.database;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.pj.tnn.MainActivity;
import com.pj.tnn.Variable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Database {

    public Database() {

    }

    public SetDatabase setDatabase = new SetDatabase("127.0.0.1", "id", "pw");

    public interface Callback<R> {

    }
}
