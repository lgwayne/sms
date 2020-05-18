package com.wayne.sms.dao;

import com.wayne.sms.pojo.Major;
import com.wayne.sms.pojo.MajorExample;
import com.wayne.sms.pojo.MajorKey;
import com.wayne.sms.pojo.SaMajor;

import java.util.List;

public interface MajorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int deleteByPrimaryKey(MajorKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int insert(Major record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int insertSelective(Major record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    List<Major> selectByExample(MajorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    Major selectByPrimaryKey(MajorKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int updateByPrimaryKeySelective(Major record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_major
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int updateByPrimaryKey(Major record);

    Major selectByMajorId(Integer majorId);

    int insertIntoSaMajor(List<SaMajor> saMajors);
}