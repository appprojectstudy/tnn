package com.pj.tnn.database;


import com.pj.tnn.Variable;

public class Database {

    public String hostName;
    public String hostId;
    public String hostPw;

    public Database() {

    }

    public SetDatabase setDatabase = new SetDatabase(hostName, hostId, hostPw);

    public void getHostName() {
        hostName =  setDatabase.getHostName();
    }

    public void getHostId() {
        hostId =  setDatabase.getHostId();
    }

    public void getHostPassWord() {
        hostPw =  setDatabase.getHostPassWord();
    }
}