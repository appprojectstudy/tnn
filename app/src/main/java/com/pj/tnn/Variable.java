package com.pj.tnn;

public class Variable {

    private String userId;
    private String userPw;
    private String userName;

    private String production;
    private String productPrice;

    // 0 = ListUrl, 1 = InfoUrl, 2 = AddUrl
    public int apiState = 0;

    // reset
    public Variable() { }

    public void setUserId(String userId) {
        userId = this.userId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserPassWord(String userPw) {
        userPw = this.userPw;
    }
    public String getUserPassWord() {
        return userPw;
    }
    public void setUserName(String userName) {
        userName = this.userName;
    }
    public String getUserName() {
        return userName;
    }


    public void setProduction(String production) {
        production = this.production;
    }
    public String getProduction() {
        return production;
    }
    public void setProductPrice(String productPrice) {
        productPrice = this.productPrice;
    }
    public String getProductPrice() {
        return productPrice;
    }

}
