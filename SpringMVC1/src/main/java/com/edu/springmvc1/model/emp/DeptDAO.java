package com.edu.springmvc1.model.emp;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.springmvc1.domain.Dept;
import com.edu.springmvc1.exception.DeptException;

@Repository
public class DeptDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void insert(Dept dept) throws DeptException{
		int result= sqlSession.insert("Dept.insert", dept);
		if(result<1) {
			throw new DeptException("부서등록 실패");
		}
	}
	
	public void delete(int deptno) throws DeptException{
		int result= sqlSession.delete("Dept.delete",deptno);
		if(result<1) {
			throw new DeptException("부서삭제 실패");
		}
	}

}
