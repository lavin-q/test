package com.qhm.example.test.googleTest;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description : PreConditions参数验证方式测试  //描述
 * @Author : qhm  //作者
 * @Date: 2020-07-12 13:57  //时间
 */
public class PreConditionsTest {

    public static void main(String[] args) {

            test(3,"");
    }

        public static void  test(Integer param1 ,String param2) {
            System.out.println("PreConditions参数验证开始");
            try {
                Preconditions.checkArgument(param1>3,"param 参数值异常");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                Preconditions.checkState(StringUtils.isNotBlank(param2),"参数为空");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                Preconditions.checkState(param1 > 3,"%s is < %s %s ", "param1",3,"测试");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("PreConditions参数验证结束");
        }
}
