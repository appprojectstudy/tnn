package com.pj.jawaseom.database.model;

import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("data")
    private Data data;

    public Data getData ()
    {
        return data;
    }
}
