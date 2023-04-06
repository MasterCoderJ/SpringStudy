package com.edu.springshop.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.model.category.CategoryService;

//쇼핑몰 어플리케이션에 전반적으로 적용 될 수 있는 공통 코드를 AOP의 
//advice로 정의해놓자,필요한 곳에 적용시켜 본다

public class CategoryAdvice {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoryService categoryService;
	
	//아래 메서드에서 서비스의 selectAll을 호출하여 ModelAndView에 저장
	public Object getCategoryList(ProceedingJoinPoint joinPoint) {
		//원래 호출하려던 메서드를 호출전, 후에 관여 할 수 있는 기능을 지원
		String target= joinPoint.getTarget().getClass().getName();
		logger.info("원래 호출하려던 객체는 타겟은?"+target);
		
		Signature sig= joinPoint.getSignature();
		String method= sig.getName();
		logger.info("원래 호출하려던 메서드는"+method);
		
		//원래는 컨트롤러들에서 매번 수행해야 했던 Category 가져오기 공통 코드를
		//여기서 수행해버리자!
		List categoryList= categoryService.selectAll();
		
		//원래 호출하려던 메서드를 진행시킨다
		Object returnObj=null;
		ModelAndView mav= null;
		
		try {
			returnObj= joinPoint.proceed(); //원래 호출하려던 메서드 호출 여기서함(shop컨트롤러에 있는 mav를 당겨온거랑 비슷)
			
			if(returnObj instanceof ModelAndView) { //returnObj의 자료형이 ModelAndView라면...
				mav= (ModelAndView)returnObj;
				mav.addObject("categoryList", categoryList);
				returnObj=mav; //반환값에 mav로 대입
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return returnObj;
	}
}
