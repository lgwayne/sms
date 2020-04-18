package com.wayne.sms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayne.sms.dao.ClazzMapper;
import com.wayne.sms.dao.CollegeMapper;
import com.wayne.sms.dao.MajorMapper;
import com.wayne.sms.dao.StudentMapper;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.*;
import com.wayne.sms.service.ClazzService;
import com.wayne.sms.service.CollegeService;
import com.wayne.sms.service.MajorService;
import com.wayne.sms.service.StudentService;
import com.wayne.sms.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-03-26 15:06
 * @Description: ${Description}
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private ClazzMapper clazzMapper;


    @Override
    public PageInfo<Student> list(Tablepar tablepar,String name){
        StudentExample testExample=new StudentExample();
        testExample.setOrderByClause("stu_id ASC");
        if(name!=null&&!"".equals(name)){
            testExample.createCriteria().andNameLike("%"+name+"%");
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<Student> list= studentMapper.selectByExample(testExample);
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        return  pageInfo;
    }

    @Override
    public PageInfo<Student> search(Tablepar tablepar,String cid,String mid,String clid,String grade){
        StudentExample testExample=new StudentExample();
        testExample.setOrderByClause("stu_id ASC");
        List<Student> list=null;    //先创建集合装学生信息
        if (cid!=null && mid!=null && clid!=null&& grade!=null){    //有clid，根据班级查学生信息
            Clazz clazz = clazzMapper.selectByClazzId(Integer.parseInt(clid));
            testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andClazzEqualTo(clazz.getClazzName());
        }else if (cid!=null && mid!=null && clid==null&& grade!=null){    //有mid根据专业查学生信息
            Major major = majorMapper.selectByMajorId(Integer.parseInt(mid));
            testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andMajorEqualTo(major.getMajorName());
        }else if (cid!=null && mid==null && clid==null && grade!=null){    //有cid根据学院查学生信息
            College college = collegeMapper.selectByCollegeId(Integer.parseInt(cid));
            testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andCollegeEqualTo(college.getCollegeName());
        }else {
            testExample.setOrderByClause("stu_id ASC");  //默认对学生进行学号的升序排序。
            PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
            list= studentMapper.selectByExample(testExample);
            PageInfo<Student> pageInfo = new PageInfo<Student>(list);
            return  pageInfo;
        }
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        list= studentMapper.selectByExample(testExample);
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        return  pageInfo;

    }

    @Override
    public int insertSelective(Student record) {

        record.setStuId(null);

        return studentMapper.insertSelective(record);
    }

    @Override
    public int checkNameUnique(Student student) {
        StudentExample example=new StudentExample();
        example.createCriteria().andNameEqualTo(student.getName());
        List<Student> list=studentMapper.selectByExample(example);
        return list.size();
    }

    @Override
    public Student selectByPrimaryKey(String id) {
        Long id1 = Long.valueOf(id);
        return studentMapper.selectByPrimaryKey(id1);

    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String ids) {
        Long[] integers = Convert.toLongArray(",", ids);
        List<Long> stringB = Arrays.asList(integers);
        StudentExample example=new StudentExample();
        example.createCriteria().andStuIdIn(stringB);
        return studentMapper.deleteByExample(example);
    }
}
