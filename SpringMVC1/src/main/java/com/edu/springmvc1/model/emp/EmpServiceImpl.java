package com.edu.springmvc1.model.emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springmvc1.domain.Emp;
import com.edu.springmvc1.exception.DeptException;
import com.edu.springmvc1.exception.EmpException;
import com.edu.springmvc1.mybatis.MybatisConfig;

import lombok.Setter;

/*
 * 이 객체는 모델 파트에서의 서비스 역할을 수행한다 
 * 만일 서비스의 존재가 없을 경우, 컨트롤러가 너무 세부적인 model
 * 영역의 업무를 수행하게 된다 
 * 또한 트랜잭션  상황에서 각각의 DAO들의 업무수행이 성공했는지 여부를
 * 판단하여 트랜잭션을  commit할지  rollback을 결정짓는 역할 수행한다
 * 주의) 직접 일하지않고 각종 모델영역의 객체들에게 일을 시킨다 
 * 
 * */
/*어노테이션을 붙여놓으면, 스프링의 컴포넌트로 인식되어, 자동 검색에 걸리게 되어
 * 인스턴스를 빈으로 올려준다...*/
@Service
@Setter
public class EmpServiceImpl implements EmpService{
	MybatisConfig config=MybatisConfig.getInstance();
	
	//자동주입(xml에 명시하지 않아도 주입을 처리)
	@Autowired 
	private DeptDAO deptDAO; //사원
	
	//자동주입(xml에 명시하지 않아도 주입을 처리)
	@Autowired
	private EmpDAO empDAO; //사원
	
	
	//사원등록 
	public void regist(Emp emp) {
		//세션 얻어와서 배분하기 (주입)
		SqlSession sqlSession=config.getSqlSession();
		deptDAO.setSqlSession(sqlSession);
		empDAO.setSqlSession(sqlSession);
		
		try {
			deptDAO.insert(emp.getDept());// 부서등록
			empDAO.insert(emp); //사원등록
			sqlSession.commit();
		} catch (DeptException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} catch (EmpException e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			config.release(sqlSession);
		}
	}
	
	public List selectAll() {
		SqlSession sqlSession = config.getSqlSession();
		empDAO.setSqlSession(sqlSession);
		List list = empDAO.selectAll(); 
		config.release(sqlSession);
		return list;
	}
	
	public Emp select(int empno) {
		SqlSession sqlSession = config.getSqlSession();
		empDAO.setSqlSession(sqlSession);
		Emp emp=empDAO.select(empno);
		config.release(sqlSession);
		return emp;
	}
	
	//사원 퇴사처리 (부서, 사원 둘다 삭제) 
	public void remove(Emp emp) {
		SqlSession sqlSession = config.getSqlSession();
		empDAO.setSqlSession(sqlSession);
		deptDAO.setSqlSession(sqlSession);
		
		try {
			empDAO.delete(emp.getEmpno());//사원삭제
			deptDAO.delete(emp.getDept().getDeptno());//부서삭제
			sqlSession.commit();
		} catch (EmpException e) {
			e.printStackTrace();
			sqlSession.rollback();
		} catch (DeptException e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			config.release(sqlSession);
		}
		
		
	}
}










