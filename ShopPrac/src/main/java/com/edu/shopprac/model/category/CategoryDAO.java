package com.edu.shopprac.model.category;

import java.util.List;

import com.edu.shopprac.domain.Category;

public interface CategoryDAO {

	public List selectAll();
	public Category select(int category_idx);
	public void insert(Category category);
	public void update(Category category);
	public void delete(int category_idx);
}
