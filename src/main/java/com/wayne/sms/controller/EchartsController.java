package com.wayne.sms.controller;

import com.wayne.sms.dao.ClazzMapper;
import com.wayne.sms.dao.CollegeMapper;
import com.wayne.sms.dao.MajorMapper;
import com.wayne.sms.dao.TeacherMapper;
import com.wayne.sms.domain.AjaxResult;
import com.wayne.sms.model.TitleVo;
import com.wayne.sms.pojo.*;
import com.wayne.sms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.controller
 * @Author: lgwayne
 * @CreateTime: 2020-04-04 22:28
 * @Description: ${Description}
 */
@Controller
public class EchartsController extends BaseController {

    private String SaCollege = "admin/saCollege";

    private String SaMajor = "admin/saMajor";

    private String SaClazz = "admin/saClazz";

    private String SaStudent = "admin/saStudent";

    private String teacherSaClazz = "teacher/saClazz";

    private String teacherSaStudent = "teacher/saStudent";


    private String teacherId;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private  TeacherMapper teacherMapper;

    /*===================================管理员模块分析开始=============================================*/

    /*=====================学院成绩分析========================*/

    /**
     * 学院柱状图跳转
     *
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/admin/saCollege/bar.html")
    public String barView(ModelMap model, HttpServletRequest request) {
        String str = "学院成绩对比";
        setTitle(model, new TitleVo("视图分析", str + "分析", true, "欢迎进入" + str + "页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);
        List<Course> courseList = courseService.selectByExample(new CourseExample());
        model.addAttribute("courseList", courseList);

        return SaCollege + "/Bar";
    }

    @GetMapping("/admin/saCollege/bar")
    @ResponseBody
    public AjaxResult saCollegeBarView(String grade, String courseName) {
        List<String> xAxisData = new ArrayList<>();
        //先创建好集合对需要平时成绩，期末成绩，总评成绩的权值和总评标准差进行封装
        List<BigDecimal> avgRegularScoreList = new ArrayList<>();
        List<BigDecimal> avgFinalScoreList = new ArrayList<>();
        List<BigDecimal> avgTotalScoreList = new ArrayList<>();
        List<BigDecimal> stdTotalScoreList = new ArrayList<>();
        if (grade != null && courseName != null) {//根据年级和科目对数据进行查询
            List<SaCollege> saCollegeList = saCollegeService.selectSaCollegeByCourseAndGrade(courseName, grade);
            for (SaCollege saCollege : saCollegeList) {
                xAxisData.add(saCollege.getCollege());
                avgRegularScoreList.add(saCollege.getAvgRegularScore());
                avgFinalScoreList.add(saCollege.getAvgFinalScore());
                avgTotalScoreList.add(saCollege.getAvgTotalScore());
                stdTotalScoreList.add(saCollege.getStdTotalScore());
            }
        }
        List seriesData = new ArrayList();
        seriesData.add(avgRegularScoreList);
        seriesData.add(avgFinalScoreList);
        seriesData.add(avgTotalScoreList);
        seriesData.add(stdTotalScoreList);

        if (courseName == null) {
            return AjaxResult.error("请选择科目！");
        }
        if (grade == null) {
            return AjaxResult.error("请选择年级！");
        }
        //将查询的数据通过数据载体传输到页面的ajax请求。
        return AjaxResult.success().put("xAxisData", xAxisData).put("seriesData", seriesData);
    }


    /**
     * 学院饼图跳转
     *
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/admin/saCollege/pie.html")
    public String PieView(ModelMap model, HttpServletRequest request) {
        String str = "学院成绩汇总";
        setTitle(model, new TitleVo("视图分析", str + "分析", true, "欢迎进入" + str + "页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);
        List<Course> courseList = courseService.selectByExample(new CourseExample());
        model.addAttribute("courseList", courseList);

        return SaCollege + "/Pie";
    }

    /**
     * 学院饼图数据展示
     *
     * @param model
     * @param courseName
     * @param cid
     * @param grade
     * @return
     */
    @GetMapping("/admin/saCollege/pie")
    @ResponseBody
    public Object SaCollegePie(ModelMap model, String courseName, String cid, String grade) {
        //创建一个List<Map<String, Object>>对象封装数据
        List<Map<String, Object>> seriesData = new ArrayList<>();
        //当考试科目、学院名字和年级不为空是才能进行查询
        if (courseName != null && cid != null && grade != null) {
            List<SaCollege> saCollegeNum = saCollegeService.findByCollegeId(courseName, cid, grade);
            SaCollege saCollege = saCollegeNum.get(0);
            Map<String, Object> map = new HashMap<>();
            map.put("name", "成绩优秀人数");
            map.put("value", saCollege.getSumExcellent());
            Map<String, Object> map2 = new HashMap<>();
            map2.put("name", "成绩良好人数");
            map2.put("value", saCollege.getSumGood());
            Map<String, Object> map3 = new HashMap<>();
            map3.put("name", "成绩中等人数");
            map3.put("value", saCollege.getSumMedium());
            Map<String, Object> map4 = new HashMap<>();
            map4.put("name", "成绩及格人数");
            map4.put("value", saCollege.getSunPass());
            Map<String, Object> map5 = new HashMap<>();
            map5.put("name", "成绩不及格人数");
            map5.put("value", saCollege.getSumFail());
            seriesData.add(map);
            seriesData.add(map2);
            seriesData.add(map3);
            seriesData.add(map4);
            seriesData.add(map5);
        }
        //当部分信息为空则弹出相应提示框
        if (courseName == null) {
            return AjaxResult.error("请选择科目");
        }
        if (cid == null) {
            return AjaxResult.error("请选择学院");
        }
        if (grade == null) {
            return AjaxResult.error("请选择年级");
        }
        return AjaxResult.success().put("seriesData", seriesData);
    }


