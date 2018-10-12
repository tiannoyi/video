package com.hniu.constan;


public enum StateCode {
    SUCCESS("0", "SUCCESS"),
    FAIL("1", "FAIL"),
    USERNAMENOTNULL("1","用户名不能为空"),
    PASSWORDNOTNULL("1","密码不能为空"),
    USERNAMENOTEXIST("1","用户名不存在"),
    USERNAMEEXIST("1","用户名已经存在"),
    PASSWORDMISTAKE("1","密码错误"),
    USERNAMELOCK("1","该账户被冻结"),
    LOGINAGAIN("1","请重新登录");


    private String state;
    private String message;

    private StateCode(String state, String message) {
        this.state = state;
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "state:" + state + "\n" + "message:" + message;
    }
}
