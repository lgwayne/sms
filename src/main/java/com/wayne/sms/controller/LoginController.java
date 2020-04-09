package com.wayne.sms.controller;
import com.google.code.kaptcha.Constants;
import com.wayne.sms.domain.AjaxResult;
import com.wayne.sms.model.TitleVo;
import com.wayne.sms.pojo.Userlogin;
import com.wayne.sms.util.MD5Utils;
import com.wayne.sms.util.ShiroUtils;
import com.wayne.sms.util.StringUtils;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @BelongsProject: demo_tool
 * @BelongsPackage: com.example.demo_tool.controller
 * @Author: lgwayne
 * @CreateTime: 2020-03-02 21:19
 * @Description: ${Description}
 */
@Controller
public class LoginController extends BaseController {

    @RequestMapping(value = {"","index"})
    public String login(Model model){
        return "login";
    }




    /**
     * 请求到登陆界面
     * @param modelMap
     * @return
     */
    @GetMapping("admin/login")
    public String login(ModelMap modelMap) {
        try {
            if ((null != SecurityUtils.getSubject() && SecurityUtils.getSubject().isAuthenticated()) || SecurityUtils.getSubject().isRemembered()) {
                return "redirect:/admin/index";
            } else {
//                System.out.println("--进行登录验证..验证开始");
//                V2Config.setRollVerification(true);
//                modelMap.put("RollVerification",V2Config.getRollVerification());
//                System.out.println("V2Config.getRollVerification()>>>"+V2Config.getRollVerification());
                return "login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }

    /**
     * 用户登陆验证
     * @param password
     * @param code
     * @param redirectAttributes
     * @param rememberMe
     * @param request
     * @return
     */
    @RequestMapping("/admin/login")
    @ResponseBody
    public AjaxResult login(@RequestParam(value = "username")String user_Id, @RequestParam(value = "password") String password, String code, RedirectAttributes redirectAttributes, boolean rememberMe, HttpServletRequest request) {
        Long userId;
        try {
            userId= Long.parseLong(user_Id);
        }catch (Exception e){
            return AjaxResult.error(500,"请输入正确的学号（数字）");
        }
        Userlogin userlogin = new Userlogin();
        userlogin.setUserId(userId);
        userlogin.setPassword(password);

        String scode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println("这是生成的验证码"+scode);
        Boolean yz ;
        yz = StringUtils.isNotEmpty(scode) && StringUtils.isNotEmpty(code) && scode.equals(code);

//        if(scode==null) {//滚动验证
//            yz=true;
//            V2Config.setRollVerification(false);
//        }else {//图片验证
//            yz = StringUtils.isNotEmpty(scode) && StringUtils.isNotEmpty(code) && scode.equals(code);
//        }
        if(!yz){
            return AjaxResult.error(500, "验证码不正确!");
        }

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(String.valueOf(userId), password);
        try {
            if (rememberMe){
                token.setRememberMe(true);
            }
            subject.login(token);
        }catch (UnknownAccountException uae) {
            return AjaxResult.error(500, "账户不存在");
        } catch (IncorrectCredentialsException ice) {
            return AjaxResult.error(500, "用户名或密码不正确");
        }catch (NumberFormatException e){
            return AjaxResult.error(500,"请输入正确的学号和密码");
        }

//        System.out.println("看看这次是否是admin"+subject.hasRole("admin"));
        if (subject.hasRole("teacher")){
            return AjaxResult.successData(201,"欢迎来到教师页面");
        }else if (subject.hasRole("student")){
            return AjaxResult.successData(202,"欢迎来到学生界面");
        }

        return AjaxResult.success();
    }

    /**
     * 退出登陆
     * @return
     */
    @GetMapping("/Loginout")
    public String LoginOut(HttpServletRequest request, HttpServletResponse response){
        //在这里执行退出系统前需要清空的数据
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return "redirect:/login";
    }


    @RequestMapping("/error/403")
    public String errorPage(){
        return "error/403";
    }

    @GetMapping("admin/index")
    @RequiresRoles("admin")
    public String index(HttpServletRequest request) {
        request.getSession().setAttribute("sessionUserName",ShiroUtils.getUser().getUserName());
        return "admin/index";

    }
    @RequiresRoles("teacher")
    @GetMapping("teacher/index")
    public String index2(HttpServletRequest request) {
        request.getSession().setAttribute("sessionUserName",ShiroUtils.getUser().getUserName());
        return "teacher/index";

    }
    @GetMapping("student/index")
    public String index3(HttpServletRequest request) {
        return "student/index";
    }


    @GetMapping(value = {"teacher/main"})
    public String testTeacher2(ModelMap map){
        setTitle(map, new TitleVo("首页", "首页", true,"欢迎进入", true, false));
        return "/teacher/main";
    }

    @GetMapping("/admin/main")
    public String main(ModelMap map) {
        setTitle(map, new TitleVo("首页", "首页", true,"欢迎进入", true, false));
        return "admin/main";
    }


}
