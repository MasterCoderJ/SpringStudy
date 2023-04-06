package com.edu.shopprac.exception;

public class MemberException extends RuntimeException {

	public MemberException(String msg) {
		super(msg);
	}

	public MemberException(String msg, Throwable e) {
		super(msg, e);
	}

}
