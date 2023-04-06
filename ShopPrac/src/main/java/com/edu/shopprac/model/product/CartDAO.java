package com.edu.shopprac.model.product;

import java.util.List;

import com.edu.shopprac.domain.Cart;


public interface CartDAO {

	public List selectAll();
	public void insert(Cart cart);
	public int selectCount(Cart cart);
	public void updateEa(Cart cart);
}
