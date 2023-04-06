package com.edu.shopprac.model.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.shopprac.domain.Cart;
import com.edu.shopprac.exception.CartException;


@Repository
public class MybatisCartDAO implements CartDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		
		List list= sqlSessionTemplate.selectList("selectAll");
		
		return list;
	}

	@Override
	public void insert(Cart cart) throws CartException{
		
		int result= sqlSessionTemplate.insert("Cart.insert", cart);
		
		if(result<1){
			throw new CartException("장바구니 등록 실패");
		}
	}

	@Override
	public int selectCount(Cart cart) throws CartException{
		
		
		int count= sqlSessionTemplate.selectOne("Cart.selectCount", cart);
		
		return count;
	}

	@Override
	public void updateEa(Cart cart) throws CartException{
		
		
		int result= sqlSessionTemplate.update("Cart.updateEA", cart);
		
		if(result<1){
			throw new CartException("장바구니 수정 실패");
		}

		
	}

}
