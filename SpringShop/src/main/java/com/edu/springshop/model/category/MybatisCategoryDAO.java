package com.edu.springshop.model.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springshop.domain.Category;
import com.edu.springshop.exception.CategoryException;

@Repository
public class MybatisCategoryDAO implements CategoryDAO{

	//1순위: 아이디 2순위: 자료형 등으로 찾아냄 즉 sqlSessionTemplate id를 줬다 하더라도 다른 변수명으로 바꿔도 사용가능
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insert(Category category) throws CategoryException{
		
		int result= sqlSessionTemplate.insert("Category.insert", category);
		
		if(result<1) {
			throw new CategoryException("카테고리 등록 실패");
		}
	}

	@Override
	public List selectAll() {

		return sqlSessionTemplate.selectList("Category.selectAll");
	}

	@Override
	public Category select(int category_idx) {

		return sqlSessionTemplate.selectOne("Category.select", category_idx);
	}

	@Override
	public void update(Category category) throws CategoryException{

		int result= sqlSessionTemplate.update("Category.update", category);
		
		if(result<1) {
			throw new CategoryException("카테고리 수정 실패");
		}
	}

	@Override
	public void delete(int category_idx) throws CategoryException{
		
		int result= sqlSessionTemplate.delete("Category.delete", category_idx);
		
		if(result<1) {
			throw new CategoryException("카테고리 삭제 실패");
		}
		
	}

}
