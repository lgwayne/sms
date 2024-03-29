package com.wayne.sms.dao;

import com.wayne.sms.pojo.Clazz;
import com.wayne.sms.pojo.ClazzExample;
import com.wayne.sms.pojo.ClazzKey;
import java.util.List;

public interface ClazzMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_clazz
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int deleteByPrimaryKey(ClazzKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_clazz
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int insert(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_clazz
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int insertSelective(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_clazz
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    List<Clazz> selectByExample(ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_clazz
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    Clazz selectByPrimaryKey(ClazzKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_clazz
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int updateByPrimaryKeySelective(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_clazz
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int updateByPrimaryKey(Clazz record);

    Clazz selectByClazzId(Integer clazzId);
}