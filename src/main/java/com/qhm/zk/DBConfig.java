package com.qhm.zk;

import lombok.Getter;
import lombok.Setter;

/**
 * @ Description: 数据库配置类
 * @ Author: qhm
 * @ Date: 2019/12/7 11:17
 * @ Version: 1.0
 */
@Getter
@Setter
public class DBConfig {

    private String url;
    private String driver;
    private String username;
    private String password;

    public DBConfig() {
    }

    public DBConfig(String url, String driver, String name, String password) {
        this.url = url;
        this.driver = driver;
        this.username = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "DRIVER:" + driver + ",URL:" + url + ",USERNAME:" + username + ",PASSWORD:" + password;
    }
}
