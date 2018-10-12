package com.hniu.entity.wrap;


public class State {
    private String state;
    private String message;
    private Object data;

    public State(String state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
