package com.wayne.sms.service;

import com.wayne.sms.pojo.Course;
import com.wayne.sms.pojo.CourseExample;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service
 * @Author: lgwayne
 * @CreateTime: 2020-03-30 22:38
 * @Description: ${Description}
 */
public interface CourseService {
    public List<Course> selectByExample(CourseExample example);

}
