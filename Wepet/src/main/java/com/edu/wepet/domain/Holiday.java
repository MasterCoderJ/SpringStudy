package com.edu.wepet.domain;

import lombok.Data;

@Data
public class Holiday {
	
	private int holiday_idx;

	//연
	private String yy;
	
	//월
	private String mm;  
	
	//일
	private String dd;
	
}
