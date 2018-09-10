package com.hniu.entity;

import java.util.ArrayList;
import java.util.List;

public class AddCurriculumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddCurriculumExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andAddIdIsNull() {
            addCriterion("add_id is null");
            return (Criteria) this;
        }

        public Criteria andAddIdIsNotNull() {
            addCriterion("add_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddIdEqualTo(Integer value) {
            addCriterion("add_id =", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotEqualTo(Integer value) {
            addCriterion("add_id <>", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThan(Integer value) {
            addCriterion("add_id >", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_id >=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThan(Integer value) {
            addCriterion("add_id <", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThanOrEqualTo(Integer value) {
            addCriterion("add_id <=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdIn(List<Integer> values) {
            addCriterion("add_id in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotIn(List<Integer> values) {
            addCriterion("add_id not in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdBetween(Integer value1, Integer value2) {
            addCriterion("add_id between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotBetween(Integer value1, Integer value2) {
            addCriterion("add_id not between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andTutionIdIsNull() {
            addCriterion("tution_id is null");
            return (Criteria) this;
        }

        public Criteria andTutionIdIsNotNull() {
            addCriterion("tution_id is not null");
            return (Criteria) this;
        }

        public Criteria andTutionIdEqualTo(Integer value) {
            addCriterion("tution_id =", value, "tutionId");
            return (Criteria) this;
        }

        public Criteria andTutionIdNotEqualTo(Integer value) {
            addCriterion("tution_id <>", value, "tutionId");
            return (Criteria) this;
        }

        public Criteria andTutionIdGreaterThan(Integer value) {
            addCriterion("tution_id >", value, "tutionId");
            return (Criteria) this;
        }

        public Criteria andTutionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tution_id >=", value, "tutionId");
            return (Criteria) this;
        }

        public Criteria andTutionIdLessThan(Integer value) {
            addCriterion("tution_id <", value, "tutionId");
            return (Criteria) this;
        }

        public Criteria andTutionIdLessThanOrEqualTo(Integer value) {
            addCriterion("tution_id <=", value, "tutionId");
            return (Criteria) this;
        }

        public Criteria andTutionIdIn(List<Integer> values) {
            addCriterion("tution_id in", values, "tutionId");
            return (Criteria) this;
        }

        public Criteria andTutionIdNotIn(List<Integer> values) {
            addCriterion("tution_id not in", values, "tutionId");
            return (Criteria) this;
        }

        public Criteria andTutionIdBetween(Integer value1, Integer value2) {
            addCriterion("tution_id between", value1, value2, "tutionId");
            return (Criteria) this;
        }

        public Criteria andTutionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tution_id not between", value1, value2, "tutionId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCourseGradeIsNull() {
            addCriterion("course_grade is null");
            return (Criteria) this;
        }

        public Criteria andCourseGradeIsNotNull() {
            addCriterion("course_grade is not null");
            return (Criteria) this;
        }

        public Criteria andCourseGradeEqualTo(Double value) {
            addCriterion("course_grade =", value, "courseGrade");
            return (Criteria) this;
        }

        public Criteria andCourseGradeNotEqualTo(Double value) {
            addCriterion("course_grade <>", value, "courseGrade");
            return (Criteria) this;
        }

        public Criteria andCourseGradeGreaterThan(Double value) {
            addCriterion("course_grade >", value, "courseGrade");
            return (Criteria) this;
        }

        public Criteria andCourseGradeGreaterThanOrEqualTo(Double value) {
            addCriterion("course_grade >=", value, "courseGrade");
            return (Criteria) this;
        }

        public Criteria andCourseGradeLessThan(Double value) {
            addCriterion("course_grade <", value, "courseGrade");
            return (Criteria) this;
        }

        public Criteria andCourseGradeLessThanOrEqualTo(Double value) {
            addCriterion("course_grade <=", value, "courseGrade");
            return (Criteria) this;
        }

        public Criteria andCourseGradeIn(List<Double> values) {
            addCriterion("course_grade in", values, "courseGrade");
            return (Criteria) this;
        }

        public Criteria andCourseGradeNotIn(List<Double> values) {
            addCriterion("course_grade not in", values, "courseGrade");
            return (Criteria) this;
        }

        public Criteria andCourseGradeBetween(Double value1, Double value2) {
            addCriterion("course_grade between", value1, value2, "courseGrade");
            return (Criteria) this;
        }

        public Criteria andCourseGradeNotBetween(Double value1, Double value2) {
            addCriterion("course_grade not between", value1, value2, "courseGrade");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIsNull() {
            addCriterion("is_qualified is null");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIsNotNull() {
            addCriterion("is_qualified is not null");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedEqualTo(Boolean value) {
            addCriterion("is_qualified =", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotEqualTo(Boolean value) {
            addCriterion("is_qualified <>", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedGreaterThan(Boolean value) {
            addCriterion("is_qualified >", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_qualified >=", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedLessThan(Boolean value) {
            addCriterion("is_qualified <", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_qualified <=", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIn(List<Boolean> values) {
            addCriterion("is_qualified in", values, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotIn(List<Boolean> values) {
            addCriterion("is_qualified not in", values, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_qualified between", value1, value2, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_qualified not between", value1, value2, "isQualified");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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