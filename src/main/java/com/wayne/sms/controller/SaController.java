package com.wayne.sms.controller;

import com.github.pagehelper.PageInfo;
import com.wayne.sms.dao.CollegeMapper;
import com.wayne.sms.dao.TeacherMapper;
import com.wayne.sms.domain.AjaxResult;
import com.wayne.sms.model.TableSplitResult;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.model.TitleVo;
import com.wayne.sms.pojo.*;
import com.wayne.sms.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.controller
 * @Author: lgwayne
 * @CreateTime: 2020-04-01 13:43
 * @Description: ${Description}
 */
@Controller
public class SaController extends BaseController {

    private String SaCollege = "admin/saCollege";

    private String SaMajor = "admin/saMajor";

    private String SaClazz = "admin/saClazz";

    private String teacherSaClazz = "teacher/saClazz";

    private String SaStudent = "admin/saStudent";


    private String teacherSaStudent = "teacher/saStudent";

    public  String teacherId=null;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private CollegeMapper collegeMapper;


    /*===================================管理员模块分析开始=============================================*/

    /*=====================学院成绩分析========================*/

    @GetMapping("/admin/saCollege/view.html")
    public String view(ModelMap model,HttpServletRequest request)
    {
        String str="学院成绩分析";
        setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);
        List<Course> courseList = courseService.selectByExample(new CourseExample());
        model.addAttribute("courseList", courseList);
        return SaCollege + "/list";
    }

    @PostMapping("admin/saCollege/list")
    @ResponseBody
    public Object list(Tablepar tablepar, String searchText,String grade,String courseName,String cid,String order){
//        System.out.println("grade="+grade+",courdeName"+courseName+",cid="+cid+",order="+order);
        PageInfo<SaCollege> page=saCollegeService.list(tablepar,searchText,grade,courseName,cid,order) ;
        TableSplitResult<SaCollege> result=new TableSplitResult<SaCollege>(page.getPageNum(), page.getTotal(), page.getList());
        return  result;
    }


    /**
     * 修改跳转
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/admin/saCollege/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("SaCollege", saCollegeService.selectByPrimaryKey(id));

        return SaCollege + "/edit";
    }



    /*=====================专业成绩分析========================*/

    @GetMapping("/admin/saMajor/view.html")
    public String getSaMajorview(ModelMap model,HttpServletRequest request)
    {
        String str="专业成绩分析";
        setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);
        List<Course> courseList = courseService.selectByExample(new CourseExample());
        model.addAttribute("courseList", courseList);
        return SaMajor + "/list";
    }

    @PostMapping("admin/saMajor/list")
    @ResponseBody
    public Object getSaMajorList(Tablepar tablepar, String searchText,String grade,String courseName,String cid,String mid,String order){
//        System.out.println("grade="+grade+",courdeName"+courseName+",mid="+mid+",order="+order);
        PageInfo<SaMajor> page=saMajorService.list(tablepar,searchText,grade,courseName,cid,mid,order) ;
        TableSplitResult<SaMajor> result=new TableSplitResult<SaMajor>(page.getPageNum(), page.getTotal(), page.getList());
        return  result;
    }

    @GetMapping("/admin/refreshStdMajor")
    @ResponseBody
    public AjaxResult refreshStdMajor(){
        //Controller层
        System.out.println("看看专业成绩标准分进来没");
        int i = saMajorService.refreshStdMajor();
        if (i==0){
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }


    /**
     * 修改跳转
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/admin/saMajor/edit/{id}")
    public String getSaMajorEdit(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("SaMajor", saMajorService.selectByPrimaryKey(id));

        return SaMajor + "/edit";
    }

    /*================================班级成绩分析=========================================*/

    @GetMapping("/admin/saClazz/view.html")
    public String getSaClazzView(ModelMap model,HttpServletRequest request)
    {
        String str="班级成绩分析";
        setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);
        List<Course> courseList = courseService.selectByExample(new CourseExample());
        model.addAttribute("courseList", courseList);
        return SaClazz + "/list";
    }

    @PostMapping("admin/saClazz/list")
    @ResponseBody
    public Object getSaClazzList(Tablepar tablepar, String searchText,String grade,String courseName,String mid,String clid,String order){
        PageInfo<SaClazz> page=saClazzService.list(tablepar,searchText,grade,courseName,mid,clid,order) ;
        TableSplitResult<SaClazz> result=new TableSplitResult<SaClazz>(page.getPageNum(), page.getTotal(), page.getList());
        return  result;
    }


    /**
     * 修改跳转
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/admin/saClazz/edit/{id}")
    public String getSaClazzEdit(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("SaClazz", saClazzService.selectByPrimaryKey(id));

        return SaClazz + "/edit";
    }


    @GetMapping("/admin/refreshStdClazz")
    @ResponseBody
    public AjaxResult refreshStdClazz(){
        System.out.println("看看班级成绩标准分进来没");
        int i = saClazzService.refreshStdClazz();
        if (i==0){
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }


    /*================================学生成绩分析=========================================*/

    @GetMapping("/admin/saStudent/view.html")
    public String getSaStudentView(ModelMap model,HttpServletRequest request)
    {
        String str="学生成绩分析";
        setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);
        List<Course> courseList = courseService.selectByExample(new CourseExample());
        model.addAttribute("courseList", courseList);
        return SaStudent + "/list";
    }

    @PostMapping("admin/saStudent/list")
    @ResponseBody
    public Object getSaStudentList(Tablepar tablepar, String searchText,String grade,String courseName,String mid,String clid,String order){
        PageInfo<SaStudent> page=saStudentService.list(tablepar,searchText,grade,courseName,mid,clid,order) ;
        TableSplitResult<SaStudent> result=new TableSplitResult<SaStudent>(page.getPageNum(), page.getTotal(), page.getList());
        return  result;
    }


    /**
     * 修改跳转
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/admin/saStudent/edit/{id}")
    public String getSaStudentEdit(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("SaStudent", saStudentService.selectByPrimaryKey(id));

        return SaStudent + "/edit";
    }


    @GetMapping("/admin/refreshStdStudents")
    @ResponseBody
    public AjaxResult refreshStdStudents(){
        System.out.println("看看学生成绩标准分进来没");
        int i = saStudentService.updateStdStudent();
        if (i==0){
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }


    /**
     * 更新成绩分析表
     * @return
     */
    @GetMapping("/admin/refreshScoreAnalysis")
    @ResponseBody
    public AjaxResult refreshSA(){
        System.out.println("看看成绩分析方法进来没");
        //更新学院成绩分析数据：
        //1.从math_score成绩表中重新查询出list<sacollege>对象，动态生成。
        List<SaCollege> saColleges = mathScoreService.selectAsSaCollege();
        //2.清除saCollege学院成绩分析表的数据
        saCollegeService.clearTable();
        //3.将重新生成的list<sacollege>对象插入到saCollege表中
        int updateSaCollege = saCollegeService.updateSaCollege(saColleges);

        //更新专业成绩分析数据
        //1.从math_score成绩表中重新查询出List<SaMajor>对象，动态生成。
        List<SaMajor> saMajors = mathScoreService.selectAsSaMajor();
        //2.清除saMajor专业成绩分析表的数据
        saMajorService.clearTable();
        //3.将重新生成的List<SaMajor>对象插入到saCollege表中
        int updateSaMajor = saMajorService.updateSaMajor(saMajors);

        //更新班级成绩分析数据

        List<SaClazz> saClazzes = mathScoreService.selectAsSaClazz();
        saClazzService.clearTable();
        int updateSaClazz = saClazzService.updateSaClazz(saClazzes);

        //更新学生成绩数据
        List<SaStudent> saStudents = mathScoreService.selectAsSaStudent();
        saStudentService.clearTable();
        int updateSaStudent = saStudentService.updateSaStudent(saStudents);

        if (updateSaClazz==0 || updateSaMajor==0 || updateSaCollege == 0 || updateSaStudent == 0){
            return AjaxResult.error();
        }else

            return AjaxResult.success();

    }

    /*===================================管理员模块分析结束=============================================*/



    /*===================================教师分析模块开始=============================================*/



    @GetMapping("/teacher/saClazz/view.html")
    public String getTeacherSaClazzView(ModelMap model,HttpServletRequest request,String tid)
    {
        String str="班级成绩分析概况";
        teacherId=tid;
        setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));

        //增加教师任教科目
        TeacherCourseExample example = new TeacherCourseExample();
        example.createCriteria().andTeacherIdEqualTo(Long.parseLong(teacherId));
        List<TeacherCourse> teacherCourseList = teacherCourseMapper.selectByExample(example);
        model.addAttribute("teacherCourseList", teacherCourseList);

        //增加教师的班级
        TeacherClazzExample example1 = new TeacherClazzExample();
        example1.createCriteria().andTeacherIdEqualTo(Long.parseLong(teacherId));
        List<TeacherClazz> teacherClazzes = teacherClazzMapper.selectByExample(example1);
        model.addAttribute("teacherClazzes", teacherClazzes);
        return teacherSaClazz + "/list";
    }

    @PostMapping("teacher/saClazz/list")
    @ResponseBody
    public Object getTeacherSaClazzList(Tablepar tablepar, String searchText,String grade,String courseName,String order,String clid){
        PageInfo<SaClazz> page=saClazzService.listByTeacher(tablepar,searchText,grade,courseName,order,teacherId,clid) ;
        TableSplitResult<SaClazz> result=new TableSplitResult<SaClazz>(page.getPageNum(), page.getTotal(), page.getList());
        return  result;
    }


    /*================================教师中的学生成绩分析=========================================*/

    @GetMapping("/teacher/saStudent/view.html")
    public String teacherGetSaStudentView(ModelMap model,HttpServletRequest request,String tid)
    {
        String str="学生成绩分析";
        teacherId = tid;
        setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        //增加教师任教科目
        TeacherCourseExample example = new TeacherCourseExample();
        example.createCriteria().andTeacherIdEqualTo(Long.parseLong(tid));
        List<TeacherCourse> teacherCourseList = teacherCourseMapper.selectByExample(example);
        model.addAttribute("teacherCourseList", teacherCourseList);

        //增加教师的班级
        TeacherClazzExample example1 = new TeacherClazzExample();
        example1.createCriteria().andTeacherIdEqualTo(Long.parseLong(tid));
        List<TeacherClazz> teacherClazzes = teacherClazzMapper.selectByExample(example1);
        model.addAttribute("teacherClazzes", teacherClazzes);

        return teacherSaStudent + "/list";
    }

    @PostMapping("teacher/saStudent/list")
    @ResponseBody
    public Object teacherGetSaStudentList(Tablepar tablepar, String searchText,String grade,String courseName,String clid,String order){

        PageInfo<SaStudent> page=saStudentService.listByTeacher(tablepar,searchText,teacherId,grade,courseName,clid,order) ;
        TableSplitResult<SaStudent> result=new TableSplitResult<SaStudent>(page.getPageNum(), page.getTotal(), page.getList());
        return  result;
    }

    /*===================================教师分析模块结束=============================================*/





}
