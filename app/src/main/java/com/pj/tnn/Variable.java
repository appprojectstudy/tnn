package com.pj.tnn;

public class Variable {

    /* -------------------- user info variable start -------------------- */
    private String userId;
    private String userPw;
    private String userName;
    /* ------------------- user info variable end ------------------- */

    /* ------------------- product variable start ------------------- */
    private String production;
    private String productPrice;
    /* -------------------- product variable end -------------------- */

    // reset
    public Variable() { }

    /* -------------------- hiding variable start -------------------- */

    /* --------------- user info hiding variable start --------------- */

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

    /* --------------- user info hiding variable end --------------- */

    /* --------------- product hiding variable start --------------- */

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

    /* ---------------- product hiding variable end ---------------- */

    /* -------------------- hiding variable end -------------------- */
}
