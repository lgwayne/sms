package com.wayne.sms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayne.sms.dao.*;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.*;
import com.wayne.sms.service.SaClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-04-01 23:13
 * @Description: ${Description}
 */

@Service
public class SaClazzServiceImpl implements SaClazzService {

    @Autowired
    private  SaClazzMapper saClazzMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private StdClazzMapper stdClazzMapper;

    @Autowired
    private TeacherClazzMapper teacherClazzMapper;

    @Autowired
    private TeacherCourseMapper teacherCourseMapper;

    @Override
    public PageInfo<SaClazz> list(Tablepar tablepar, String name, String grade, String courseName,String mid,String clid, String order) {
        SaClazzExample testExample = new SaClazzExample();
        if (order==null||"ID".equals(order)){
            testExample.setOrderByClause("id ASC");
        }else if ("total ASC".equals(order)){
            testExample.setOrderByClause("avg_total_score ASC");
        }else if("total DESC".equals(order)){
            testExample.setOrderByClause("avg_total_score DESC");
        }else if ("std ASC".equals(order)){
            testExample.setOrderByClause("std_score ASC");
        }else if ("std DESC".equals(order)){
            testExample.setOrderByClause("std_score DESC");
        }

        if(name!=null&&!"".equals(name)){
            testExample.createCriteria().andClazzLike("%"+name+"%");
        }

        if (grade!=null && courseName!=null && clid!=null && mid!=null){
            if (!"0".equals(clid)){
                Clazz clazz = clazzMapper.selectByClazzId(Integer.parseInt(clid));
                testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andCourseNameEqualTo(courseName).andClazzEqualTo(clazz.getClazzName());
            }else {
                Major major = majorMapper.selectByMajorId(Integer.parseInt(mid));
                testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andCourseNameEqualTo(courseName).andMajorEqualTo(major.getMajorName());
            }
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<SaClazz> list= saClazzMapper.selectByExample(testExample);
        PageInfo<SaClazz> pageInfo = new PageInfo<SaClazz>(list);
        return  pageInfo;
    }

    @Override
    public SaClazz selectByPrimaryKey(String id) {
        Integer id1 = Integer.valueOf(id);
        return saClazzMapper.selectByPrimaryKey(id1);
    }

    @Override
    public void clearTable() {
        saClazzMapper.truncateTable();
    }

    @Override
    public int updateSaClazz(List<SaClazz> saClazzes) {
        return saClazzMapper.insertIntoSaClazz(saClazzes);
    }

    @Override
    public int refreshStdClazz() {
        stdClazzMapper.clearTable();
        List<StdClazz> stdClazzes=saClazzMapper.selectAsSTDClazzes();
        int i = stdClazzMapper.insertIntoStdClazz(stdClazzes);
        int i1 = saClazzMapper.updateStdScore();
        return i1;
    }

    @Override
    public List<SaClazz> findByClazzId(String courseName, String grade, String clid) {
        SaClazzExample testExample = new SaClazzExample();
//        SaClazz saClazz = saClazzMapper.selectByPrimaryKey(Integer.parseInt(clid));
        Clazz clazz = clazzMapper.selectByClazzId(Integer.parseInt(clid));
        testExample.createCriteria().andClazzEqualTo(clazz.getClazzName()).andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade));
        return saClazzMapper.selectByExample(testExample);
    }

    @Override
    public List<SaClazz> selectByCourseAndGradeAndMid(String grade, String courseName, String mid) {
        SaClazzExample saClazzExample = new SaClazzExample();
        Major major = majorMapper.selectByMajorId(Integer.parseInt(mid));
        saClazzExample.createCriteria().andMajorEqualTo(major.getMajorName()).andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade));
        return saClazzMapper.selectByExample(saClazzExample);
    }

    @Override
    public SaClazz selectByCourseAndGradeAndClazzName(String grade, String courseName, String clazzName) {
        SaClazzExample saClazzExample = new SaClazzExample();
        saClazzExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andCourseNameEqualTo(courseName).andClazzEqualTo(clazzName);
        List<SaClazz> saClazzes = saClazzMapper.selectByExample(saClazzExample);
        return saClazzes.get(0);
    }

    @Override
    public PageInfo<SaClazz> listByTeacher(Tablepar tablepar, String searchText, String grade, String courseName, String order, String teacherId,String clid) {
        SaClazzExample testExample = new SaClazzExample();

        if (order==null||"ID".equals(order)){
            testExample.setOrderByClause("id ASC");
        }else if ("total ASC".equals(order)){
            testExample.setOrderByClause("avg_total_score ASC");
        }else if("total DESC".equals(order)){
            testExample.setOrderByClause("avg_total_score DESC");
        }else if ("std ASC".equals(order)){
            testExample.setOrderByClause("std_score ASC");
        }else if ("std DESC".equals(order)){
            testExample.setOrderByClause("std_score DESC");
        }

        //搜索教师所教班级
        TeacherClazzExample teacherClazzExample = new TeacherClazzExample();
        teacherClazzExample.createCriteria().andTeacherIdEqualTo(Long.parseLong(teacherId));
        List<TeacherClazz> teacherClazzes = teacherClazzMapper.selectByExample(teacherClazzExample);
        List<String> clazzList = new ArrayList<>();
        for (TeacherClazz teacherClazz : teacherClazzes) {
            clazzList.add(teacherClazz.getClazzName() );
        }
        //查找教师任教科目
        TeacherCourseExample example = new TeacherCourseExample();
        example.createCriteria().andTeacherIdEqualTo(Long.parseLong(teacherId));
        List<String> courses = new ArrayList<>();
        List<TeacherCourse> teacherCourseList = teacherCourseMapper.selectByExample(example);
        for (TeacherCourse course : teacherCourseList) {
            courses.add(course.getCourseName());
        }
        if(courseName==null || clid==null) {
            testExample.createCriteria().andCourseNameIn(courses).andClazzIn(clazzList);
        }

        if(searchText!=null&&!"".equals(searchText)){
            testExample.createCriteria().andClazzLike("%"+searchText+"%");
        }
        if (grade!=null && courseName!=null && clid!=null){
            if (!"0".equals(clid)){
                Clazz clazz = clazzMapper.selectByClazzId(Integer.parseInt(clid));
                testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andCourseNameEqualTo(courseName).andClazzEqualTo(clazz.getClazzName());
            }else {
                testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andCourseNameIn(courses).andClazzIn(clazzList);
            }
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<SaClazz> list= saClazzMapper.selectByExample(testExample);
        PageInfo<SaClazz> pageInfo = new PageInfo<SaClazz>(list);
        return  pageInfo;



    }

}
