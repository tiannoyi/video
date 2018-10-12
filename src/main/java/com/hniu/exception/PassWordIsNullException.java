package com.hniu.exception;

import org.apache.shiro.authc.AuthenticationException;

public class PassWordIsNullException extends AuthenticationException {


	public PassWordIsNullException() {
		super();
	}

	public PassWordIsNullException(String string) {
		super(string);
	}
}
