package com.wayne.sms.pojo;

import java.io.Serializable;

public class College extends CollegeKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.college_info
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    private String collegeInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_college
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.college_info
     *
     * @return the value of t_college.college_info
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    public String getCollegeInfo() {
        return collegeInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.college_info
     *
     * @param collegeInfo the value for t_college.college_info
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    public void setCollegeInfo(String collegeInfo) {
        this.collegeInfo = collegeInfo == null ? null : collegeInfo.trim();
    }


}