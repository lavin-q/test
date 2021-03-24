package com.qhm.zk;

/**
 * @ Description: zk配置类
 * @ Author: qhm
 * @ Date: 2019/12/7 11:15
 * @ Version: 1.0
 */
public class ZKConstants {

    public static final String zkAddress = "192.168.120.22:2181";
    public static final int sessionTimeout = 20000;
    public static String parentPath = "/Pub-Sub";//父节点
    public static String configPath = parentPath + "/DBConfig";//存放配置信息的节点

}
