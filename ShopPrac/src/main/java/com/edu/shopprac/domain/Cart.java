package com.edu.shopprac.domain;

import lombok.Data;

@Data
public class Cart {
	
	private int cart_idx;
	private Member member;
	private Product product;
	

}
