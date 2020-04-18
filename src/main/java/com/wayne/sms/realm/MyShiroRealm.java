package com.wayne.sms.realm;

import com.wayne.sms.pojo.Role;
import com.wayne.sms.pojo.Userlogin;
import com.wayne.sms.service.RoleService;
import com.wayne.sms.service.UserLoginService;
import jdk.nashorn.internal.parser.Token;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

import static java.awt.SystemColor.info;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.realm
 * @Author: lgwayne
 * @CreateTime: 2020-03-16 14:04
 * @Description: ${Description}
 */
public class MyShiroRealm extends AuthorizingRealm {


    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private RoleService roleService;


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

//        //得到用户名和密码
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
//
//        String username = usernamePasswordToken.getUsername();
//        String password = new String((char[]) token.getCredentials());
//
//        Userlogin byUserId = userLoginService.findByUserId(Long.parseLong(username));
//
////        SysUser byUsername = sysUserService.findByUsername(username);
//        System.out.println("看看找出了啥："+byUserId);
//        System.out.println("这是token密码"+password);
//
//        System.out.println("看看密码对不对"+byUserId.getPassword().equals(password));
//
//        if(byUserId==null){
//            throw new UnknownAccountException("账户不存在");
//        }else if(!byUserId.getPassword().equals(password)){
//            throw new IncorrectCredentialsException("密码不正确");
//        }
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(byUserId,password,this.getName());
//        return info;




        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (token.getPrincipal() == null) {
            return null;
        }
//		System.out.println("可以看看在realm找出来啥"+userInfo);
//		System.out.println("----->>userInfo=" + userInfo.getUserName() + "---"+ userInfo.getPassword());
        //        System.out.println("看看这个id是什么"+userId);
//        String password = new String((char[]) token.getCredentials());
        // 通过username从数据库中查找 User对象，如果找到，没找到.
        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        System.out.println("看看这个id是什么"+(String) token.getPrincipal());
        Long userId = Long.parseLong((String) token.getPrincipal());
        Userlogin userInfo = userLoginService.findByUserId(userId);
        if (userInfo == null)
        {
            throw new UnknownAccountException("账户不存在");
        }
        else{
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    userInfo, // 用户名
                    userInfo.getPassword(), // 密码
                    getName() // realm name
            );
            return authenticationInfo;
        }

    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Role role=null;
        Userlogin user= (Userlogin) getAvailablePrincipal(principals);

        try {
            Userlogin userlogin = userLoginService.findByUserId(user.getUserId());
             role = roleService.findbyId(userlogin.getRole());
        }catch (Exception e){
            e.printStackTrace();
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> r = new HashSet<>();
        if (role!=null){
            r.add(role.getRoleName());
            info.setRoles(r);
        }
        return info;
    }


}
