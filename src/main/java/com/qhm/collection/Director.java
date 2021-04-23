package com.qhm.collection;

/**
 * 主管
 */
public class Director extends Employee{

    @Override
    public void setBoss(Employee boss) {
        mBoss = boss;
    }

    @Override
    public void handleCall(Call call) {
        if (call.getCaller().getRank().equals("SSS")) {
            System.out.println("Respondent : handle this call");
            call.getCaller().disconnect();
        } else {
            System.out.println("无法处理！");
        }
    }
}
