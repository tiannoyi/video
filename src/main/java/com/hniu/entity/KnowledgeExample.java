package com.hniu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KnowledgeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KnowledgeExample() {
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

        public Criteria andKnowledgeIdIsNull() {
            addCriterion("knowledge_id is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdIsNotNull() {
            addCriterion("knowledge_id is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdEqualTo(Integer value) {
            addCriterion("knowledge_id =", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotEqualTo(Integer value) {
            addCriterion("knowledge_id <>", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdGreaterThan(Integer value) {
            addCriterion("knowledge_id >", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("knowledge_id >=", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdLessThan(Integer value) {
            addCriterion("knowledge_id <", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdLessThanOrEqualTo(Integer value) {
            addCriterion("knowledge_id <=", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdIn(List<Integer> values) {
            addCriterion("knowledge_id in", values, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotIn(List<Integer> values) {
            addCriterion("knowledge_id not in", values, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdBetween(Integer value1, Integer value2) {
            addCriterion("knowledge_id between", value1, value2, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("knowledge_id not between", value1, value2, "knowledgeId");
            return (Criteria) this;
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

        public Criteria andSummaryNameIsNull() {
            addCriterion("Summary_name is null");
            return (Criteria) this;
        }

        public Criteria andSummaryNameIsNotNull() {
            addCriterion("Summary_name is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryNameEqualTo(String value) {
            addCriterion("Summary_name =", value, "summaryName");
            return (Criteria) this;
        }

        public Criteria andSummaryNameNotEqualTo(String value) {
            addCriterion("Summary_name <>", value, "summaryName");
            return (Criteria) this;
        }

        public Criteria andSummaryNameGreaterThan(String value) {
            addCriterion("Summary_name >", value, "summaryName");
            return (Criteria) this;
        }

        public Criteria andSummaryNameGreaterThanOrEqualTo(String value) {
            addCriterion("Summary_name >=", value, "summaryName");
            return (Criteria) this;
        }

        public Criteria andSummaryNameLessThan(String value) {
            addCriterion("Summary_name <", value, "summaryName");
            return (Criteria) this;
        }

        public Criteria andSummaryNameLessThanOrEqualTo(String value) {
            addCriterion("Summary_name <=", value, "summaryName");
            return (Criteria) this;
        }

        public Criteria andSummaryNameLike(String value) {
            addCriterion("Summary_name like", value, "summaryName");
            return (Criteria) this;
        }

        public Criteria andSummaryNameNotLike(String value) {
            addCriterion("Summary_name not like", value, "summaryName");
            return (Criteria) this;
        }

        public Criteria andSummaryNameIn(List<String> values) {
            addCriterion("Summary_name in", values, "summaryName");
            return (Criteria) this;
        }

        public Criteria andSummaryNameNotIn(List<String> values) {
            addCriterion("Summary_name not in", values, "summaryName");
            return (Criteria) this;
        }

        public Criteria andSummaryNameBetween(String value1, String value2) {
            addCriterion("Summary_name between", value1, value2, "summaryName");
            return (Criteria) this;
        }

        public Criteria andSummaryNameNotBetween(String value1, String value2) {
            addCriterion("Summary_name not between", value1, value2, "summaryName");
            return (Criteria) this;
        }

        public Criteria andSummaryNumIsNull() {
            addCriterion("Summary_Num is null");
            return (Criteria) this;
        }

        public Criteria andSummaryNumIsNotNull() {
            addCriterion("Summary_Num is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryNumEqualTo(String value) {
            addCriterion("Summary_Num =", value, "summaryNum");
            return (Criteria) this;
        }

        public Criteria andSummaryNumNotEqualTo(String value) {
            addCriterion("Summary_Num <>", value, "summaryNum");
            return (Criteria) this;
        }

        public Criteria andSummaryNumGreaterThan(String value) {
            addCriterion("Summary_Num >", value, "summaryNum");
            return (Criteria) this;
        }

        public Criteria andSummaryNumGreaterThanOrEqualTo(String value) {
            addCriterion("Summary_Num >=", value, "summaryNum");
            return (Criteria) this;
        }

        public Criteria andSummaryNumLessThan(String value) {
            addCriterion("Summary_Num <", value, "summaryNum");
            return (Criteria) this;
        }

        public Criteria andSummaryNumLessThanOrEqualTo(String value) {
            addCriterion("Summary_Num <=", value, "summaryNum");
            return (Criteria) this;
        }

        public Criteria andSummaryNumLike(String value) {
            addCriterion("Summary_Num like", value, "summaryNum");
            return (Criteria) this;
        }

        public Criteria andSummaryNumNotLike(String value) {
            addCriterion("Summary_Num not like", value, "summaryNum");
            return (Criteria) this;
        }

        public Criteria andSummaryNumIn(List<String> values) {
            addCriterion("Summary_Num in", values, "summaryNum");
            return (Criteria) this;
        }

        public Criteria andSummaryNumNotIn(List<String> values) {
            addCriterion("Summary_Num not in", values, "summaryNum");
            return (Criteria) this;
        }

        public Criteria andSummaryNumBetween(String value1, String value2) {
            addCriterion("Summary_Num between", value1, value2, "summaryNum");
            return (Criteria) this;
        }

        public Criteria andSummaryNumNotBetween(String value1, String value2) {
            addCriterion("Summary_Num not between", value1, value2, "summaryNum");
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