package com.edu.wepet.exception;

public class HolidayException extends RuntimeException{
	
	public HolidayException(String msg) {
		super(msg);
	}
	
	public HolidayException(String msg, Throwable e) {
		super(msg, e);
	}
}
