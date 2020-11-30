package com.pj.tnn.database.model;

import com.google.gson.annotations.SerializedName;

public class Data {
    //user info
    @SerializedName(value = "name")
    private String userName;

    @SerializedName(value = "id")
    private String userId;

    @SerializedName(value = "pw")
    private String passWord;

    //product
    @SerializedName(value = "production")
    private String production;

    @SerializedName(value = "productPrice")
    private String productPrice;

    public String getUserName()
    {
        return userName;
    }

    public String getUserId()
    {
        return userId;
    }

    public String getPassWord()
    {
        return passWord;
    }

    public String getProduction()
    {
        return production;
    }

    public String getProductPrice()
    {
        return productPrice;
    }
}
