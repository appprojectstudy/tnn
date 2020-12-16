package com.pj.jawaseom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProductInfo implements Serializable {

    private String productName;
    private int productCode;
    private Boolean productState;
    private String accountName;
    private int accountCode;
    private ArrayList<String> productContents;
    private String productNoticeInfo;
    private float customerPrice;
    private float cost;
    private float purchasePrice;
    private float wholesalePrice;
    private float thirdPartyCode;
    private Date createdAt;
    private String id;

    private ProductInfo(String productName, int productCode, Boolean productState, String accountName, int accountCode, ArrayList<String> productContents,
                        String productNoticeInfo, float customerPrice, float cost, float wholesalePrice, float thirdPartyCode, Date createdAt, String id) {
        this.productName = productName;
        this.productCode = productCode;
        this.productState = productState;
        this.accountName = accountName;
        this.accountCode = accountCode;
        this.productContents = productContents;
        this.productNoticeInfo = productNoticeInfo;
        this.customerPrice = customerPrice;
        this.cost = cost;
        this.wholesalePrice = wholesalePrice;
        this.thirdPartyCode = thirdPartyCode;
        this.createdAt = createdAt;
        this.id = id;
    }
    private ProductInfo(String productName, int productCode, Boolean productState, String accountName, int accountCode, ArrayList<String> productContents,
                        String productNoticeInfo, float customerPrice, float cost, float wholesalePrice, float thirdPartyCode, Date createdAt) {
        this.productName = productName;
        this.productCode = productCode;
        this.productState = productState;
        this.accountName = accountName;
        this.accountCode = accountCode;
        this.productContents = productContents;
        this.productNoticeInfo = productNoticeInfo;
        this.customerPrice = customerPrice;
        this.cost = cost;
        this.wholesalePrice = wholesalePrice;
        this.thirdPartyCode = thirdPartyCode;
        this.createdAt = createdAt;
    }

    public Map<String, Object> getProductInfo(){
        Map<String, Object> docData = new HashMap<>();
        return  docData;
    }

    public void setProductName(String productName) {
       this.productName = productName;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }
    public int getProductCode() {
        return productCode;
    }
    public void setProductState(Boolean productState) {
        this.productState = productState;
    }
    public Boolean getProductState() {
        return productState;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountCode(int accountCode) {
        this.accountCode = accountCode;
    }
    public int getAccountCode() {
        return accountCode;
    }
    public void setProductContents(ArrayList<String> productContents) {
        this.productContents = productContents;
    }
    public ArrayList<String> getProductContents() {
        return productContents;
    }
    public void setProductNoticeInfo(String productNoticeInfo) {
        this.productNoticeInfo = productNoticeInfo;
    }
    public String getProductNoticeInfoInfo() {
        return productNoticeInfo;
    }
    public void setCustomerPrice(float customerPrice) {
        this.customerPrice = customerPrice;
    }
    public float getCustomerPrice() {
        return customerPrice;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public float getCost() {
        return cost;
    }
    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public float getPurchasePrice() {
        return purchasePrice;
    }
    public void setWholesalePrice(float wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }
    public float getWholesalePrice() {
        return wholesalePrice;
    }
    public void setThirdPartyCode(float thirdPartyCode) {
        this.thirdPartyCode = thirdPartyCode;
    }
    public float getThirdPartyCode() {
        return thirdPartyCode;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
