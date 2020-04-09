package com.wayne.sms.controller;

import com.wayne.sms.dao.RoleMapper;
import com.wayne.sms.model.TitleVo;
import com.wayne.sms.pojo.Role;
import com.wayne.sms.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: demo_tool_pages
 * @BelongsPackage: com.example.controller
 * @Author: lgwayne
 * @CreateTime: 2020-03-14 23:06
 * @Description: ${Description}
 */
@Controller
public class testController extends BaseController{

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleService roleService;


//    @RequestMapping(value = {"admin"})
//    public String testAdim(Model model){
//        return "admin/index";
//    }



//
//    @RequestMapping(value = {"teacher"})
//    public String testTeacher(Model model){
//        return "teacher/index";
//    }


//    @RequestMapping(value = {"student"})
//    public String testStudent(Model model){
//        return "student/index";
//    }
    @RequestMapping(value = {"student/main"})
    public String testStudent2(Model model){
        return "/student/main";
    }


    @PostMapping("/findAllRole")
    @ResponseBody
    public List<Role> findAll(){
        return roleMapper.selectByExample(null);
    }
    @RequestMapping("/findRole")
    @ResponseBody
    public Role findOne(){
        return roleService.findbyId(1);
    }




    @GetMapping("/testPage")
//    @ResponseBody
    public String backEcharts(){

        return "bar-label-rotation";
    }

    public void  test(){
//        ArrayList<Object> list = new List<Map<String,Map<String,Double>>>();

        ArrayList<Map<String, Map<String, Double>>> list = new ArrayList<Map<String,Map<String,Double>>>();

    }
}
