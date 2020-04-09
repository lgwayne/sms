package com.wayne.sms.pojo;

import java.io.Serializable;

public class CollegeKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.college_id
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    private Integer collegeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.college_name
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    private String collegeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_college
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.college_id
     *
     * @return the value of t_college.college_id
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    public Integer getCollegeId() {
        return collegeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.college_id
     *
     * @param collegeId the value for t_college.college_id
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.college_name
     *
     * @return the value of t_college.college_name
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.college_name
     *
     * @param collegeName the value for t_college.college_name
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }

    @Override
    public String toString() {
        return "CollegeKey{" +
                "collegeId=" + collegeId +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}