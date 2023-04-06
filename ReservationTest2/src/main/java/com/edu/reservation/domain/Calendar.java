package com.edu.reservation.domain;

import lombok.Data;

@Data
public class Calendar {
	
	private int calendar_idx;
	private String res_title;
	private String res_start;
	private String res_end;
}
