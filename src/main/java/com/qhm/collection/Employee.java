package com.qhm.collection;

public abstract class Employee {

    protected Employee mBoss;

    public abstract void setBoss(Employee boss);

    public abstract void handleCall(Call call);

}
