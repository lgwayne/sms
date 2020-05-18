package com.wayne.sms.controller;

import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.Constants;
import com.wayne.sms.dao.TeacherClazzMapper;
import com.wayne.sms.dao.TeacherCourseMapper;
import com.wayne.sms.domain.AjaxResult;
import com.wayne.sms.model.TableSplitResult;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.model.TitleVo;
import com.wayne.sms.pojo.*;
import com.wayne.sms.service.*;
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
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import static org.apache.naming.SelectorContext.prefix;

/**
 * @BelongsProject: demo_tool
 * @BelongsPackage: com.example.demo_tool.controller
 * @Author: lgwayne
 * @CreateTime: 2020-03-02 21:19
 * @Description: ${Description}
 */
@Controller
//@RequestMapping("admin")
public class AdminController extends BaseController {

    private String userLogin = "admin/userLogin";

    private String student = "admin/student";

    private String teacher = "admin/teacher";

    private String score = "admin/mathScore";

    private String teacherCourse = "admin/teacherCourse";


    /*-------------------用户登录模块开始-------------------------*/
    /*
    查看登录用户信息
     */

    @GetMapping("/admin/userLogin/list")
    public String list(ModelMap model, HttpServletRequest request) {
        String str = "用户登录";
        setTitle(model, new TitleVo("列表", str + "管理", true, "欢迎进入" + str + "页面", true, false));
        return userLogin + "/list";
    }

