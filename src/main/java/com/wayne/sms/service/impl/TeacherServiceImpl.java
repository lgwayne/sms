package com.wayne.sms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayne.sms.dao.TeacherMapper;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.Teacher;
import com.wayne.sms.pojo.TeacherExample;
import com.wayne.sms.service.TeacherService;
import com.wayne.sms.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-03-28 23:51
 * @Description: ${Description}
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public Teacher findByTeacherId(Long user_id) {
        return null;
    }

    @Override
    public PageInfo<Teacher> list(Tablepar tablepar, String name) {
        TeacherExample testExample=new TeacherExample();
        testExample.setOrderByClause("teacher_id ASC");
        if(name!=null&&!"".equals(name)){
            testExample.createCriteria().andNameLike("%"+name+"%");
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<Teacher> list= teacherMapper.selectByExample(testExample);
        PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(list);
        return  pageInfo;
    }

    @Override
    public int insertSelective(Teacher teacher) {

        teacher.setTeacherId(null);

        return teacherMapper.insertSelective(teacher);
    }

    @Override
    public int checkNameUnique(Teacher teacher) {
        TeacherExample example=new TeacherExample();
        example.createCriteria().andNameEqualTo(teacher.getName());
        List<Teacher> list=teacherMapper.selectByExample(example);
        return list.size();
    }

    @Override
    public Teacher selectByPrimaryKey(String id) {
        Long id1 = Long.valueOf(id);
        return teacherMapper.selectByPrimaryKey(id1);
    }

    @Override
    public int updateByPrimaryKeySelective(Teacher record) {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String ids) {
        Long[] integers = Convert.toLongArray(",", ids);
        List<Long> stringB = Arrays.asList(integers);
        TeacherExample example=new TeacherExample();
        example.createCriteria().andTeacherIdIn(stringB);
        return teacherMapper.deleteByExample(example);
    }
}
