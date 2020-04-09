package com.wayne.sms.service.impl;

import com.wayne.sms.dao.CourseMapper;
import com.wayne.sms.pojo.Course;
import com.wayne.sms.pojo.CourseExample;
import com.wayne.sms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-03-30 22:39
 * @Description: ${Description}
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> selectByExample(CourseExample example) {
        return courseMapper.selectByExample(example);
    }
}
