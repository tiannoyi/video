package com.hniu.controller;

import com.hniu.constant.StateCode;
import com.hniu.util.State;

public class Base {

	/**
	 * 状态包装
	 */
	public State<Object> packaging(StateCode success, String message, Object data) {
		return new State<Object>(success, message, data);
	}
}
