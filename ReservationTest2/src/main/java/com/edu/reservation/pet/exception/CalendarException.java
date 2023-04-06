package com.edu.reservation.pet.exception;

public class CalendarException extends RuntimeException{

	public CalendarException(String msg) {
		super(msg);
	}
	
	public CalendarException(String msg, Throwable e) {
		super(msg, e);
	}
}
