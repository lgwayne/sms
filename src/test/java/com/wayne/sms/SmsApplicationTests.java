package com.wayne.sms;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayne.sms.dao.*;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.*;
import com.wayne.sms.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;

@SpringBootTest
class SmsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void text() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
////            if (删除元素的条件) {
//                iterator.remove();
//            }
//        }
        CollegeService collegeService = null;
        List<College> colleges = collegeService.selectByExample(new CollegeExample());

        System.out.println(colleges.get(1));
    }


    @Autowired
    private MathScoreMapper mathScoreMapper;

    @Autowired
    private MathScoreService mathScoreService;

    @Autowired
    private SaMajorService saMajorService;
 /*
 这是测试生成学院成绩分析表的方法能否成功
  */

    @Test
    public void kanxia() {

        //更新专业成绩分析数据
        List<SaMajor> saMajors = mathScoreService.selectAsSaMajor();
        for (int i = 0; i < 3; i++) {
            System.out.println(saMajors.get(i));
        }
        saMajorService.clearTable();
        int updateSaMajor = saMajorService.updateSaMajor(saMajors);


    }


    @Autowired
    private SaMajorMapper saMajorMapper;

    @Autowired
    private StdMajorMapper stdMajorMapper;

    @Test
    public void testSTDMajor() {
        stdMajorMapper.clearTable();
        List<StdMajor> stdMajors = saMajorMapper.selectAsStdMajor();
        for (int i = 0; i < 3; i++) {
            System.out.println(stdMajors.get(i));
        }
        int i = stdMajorMapper.insertIntoStdMajor(stdMajors);
        System.out.println("看看插入了几条数据" + i);
        int i1 = saMajorMapper.updateStdScore();
        System.out.println("看看更新了几行" + i1);
    }


    @Autowired
    private SaClazzMapper saClazzMapper;

    @Autowired
    private StdClazzMapper stdClazzMapper;

    @Test
    public void testStdClazz() {
        stdClazzMapper.clearTable();
        List<StdClazz> stdClazzes = saClazzMapper.selectAsSTDClazzes();
//        for (int i = 0; i <3; i++) {
//            System.out.println(stdClazzes.get(i));
//        }
        int i = stdClazzMapper.insertIntoStdClazz(stdClazzes);
//        System.out.println("看看i是什么"+i);
        int i1 = saClazzMapper.updateStdScore();


    }


    @Autowired
    private SaStudentMapper saStudentMapper;

    @Test
    public void testSaStudent() {
        saStudentMapper.truncateTable();

        List<SaStudent> saStudents = mathScoreMapper.selectAsSaStudent();

        saStudentMapper.insertIntoSaStudents(saStudents);
    }


    @Autowired
    private StdStudentMapper stdStudentMapper;

    @Test
    public void updateStdStudent() {
        stdStudentMapper.clearTable();
        List<StdStudent> stdStudents = saStudentMapper.selectAsStdStudents();
//        for (int i = 0; i < 3; i++) {
//            System.out.println(stdStudents.get(i));
//        }
        int i = stdStudentMapper.insertIntoStdStudent(stdStudents);
        int i1 = saStudentMapper.updateStdScore();

        System.out.println("看看更新了多少数据" + i1);
    }


    @Autowired
    private SaCollegeService saCollegeService;

    @Test
    public void TestEcharts() {
//     String courseName="高等数学(2)";
//     String cid="1";
//     List<SaCollege> saCollege = saCollegeService.findByCollegeId(courseName,cid);
//     System.out.println(saCollege.get(0));

        HashMap<Object, Object> Map = new HashMap<>();

        Map.put("这是key", "这是value");
        Map.put("这是key2", "这是value2");

        System.out.println("map的key:" + Map.keySet());
        System.out.println("map的value:" + Map.values());
    }


    @Test
    public void testSaCollege() {
        String courseName = "高等数学(1)";
        String grade = "2017";
        ArrayList<String> legendData = new ArrayList<>();
        legendData.add("平时成绩");
        legendData.add("期末成绩");
        legendData.add("总评成绩");
        legendData.add("成绩标准差");
//        假设courseName为高等数学1
        List<String> xAxisData = new ArrayList<>();

        List<BigDecimal> avgRegularScoreList = new ArrayList<>();
        List<BigDecimal> avgFinalScoreList = new ArrayList<>();
        List<BigDecimal> avgTotalScoreList = new ArrayList<>();
        List<BigDecimal> stdTotalScoreList = new ArrayList<>();
        courseName = "高等数学(1)";
        grade = "2017";
        List<SaCollege> saCollegeList = saCollegeService.selectSaCollegeByCourseAndGrade(courseName, grade);
        for (SaCollege saCollege : saCollegeList) {
            xAxisData.add(saCollege.getCollege());
            avgRegularScoreList.add(saCollege.getAvgRegularScore());
            avgFinalScoreList.add(saCollege.getAvgFinalScore());
            avgTotalScoreList.add(saCollege.getAvgTotalScore());
            stdTotalScoreList.add(saCollege.getStdTotalScore());
        }
        List seriesData = new ArrayList();
        seriesData.add(avgRegularScoreList);
        seriesData.add(avgFinalScoreList);
        seriesData.add(avgTotalScoreList);
        seriesData.add(stdTotalScoreList);

        System.out.println("legendData:" + legendData);
        System.out.println("xAxisData:" + xAxisData);
        System.out.println("seriesData:" + seriesData);
    }


    @Test
    public void testSaMajor() {
        String grade = "2017";
        String courseName = "高等数学(1)";
        String cid = "1";
        List<String> xAxisData = new ArrayList<>();

        List<BigDecimal> avgRegularScoreList = new ArrayList<>();
        List<BigDecimal> avgFinalScoreList = new ArrayList<>();
        List<BigDecimal> avgTotalScoreList = new ArrayList<>();
        List<BigDecimal> stdTotalScoreList = new ArrayList<>();
        if (grade != null && courseName != null && cid != null) {
            List<SaMajor> saMajors = saMajorService.selectByCourseAndGradeAndCid(grade, courseName, cid);
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

        System.out.println("xAxisData:" + xAxisData);
        System.out.println("seriesData:" + seriesData);
    }


    @Autowired
    private SaClazzService saClazzService;

    @Test
    public void testSaclazz() {
        String grade = "2017";
        String courseName = "高等数学(1)";
        String mid = "1";
        List<SaClazz> saClazzes = saClazzService.selectByCourseAndGradeAndMid(grade, courseName, mid);
        for (SaClazz saClazz : saClazzes) {
            System.out.println(saClazz);
        }
    }

    @Autowired
    ClazzMapper clazzMapper;
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testStudent() {
        String clid = "12";
        StudentExample studentExample = new StudentExample();
        Clazz clazz = clazzMapper.selectByClazzId(Integer.parseInt(clid));
        studentExample.createCriteria().andClazzEqualTo(clazz.getClazzName());
        List<Student> students = studentMapper.selectByExample(studentExample);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testCLA() {

        Clazz clazz = clazzMapper.selectByClazzId(Integer.parseInt("2"));
        SaClazz saClazz = saClazzService.selectByCourseAndGradeAndClazzName("2017", "高等数学(1)", clazz.getClazzName());
        System.out.println(saClazz);

    }


    @Autowired
    private TeacherCourseMapper teacherCourseMapper;

    @Autowired
    private TeacherClazzMapper teacherClazzMapper;

    @Test
    public void testcourse() {
        MathScoreExample testExample = new MathScoreExample();//根据Example对象来添加筛选条件

        //获取2001教师的班级
        TeacherClazzExample teacherClazzExample = new TeacherClazzExample();
        teacherClazzExample.createCriteria().andTeacherIdEqualTo(2001L);
        List<TeacherClazz> teacherClazzes = teacherClazzMapper.selectByExample(teacherClazzExample);
        List<String> courseName = new ArrayList<>();
        for (TeacherClazz teacherClazz : teacherClazzes) {
         courseName.add(teacherClazz.getClazzName() );
        }

        for (String s : courseName) {
            System.out.println("这是班级名"+s);
        }
        testExample.createCriteria().andClazzIn(courseName);

        List<MathScore> list = mathScoreMapper.selectByExample(testExample);

    }

}
