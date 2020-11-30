package com.pj.tnn.database;

public class SetDataBase {

    private static final String USER_INFO_URL = "ip";
    private static final String USER_LIST_URL = "ip";
    private static final String USER_ADD_URL = "ip";
    private static final String TAG_RESULT = "result";

    private String tagName;
    private String tagId;
    private String tagPw;

    public SetDataBase(String name, String id, String pw) {
        this.tagName = name;
        this.tagId = id;
        this.tagPw = pw;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    public String getTagName() {
        return tagName;
    }
    public void setTagId(String tagId) {
        this.tagId = tagId;
    }
    public String getTagId() {
        return tagId;
    }
    public void setTagPassWord(String tagPw) {
        this.tagPw = tagPw;
    }
    public String getTagPassWord() {
        return tagPw;
    }
    public static String getTagResult() {
        return TAG_RESULT;
    }

    public static String getUserListUrl() {
        return USER_LIST_URL;
    }
    public static String getUserInfoUrl() {
        return USER_INFO_URL;
    }
    public static String getUserAddUrl() {
        return USER_ADD_URL;
    }

}
