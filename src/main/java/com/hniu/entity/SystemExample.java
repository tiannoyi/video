package com.hniu.entity;

import java.util.ArrayList;
import java.util.List;

public class SystemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemExample() {
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

        public Criteria andSustemIdIsNull() {
            addCriterion("sustem_id is null");
            return (Criteria) this;
        }

        public Criteria andSustemIdIsNotNull() {
            addCriterion("sustem_id is not null");
            return (Criteria) this;
        }

        public Criteria andSustemIdEqualTo(Integer value) {
            addCriterion("sustem_id =", value, "sustemId");
            return (Criteria) this;
        }

        public Criteria andSustemIdNotEqualTo(Integer value) {
            addCriterion("sustem_id <>", value, "sustemId");
            return (Criteria) this;
        }

        public Criteria andSustemIdGreaterThan(Integer value) {
            addCriterion("sustem_id >", value, "sustemId");
            return (Criteria) this;
        }

        public Criteria andSustemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sustem_id >=", value, "sustemId");
            return (Criteria) this;
        }

        public Criteria andSustemIdLessThan(Integer value) {
            addCriterion("sustem_id <", value, "sustemId");
            return (Criteria) this;
        }

        public Criteria andSustemIdLessThanOrEqualTo(Integer value) {
            addCriterion("sustem_id <=", value, "sustemId");
            return (Criteria) this;
        }

        public Criteria andSustemIdIn(List<Integer> values) {
            addCriterion("sustem_id in", values, "sustemId");
            return (Criteria) this;
        }

        public Criteria andSustemIdNotIn(List<Integer> values) {
            addCriterion("sustem_id not in", values, "sustemId");
            return (Criteria) this;
        }

        public Criteria andSustemIdBetween(Integer value1, Integer value2) {
            addCriterion("sustem_id between", value1, value2, "sustemId");
            return (Criteria) this;
        }

        public Criteria andSustemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sustem_id not between", value1, value2, "sustemId");
            return (Criteria) this;
        }

        public Criteria andSystemNameIsNull() {
            addCriterion("system_name is null");
            return (Criteria) this;
        }

        public Criteria andSystemNameIsNotNull() {
            addCriterion("system_name is not null");
            return (Criteria) this;
        }

        public Criteria andSystemNameEqualTo(String value) {
            addCriterion("system_name =", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotEqualTo(String value) {
            addCriterion("system_name <>", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThan(String value) {
            addCriterion("system_name >", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThanOrEqualTo(String value) {
            addCriterion("system_name >=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThan(String value) {
            addCriterion("system_name <", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThanOrEqualTo(String value) {
            addCriterion("system_name <=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLike(String value) {
            addCriterion("system_name like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotLike(String value) {
            addCriterion("system_name not like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameIn(List<String> values) {
            addCriterion("system_name in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotIn(List<String> values) {
            addCriterion("system_name not in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameBetween(String value1, String value2) {
            addCriterion("system_name between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotBetween(String value1, String value2) {
            addCriterion("system_name not between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemLogoIsNull() {
            addCriterion("system_logo is null");
            return (Criteria) this;
        }

        public Criteria andSystemLogoIsNotNull() {
            addCriterion("system_logo is not null");
            return (Criteria) this;
        }

        public Criteria andSystemLogoEqualTo(String value) {
            addCriterion("system_logo =", value, "systemLogo");
            return (Criteria) this;
        }

        public Criteria andSystemLogoNotEqualTo(String value) {
            addCriterion("system_logo <>", value, "systemLogo");
            return (Criteria) this;
        }

        public Criteria andSystemLogoGreaterThan(String value) {
            addCriterion("system_logo >", value, "systemLogo");
            return (Criteria) this;
        }

        public Criteria andSystemLogoGreaterThanOrEqualTo(String value) {
            addCriterion("system_logo >=", value, "systemLogo");
            return (Criteria) this;
        }

        public Criteria andSystemLogoLessThan(String value) {
            addCriterion("system_logo <", value, "systemLogo");
            return (Criteria) this;
        }

        public Criteria andSystemLogoLessThanOrEqualTo(String value) {
            addCriterion("system_logo <=", value, "systemLogo");
            return (Criteria) this;
        }

        public Criteria andSystemLogoLike(String value) {
            addCriterion("system_logo like", value, "systemLogo");
            return (Criteria) this;
        }

        public Criteria andSystemLogoNotLike(String value) {
            addCriterion("system_logo not like", value, "systemLogo");
            return (Criteria) this;
        }

        public Criteria andSystemLogoIn(List<String> values) {
            addCriterion("system_logo in", values, "systemLogo");
            return (Criteria) this;
        }

        public Criteria andSystemLogoNotIn(List<String> values) {
            addCriterion("system_logo not in", values, "systemLogo");
            return (Criteria) this;
        }

        public Criteria andSystemLogoBetween(String value1, String value2) {
            addCriterion("system_logo between", value1, value2, "systemLogo");
            return (Criteria) this;
        }

        public Criteria andSystemLogoNotBetween(String value1, String value2) {
            addCriterion("system_logo not between", value1, value2, "systemLogo");
            return (Criteria) this;
        }

        public Criteria andCoverIsNull() {
            addCriterion("cover is null");
            return (Criteria) this;
        }

        public Criteria andCoverIsNotNull() {
            addCriterion("cover is not null");
            return (Criteria) this;
        }

        public Criteria andCoverEqualTo(String value) {
            addCriterion("cover =", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotEqualTo(String value) {
            addCriterion("cover <>", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThan(String value) {
            addCriterion("cover >", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThanOrEqualTo(String value) {
            addCriterion("cover >=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThan(String value) {
            addCriterion("cover <", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThanOrEqualTo(String value) {
            addCriterion("cover <=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLike(String value) {
            addCriterion("cover like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotLike(String value) {
            addCriterion("cover not like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverIn(List<String> values) {
            addCriterion("cover in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotIn(List<String> values) {
            addCriterion("cover not in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverBetween(String value1, String value2) {
            addCriterion("cover between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotBetween(String value1, String value2) {
            addCriterion("cover not between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andAppsecretIsNull() {
            addCriterion("appsecret is null");
            return (Criteria) this;
        }

        public Criteria andAppsecretIsNotNull() {
            addCriterion("appsecret is not null");
            return (Criteria) this;
        }

        public Criteria andAppsecretEqualTo(String value) {
            addCriterion("appsecret =", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotEqualTo(String value) {
            addCriterion("appsecret <>", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretGreaterThan(String value) {
            addCriterion("appsecret >", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretGreaterThanOrEqualTo(String value) {
            addCriterion("appsecret >=", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretLessThan(String value) {
            addCriterion("appsecret <", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretLessThanOrEqualTo(String value) {
            addCriterion("appsecret <=", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretLike(String value) {
            addCriterion("appsecret like", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotLike(String value) {
            addCriterion("appsecret not like", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretIn(List<String> values) {
            addCriterion("appsecret in", values, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotIn(List<String> values) {
            addCriterion("appsecret not in", values, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretBetween(String value1, String value2) {
            addCriterion("appsecret between", value1, value2, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotBetween(String value1, String value2) {
            addCriterion("appsecret not between", value1, value2, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appid like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appid not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appid not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andPageLineIsNull() {
            addCriterion("page_line is null");
            return (Criteria) this;
        }

        public Criteria andPageLineIsNotNull() {
            addCriterion("page_line is not null");
            return (Criteria) this;
        }

        public Criteria andPageLineEqualTo(Byte value) {
            addCriterion("page_line =", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineNotEqualTo(Byte value) {
            addCriterion("page_line <>", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineGreaterThan(Byte value) {
            addCriterion("page_line >", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineGreaterThanOrEqualTo(Byte value) {
            addCriterion("page_line >=", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineLessThan(Byte value) {
            addCriterion("page_line <", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineLessThanOrEqualTo(Byte value) {
            addCriterion("page_line <=", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineIn(List<Byte> values) {
            addCriterion("page_line in", values, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineNotIn(List<Byte> values) {
            addCriterion("page_line not in", values, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineBetween(Byte value1, Byte value2) {
            addCriterion("page_line between", value1, value2, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineNotBetween(Byte value1, Byte value2) {
            addCriterion("page_line not between", value1, value2, "pageLine");
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