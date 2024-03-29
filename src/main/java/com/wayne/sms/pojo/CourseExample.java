package com.wayne.sms.pojo;

import java.util.ArrayList;
import java.util.List;

public class CourseExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    public CourseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCouseInfoIsNull() {
            addCriterion("couse_info is null");
            return (Criteria) this;
        }

        public Criteria andCouseInfoIsNotNull() {
            addCriterion("couse_info is not null");
            return (Criteria) this;
        }

        public Criteria andCouseInfoEqualTo(String value) {
            addCriterion("couse_info =", value, "couseInfo");
            return (Criteria) this;
        }

        public Criteria andCouseInfoNotEqualTo(String value) {
            addCriterion("couse_info <>", value, "couseInfo");
            return (Criteria) this;
        }

        public Criteria andCouseInfoGreaterThan(String value) {
            addCriterion("couse_info >", value, "couseInfo");
            return (Criteria) this;
        }

        public Criteria andCouseInfoGreaterThanOrEqualTo(String value) {
            addCriterion("couse_info >=", value, "couseInfo");
            return (Criteria) this;
        }

        public Criteria andCouseInfoLessThan(String value) {
            addCriterion("couse_info <", value, "couseInfo");
            return (Criteria) this;
        }

        public Criteria andCouseInfoLessThanOrEqualTo(String value) {
            addCriterion("couse_info <=", value, "couseInfo");
            return (Criteria) this;
        }

        public Criteria andCouseInfoLike(String value) {
            addCriterion("couse_info like", value, "couseInfo");
            return (Criteria) this;
        }

        public Criteria andCouseInfoNotLike(String value) {
            addCriterion("couse_info not like", value, "couseInfo");
            return (Criteria) this;
        }

        public Criteria andCouseInfoIn(List<String> values) {
            addCriterion("couse_info in", values, "couseInfo");
            return (Criteria) this;
        }

        public Criteria andCouseInfoNotIn(List<String> values) {
            addCriterion("couse_info not in", values, "couseInfo");
            return (Criteria) this;
        }

        public Criteria andCouseInfoBetween(String value1, String value2) {
            addCriterion("couse_info between", value1, value2, "couseInfo");
            return (Criteria) this;
        }

        public Criteria andCouseInfoNotBetween(String value1, String value2) {
            addCriterion("couse_info not between", value1, value2, "couseInfo");
            return (Criteria) this;
        }

        public Criteria andRegularScorePerIsNull() {
            addCriterion("regular_score_per is null");
            return (Criteria) this;
        }

        public Criteria andRegularScorePerIsNotNull() {
            addCriterion("regular_score_per is not null");
            return (Criteria) this;
        }

        public Criteria andRegularScorePerEqualTo(Double value) {
            addCriterion("regular_score_per =", value, "regularScorePer");
            return (Criteria) this;
        }

        public Criteria andRegularScorePerNotEqualTo(Double value) {
            addCriterion("regular_score_per <>", value, "regularScorePer");
            return (Criteria) this;
        }

        public Criteria andRegularScorePerGreaterThan(Double value) {
            addCriterion("regular_score_per >", value, "regularScorePer");
            return (Criteria) this;
        }

        public Criteria andRegularScorePerGreaterThanOrEqualTo(Double value) {
            addCriterion("regular_score_per >=", value, "regularScorePer");
            return (Criteria) this;
        }

        public Criteria andRegularScorePerLessThan(Double value) {
            addCriterion("regular_score_per <", value, "regularScorePer");
            return (Criteria) this;
        }

        public Criteria andRegularScorePerLessThanOrEqualTo(Double value) {
            addCriterion("regular_score_per <=", value, "regularScorePer");
            return (Criteria) this;
        }

        public Criteria andRegularScorePerIn(List<Double> values) {
            addCriterion("regular_score_per in", values, "regularScorePer");
            return (Criteria) this;
        }

        public Criteria andRegularScorePerNotIn(List<Double> values) {
            addCriterion("regular_score_per not in", values, "regularScorePer");
            return (Criteria) this;
        }

        public Criteria andRegularScorePerBetween(Double value1, Double value2) {
            addCriterion("regular_score_per between", value1, value2, "regularScorePer");
            return (Criteria) this;
        }

        public Criteria andRegularScorePerNotBetween(Double value1, Double value2) {
            addCriterion("regular_score_per not between", value1, value2, "regularScorePer");
            return (Criteria) this;
        }

        public Criteria andFinalScorePerIsNull() {
            addCriterion("final_score_per is null");
            return (Criteria) this;
        }

        public Criteria andFinalScorePerIsNotNull() {
            addCriterion("final_score_per is not null");
            return (Criteria) this;
        }

        public Criteria andFinalScorePerEqualTo(Double value) {
            addCriterion("final_score_per =", value, "finalScorePer");
            return (Criteria) this;
        }

        public Criteria andFinalScorePerNotEqualTo(Double value) {
            addCriterion("final_score_per <>", value, "finalScorePer");
            return (Criteria) this;
        }

        public Criteria andFinalScorePerGreaterThan(Double value) {
            addCriterion("final_score_per >", value, "finalScorePer");
            return (Criteria) this;
        }

        public Criteria andFinalScorePerGreaterThanOrEqualTo(Double value) {
            addCriterion("final_score_per >=", value, "finalScorePer");
            return (Criteria) this;
        }

        public Criteria andFinalScorePerLessThan(Double value) {
            addCriterion("final_score_per <", value, "finalScorePer");
            return (Criteria) this;
        }

        public Criteria andFinalScorePerLessThanOrEqualTo(Double value) {
            addCriterion("final_score_per <=", value, "finalScorePer");
            return (Criteria) this;
        }

        public Criteria andFinalScorePerIn(List<Double> values) {
            addCriterion("final_score_per in", values, "finalScorePer");
            return (Criteria) this;
        }

        public Criteria andFinalScorePerNotIn(List<Double> values) {
            addCriterion("final_score_per not in", values, "finalScorePer");
            return (Criteria) this;
        }

        public Criteria andFinalScorePerBetween(Double value1, Double value2) {
            addCriterion("final_score_per between", value1, value2, "finalScorePer");
            return (Criteria) this;
        }

        public Criteria andFinalScorePerNotBetween(Double value1, Double value2) {
            addCriterion("final_score_per not between", value1, value2, "finalScorePer");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_course
     *
     * @mbggenerated do_not_delete_during_merge Sat Apr 18 23:36:53 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_course
     *
     * @mbggenerated Sat Apr 18 23:36:53 CST 2020
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}