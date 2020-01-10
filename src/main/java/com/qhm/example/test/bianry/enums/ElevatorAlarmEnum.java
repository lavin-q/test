package com.qhm.example.test.bianry.enums;


import java.util.List;

import static java.util.Arrays.asList;


/**
 *
 * @Description:    alarm状态枚举
 * @CreateDate:     2019/8/9 16:53
 * @Version:        1.0
 */

public enum  ElevatorAlarmEnum {

    ElEVATOR_EARLY_ALARM("升降机预警",asList("载重预警","人数预警","风速预警","速度预警","高度预警","倾角预警","冲顶预警",
            "高度上限位预警","高度下限位预警","电池低压预警","UPS即将关闭预警","日常维保预警","防坠安全器维保","整机复检预警","防坠器异常预警")),

    ELEVATOR_ALARM("升降机报警",asList("载重报警","人数报警","风速报警","速度报警","高度报警","倾角报警","冲顶报警",
            "高度上限位报警","高度下限位报警","电池低压报警","UPS即将关闭报警","日常维保报警","防坠安全器维保报警","整机复检报警","防坠器异常报警"))

;


    public String getDes(){return des;}
    public List<String> getValue(){return value;}

    private String des;
    private List<String> value;

    private ElevatorAlarmEnum(String des, List<String> value){
        this.des = des;
        this.value = value;
    }

}
