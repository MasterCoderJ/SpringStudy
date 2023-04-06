package com.edu.shopprac.model.product;

import java.util.List;

import com.edu.shopprac.domain.Pimg;


public interface PimgDAO {
	
	public List selectAll();
	public List selectByProduct(int product_idx);
	public void insert(Pimg pimg);
	public void delete(int product_idx);

}
