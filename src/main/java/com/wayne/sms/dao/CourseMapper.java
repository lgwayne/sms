package com.wayne.sms.dao;

import com.wayne.sms.pojo.Course;
import com.wayne.sms.pojo.CourseExample;
import java.util.List;

public interface CourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    int deleteByPrimaryKey(Integer courseId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    int insert(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    int insertSelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    List<Course> selectByExample(CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    Course selectByPrimaryKey(Integer courseId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    int updateByPrimaryKeySelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    int updateByPrimaryKey(Course record);
}