package com.edu.springshop.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	
	private int product_idx;
	private String product_name;
	private String brand;
	private int price;
	private int discount;
	private String detail;
	private Category category;
	private List<Pimg> pimgList; //자식을 담을 그릇
	
	private MultipartFile[] photo;

}
