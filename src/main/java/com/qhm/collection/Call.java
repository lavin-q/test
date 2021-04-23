package com.qhm.collection;

public class Call {

    private Caller mCaller;
    private Employee mEmployee;

    public Call(Caller caller) {
        this.mCaller = caller;
    }

    public Caller getCaller() {
        return mCaller;
    }

    public void handle() {
        mEmployee.handleCall(this);
    }

    public void setRespondent(Employee respondent) {
        mEmployee = respondent;
    }

}