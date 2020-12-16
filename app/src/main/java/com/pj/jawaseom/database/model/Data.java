package com.pj.jawaseom.database.model;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("name")
    private String userName;

    @SerializedName("id")
    private String userId;

    @SerializedName("pw")
    private String passWord;

    public String getUserName ()
    {
        return userName;
    }

    public String getUserId ()
    {
        return userId;
    }

    public String getPassWord ()
    {
        return passWord;
    }
}
