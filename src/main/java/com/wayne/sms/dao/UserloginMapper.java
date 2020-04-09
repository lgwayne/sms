package com.wayne.sms.dao;

import com.wayne.sms.pojo.Userlogin;
import com.wayne.sms.pojo.UserloginExample;
import java.util.List;

public interface UserloginMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userlogin
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userlogin
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int insert(Userlogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userlogin
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int insertSelective(Userlogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userlogin
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    List<Userlogin> selectByExample(UserloginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userlogin
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    Userlogin selectByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userlogin
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int updateByPrimaryKeySelective(Userlogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userlogin
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    int updateByPrimaryKey(Userlogin record);

    /*
    联动角色名称一并查出
     */
    List<Userlogin> selectByExample1(UserloginExample testExample);

    int deleteByExample(UserloginExample example);
}