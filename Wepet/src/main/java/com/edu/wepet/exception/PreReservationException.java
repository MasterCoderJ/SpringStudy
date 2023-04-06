package com.edu.wepet.exception;

public class PreReservationException extends RuntimeException{
	
	public PreReservationException(String msg) {
		super(msg);
	}
	
	public PreReservationException(String msg, Throwable e) {
		super(msg, e);
	}
}
