package com.hniu.util;

import com.hniu.constan.StateCode;

public class State<T> {

	private StateCode state;
	private String message;
	private T data;

	public State() {
		super();
	}

	public State(StateCode state, String message, T data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}

	public StateCode getState() {
		return state;
	}

	public void setState(StateCode state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}