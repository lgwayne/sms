package com.wayne.sms.dao;

import com.wayne.sms.pojo.Teacher;
import com.wayne.sms.pojo.TeacherExample;
import java.util.List;

public interface TeacherMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Apr 06 14:51:38 CST 2020
     */
    int deleteByPrimaryKey(Long teacherId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Apr 06 14:51:38 CST 2020
     */
    int insert(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Apr 06 14:51:38 CST 2020
     */
    int insertSelective(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Apr 06 14:51:38 CST 2020
     */
    List<Teacher> selectByExample(TeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Apr 06 14:51:38 CST 2020
     */
    Teacher selectByPrimaryKey(Long teacherId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Apr 06 14:51:38 CST 2020
     */
    int updateByPrimaryKeySelective(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Apr 06 14:51:38 CST 2020
     */
    int updateByPrimaryKey(Teacher record);

    int deleteByExample(TeacherExample example);
}