package com.qhm.collection;

/**
 * 经理
 */
public class Manager extends Employee {

    @Override
    public void setBoss(Employee boss) {
        mBoss = boss;
    }

    @Override
    public void handleCall(Call call) {
        if (call.getCaller().getRank().equals("SS")) {
            System.out.println("Respondent : handle this call");
            call.getCaller().disconnect();
        } else {
            mBoss.handleCall(call);
        }
    }
}
