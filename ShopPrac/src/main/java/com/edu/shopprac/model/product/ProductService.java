package com.edu.shopprac.model.product;

import java.util.List;

import com.edu.shopprac.domain.Product;


public interface ProductService {
	
	
	public List selectAll();
	public Product select(int product_idx);
	public void regist(Product product, String dir); //db연동+file제어
	public void update(Product product);
	public void delete(int product_idx);


	
}
