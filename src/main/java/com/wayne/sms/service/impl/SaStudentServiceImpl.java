package com.wayne.sms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayne.sms.dao.*;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.*;
import com.wayne.sms.service.SaStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-04-02 00:25
 * @Description: ${Description}
 */
@Service
public class SaStudentServiceImpl implements SaStudentService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private SaStudentMapper saStudentMapper;

    @Autowired
    private StdStudentMapper stdStudentMapper;

    @Autowired
    private TeacherClazzMapper teacherClazzMapper;

    @Override
    public PageInfo<SaStudent> list(Tablepar tablepar, String name, String grade, String courseName, String mid, String clid, String order) {
        SaStudentExample testExample=new SaStudentExample();
        if (order==null||"ID".equals(order)){
            testExample.setOrderByClause("id ASC");
        }else if ("total ASC".equals(order)){
            testExample.setOrderByClause("total_score ASC");
        }else if("total DESC".equals(order)){
            testExample.setOrderByClause("total_score DESC");
        }else if ("std ASC".equals(order)){
            testExample.setOrderByClause("std_score ASC");
        }else if ("std DESC".equals(order)){
            testExample.setOrderByClause("std_score DESC");
        }
        if(name!=null&&!"".equals(name)){
            testExample.createCriteria().andStuNameLike("%"+name+"%");
        }

        if (grade != null && courseName != null  && mid != null && clid != null){
            Clazz clazz = clazzMapper.selectByClazzId(Integer.parseInt(clid));
            testExample.createCriteria().andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade)).andClazzEqualTo(clazz.getClazzName());
        }else if (grade != null && courseName != null && mid != null) {
            Major major = majorMapper.selectByMajorId(Integer.parseInt(mid));
            testExample.createCriteria().andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade)).andMajorEqualTo(major.getMajorName());
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<SaStudent> list= saStudentMapper.selectByExample(testExample);
        PageInfo<SaStudent> pageInfo = new PageInfo<SaStudent>(list);
        return  pageInfo;
    }

    @Override
    public SaStudent selectByPrimaryKey(String id) {
        Integer id1 = Integer.valueOf(id);
        return saStudentMapper.selectByPrimaryKey(id1);
    }

    @Override
    public void clearTable() {
        saStudentMapper.truncateTable();
    }

    @Override
    public int updateSaStudent(List<SaStudent> saStudents) {
        return saStudentMapper.insertIntoSaStudents(saStudents);
    }

    @Override
    public int updateStdStudent() {
        stdStudentMapper.clearTable();
        List<StdStudent> stdStudents=saStudentMapper.selectAsStdStudents();
        int i = stdStudentMapper.insertIntoStdStudent(stdStudents);
        int i1 = saStudentMapper.updateStdScore();
        return i1;
    }

    @Override
    public SaStudent selectByStuId(long i) {
        SaStudentExample saStudentExample = new SaStudentExample();
        saStudentExample.createCriteria().andStuIdEqualTo(i);
        List<SaStudent> saStudents = saStudentMapper.selectByExample(saStudentExample);
        return saStudents.get(0);
    }

    @Override
    public PageInfo<SaStudent> listByTeacher(Tablepar tablepar, String searchText, String tid, String grade, String courseName, String clid, String order) {
        SaStudentExample testExample = new SaStudentExample();
        TeacherClazzExample teacherClazzExample = new TeacherClazzExample();
        System.out.println("order="+order);
        teacherClazzExample.createCriteria().andTeacherIdEqualTo(Long.parseLong(tid));

        List<TeacherClazz> teacherClazzes = teacherClazzMapper.selectByExample(teacherClazzExample);
        List<String> clazzList = new ArrayList<>();
        for (TeacherClazz teacherClazz : teacherClazzes) {
            clazzList.add(teacherClazz.getClazzName() );
        }
        if(clid==null) {
            testExample.createCriteria().andClazzIn(clazzList);
        }
        if (order == null || "ID".equals(order)) {
            testExample.setOrderByClause("id ASC");//根据id默认升序排序
        } else if ("ASC".equals(order)) {
            testExample.setOrderByClause("total_score ASC");//根据总评成绩程序排序
        } else if ("DESC".equals(order)) {
            testExample.setOrderByClause("total_score DESC");//根据总评成绩降序排序
        }else if ("std ASC".equals(order)) {
            testExample.setOrderByClause("std_score ASC");//根据总评成绩标准分程序排序
        } else if ("std DESC".equals(order)) {
            testExample.setOrderByClause("std_score DESC");//根据总评成绩标准分降序排序
        }


        if (searchText != null && !"".equals(searchText)) {
            testExample.createCriteria().andStuNameLike("%" + searchText + "%");
        }

        if (grade != null && courseName != null && clid != null) {
            Clazz clazz = clazzMapper.selectByClazzId(Integer.parseInt(clid));
            System.out.println("这里是mapper的clid"+clazz);
            testExample.createCriteria().andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade)).andClazzEqualTo(clazz.getClazzName());
        } else if (grade != null & courseName != null) {
            testExample.createCriteria().andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade));
        } else if (courseName != null) {
            testExample.createCriteria().andCourseNameEqualTo(courseName);
        } else if (grade != null) {
            testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade));
        }
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<SaStudent> saStudents = saStudentMapper.selectByExample(testExample);
        PageInfo<SaStudent> pageInfo = new PageInfo<SaStudent>(saStudents);
        return pageInfo;
    }
}
