package com.hniu.entity;

import java.util.ArrayList;
import java.util.List;

public class CurriculumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CurriculumExample() {
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

        public Criteria andUniversityIdIsNull() {
            addCriterion("university_id is null");
            return (Criteria) this;
        }

        public Criteria andUniversityIdIsNotNull() {
            addCriterion("university_id is not null");
            return (Criteria) this;
        }

        public Criteria andUniversityIdEqualTo(Integer value) {
            addCriterion("university_id =", value, "universityId");
            return (Criteria) this;
        }

        public Criteria andUniversityIdNotEqualTo(Integer value) {
            addCriterion("university_id <>", value, "universityId");
            return (Criteria) this;
        }

        public Criteria andUniversityIdGreaterThan(Integer value) {
            addCriterion("university_id >", value, "universityId");
            return (Criteria) this;
        }

        public Criteria andUniversityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("university_id >=", value, "universityId");
            return (Criteria) this;
        }

        public Criteria andUniversityIdLessThan(Integer value) {
            addCriterion("university_id <", value, "universityId");
            return (Criteria) this;
        }

        public Criteria andUniversityIdLessThanOrEqualTo(Integer value) {
            addCriterion("university_id <=", value, "universityId");
            return (Criteria) this;
        }

        public Criteria andUniversityIdIn(List<Integer> values) {
            addCriterion("university_id in", values, "universityId");
            return (Criteria) this;
        }

        public Criteria andUniversityIdNotIn(List<Integer> values) {
            addCriterion("university_id not in", values, "universityId");
            return (Criteria) this;
        }

        public Criteria andUniversityIdBetween(Integer value1, Integer value2) {
            addCriterion("university_id between", value1, value2, "universityId");
            return (Criteria) this;
        }

        public Criteria andUniversityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("university_id not between", value1, value2, "universityId");
            return (Criteria) this;
        }

        public Criteria andCtIdIsNull() {
            addCriterion("ct_id is null");
            return (Criteria) this;
        }

        public Criteria andCtIdIsNotNull() {
            addCriterion("ct_id is not null");
            return (Criteria) this;
        }

        public Criteria andCtIdEqualTo(Integer value) {
            addCriterion("ct_id =", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdNotEqualTo(Integer value) {
            addCriterion("ct_id <>", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdGreaterThan(Integer value) {
            addCriterion("ct_id >", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ct_id >=", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdLessThan(Integer value) {
            addCriterion("ct_id <", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdLessThanOrEqualTo(Integer value) {
            addCriterion("ct_id <=", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdIn(List<Integer> values) {
            addCriterion("ct_id in", values, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdNotIn(List<Integer> values) {
            addCriterion("ct_id not in", values, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdBetween(Integer value1, Integer value2) {
            addCriterion("ct_id between", value1, value2, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ct_id not between", value1, value2, "ctId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsIsNull() {
            addCriterion("propaedeutics is null");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsIsNotNull() {
            addCriterion("propaedeutics is not null");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsEqualTo(String value) {
            addCriterion("propaedeutics =", value, "propaedeutics");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsNotEqualTo(String value) {
            addCriterion("propaedeutics <>", value, "propaedeutics");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsGreaterThan(String value) {
            addCriterion("propaedeutics >", value, "propaedeutics");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsGreaterThanOrEqualTo(String value) {
            addCriterion("propaedeutics >=", value, "propaedeutics");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsLessThan(String value) {
            addCriterion("propaedeutics <", value, "propaedeutics");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsLessThanOrEqualTo(String value) {
            addCriterion("propaedeutics <=", value, "propaedeutics");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsLike(String value) {
            addCriterion("propaedeutics like", value, "propaedeutics");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsNotLike(String value) {
            addCriterion("propaedeutics not like", value, "propaedeutics");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsIn(List<String> values) {
            addCriterion("propaedeutics in", values, "propaedeutics");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsNotIn(List<String> values) {
            addCriterion("propaedeutics not in", values, "propaedeutics");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsBetween(String value1, String value2) {
            addCriterion("propaedeutics between", value1, value2, "propaedeutics");
            return (Criteria) this;
        }

        public Criteria andPropaedeuticsNotBetween(String value1, String value2) {
            addCriterion("propaedeutics not between", value1, value2, "propaedeutics");
            return (Criteria) this;
        }

        public Criteria andMeferencesIsNull() {
            addCriterion("meferences is null");
            return (Criteria) this;
        }

        public Criteria andMeferencesIsNotNull() {
            addCriterion("meferences is not null");
            return (Criteria) this;
        }

        public Criteria andMeferencesEqualTo(String value) {
            addCriterion("meferences =", value, "meferences");
            return (Criteria) this;
        }

        public Criteria andMeferencesNotEqualTo(String value) {
            addCriterion("meferences <>", value, "meferences");
            return (Criteria) this;
        }

        public Criteria andMeferencesGreaterThan(String value) {
            addCriterion("meferences >", value, "meferences");
            return (Criteria) this;
        }

        public Criteria andMeferencesGreaterThanOrEqualTo(String value) {
            addCriterion("meferences >=", value, "meferences");
            return (Criteria) this;
        }

        public Criteria andMeferencesLessThan(String value) {
            addCriterion("meferences <", value, "meferences");
            return (Criteria) this;
        }

        public Criteria andMeferencesLessThanOrEqualTo(String value) {
            addCriterion("meferences <=", value, "meferences");
            return (Criteria) this;
        }

        public Criteria andMeferencesLike(String value) {
            addCriterion("meferences like", value, "meferences");
            return (Criteria) this;
        }

        public Criteria andMeferencesNotLike(String value) {
            addCriterion("meferences not like", value, "meferences");
            return (Criteria) this;
        }

        public Criteria andMeferencesIn(List<String> values) {
            addCriterion("meferences in", values, "meferences");
            return (Criteria) this;
        }

        public Criteria andMeferencesNotIn(List<String> values) {
            addCriterion("meferences not in", values, "meferences");
            return (Criteria) this;
        }

        public Criteria andMeferencesBetween(String value1, String value2) {
            addCriterion("meferences between", value1, value2, "meferences");
            return (Criteria) this;
        }

        public Criteria andMeferencesNotBetween(String value1, String value2) {
            addCriterion("meferences not between", value1, value2, "meferences");
            return (Criteria) this;
        }

        public Criteria andRequireIsNull() {
            addCriterion("require is null");
            return (Criteria) this;
        }

        public Criteria andRequireIsNotNull() {
            addCriterion("require is not null");
            return (Criteria) this;
        }

        public Criteria andRequireEqualTo(String value) {
            addCriterion("require =", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireNotEqualTo(String value) {
            addCriterion("require <>", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireGreaterThan(String value) {
            addCriterion("require >", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireGreaterThanOrEqualTo(String value) {
            addCriterion("require >=", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireLessThan(String value) {
            addCriterion("require <", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireLessThanOrEqualTo(String value) {
            addCriterion("require <=", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireLike(String value) {
            addCriterion("require like", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireNotLike(String value) {
            addCriterion("require not like", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireIn(List<String> values) {
            addCriterion("require in", values, "require");
            return (Criteria) this;
        }

        public Criteria andRequireNotIn(List<String> values) {
            addCriterion("require not in", values, "require");
            return (Criteria) this;
        }

        public Criteria andRequireBetween(String value1, String value2) {
            addCriterion("require between", value1, value2, "require");
            return (Criteria) this;
        }

        public Criteria andRequireNotBetween(String value1, String value2) {
            addCriterion("require not between", value1, value2, "require");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Integer value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Integer value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Integer value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Integer value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Integer value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Integer> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Integer> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Integer value1, Integer value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Double value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Double value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Double value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Double value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Double value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Double> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Double> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Double value1, Double value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Double value1, Double value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andVideoIsNull() {
            addCriterion("video is null");
            return (Criteria) this;
        }

        public Criteria andVideoIsNotNull() {
            addCriterion("video is not null");
            return (Criteria) this;
        }

        public Criteria andVideoEqualTo(String value) {
            addCriterion("video =", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoNotEqualTo(String value) {
            addCriterion("video <>", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoGreaterThan(String value) {
            addCriterion("video >", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoGreaterThanOrEqualTo(String value) {
            addCriterion("video >=", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoLessThan(String value) {
            addCriterion("video <", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoLessThanOrEqualTo(String value) {
            addCriterion("video <=", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoLike(String value) {
            addCriterion("video like", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoNotLike(String value) {
            addCriterion("video not like", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoIn(List<String> values) {
            addCriterion("video in", values, "video");
            return (Criteria) this;
        }

        public Criteria andVideoNotIn(List<String> values) {
            addCriterion("video not in", values, "video");
            return (Criteria) this;
        }

        public Criteria andVideoBetween(String value1, String value2) {
            addCriterion("video between", value1, value2, "video");
            return (Criteria) this;
        }

        public Criteria andVideoNotBetween(String value1, String value2) {
            addCriterion("video not between", value1, value2, "video");
            return (Criteria) this;
        }

        public Criteria andIsMainpicIsNull() {
            addCriterion("is_Mainpic is null");
            return (Criteria) this;
        }

        public Criteria andIsMainpicIsNotNull() {
            addCriterion("is_Mainpic is not null");
            return (Criteria) this;
        }

        public Criteria andIsMainpicEqualTo(Boolean value) {
            addCriterion("is_Mainpic =", value, "isMainpic");
            return (Criteria) this;
        }

        public Criteria andIsMainpicNotEqualTo(Boolean value) {
            addCriterion("is_Mainpic <>", value, "isMainpic");
            return (Criteria) this;
        }

        public Criteria andIsMainpicGreaterThan(Boolean value) {
            addCriterion("is_Mainpic >", value, "isMainpic");
            return (Criteria) this;
        }

        public Criteria andIsMainpicGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_Mainpic >=", value, "isMainpic");
            return (Criteria) this;
        }

        public Criteria andIsMainpicLessThan(Boolean value) {
            addCriterion("is_Mainpic <", value, "isMainpic");
            return (Criteria) this;
        }

        public Criteria andIsMainpicLessThanOrEqualTo(Boolean value) {
            addCriterion("is_Mainpic <=", value, "isMainpic");
            return (Criteria) this;
        }

        public Criteria andIsMainpicIn(List<Boolean> values) {
            addCriterion("is_Mainpic in", values, "isMainpic");
            return (Criteria) this;
        }

        public Criteria andIsMainpicNotIn(List<Boolean> values) {
            addCriterion("is_Mainpic not in", values, "isMainpic");
            return (Criteria) this;
        }

        public Criteria andIsMainpicBetween(Boolean value1, Boolean value2) {
            addCriterion("is_Mainpic between", value1, value2, "isMainpic");
            return (Criteria) this;
        }

        public Criteria andIsMainpicNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_Mainpic not between", value1, value2, "isMainpic");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIsNull() {
            addCriterion("main_teacher is null");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIsNotNull() {
            addCriterion("main_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andMainTeacherEqualTo(String value) {
            addCriterion("main_teacher =", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherNotEqualTo(String value) {
            addCriterion("main_teacher <>", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherGreaterThan(String value) {
            addCriterion("main_teacher >", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("main_teacher >=", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherLessThan(String value) {
            addCriterion("main_teacher <", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherLessThanOrEqualTo(String value) {
            addCriterion("main_teacher <=", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherLike(String value) {
            addCriterion("main_teacher like", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherNotLike(String value) {
            addCriterion("main_teacher not like", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIn(List<String> values) {
            addCriterion("main_teacher in", values, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherNotIn(List<String> values) {
            addCriterion("main_teacher not in", values, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherBetween(String value1, String value2) {
            addCriterion("main_teacher between", value1, value2, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherNotBetween(String value1, String value2) {
            addCriterion("main_teacher not between", value1, value2, "mainTeacher");
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