    /*=====================专业成绩分析========================*/

    @GetMapping("/admin/saMajor/pie.html")
    public String saMajorPieView(ModelMap model, HttpServletRequest request) {
        String str = "专业成绩占比";
        setTitle(model, new TitleVo("视图分析", str + "分析", true, "欢迎进入" + str + "页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);
        List<Course> courseList = courseService.selectByExample(new CourseExample());
        model.addAttribute("courseList", courseList);

        return SaMajor + "/Pie";
    }

    @GetMapping("/admin/saMajor/pie")
    @ResponseBody
    public Object SaMajorPie(ModelMap model, String courseName, String cid, String mid, String grade) {
        List<Map<String, Object>> seriesData = new ArrayList<>();
        if (courseName != null && mid != null && cid != null && grade != null) {
            List<SaMajor> saMajors = saMajorService.findByMajorId(courseName, cid, mid, grade);
            SaMajor saMajor = saMajors.get(0);

//            System.out.println("这是专业数据" + saMajor);
            Map<String, Object> map = new HashMap<>();
            map.put("name", "成绩优秀人数");
            map.put("value", saMajor.getSumExcellent());
            Map<String, Object> map2 = new HashMap<>();
            map2.put("name", "成绩良好人数");
            map2.put("value", saMajor.getSumGood());
            Map<String, Object> map3 = new HashMap<>();
            map3.put("name", "成绩中等人数");
            map3.put("value", saMajor.getSumMedium());
            Map<String, Object> map4 = new HashMap<>();
            map4.put("name", "成绩及格人数");
            map4.put("value", saMajor.getSumPass());
            Map<String, Object> map5 = new HashMap<>();
            map5.put("name", "成绩不及格人数");
            map5.put("value", saMajor.getSumFail());
            seriesData.add(map);
            seriesData.add(map2);
            seriesData.add(map3);
            seriesData.add(map4);
            seriesData.add(map5);
        }
        if (courseName == null) {
            return AjaxResult.error("请选择科目");
        }
        if (mid == null) {
            return AjaxResult.error("请选择专业");
        }
        if (grade == null) {
            return AjaxResult.error("请选择年级");
        }
        return AjaxResult.success().put("seriesData", seriesData);
    }

    @GetMapping("/admin/saMajor/bar.html")
    public String saMajorBarView(ModelMap model, HttpServletRequest request) {
        String str = "专业成绩对比";
        setTitle(model, new TitleVo("视图分析", str + "分析", true, "欢迎进入" + str + "页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);
        List<Course> courseList = courseService.selectByExample(new CourseExample());
        model.addAttribute("courseList", courseList);

        return SaMajor+ "/Bar";
    }

    @GetMapping("/admin/saMajor/bar")
    @ResponseBody
    public AjaxResult saMajorBarView(String grade, String courseName,String cid) {

        List<String> xAxisData = new ArrayList<>();

        List<BigDecimal> avgRegularScoreList = new ArrayList<>();
        List<BigDecimal> avgFinalScoreList = new ArrayList<>();
        List<BigDecimal> avgTotalScoreList = new ArrayList<>();
        List<BigDecimal> stdTotalScoreList = new ArrayList<>();
        if (grade!=null && courseName!=null && cid!=null){
            List<SaMajor> saMajors=saMajorService.selectByCourseAndGradeAndCid(grade,courseName,cid);
            for (SaMajor saMajor : saMajors) {
                xAxisData.add(saMajor.getMajor());
                avgRegularScoreList.add(saMajor.getAvgRegularScore());
                avgFinalScoreList.add(saMajor.getAvgFinalScore());
                avgTotalScoreList.add(saMajor.getAvgTotalScore());
                stdTotalScoreList.add(saMajor.getStdTotalScore());
            }
        }
        List seriesData = new ArrayList();
        seriesData.add(avgRegularScoreList);
        seriesData.add(avgFinalScoreList);
        seriesData.add(avgTotalScoreList);
        seriesData.add(stdTotalScoreList);

        if (courseName == null) {
            return AjaxResult.error("请选择科目！");
        }
        if (grade == null) {
            return AjaxResult.error("请选择年级！");
        }
        if(cid == null){
            return AjaxResult.error("请选择学院");
        }

        return AjaxResult.success().put("xAxisData", xAxisData).put("seriesData", seriesData);
    }


    /*=====================班级成绩分析========================*/
    @GetMapping("/admin/saClazz/pie.html")
    public String saClazzPieView(ModelMap model, HttpServletRequest request) {
        String str = "班级成绩占比";
        setTitle(model, new TitleVo("视图分析", str + "分析", true, "欢迎进入" + str + "页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);
        List<Course> courseList = courseService.selectByExample(new CourseExample());
        model.addAttribute("courseList", courseList);

        return SaClazz + "/Pie";
    }

    @GetMapping("/admin/saClazz/pie")
    @ResponseBody
    public Object SaClazzPie(ModelMap model, String courseName, String cid, String mid, String grade, String clid) {

        List<Map<String, Object>> seriesData = new ArrayList<>();
        if (courseName != null && clid != null && grade != null) {
            List<SaClazz> saClazzes = saClazzService.findByClazzId(courseName, grade, clid);
            SaClazz saClazz = saClazzes.get(0);

            Map<String, Object> map = new HashMap<>();
            map.put("name", "成绩优秀人数");
            map.put("value", saClazz.getSumExcellent());
            Map<String, Object> map2 = new HashMap<>();
            map2.put("name", "成绩良好人数");
            map2.put("value", saClazz.getSumGood());
            Map<String, Object> map3 = new HashMap<>();
            map3.put("name", "成绩中等人数");
            map3.put("value", saClazz.getSumMedium());
            Map<String, Object> map4 = new HashMap<>();
            map4.put("name", "成绩及格人数");
            map4.put("value", saClazz.getSumPass());
            Map<String, Object> map5 = new HashMap<>();
            map5.put("name", "成绩不及格人数");
            map5.put("value", saClazz.getSumFail());
            seriesData.add(map);
            seriesData.add(map2);
            seriesData.add(map3);
            seriesData.add(map4);
            seriesData.add(map5);
        }
        if (courseName == null) {
            return AjaxResult.error("请选择科目");
        }
//        if (clid == null || mid == null || cid == null) {
//            return AjaxResult.error("请选择班级");
//        }
        if (grade == null) {
            return AjaxResult.error("请选择年级");
        }
        return AjaxResult.success().put("seriesData", seriesData);
    }

    @GetMapping("/admin/saClazz/bar.html")
    public String saClazzBarView(ModelMap model, HttpServletRequest request) {
        String str = "班级成绩对比";
        setTitle(model, new TitleVo("视图分析", str + "分析", true, "欢迎进入" + str + "页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);
        List<Course> courseList = courseService.selectByExample(new CourseExample());
        model.addAttribute("courseList", courseList);

        return SaClazz + "/Bar";
    }

    @GetMapping("/admin/saClazz/bar")
    @ResponseBody
    public AjaxResult saClazzBarView(String grade, String courseName,String mid) {
        List<String> xAxisData = new ArrayList<>();

        List<BigDecimal> avgRegularScoreList = new ArrayList<>();
        List<BigDecimal> avgFinalScoreList = new ArrayList<>();
        List<BigDecimal> avgTotalScoreList = new ArrayList<>();
        List<BigDecimal> stdTotalScoreList = new ArrayList<>();
        if (grade!=null && courseName!=null && mid!=null){
            List<SaClazz> saClazzes = saClazzService.selectByCourseAndGradeAndMid(grade,courseName,mid);
            for (SaClazz saClazz : saClazzes) {
                xAxisData.add(saClazz.getClazz());
                avgRegularScoreList.add(saClazz.getAvgRegularScore());
                avgFinalScoreList.add(saClazz.getAvgFinalScore());
                avgTotalScoreList.add(saClazz.getAvgTotalScore());
                stdTotalScoreList.add(saClazz.getStdTotalScore());
            }
        }
        List seriesData = new ArrayList();
        seriesData.add(avgRegularScoreList);
        seriesData.add(avgFinalScoreList);
        seriesData.add(avgTotalScoreList);
        seriesData.add(stdTotalScoreList);

        if (courseName == null) {
            return AjaxResult.error("请选择科目！");
        }
        if (grade == null) {
            return AjaxResult.error("请选择年级！");
        }
        if(mid == null){
            return AjaxResult.error("请选择专业！");
        }

        return AjaxResult.success().put("xAxisData", xAxisData).put("seriesData", seriesData);

    }

    /*========================================学生个人成绩分析=================================================*/
    @GetMapping("/admin/saStudent/bar.html")
    public String getSaStudentBarView(ModelMap model, HttpServletRequest request) {
        String str = "学生成绩对比";
        setTitle(model, new TitleVo("视图分析", str + "分析", true, "欢迎进入" + str + "页面", true, false));
        List<College> colleges = collegeService.selectByExample(new CollegeExample());
        model.addAttribute("collegeList", colleges);
        List<Course> courseList = courseService.selectByExample(new CourseExample());
        model.addAttribute("courseList", courseList);

        return SaStudent+ "/Bar";
    }

    @GetMapping("/admin/saStudent/bar")
    @ResponseBody
    public AjaxResult getSaStudentBar(String grade,String courseName,String cid,String mid,String clid,String sid){
        //检验输入信息
        if (mid==null || clid==null|| sid==null ||grade==null ||courseName==null){
            return AjaxResult.error("请填好下拉框信息，并选定一位学生");
        }
        //创建集合对象传输数据
        List seriesData = new ArrayList();
        List clazzScore = new ArrayList<>();
        List majorScore = new ArrayList<>();
        List collegeScore = new ArrayList<>();
        List studentScore = new ArrayList<>();
        //学生所在班级
        Clazz clazz = clazzMapper.selectByClazzId(Integer.parseInt(clid));
        SaClazz saClazz =saClazzService.selectByCourseAndGradeAndClazzName(grade,courseName,clazz.getClazzName());
        clazzScore.add(saClazz.getAvgRegularScore());
        clazzScore.add(saClazz.getAvgFinalScore());
        clazzScore.add(saClazz.getAvgTotalScore());

        //学生所在专业
        Major major = majorMapper.selectByMajorId(Integer.parseInt(mid));
        SaMajor saMajor=saMajorService.selectByCourseAndGradeAndMajorName(grade,courseName,major.getMajorName());
        majorScore.add(saMajor.getAvgRegularScore());
        majorScore.add(saMajor.getAvgFinalScore());
        majorScore.add(saMajor.getAvgTotalScore());

        //学生所在学院
        College college = collegeMapper.selectByCollegeId(Integer.parseInt(cid));
        SaCollege saCollege = saCollegeService.selectByCourseAndGradeAndCollegeName(grade,courseName,college.getCollegeName());
        collegeScore.add(saCollege.getAvgRegularScore());
        collegeScore.add(saCollege.getAvgFinalScore());
        collegeScore.add(saCollege.getAvgTotalScore());


        SaStudent saStudent=saStudentService.selectByStuId(Long.parseLong(sid));
        studentScore.add(saStudent.getRegularScore());
        studentScore.add(saStudent.getFinalScore());
        studentScore.add(saStudent.getTotalScore());

        seriesData.add(clazzScore);
        seriesData.add(majorScore);
        seriesData.add(collegeScore);
        seriesData.add(studentScore);
        return AjaxResult.success().put("seriesData",seriesData);
    }



/*=======================================教师部分=======================================================================*/

    /*=====================教师班级成绩分析========================*/
    @GetMapping("/teacher/saClazz/pie.html")
    public String teacherSaClazzPieView(ModelMap model, HttpServletRequest request,String tid) {
        String str = "班级成绩占比";
        setTitle(model, new TitleVo("视图分析", str + "分析", true, "欢迎进入" + str + "页面", true, false));
            teacherId = tid;
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

        return teacherSaClazz + "/Pie";
    }



    @GetMapping("/teacher/saClazz/bar.html")
    public String teacherSaClazzBarView(ModelMap model, HttpServletRequest request,String tid) {
        String str = "班级成绩对比";
        setTitle(model, new TitleVo("视图分析", str + "分析", true, "欢迎进入" + str + "页面", true, false));
        //增加教师任教科目
        TeacherCourseExample example = new TeacherCourseExample();
        example.createCriteria().andTeacherIdEqualTo(Long.parseLong(tid));
        List<TeacherCourse> teacherCourseList = teacherCourseMapper.selectByExample(example);
        model.addAttribute("teacherCourseList", teacherCourseList);
        //增加教师所在学院
        Teacher teacher = teacherMapper.selectByPrimaryKey(Long.parseLong(tid));
        String collegeName = teacher.getCollegeName();
        CollegeExample collegeExample = new CollegeExample();
        collegeExample.createCriteria().andCollegeNameEqualTo(collegeName);
        List<College> collegeList = collegeMapper.selectByExample(collegeExample);
        model.addAttribute("collegeList", collegeList);

        return teacherSaClazz + "/Bar";
    }


    /*========================================学生个人成绩分析=============================================================*/
    @GetMapping("/teacher/saStudent/bar.html")
    public String teacherGetSaStudentBarView(ModelMap model, HttpServletRequest request,String tid) {
        String str = "学生成绩对比";
        setTitle(model, new TitleVo("视图分析", str + "分析", true, "欢迎进入" + str + "页面", true, false));

        //增加教师任教科目
        TeacherCourseExample example = new TeacherCourseExample();
        example.createCriteria().andTeacherIdEqualTo(Long.parseLong(tid));
        List<TeacherCourse> teacherCourseList = teacherCourseMapper.selectByExample(example);
        model.addAttribute("teacherCourseList", teacherCourseList);

        //增加教师所在学院
        Teacher teacher = teacherMapper.selectByPrimaryKey(Long.parseLong(tid));
        String collegeName = teacher.getCollegeName();
        CollegeExample collegeExample = new CollegeExample();
        collegeExample.createCriteria().andCollegeNameEqualTo(collegeName);
        List<College> collegeList = collegeMapper.selectByExample(collegeExample);
        model.addAttribute("collegeList", collegeList);

        return teacherSaStudent+ "/Bar";
    }


}
