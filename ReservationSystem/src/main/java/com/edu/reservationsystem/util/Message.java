package com.edu.reservationsystem.util;

import lombok.Data;

//클라이언트에게 응답으로 보낼 메시지 객체
@Data
public class Message {
	private String msg;
	private int code;
}
