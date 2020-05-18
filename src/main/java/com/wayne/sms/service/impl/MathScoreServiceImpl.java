package com.wayne.sms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayne.sms.dao.*;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.*;
import com.wayne.sms.service.MathScoreService;
import com.wayne.sms.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-03-30 14:48
 * @Description: ${Description}
 */
@Service
public class MathScoreServiceImpl implements MathScoreService {

    @Autowired
    private MathScoreMapper mathScoreMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private TeacherClazzMapper teacherClazzMapper;


    @Override
    public PageInfo<MathScore> list(Tablepar tablepar, String name, String cid, String mid, String clid, String grade, String courseName, String scoreOder) {
        MathScoreExample testExample = new MathScoreExample();//根据Example对象来添加筛选条件
        if (scoreOder == null || "ID".equals(scoreOder)) {
            testExample.setOrderByClause("id ASC");//根据id默认升序排序
        } else if ("ASC".equals(scoreOder)) {
            testExample.setOrderByClause("total_score ASC");//根据总评成绩程序排序
        } else if ("DESC".equals(scoreOder)) {
            testExample.setOrderByClause("total_score DESC");//根据总评成绩降序排序
        }
        if (name != null && !"".equals(name)) {
            testExample.createCriteria().andStuNameLike("%" + name + "%");
        }
        if (grade != null && courseName != null && cid != null && mid != null && clid != null) {
            Clazz clazz = clazzMapper.selectByClazzId(Integer.parseInt(clid));
            testExample.createCriteria().andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade)).andClazzEqualTo(clazz.getClazzName());
        } else if (grade != null && courseName != null && cid != null && mid != null && clid == null) {
            Major major = majorMapper.selectByMajorId(Integer.parseInt(mid));
            testExample.createCriteria().andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade)).andMajorEqualTo(major.getMajorName());
        } else if (grade != null & courseName != null && cid != null && mid == null && clid == null) {
            College college = collegeMapper.selectByCollegeId(Integer.parseInt(cid));
            testExample.createCriteria().andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade)).andCollegeEqualTo(college.getCollegeName());
        } else if (grade != null & courseName != null) {
            testExample.createCriteria().andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade));
        } else
            //有课程名
            if (courseName != null) {
                testExample.createCriteria().andCourseNameEqualTo(courseName);
            } else
                //有年级
                if (grade != null) {
                    testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade));
                }
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<MathScore> list = mathScoreMapper.selectByExample(testExample);
        PageInfo<MathScore> pageInfo = new PageInfo<MathScore>(list);
        return pageInfo;
    }

    @Override
    public int insertSelective(MathScore record) {

        record.setId(null);


        return mathScoreMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String ids) {

        Integer[] integers = Convert.toIntArray(",", ids);
        List<Integer> stringB = Arrays.asList(integers);
        MathScoreExample example = new MathScoreExample();
        example.createCriteria().andIdIn(stringB);
        return mathScoreMapper.deleteByExample(example);

    }

    @Override
    public int checkNameUnique(MathScore mathScore) {
        MathScoreExample example = new MathScoreExample();
        example.createCriteria().andIdEqualTo(mathScore.getId());
        List<MathScore> list = mathScoreMapper.selectByExample(example);
        return list.size();
    }

    @Override
    public MathScore selectByPrimaryKey(String id) {
        Integer id1 = Integer.valueOf(id);
        return mathScoreMapper.selectByPrimaryKey(id1);
    }

    @Override
    public int updateByPrimaryKeySelective(MathScore record) {
        return mathScoreMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SaCollege> selectAsSaCollege() {
        return mathScoreMapper.selectAsSaCollege();
    }

    @Override
    public List<SaMajor> selectAsSaMajor() {
        return mathScoreMapper.selectAsSaMajor();
    }

    @Override
    public List<SaClazz> selectAsSaClazz() {
        return mathScoreMapper.selectAsSaClazz();
    }

    @Override
    public List<SaStudent> selectAsSaStudent() {
        return mathScoreMapper.selectAsSaStudent();
    }

    @Override
    public PageInfo<MathScore> listByTeacher(Tablepar tablepar, String teacherId, String searchText, String clid, String grade, String courseName, String scoreOder) {
        MathScoreExample testExample = new MathScoreExample();//根据Example对象来添加筛选条件
        TeacherClazzExample teacherClazzExample = new TeacherClazzExample();
        teacherClazzExample.createCriteria().andTeacherIdEqualTo(Long.parseLong(teacherId));

        List<TeacherClazz> teacherClazzes = teacherClazzMapper.selectByExample(teacherClazzExample);
        List<String> clazzList = new ArrayList<>();
        for (TeacherClazz teacherClazz : teacherClazzes) {
            clazzList.add(teacherClazz.getClazzName());
        }
        if (clid == null) {
            testExample.createCriteria().andClazzIn(clazzList);
        }
        if (scoreOder == null || "ID".equals(scoreOder)) {
            testExample.setOrderByClause("id ASC");//根据id默认升序排序
        } else if ("ASC".equals(scoreOder)) {
            testExample.setOrderByClause("total_score ASC");//根据总评成绩程序排序
        } else if ("DESC".equals(scoreOder)) {
            testExample.setOrderByClause("total_score DESC");//根据总评成绩降序排序
        }
        if (searchText != null && !"".equals(searchText)) {
            testExample.createCriteria().andStuNameLike("%" + searchText + "%");
        }

        if (grade != null && courseName != null && clid != null) {
            Clazz clazz = clazzMapper.selectByClazzId(Integer.parseInt(clid));
            System.out.println("这里是mapper的clid" + clazz);
            testExample.createCriteria().andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade)).andClazzEqualTo(clazz.getClazzName());
        } else if (grade != null & courseName != null) {
            testExample.createCriteria().andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade));
        } else if (courseName != null) {
            testExample.createCriteria().andCourseNameEqualTo(courseName);
        } else if (grade != null) {
            testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade));
        }
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<MathScore> list = mathScoreMapper.selectByExample(testExample);
        PageInfo<MathScore> pageInfo = new PageInfo<MathScore>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<MathScore> listByStudent(Tablepar tablepar, String studentId, String scoreOder, String courseName) {
        MathScoreExample testExample = new MathScoreExample();
        if (studentId != null && scoreOder == null && courseName == null) {
            testExample.createCriteria().andStuIdEqualTo(Long.parseLong(studentId));
        }
        if (scoreOder == null || "ID".equals(scoreOder)) {
            testExample.setOrderByClause("id ASC");//根据id默认升序排序
        } else if ("ASC".equals(scoreOder)) {
            testExample.setOrderByClause("total_score ASC");//根据总评成绩程序排序
        } else if ("DESC".equals(scoreOder)) {
            testExample.setOrderByClause("total_score DESC");//根据总评成绩降序排序
        }
        if (courseName != null) {
            testExample.createCriteria().andStuIdEqualTo(Long.parseLong(studentId)).andCourseNameEqualTo(courseName);
        }
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<MathScore> list = mathScoreMapper.selectByExample(testExample);
        PageInfo<MathScore> pageInfo = new PageInfo<MathScore>(list);
        return pageInfo;
    }
}
