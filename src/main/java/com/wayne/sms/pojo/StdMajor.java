package com.wayne.sms.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class StdMajor implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_std_major.college
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    private String college;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_std_major.major
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    private String major;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_std_major.course_name
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    private String courseName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_std_major.std_score
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    private BigDecimal stdScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_std_major
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_std_major.college
     *
     * @return the value of t_std_major.college
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    public String getCollege() {
        return college;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_std_major.college
     *
     * @param college the value for t_std_major.college
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_std_major.major
     *
     * @return the value of t_std_major.major
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    public String getMajor() {
        return major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_std_major.major
     *
     * @param major the value for t_std_major.major
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_std_major.course_name
     *
     * @return the value of t_std_major.course_name
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_std_major.course_name
     *
     * @param courseName the value for t_std_major.course_name
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_std_major.std_score
     *
     * @return the value of t_std_major.std_score
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    public BigDecimal getStdScore() {
        return stdScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_std_major.std_score
     *
     * @param stdScore the value for t_std_major.std_score
     *
     * @mbggenerated Fri Apr 03 15:41:56 CST 2020
     */
    public void setStdScore(BigDecimal stdScore) {
        this.stdScore = stdScore;
    }

    @Override
    public String toString() {
        return "StdMajor{" +
                "college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", courseName='" + courseName + '\'' +
                ", stdScore=" + stdScore +
                '}';
    }
}