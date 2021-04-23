package com.qhm.collection;

/**
 * 电话类型
 */
public class Caller {

    private String mName;
    private String mRank;

    public Caller(String rank) {
        this.mRank = rank;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getRank() {
        return mRank;
    }

    public void setRank(String rank) {
        mRank = rank;
    }

    public void disconnect() {
        System.out.println("Caller : disconnect");
    }

}