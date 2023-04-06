package com.edu.shopprac.model.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.shopprac.domain.Product;
import com.edu.shopprac.exception.ProductException;


@Repository
public class MybatisProductDAO implements ProductDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		List list= sqlSessionTemplate.selectList("Product.selectAll");
		
		return list;
	}

	@Override
	public Product select(int product_idx) {
		
		return sqlSessionTemplate.selectOne("Product.select", product_idx);
	}

	@Override
	public void insert(Product product) throws ProductException{
		
		int result= sqlSessionTemplate.insert("Product.insert", product);
		
		if(result<1) {
			throw new ProductException("상품 등록 실패");
		}
		
	}

	@Override
	public void update(Product product) throws ProductException{
		
		int result= sqlSessionTemplate.update("Product.update", product);
		
		if(result<1) {
			throw new ProductException("상품 수정 실패");
		}

	}

	@Override
	public void delete(int product_idx) throws ProductException{
		
		int result= sqlSessionTemplate.delete("Product.delete", product_idx);
		
		if(result<1) {
			throw new ProductException("상품 삭제 실패");
		}

	}

	@Override
	public com.edu.shopprac.domain.Product select(int product_idx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void insert(com.edu.shopprac.domain.Product product) {
		// TODO Auto-generated method stub
		
	}

	public void update(com.edu.shopprac.domain.Product product) {
		// TODO Auto-generated method stub
		
	}

}
