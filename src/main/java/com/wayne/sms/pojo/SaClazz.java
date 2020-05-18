package com.wayne.sms.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaClazz implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.id
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.grade
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private Integer grade;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.course_name
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private String courseName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.college
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private String college;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.major
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private String major;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.clazz
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private String clazz;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.avg_regular_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private BigDecimal avgRegularScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.avg_final_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private BigDecimal avgFinalScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.std_final_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private BigDecimal stdFinalScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.avg_total_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private BigDecimal avgTotalScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.std_total_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private BigDecimal stdTotalScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.sum_clazz_stu
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private Long sumClazzStu;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.sum_excellent
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private Long sumExcellent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.sum_good
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private Long sumGood;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.sum_medium
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private Long sumMedium;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.sum_pass
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private Long sumPass;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.sum_fail
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private Long sumFail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_clazz.std_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private BigDecimal stdScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_sa_clazz
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.id
     *
     * @return the value of t_sa_clazz.id
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.id
     *
     * @param id the value for t_sa_clazz.id
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.grade
     *
     * @return the value of t_sa_clazz.grade
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.grade
     *
     * @param grade the value for t_sa_clazz.grade
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.course_name
     *
     * @return the value of t_sa_clazz.course_name
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.course_name
     *
     * @param courseName the value for t_sa_clazz.course_name
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.college
     *
     * @return the value of t_sa_clazz.college
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public String getCollege() {
        return college;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.college
     *
     * @param college the value for t_sa_clazz.college
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.major
     *
     * @return the value of t_sa_clazz.major
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public String getMajor() {
        return major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.major
     *
     * @param major the value for t_sa_clazz.major
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.clazz
     *
     * @return the value of t_sa_clazz.clazz
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.clazz
     *
     * @param clazz the value for t_sa_clazz.clazz
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.avg_regular_score
     *
     * @return the value of t_sa_clazz.avg_regular_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public BigDecimal getAvgRegularScore() {
        return avgRegularScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.avg_regular_score
     *
     * @param avgRegularScore the value for t_sa_clazz.avg_regular_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setAvgRegularScore(BigDecimal avgRegularScore) {
        this.avgRegularScore = avgRegularScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.avg_final_score
     *
     * @return the value of t_sa_clazz.avg_final_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public BigDecimal getAvgFinalScore() {
        return avgFinalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.avg_final_score
     *
     * @param avgFinalScore the value for t_sa_clazz.avg_final_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setAvgFinalScore(BigDecimal avgFinalScore) {
        this.avgFinalScore = avgFinalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.std_final_score
     *
     * @return the value of t_sa_clazz.std_final_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public BigDecimal getStdFinalScore() {
        return stdFinalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.std_final_score
     *
     * @param stdFinalScore the value for t_sa_clazz.std_final_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setStdFinalScore(BigDecimal stdFinalScore) {
        this.stdFinalScore = stdFinalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.avg_total_score
     *
     * @return the value of t_sa_clazz.avg_total_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public BigDecimal getAvgTotalScore() {
        return avgTotalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.avg_total_score
     *
     * @param avgTotalScore the value for t_sa_clazz.avg_total_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setAvgTotalScore(BigDecimal avgTotalScore) {
        this.avgTotalScore = avgTotalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.std_total_score
     *
     * @return the value of t_sa_clazz.std_total_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public BigDecimal getStdTotalScore() {
        return stdTotalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.std_total_score
     *
     * @param stdTotalScore the value for t_sa_clazz.std_total_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setStdTotalScore(BigDecimal stdTotalScore) {
        this.stdTotalScore = stdTotalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.sum_clazz_stu
     *
     * @return the value of t_sa_clazz.sum_clazz_stu
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public Long getSumClazzStu() {
        return sumClazzStu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.sum_clazz_stu
     *
     * @param sumClazzStu the value for t_sa_clazz.sum_clazz_stu
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setSumClazzStu(Long sumClazzStu) {
        this.sumClazzStu = sumClazzStu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.sum_excellent
     *
     * @return the value of t_sa_clazz.sum_excellent
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public Long getSumExcellent() {
        return sumExcellent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.sum_excellent
     *
     * @param sumExcellent the value for t_sa_clazz.sum_excellent
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setSumExcellent(Long sumExcellent) {
        this.sumExcellent = sumExcellent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.sum_good
     *
     * @return the value of t_sa_clazz.sum_good
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public Long getSumGood() {
        return sumGood;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.sum_good
     *
     * @param sumGood the value for t_sa_clazz.sum_good
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setSumGood(Long sumGood) {
        this.sumGood = sumGood;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.sum_medium
     *
     * @return the value of t_sa_clazz.sum_medium
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public Long getSumMedium() {
        return sumMedium;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.sum_medium
     *
     * @param sumMedium the value for t_sa_clazz.sum_medium
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setSumMedium(Long sumMedium) {
        this.sumMedium = sumMedium;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.sum_pass
     *
     * @return the value of t_sa_clazz.sum_pass
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public Long getSumPass() {
        return sumPass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.sum_pass
     *
     * @param sumPass the value for t_sa_clazz.sum_pass
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setSumPass(Long sumPass) {
        this.sumPass = sumPass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.sum_fail
     *
     * @return the value of t_sa_clazz.sum_fail
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public Long getSumFail() {
        return sumFail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.sum_fail
     *
     * @param sumFail the value for t_sa_clazz.sum_fail
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setSumFail(Long sumFail) {
        this.sumFail = sumFail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_clazz.std_score
     *
     * @return the value of t_sa_clazz.std_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public BigDecimal getStdScore() {
        return stdScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_clazz.std_score
     *
     * @param stdScore the value for t_sa_clazz.std_score
     *
     * @mbggenerated Fri Apr 03 14:01:01 CST 2020
     */
    public void setStdScore(BigDecimal stdScore) {
        this.stdScore = stdScore;
    }

    @Override
    public String toString() {
        return "SaClazz{" +
                "id=" + id +
                ", grade=" + grade +
                ", courseName='" + courseName + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", clazz='" + clazz + '\'' +
                ", avgRegularScore=" + avgRegularScore +
                ", avgFinalScore=" + avgFinalScore +
                ", stdFinalScore=" + stdFinalScore +
                ", avgTotalScore=" + avgTotalScore +
                ", stdTotalScore=" + stdTotalScore +
                ", sumClazzStu=" + sumClazzStu +
                ", sumExcellent=" + sumExcellent +
                ", sumGood=" + sumGood +
                ", sumMedium=" + sumMedium +
                ", sumPass=" + sumPass +
                ", sumFail=" + sumFail +
                ", stdScore=" + stdScore +
                '}';
    }
}