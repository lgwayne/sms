package com.wayne.sms.pojo;

import java.io.Serializable;

public class Clazz extends ClazzKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_clazz.major_id
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    private Integer majorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_clazz
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_clazz.major_id
     *
     * @return the value of t_clazz.major_id
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    public Integer getMajorId() {
        return majorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_clazz.major_id
     *
     * @param majorId the value for t_clazz.major_id
     *
     * @mbggenerated Mon Mar 16 14:52:57 CST 2020
     */
    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "majorId=" + majorId +super.toString()+
                '}';
    }
}