package com.qhm.shiro.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.subject.WebSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
* @Description: Realm的配置<br/>
* @Author: qhm <br/>
* @Date: 2019/11/12 16:18<br/>
* @Version: 1.0 <br/>
*/
public class MyShiroRealm extends AuthorizingRealm {
    //slf4j记录日志，可以不使用
    private Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    /**
    * @Description: 设置授权信息 <br/>
    * @Author  qhm    <br/>
    * @Date: 2019/11/12 16:24 <br/>
    * @Version: 1.0 <br/>
    */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("开始授权(doGetAuthorizationInfo)");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //这个可以用来获取在登录的时候提交的其他额外的参数信息
        HttpServletRequest request = (HttpServletRequest) ((WebSubject) SecurityUtils
                                        .getSubject()).getServletRequest();

        String username = (String) principals.getPrimaryPrincipal();
        Set<String> roles = new HashSet<String> ();
        roles.add(username);
        authorizationInfo.setRoles(roles);
        //权限
        Set<String> permissions = new HashSet<String>();
        //通过数据库获取权限信息
        permissions.add("/user/add");
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
    * @Description: 设置认证信息 <br/>
    * @Author  qhm    <br/>
    * @Date: 2019/11/12 16:25 <br/>
    * @Version: 1.0 <br/>
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("开始认证(doGetAuthenticationInfo)");
        HttpServletRequest request = (HttpServletRequest) ((WebSubject) SecurityUtils
                .getSubject()).getServletRequest();
        UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("userName"), request.getParameter("password"));
        //获取用户输入的账号
        String userName = (String) token.getPrincipal();
        //通过userName去数据库中匹配用户信息，通过查询用户的情况做下面的处理
        logger.info("账号：" + userName);
        if ("passwordError".equals(userName)) {//密码错误
            throw new IncorrectCredentialsException();
        } else if ("lockAccount".equals(userName)) {// 用户锁定
            throw new LockedAccountException();
        } else {
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    userName, //用户名
                    "123456", //密码，写死
                    ByteSource.Util.bytes(userName + "salt"),//salt=username+salt
                    getName()  //realm name
            );
            return authenticationInfo;
        }
    }
}
