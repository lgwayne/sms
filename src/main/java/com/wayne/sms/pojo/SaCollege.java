package com.wayne.sms.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaCollege implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.id
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.grade
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private Integer grade;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.course_name
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private String courseName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.college
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private String college;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.avg_regular_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private BigDecimal avgRegularScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.avg_final_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private BigDecimal avgFinalScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.std_final_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private BigDecimal stdFinalScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.avg_total_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private BigDecimal avgTotalScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.std_total_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private BigDecimal stdTotalScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.sum_college_stu
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private Long sumCollegeStu;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.sum_excellent
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private Long sumExcellent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.sum_good
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private Long sumGood;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.sum_medium
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private Long sumMedium;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.sun_pass
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private Long sunPass;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sa_college.sum_fail
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private Long sumFail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_sa_college
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.id
     *
     * @return the value of t_sa_college.id
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.id
     *
     * @param id the value for t_sa_college.id
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.grade
     *
     * @return the value of t_sa_college.grade
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.grade
     *
     * @param grade the value for t_sa_college.grade
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.course_name
     *
     * @return the value of t_sa_college.course_name
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.course_name
     *
     * @param courseName the value for t_sa_college.course_name
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.college
     *
     * @return the value of t_sa_college.college
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public String getCollege() {
        return college;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.college
     *
     * @param college the value for t_sa_college.college
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.avg_regular_score
     *
     * @return the value of t_sa_college.avg_regular_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public BigDecimal getAvgRegularScore() {
        return avgRegularScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.avg_regular_score
     *
     * @param avgRegularScore the value for t_sa_college.avg_regular_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setAvgRegularScore(BigDecimal avgRegularScore) {
        this.avgRegularScore = avgRegularScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.avg_final_score
     *
     * @return the value of t_sa_college.avg_final_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public BigDecimal getAvgFinalScore() {
        return avgFinalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.avg_final_score
     *
     * @param avgFinalScore the value for t_sa_college.avg_final_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setAvgFinalScore(BigDecimal avgFinalScore) {
        this.avgFinalScore = avgFinalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.std_final_score
     *
     * @return the value of t_sa_college.std_final_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public BigDecimal getStdFinalScore() {
        return stdFinalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.std_final_score
     *
     * @param stdFinalScore the value for t_sa_college.std_final_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setStdFinalScore(BigDecimal stdFinalScore) {
        this.stdFinalScore = stdFinalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.avg_total_score
     *
     * @return the value of t_sa_college.avg_total_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public BigDecimal getAvgTotalScore() {
        return avgTotalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.avg_total_score
     *
     * @param avgTotalScore the value for t_sa_college.avg_total_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setAvgTotalScore(BigDecimal avgTotalScore) {
        this.avgTotalScore = avgTotalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.std_total_score
     *
     * @return the value of t_sa_college.std_total_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public BigDecimal getStdTotalScore() {
        return stdTotalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.std_total_score
     *
     * @param stdTotalScore the value for t_sa_college.std_total_score
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setStdTotalScore(BigDecimal stdTotalScore) {
        this.stdTotalScore = stdTotalScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.sum_college_stu
     *
     * @return the value of t_sa_college.sum_college_stu
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public Long getSumCollegeStu() {
        return sumCollegeStu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.sum_college_stu
     *
     * @param sumCollegeStu the value for t_sa_college.sum_college_stu
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setSumCollegeStu(Long sumCollegeStu) {
        this.sumCollegeStu = sumCollegeStu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.sum_excellent
     *
     * @return the value of t_sa_college.sum_excellent
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public Long getSumExcellent() {
        return sumExcellent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.sum_excellent
     *
     * @param sumExcellent the value for t_sa_college.sum_excellent
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setSumExcellent(Long sumExcellent) {
        this.sumExcellent = sumExcellent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.sum_good
     *
     * @return the value of t_sa_college.sum_good
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public Long getSumGood() {
        return sumGood;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.sum_good
     *
     * @param sumGood the value for t_sa_college.sum_good
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setSumGood(Long sumGood) {
        this.sumGood = sumGood;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.sum_medium
     *
     * @return the value of t_sa_college.sum_medium
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public Long getSumMedium() {
        return sumMedium;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.sum_medium
     *
     * @param sumMedium the value for t_sa_college.sum_medium
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setSumMedium(Long sumMedium) {
        this.sumMedium = sumMedium;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.sun_pass
     *
     * @return the value of t_sa_college.sun_pass
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public Long getSunPass() {
        return sunPass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.sun_pass
     *
     * @param sunPass the value for t_sa_college.sun_pass
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setSunPass(Long sunPass) {
        this.sunPass = sunPass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sa_college.sum_fail
     *
     * @return the value of t_sa_college.sum_fail
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public Long getSumFail() {
        return sumFail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sa_college.sum_fail
     *
     * @param sumFail the value for t_sa_college.sum_fail
     *
     * @mbggenerated Thu Apr 02 10:51:13 CST 2020
     */
    public void setSumFail(Long sumFail) {

        this.sumFail = sumFail;
    }

    @Override
    public String toString() {
        return "SaCollege{" +
                "id=" + id +
                ", grade=" + grade +
                ", courseName='" + courseName + '\'' +
                ", college='" + college + '\'' +
                ", avgRegularScore=" + avgRegularScore +
                ", avgFinalScore=" + avgFinalScore +
                ", stdFinalScore=" + stdFinalScore +
                ", avgTotalScore=" + avgTotalScore +
                ", stdTotalScore=" + stdTotalScore +
                ", sumCollegeStu=" + sumCollegeStu +
                ", sumExcellent=" + sumExcellent +
                ", sumGood=" + sumGood +
                ", sumMedium=" + sumMedium +
                ", sunPass=" + sunPass +
                ", sumFail=" + sumFail +
                '}';
    }
}