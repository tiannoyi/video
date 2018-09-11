package com.hniu.constant;

public enum StateCode {
	FAIL("0"),//失败
	SUCCESS("1"), //成功
	NOCHANGE("2");//未更改

	private String state;

	private StateCode(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return state;
	}
}
