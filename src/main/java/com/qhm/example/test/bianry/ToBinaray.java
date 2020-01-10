package com.qhm.example.test.bianry;

import org.springframework.util.StringUtils;

public class ToBinaray {

    public static int[] nums = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192};
    public static String [] alarm = {"载重","人数","风速","速度","高度","倾角","冲顶","高度上限位预警","高度下限位","电池低压","UPS即将关闭","日常维保","防坠安全器维保","整机复检","防坠器异常报警"};
    public static String [] alarm1 = {"载重","人数","风速","速度","高度","倾角","冲顶","高度上限位预警","高度下限位","电池低压","UPS即将关闭","日常维保","防坠安全器维保","整机复检","防坠器异常报警"};
    public static void main(String[] args) {
        /*char[] chars = toBinString((512+256+8192));
        System.out.println(chars);
        List<java.lang.String> value = ElevatorAlarmEnum.ElEVATOR_EARLY_ALARM.getValue();
        String [] strs = value.toArray(new String[value.size()]);
        String[] fun = fun(chars, strs);
        System.out.println(Arrays.toString(alarm1));
        System.out.println(Arrays.toString(fun));*/

        //System.out.println(Arrays.toString(new String[15]));
        //System.out.println(transToBoolean((byte)0));
        //System.out.println(dataTypeTrans("16"));
        //32768 16384 1 2 4 8
        System.out.println(fun(262144));
        System.out.println(toBinString(268432456l)[27]);
        System.out.println(getAlarmlength(268432456l));
    }

    /**
     * 十进制转换为32位2进制数组
     * @param num
     */
    public static char[]  toBinString (Long num){
        String s = Long.toBinaryString(num);
        StringBuilder stringBuilder = new StringBuilder(s);
        while(stringBuilder.length()<32){
            stringBuilder.insert(0,'0');
        }
        stringBuilder.reverse();
        String str = new String(stringBuilder);
        char[] chars = str.toCharArray();
        return chars;

    }

    public static Integer fun(Integer num){
        String s = Integer.toBinaryString(num);
        return s.length();
    }

    /**
     * 数组转换
     */
    public static String[] fun(char[] chars,String[] strs){
        if(chars!=null && strs !=null){
            if(chars.length ==15 && strs.length == 15){
                for(int i = 0;i< 15;i++){
                    if(chars[i] =='0'){
                        strs[i] = "";
                    }
                }
            }
        }
        return strs;
    }

    private static  boolean transToBoolean(Byte byteValue){
        boolean b = false;
        if(byteValue != null){
            b = (byteValue != 0)? true:false;
        }
        return b;
    }

    /**
     * @description: 数据库DataType转换为对接接口所需要类型
     * @date:
     * @Version: 1.0
     */
    private static Integer dataTypeTrans(String dataType) {

        if (!StringUtils.isEmpty(dataType)) {
            int value = 0;
            int i = Integer.parseInt(dataType);
            switch (i) {
                case 0:
                    value = 0;
                    break;
                case 1:
                    value = 1;
                    break;
                case 16:
                    value = 3;
                    break;
                case 31:
                    value = 4;
                    break;
                default:
                    break;
            }
            return value;
        }

        return null;
    }

    /**
     * @Description: 获取当前数字的2进制长度 <br/>
     * @Author  qhm    <br/>
     * @Date: 2019/8/29 10:15 <br/>
     * @Version: 1.0 <br/>
     */
    public static Integer getAlarmlength(Long alarm){
        String s = Long.toBinaryString(alarm);
        StringBuilder sb = new StringBuilder(s);
        return sb.length();
    }
}
