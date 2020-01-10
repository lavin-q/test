package com.qhm.zk;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @ Description:
 * @ Author: qhm
 * @ Date: 2019/12/7 11:18
 * @ Version: 1.0
 */
public class PublishServer {
    private static DBConfig dbConfig;
    private static CuratorFramework client;

    public static void main(String[] args) {
        init();
        readConfig();
        publishInfo();
    }


    /**
     * 创建客户端，并且如果父节点不存在则创建父节点和配置信息的节点
     */
    public static void init() {
        client = CuratorFrameworkFactory.builder()
                .connectString(ZKConstants.zkAddress)
                .sessionTimeoutMs(ZKConstants.sessionTimeout)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        client.start();

        try {
            if (client.checkExists().forPath(ZKConstants.parentPath) == null) {
                client.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT).forPath(ZKConstants.parentPath);
            }
            if (client.checkExists().forPath(ZKConstants.configPath) == null) {
                client.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT).forPath(ZKConstants.configPath,"".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *  读取配置文件到一个DBConfig对象中。
     */
    public static void readConfig() {
        BufferedReader reader = null;//加载文件流
        try {

            reader = new BufferedReader(new FileReader("H:\\test\\src\\main\\resources\\dbconfig.properties"));
            Properties prop = new Properties();//创建属性操作对象
            prop.load(reader);//加载流
            dbConfig = new DBConfig(prop.getProperty("url"),prop.getProperty("driver"),prop.getProperty("username"),prop.getProperty("password"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 将DBConfig使用Kryo序列化之后发布到ZooKeeper节点中
     */
    public static void publishInfo() {
        try {
            Kryo kryo = new Kryo();
            Output output = new Output(1,1024);
            kryo.writeObject(output, dbConfig);
            output.close();
            client.setData().forPath(ZKConstants.configPath, output.getBuffer());//添加到节点中
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
