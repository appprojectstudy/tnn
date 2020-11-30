package com.pj.tnn.database;

import android.util.Log;

import com.pj.tnn.MainActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class DataBase extends MainActivity {
    String myJson;
    ArrayList<HashMap<String, String>> userList;
    JSONArray users = null;

    public SetDataBase setDataBase = new SetDataBase("name", "id", "pw");

    protected void showList() {
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

    public interface serverRequests {
        //TODO RXSync 구현
    }
}



