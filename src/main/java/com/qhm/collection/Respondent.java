package com.qhm.collection;

/**
 * 接线员
 */
public class Respondent extends Employee {

    @Override
    public void handleCall(Call call) {
        if (call.getCaller().getRank().equals("S")) {
            System.out.println("Respondent : handle this call");
            call.getCaller().disconnect();
        } else {
            mBoss.handleCall(call);
        }
    }

    @Override
    public void setBoss(Employee boss) {
        mBoss = boss;
    }

}