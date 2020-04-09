package com.wayne.sms.controller;

import com.wayne.sms.dao.ClazzMapper;
import com.wayne.sms.dao.StudentMapper;
import com.wayne.sms.domain.AjaxResult;
import com.wayne.sms.model.TitleVo;
import com.wayne.sms.pojo.*;
import com.wayne.sms.service.ClazzService;
import com.wayne.sms.service.CollegeService;
import com.wayne.sms.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.controller
 * @Author: lgwayne
 * @CreateTime: 2020-03-27 16:44
 * @Description: ${Description}
 */
@Controller
public class CollegeLinkedController extends BaseController{

    private String collegeLinked = "admin/collegeLinked";


    @Autowired
    private CollegeService collegeService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private ClazzService clazzService;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;


    /**
     * =============================================学院联动开始=======================================
     */

    @GetMapping("admin/collegeLinked/view.html")
    public String collegeView(ModelMap model) {
        String str = "学院联动";
        setTitle(model, new TitleVo("列表", str + "管理", true, "欢迎进入" + str + "页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);
        return collegeLinked + "/view";
    }
    @GetMapping("admin/collegeLinked/list")
    public String collegeList(ModelMap model) {
        String str = "学院联动";
        setTitle(model, new TitleVo("列表", str + "管理", true, "欢迎进入" + str + "页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
//        for (College college : colleges) {
//            System.out.println("这是学院信息："+college);
//        }
        model.addAttribute("collegeList", colleges);
        return collegeLinked + "/list";
    }


    /**
     * 市查询
     *
     * @param cid
     * @return
     */
    @GetMapping("admin/collegeLinked/getMajor")
    @ResponseBody
    public List<Major> getMajor(String cid) {

        MajorExample example = new MajorExample();
        example.createCriteria().andCollegeIdEqualTo(Integer.parseInt(cid));
        List<Major> majors = majorService.selectByExample(example);
//        for (Major major : majors) {
//            System.out.println("这是专业"+major);
//        }
        return majors;

    }

    /**
     * 区查询
     * TODO(请说明这个方法的作用).
     *
     * @param mid
     * @return
     */
    @GetMapping("admin/collegeLinked/getClazz")
    @ResponseBody
    public List<Clazz> getClazz(String mid) {

        ClazzExample example = new ClazzExample();
        example.createCriteria().andMajorIdEqualTo(Integer.parseInt(mid));
        List<Clazz> clazzes = clazzService.selectByExample(example);
//        for (Clazz clazz : clazzes) {
//            System.out.println("这是班级信息"+clazz);
//        }
        return clazzes;
    }
    @GetMapping("admin/collegeLinked/getStudent")
    @ResponseBody
    public List<Student> getStudent(String clid) {
        StudentExample studentExample = new StudentExample();
        Clazz clazz = clazzMapper.selectByClazzId(Integer.parseInt(clid));
        studentExample.createCriteria().andClazzEqualTo(clazz.getClazzName());
        List<Student> students = studentMapper.selectByExample(studentExample);
//        for (Student student : students) {
//            System.out.println(student);
//        }
        return students;
    }



    @PostMapping("/admin/collegeLinked/search")
    @ResponseBody
//    public String getRequest(String dataFormJson){
//        return dataFormJson;
//    }

    public AjaxResult editSave(String cid, String mid, String clid) {

        System.out.println("看看传来了啥:cid="+cid+",mid="+mid+",clid="+clid);
        return AjaxResult.success();
    }
}
