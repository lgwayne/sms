package com.wayne.sms.util;

import com.wayne.sms.pojo.Userlogin;
import com.wayne.sms.realm.MyShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;


/**
 * shiro 工具类
 *	
 * @author fuce
 */
public class ShiroUtils {

    private ShiroUtils(){}
    
    /**
     * 获取shiro subject
     * @return
     * @author fuce
     * @Date 2019年11月21日 上午10:00:55
     */
    public static Subject getSubjct()
    {
        return SecurityUtils.getSubject();
    }
    
    /**
     * 获取登录session
     * @return
     * @author fuce
     * @Date 2019年11月21日 上午10:00:41
     */
    public static Session getSession()
    {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 退出登录
     * @author fuce
     * @Date 2019年11月21日 上午10:00:24
     */
    public static void logout()
    {
        getSubjct().logout();
    }
    
    /**
     * 获取登录用户model
     * @return
     * @author fuce
     * @Date 2019年11月21日 上午10:00:10
     */
    public static Userlogin getUser()
    {
    	Userlogin user = null;
        Object obj = getSubjct().getPrincipal();
        if (StringUtils.isNotNull(obj))
        {
            user = new Userlogin();
            BeanUtils.copyBeanProp(user, obj);
        }
        return user;
    }
    
    /**
     * set用户
     * @param user
     * @author fuce
     * @Date 2019年11月21日 上午9:59:52
     */
    public static void setUser(Userlogin user)
    {
        Subject subject = getSubjct();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
        // 重新加载Principal
        subject.runAs(newPrincipalCollection);
    }
    
    /**
     * 获取登录用户id
     * @return
     * @author fuce
     * @Date 2019年11月21日 上午9:58:55
     */
    public static String getUserId()
    {
        Userlogin user = getUser();
        if (user == null || user.getUserId() == null){
            throw new RuntimeException("用户不存在！");
        }
        return user.getUserName();
    }

    /**
     * 获取登录用户name
     * @return
     * @author fuce
     * @Date 2019年11月21日 上午9:58:48
     */
    public static String getLoginName()
    {
        Userlogin user = getUser();
        if (user == null){
            throw new RuntimeException("用户不存在！");
        }
        return user.getUserName();
    }
    
    /**
     * 获取登录用户ip
     * @return
     * @author fuce
     * @Date 2019年11月21日 上午9:58:26
     */
    public static String getIp()
    {
        return getSubjct().getSession().getHost();
    }
    
    /**
     * 获取登录用户sessionid
     * @return
     * @author fuce
     * @Date 2019年11月21日 上午9:58:37
     */
    public static String getSessionId()
    {
        return String.valueOf(getSubjct().getSession().getId());
    }
}
