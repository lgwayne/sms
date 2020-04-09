package com.wayne.sms.dao;

import com.wayne.sms.pojo.StdMajor;
import com.wayne.sms.pojo.StdMajorExample;
import java.util.List;

public interface StdMajorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_std_major
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    int insert(StdMajor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_std_major
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    int insertSelective(StdMajor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_std_major
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    List<StdMajor> selectByExample(StdMajorExample example);

    int insertIntoStdMajor(List<StdMajor> stdMajors);

    void clearTable();
}