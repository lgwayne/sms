package com.wayne.sms.config;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: ShiroFilterMapFactory
 * @author fuce
 * @date 2018年8月26日
 *
 */
public class ShiroFilterMapFactory {
	
/**
anon:例子/admins/**=anon 没有参数，表示可以匿名使用。

authc:例如/admins/user/**=authc表示需要认证(登录)才能使用，没有参数

roles(角色)：例子/admins/user/**=roles[admin],参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，当有多个参数时，例如admins/user/**=roles["admin,guest"],每个参数通过才算通过，相当于hasAllRoles()方法。

perms（权限）：例子/admins/user/**=perms[user:add:*],参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，例如/admins/user/**=perms["user:add:*,user:modify:*"]，当有多个参数时必须每个参数都通过才通过，想当于isPermitedAll()方法。

rest：例子/admins/user/**=rest[user],根据请求的方法，相当于/admins/user/**=perms[user:method] ,其中method为post，get，delete等。

port：例子/admins/user/**=port[8081],当请求的url的端口不是8081是跳转到schemal://serverName:8081?queryString,其中schmal是协议http或https等，serverName是你访问的host,8081是url配置里port的端口，queryString

是你访问的url里的？后面的参数。

authcBasic：例如/admins/user/**=authcBasic没有参数表示httpBasic认证

ssl:例子/admins/user/**=ssl没有参数，表示安全的url请求，协议为https

user:例如/admins/user/**=user没有参数表示必须存在用户，当登入操作时不做检查

*/
	
	public static Map<String, String> shiroFilterMap() {
//		设置路径映射，注意这里要用LinkedHashMap 保证有序
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//		filterChainDefinitionMap.put("/admin/index", "authc, roles[admin]");
//		filterChainDefinitionMap.put("/techer/index", "authc, roles[teacher]");
//		filterChainDefinitionMap.put("/student/index", "authc, roles[student]");

		//对所有用户认证
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/admin/login", "anon");
		filterChainDefinitionMap.put("/admin/logout", "logout");
		filterChainDefinitionMap.put("/Logout", "logout");


		//放验证码
		filterChainDefinitionMap.put("/captcha/**", "anon");
//		// 释放 druid 监控画面
//		filterChainDefinitionMap.put("/websocket", "anon");
		//前端
		filterChainDefinitionMap.put("/", "anon");
		filterChainDefinitionMap.put("/index", "anon");//任务调度暂时放开

		//
		//对所有页面进行认证
		filterChainDefinitionMap.put("/**","authc");
		return filterChainDefinitionMap;
	}
	/*//Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new HashMap<>();
        //登出
        map.put("/logout", "logout");
        //对所有用户认证
        map.put("/admin/**", "authc, roles[admin]");
        map.put("/techer/**", "authc, roles[teacher]");
        map.put("/student/**", "authc, roles[student]");
        map.put("/login", "anon");

        //静态资源可以匿名访问
        map.put("/css/**", "anon");
        map.put("/js/**", "anon");
        map.put("/images/**", "anon");
        map.put("/fonts/**", "anon");

        map.put("/**", "authc");
        //登录
        shiroFilterFactoryBean.setLoginUrl("/login.jsp");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error.jsp");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }*/
}
