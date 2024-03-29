package com.qhm.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.junit.Assert;
import org.quartz.CronExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
        Logger logger = LoggerFactory.getLogger(UserController.class);
        @RequiresPermissions("user:list")//这个是配置是否有该权限的，如果是按上面的写法，这个是有权限的
        @RequestMapping(value="/list",method= RequestMethod.GET)
        public String getList(){
            logger.info("进入用户列表");
            return "user/list";
        }
        @RequiresPermissions(value={"user:add"})//这个是没有权限的
        @RequestMapping(value="/add",method=RequestMethod.GET)
        public String getAdd(){
            logger.info("进入新增用户界面");
            return "user/add";
        }


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse("2021-02-22 22:23:24");

        CronExpression cronExpression = new CronExpression("* * 10-22 18 1,4,7,10 ?");
        boolean resCron = cronExpression.isSatisfiedBy(new Date());
        System.out.println(resCron);

    }
}
