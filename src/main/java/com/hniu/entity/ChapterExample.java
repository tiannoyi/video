package com.hniu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChapterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChapterExample() {
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

        public Criteria andChapterIdIsNull() {
            addCriterion("chapter_id is null");
            return (Criteria) this;
        }

        public Criteria andChapterIdIsNotNull() {
            addCriterion("chapter_id is not null");
            return (Criteria) this;
        }

        public Criteria andChapterIdEqualTo(Integer value) {
            addCriterion("chapter_id =", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotEqualTo(Integer value) {
            addCriterion("chapter_id <>", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdGreaterThan(Integer value) {
            addCriterion("chapter_id >", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("chapter_id >=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdLessThan(Integer value) {
            addCriterion("chapter_id <", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdLessThanOrEqualTo(Integer value) {
            addCriterion("chapter_id <=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdIn(List<Integer> values) {
            addCriterion("chapter_id in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotIn(List<Integer> values) {
            addCriterion("chapter_id not in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdBetween(Integer value1, Integer value2) {
            addCriterion("chapter_id between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("chapter_id not between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterNameIsNull() {
            addCriterion("chapter_name is null");
            return (Criteria) this;
        }

        public Criteria andChapterNameIsNotNull() {
            addCriterion("chapter_name is not null");
            return (Criteria) this;
        }

        public Criteria andChapterNameEqualTo(String value) {
            addCriterion("chapter_name =", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameNotEqualTo(String value) {
            addCriterion("chapter_name <>", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameGreaterThan(String value) {
            addCriterion("chapter_name >", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameGreaterThanOrEqualTo(String value) {
            addCriterion("chapter_name >=", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameLessThan(String value) {
            addCriterion("chapter_name <", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameLessThanOrEqualTo(String value) {
            addCriterion("chapter_name <=", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameLike(String value) {
            addCriterion("chapter_name like", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameNotLike(String value) {
            addCriterion("chapter_name not like", value, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameIn(List<String> values) {
            addCriterion("chapter_name in", values, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameNotIn(List<String> values) {
            addCriterion("chapter_name not in", values, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameBetween(String value1, String value2) {
            addCriterion("chapter_name between", value1, value2, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNameNotBetween(String value1, String value2) {
            addCriterion("chapter_name not between", value1, value2, "chapterName");
            return (Criteria) this;
        }

        public Criteria andChapterNumIsNull() {
            addCriterion("chapter_num is null");
            return (Criteria) this;
        }

        public Criteria andChapterNumIsNotNull() {
            addCriterion("chapter_num is not null");
            return (Criteria) this;
        }

        public Criteria andChapterNumEqualTo(String value) {
            addCriterion("chapter_num =", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumNotEqualTo(String value) {
            addCriterion("chapter_num <>", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumGreaterThan(String value) {
            addCriterion("chapter_num >", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumGreaterThanOrEqualTo(String value) {
            addCriterion("chapter_num >=", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumLessThan(String value) {
            addCriterion("chapter_num <", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumLessThanOrEqualTo(String value) {
            addCriterion("chapter_num <=", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumLike(String value) {
            addCriterion("chapter_num like", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumNotLike(String value) {
            addCriterion("chapter_num not like", value, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumIn(List<String> values) {
            addCriterion("chapter_num in", values, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumNotIn(List<String> values) {
            addCriterion("chapter_num not in", values, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumBetween(String value1, String value2) {
            addCriterion("chapter_num between", value1, value2, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andChapterNumNotBetween(String value1, String value2) {
            addCriterion("chapter_num not between", value1, value2, "chapterNum");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherIsNull() {
            addCriterion("redact_teacher is null");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherIsNotNull() {
            addCriterion("redact_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherEqualTo(String value) {
            addCriterion("redact_teacher =", value, "redactTeacher");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherNotEqualTo(String value) {
            addCriterion("redact_teacher <>", value, "redactTeacher");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherGreaterThan(String value) {
            addCriterion("redact_teacher >", value, "redactTeacher");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("redact_teacher >=", value, "redactTeacher");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherLessThan(String value) {
            addCriterion("redact_teacher <", value, "redactTeacher");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherLessThanOrEqualTo(String value) {
            addCriterion("redact_teacher <=", value, "redactTeacher");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherLike(String value) {
            addCriterion("redact_teacher like", value, "redactTeacher");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherNotLike(String value) {
            addCriterion("redact_teacher not like", value, "redactTeacher");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherIn(List<String> values) {
            addCriterion("redact_teacher in", values, "redactTeacher");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherNotIn(List<String> values) {
            addCriterion("redact_teacher not in", values, "redactTeacher");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherBetween(String value1, String value2) {
            addCriterion("redact_teacher between", value1, value2, "redactTeacher");
            return (Criteria) this;
        }

        public Criteria andRedactTeacherNotBetween(String value1, String value2) {
            addCriterion("redact_teacher not between", value1, value2, "redactTeacher");
            return (Criteria) this;
        }

        public Criteria andRedactTimeIsNull() {
            addCriterion("redact_time is null");
            return (Criteria) this;
        }

        public Criteria andRedactTimeIsNotNull() {
            addCriterion("redact_time is not null");
            return (Criteria) this;
        }

        public Criteria andRedactTimeEqualTo(Date value) {
            addCriterion("redact_time =", value, "redactTime");
            return (Criteria) this;
        }

        public Criteria andRedactTimeNotEqualTo(Date value) {
            addCriterion("redact_time <>", value, "redactTime");
            return (Criteria) this;
        }

        public Criteria andRedactTimeGreaterThan(Date value) {
            addCriterion("redact_time >", value, "redactTime");
            return (Criteria) this;
        }

        public Criteria andRedactTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("redact_time >=", value, "redactTime");
            return (Criteria) this;
        }

        public Criteria andRedactTimeLessThan(Date value) {
            addCriterion("redact_time <", value, "redactTime");
            return (Criteria) this;
        }

        public Criteria andRedactTimeLessThanOrEqualTo(Date value) {
            addCriterion("redact_time <=", value, "redactTime");
            return (Criteria) this;
        }

        public Criteria andRedactTimeIn(List<Date> values) {
            addCriterion("redact_time in", values, "redactTime");
            return (Criteria) this;
        }

        public Criteria andRedactTimeNotIn(List<Date> values) {
            addCriterion("redact_time not in", values, "redactTime");
            return (Criteria) this;
        }

        public Criteria andRedactTimeBetween(Date value1, Date value2) {
            addCriterion("redact_time between", value1, value2, "redactTime");
            return (Criteria) this;
        }

        public Criteria andRedactTimeNotBetween(Date value1, Date value2) {
            addCriterion("redact_time not between", value1, value2, "redactTime");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIsNull() {
            addCriterion("curriculum_id is null");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIsNotNull() {
            addCriterion("curriculum_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdEqualTo(Integer value) {
            addCriterion("curriculum_id =", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotEqualTo(Integer value) {
            addCriterion("curriculum_id <>", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdGreaterThan(Integer value) {
            addCriterion("curriculum_id >", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("curriculum_id >=", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdLessThan(Integer value) {
            addCriterion("curriculum_id <", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdLessThanOrEqualTo(Integer value) {
            addCriterion("curriculum_id <=", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIn(List<Integer> values) {
            addCriterion("curriculum_id in", values, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotIn(List<Integer> values) {
            addCriterion("curriculum_id not in", values, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdBetween(Integer value1, Integer value2) {
            addCriterion("curriculum_id between", value1, value2, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotBetween(Integer value1, Integer value2) {
            addCriterion("curriculum_id not between", value1, value2, "curriculumId");
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