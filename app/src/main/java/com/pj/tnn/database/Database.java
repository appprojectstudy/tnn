package com.pj.tnn.database;


import com.pj.tnn.Variable;

public class Database {


    public Database() {

    }

    public String hostName;
    public String hostId;
    public String hostPw;

    public SetDatabase setDatabase = new SetDatabase();

    public SetDatabase setSetDatabase() {
        setDatabase.setHostName("127.0.0.1");
        setDatabase.setHostId("test");
        setDatabase.setHostPassWord("test");

        return setDatabase;
    }

    public void getSetDatabase(SetDatabase setDatabase) {
        this.setDatabase = setDatabase;

        hostName = setDatabase.getHostName();
        hostId = setDatabase.getHostId();
        hostPw = setDatabase.getHostPassWord();
    }
}