    @PostMapping("admin/userLogin/list")
    @ResponseBody
    //controller层代码
    public Object list(Tablepar tablepar, String searchText) {

        PageInfo<Userlogin> page = userloginService.list(tablepar, searchText);
        TableSplitResult<Userlogin> result = new TableSplitResult<Userlogin>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /*
     * 新增用户登录信息
     */
    @GetMapping("/admin/userLogin/add")
    public String add(ModelMap modelMap) {
        return userLogin + "/add";
    }

    @PostMapping("admin/userLogin/add")
    @ResponseBody
    public AjaxResult add(Userlogin userlogin) {
        String password = userlogin.getPassword();
        Integer role = userlogin.getRole();

        String newPassword = MD5Utils.md5(password, null, 1024);
        userlogin.setPassword(newPassword);
        int b = userloginService.insertSelective(userlogin);

        System.out.println(userlogin);
        /**
         *根据角色再到添加到相应的学生/教师界面，待完善-------
         */
        if (b > 0 && (role == 1 || role == 2)) {
            return AjaxResult.successData(200, "操作成功，请完善教师个人信息");
        } else if (b > 0 && role > 1) {
            return AjaxResult.successData(200, "操作成功，请完善学生个人信息");
        } else {
            return error();
        }

    }

    /**
     * 检查用户
     *
     * @return
     */
    @PostMapping("admin/userLogin/checkNameUnique")
    @ResponseBody
    public int checkNameUnique(Userlogin userlogin) {
//        System.out.println("这是检查的userlogin"+userlogin);
        int b = userloginService.checkNameUnique(userlogin);
        if (b > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 修改跳转
     *
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/admin/userLogin/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        Userlogin userlogin = userloginService.selectByPrimaryKey(id);
        mmap.put("Userlogin", userlogin);
        return userLogin + "/edit";
    }

    /**
     * 修改保存
     */
    @PostMapping("admin/userLogin/edit")
    @ResponseBody
    public AjaxResult editSave(Userlogin record) {
        String password = MD5Utils.md5(record.getPassword(), null, 1024);//md5加密
        record.setPassword(password);

        return toAjax(userloginService.updateByPrimaryKeySelective(record));
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @param
     * @return
     */
    @PostMapping("admin/userLogin/get/{id}")
    public Userlogin edit(@PathVariable("id") String id) {
        return userloginService.selectByPrimaryKey(id);
    }


    /**
     * 删除用户
     *
     * @param ids
     * @return
     */
    @PostMapping("admin/userLogin/get/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int b = userloginService.deleteByPrimaryKey(ids);
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }

    /*---------------------------用户登录管理结束---------------------------------------*/


    /*---------------------------课程安排模块开始---------------------------------------*/
    @GetMapping("/admin/teacherCourse/view")
    public String teacherCourseView(ModelMap model) {
        String str = "课程任教表";
        setTitle(model, new TitleVo("列表", str + "管理", true, "欢迎进入" + str + "页面", true, false));
        return teacherCourse + "/list";
    }

    @PostMapping("admin/teacherCourse/list")
    @ResponseBody
    public Object teacherCourselist(Tablepar tablepar, String searchText) {
        PageInfo<TeacherCourse> page = teacherCourseService.list(tablepar, searchText);
        TableSplitResult<TeacherCourse> result = new TableSplitResult<TeacherCourse>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }


    @GetMapping("/admin/teacherCourse/edit/{id}")
    public String teacherClazz(@PathVariable("id") String id, ModelMap mmap) {

        TeacherClazzExample example = new TeacherClazzExample();
        example.createCriteria().andTeacherIdEqualTo(Long.parseLong(id));
        List<TeacherClazz> teacherClazzes = teacherClazzMapper.selectByExample(example);

        mmap.addAttribute("teacherClazzes", teacherClazzes);
        return teacherCourse + "/edit";
    }
    /*---------------------------课程安排模块结束---------------------------------------*/





    /*-------------------教師模块开始-------------------------*/
    /*
    查看教师信息
     */

    @GetMapping("/admin/teacher/list")
    public String teacherList(ModelMap model, HttpServletRequest request) {
        String str = "教师";
        setTitle(model, new TitleVo("列表", str + "管理", true, "欢迎进入" + str + "页面", true, false));
        return teacher + "/list";
    }

    @PostMapping("admin/teacher/list")
    @ResponseBody
    public Object teacherlist(Tablepar tablepar, String searchText) {
        PageInfo<Teacher> page = teacherService.list(tablepar, searchText);
        TableSplitResult<Teacher> result = new TableSplitResult<Teacher>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /*
     * 新增用户登录信息
     */
    @GetMapping("/admin/teacher/add")
    public String teacherAdd(ModelMap modelMap) {
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        modelMap.addAttribute("collegeList", colleges);

        return teacher + "/add";
    }

    @PostMapping("admin/teacher/add")
    @ResponseBody
    public AjaxResult teacherAdd(Teacher teacher) {
        Userlogin userlogin = new Userlogin();//新建一个用户登录对象，并用教师信息赋值
        userlogin.setUserName(teacher.getName());
        userlogin.setRole(2);
        userlogin.setPassword("64c8b1e43d8ba3115ab40bcea57f010b");//默认密码：123
        userloginService.insertSelective(userlogin);

        Teacher teacher1 = new Teacher();
        teacher1.setTeacherId(userlogin.getUserId());//根据用户登录表获取教师编号
        teacher1.setName(teacher.getName());
        teacher1.setJob(teacher.getJob());
        teacher1.setCollegeName(teacher.getCollegeName());

        int b = teacherService.insertSelective(teacher1);
        if (b > 0) {
            return success();
        } else {
            return error();
        }

    }

    /**
     * 检查用户
     *
     * @return
     */
    @PostMapping("admin/teacher/checkNameUnique")
    @ResponseBody
    public int checkNameUnique(Teacher teacher) {
        int b = teacherService.checkNameUnique(teacher);
        if (b > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 修改跳转
     *
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/admin/teacher/edit/{id}")
    public String teacherEdit(@PathVariable("id") String id, ModelMap mmap) {
        mmap.put("Teacher", teacherService.selectByPrimaryKey(id));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        mmap.addAttribute("collegeList", colleges);
        return teacher + "/edit";
    }

    /**
     * 修改保存
     */
    @PostMapping("admin/teacher/edit")
    @ResponseBody
    public AjaxResult editSave(Teacher record) {

        return toAjax(teacherService.updateByPrimaryKeySelective(record));
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @param
     * @return
     */
    @PostMapping("admin/teacher/get/{id}")
    public Teacher teacherEdit(@PathVariable("id") String id) {
        return teacherService.selectByPrimaryKey(id);
    }


    /**
     * 删除用户
     *
     * @param ids
     * @return
     */
    @PostMapping("admin/teacher/get/remove")
    @ResponseBody
    public AjaxResult teacherRemove(String ids) {
        int b = userloginService.deleteByPrimaryKey(ids);//根据教师id在用户登录表删除，教师表的信息也会删除
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }
    /*---------------------------教師登录管理结束---------------------------------------*/



    /*-------------------------学生信息管理开始-----------------------------------------*/

    /*
    跳转查看学生信息
     */

    @GetMapping("/admin/student/list")
    public String studentList(ModelMap model, HttpServletRequest request) {
        String str = "学生";
        setTitle(model, new TitleVo("列表", str + "管理", true, "欢迎进入" + str + "页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);
        return student + "/list";
    }

    @PostMapping("admin/student/list")
    @ResponseBody
    public Object studentList(Tablepar tablepar, String searchText, ModelMap model, String cid, String mid, String clid, String grade) {
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);//将学院信息以列表形式传到html页面

        PageInfo<Student> page = null;
        if (cid == null && mid == null && clid == null) {
            page = studentService.list(tablepar, searchText);
        } else {
            page = studentService.search(tablepar, cid, mid, clid, grade);
        }

        TableSplitResult<Student> result = new TableSplitResult<Student>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }


    /*
     * 跳转新增学生信息
     */
    @GetMapping("/admin/student/add")
    public String studentAdd(ModelMap modelMap) {
        return student + "/add";
    }

    /*
     * 新增学生信息
     */
    @PostMapping("admin/student/add")
    @ResponseBody
    public AjaxResult studentAdd(Student student) {
        int b = studentService.insertSelective(student);
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }


    /**
     * 检查用户
     *
     * @param student
     * @return
     */
    @PostMapping("admin/student/checkNameUnique")
    @ResponseBody
    public int checkNameUnique(Student student) {
        int b = studentService.checkNameUnique(student);
        if (b > 0) {
            return 1;
        } else {
            return 0;
        }
    }


    /**
     * 修改跳转
     *
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/admin/student/edit/{id}")
    public String studentEdit(@PathVariable("id") String id, ModelMap mmap) {

        mmap.put("Student", studentService.selectByPrimaryKey(id));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        mmap.addAttribute("collegeList", colleges);

        return student + "/edit";
    }


    /**
     * 修改保存
     */
    @PostMapping("admin/student/edit")
    @ResponseBody
    public AjaxResult editSave(Student record, String cid, String mid, String clid) {
        System.out.println("学生信息" + record);
        String c_name = null, m_name = null, cl_name = null;
        if (cid != null && mid != null && clid != null && isNum(cid) && isNum(mid) && isNum(clid)) {
            c_name = collegeMapper.selectByCollegeId(Integer.parseInt(cid)).getCollegeName();
            m_name = majorMapper.selectByMajorId(Integer.parseInt(mid)).getMajorName();
            cl_name = clazzMapper.selectByClazzId(Integer.parseInt(clid)).getClazzName();
            record.setCollege(c_name);
            record.setMajor(m_name);
            record.setClazz(cl_name);
            System.out.println("学生信息改之后："+record);

            return toAjax(studentService.updateByPrimaryKeySelective(record));
        }else
            return AjaxResult.error("请确认输入信息");

    }

    public boolean isNum(String ids) {
        return ids.matches("[0-9]+");
    }

    ;

    @PostMapping("admin/student/get/{id}")
    public Student studentEdit(@PathVariable("id") String id) {
        return studentService.selectByPrimaryKey(id);
    }


    /**
     * 删除学生
     *
     * @param ids
     * @return
     */
    @PostMapping("admin/student/get/remove")
    @ResponseBody
    public AjaxResult studentRemove(String ids) {
        int b = studentService.deleteByPrimaryKey(ids);
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }

    /*=============================================成绩管理模块===================================================================*/

    @GetMapping("/admin/mathScore/list")
    public String scoreList(ModelMap model, HttpServletRequest request) {
        String str = "成绩";
        setTitle(model, new TitleVo("列表", str + "管理", true, "欢迎进入" + str + "页面", true, false));
        //controller层
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);

        List<Course> courseList = courseService.selectByExample(new CourseExample());
        model.addAttribute("courseList", courseList);
        return score + "/list";
    }

    ;

    @PostMapping("admin/mathScore/list")
    @ResponseBody
    public Object scoreList(Tablepar tablepar, String searchText, ModelMap model, String cid, String mid, String clid, String grade, String courseName, String scoreOder) {
        PageInfo<MathScore> page = mathScoreService.list(tablepar, searchText, cid, mid, clid, grade, courseName, scoreOder);
        TableSplitResult<MathScore> result = new TableSplitResult<MathScore>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /**
     * 新增
     */

    @GetMapping("/admin/mathScore/add")
    public String mathScoreAdd(ModelMap modelMap) {
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        modelMap.addAttribute("collegeList", colleges);

        List<Course> courseList = courseService.selectByExample(new CourseExample());
        modelMap.addAttribute("courseList", courseList);
        return score + "/add";
    }

    @PostMapping("admin/mathScore/add")
    @ResponseBody
    public AjaxResult add(MathScore mathScore) {
        System.out.println("before:" + mathScore);
        String stuId = mathScore.getStuName();
        mathScore.setStuId(Long.parseLong(stuId));
        //完善学生信息
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStuIdEqualTo(Long.parseLong(stuId));
        List<Student> students = studentMapper.selectByExample(studentExample);
        String name = students.get(0).getName();
        mathScore.setStuName(name);
        String college = students.get(0).getCollege();
        mathScore.setCollege(college);
        String major = students.get(0).getMajor();
        mathScore.setMajor(major);
        String clazz = students.get(0).getClazz();
        mathScore.setClazz(clazz);
        //根据对应科目名获取课程信息(平时成绩占比和期末成绩占比)
        String courseName = mathScore.getCourseName();
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andCourseNameEqualTo(courseName);
        //从数据库中查找成绩评定标准
        List<Course> courses = courseMapper.selectByExample(courseExample);
        Double finalScorePer = courses.get(0).getFinalScorePer();
        Double regularScorePer = courses.get(0).getRegularScorePer();
        mathScore.setRegularScorePer(regularScorePer);
        mathScore.setFinalScorePer(finalScorePer);
        //根据根据成绩和占比算出总评和绩点
        Double total_score = 0.00;
        total_score = mathScore.getRegularScore() * (regularScorePer * 0.01) + mathScore.getFinalScore() * (finalScorePer * 0.01);
        mathScore.setTotalScore((double) Math.round(total_score));
        double tScore = Math.round(total_score);
        Double gpa = (tScore - 50) / 10;
        mathScore.setGpa(gpa);
        System.out.println("添加信息之后的：" + mathScore);
//        int b=mathScoreService.insertSelective(mathScore);
//        if(b>0){
//            return success();
//        }else{
//            return error();
//        }
        return null;
//
    }

    /**
     * 删除用户
     *
     * @param ids
     * @return
     */
    @PostMapping("admin/mathScore/remove")
    @ResponseBody
    public AjaxResult mathScoreRemove(String ids) {
        int b = mathScoreService.deleteByPrimaryKey(ids);
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }


    /**
     * 修改跳转
     *
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/admin/mathScore/edit/{id}")
    public String mathScoreEdit(@PathVariable("id") String id, ModelMap mmap) {
        mmap.put("MathScore", mathScoreService.selectByPrimaryKey(id));

        return score + "/edit";
    }

    /**
     * 修改保存
     */
    @PostMapping("admin/mathScore/edit")
    @ResponseBody
    public AjaxResult editSave(MathScore record) {
        Double finalScorePer = record.getFinalScorePer();
        Double regularScorePer = record.getRegularScorePer();
        Double total_score = 0.00;
        total_score = record.getRegularScore() * (regularScorePer * 0.01) + record.getFinalScore() * (finalScorePer * 0.01);
        record.setTotalScore((double) Math.round(total_score));
        double tScore = Math.round(total_score);
        Double gpa = (tScore - 50) / 10;
        record.setGpa(gpa);

        return toAjax(mathScoreService.updateByPrimaryKeySelective(record));
    }


    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    @PostMapping("admin/mathScore/get/{id}")
    public MathScore mathScoreEdit(@PathVariable("id") String id) {

        return mathScoreService.selectByPrimaryKey(id);
    }


    /**================================================成绩管理模块结束=======================================================================*/

}
