package com.edu.wepet.domain;

import lombok.Data;

@Data
public class PreReservation {
	
	private int prereservation_idx;
	private String yy;
	private String mm;
	private String dd;
	private String pet_kind;
	private int pet_number;
	private String client_content;
	private int fee;

}
