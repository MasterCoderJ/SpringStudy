package com.edu.db.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{

	/*
	 ApplicationContext -> Spring 컨테이너
	 ServletContext -> 어플리케이션 내장객체의 자료형
	 ServletConfig -> 스프링의 생명주기 중 init()매개변수로써 init-param 값을 가지고 있거나
	 						ServletContext를 얻어올때 사용되는 환경정보 객체
	 */
	public void contextInitialized(ServletContextEvent sce) {
		//어플리케이션 내장객체 얻기
		ServletContext application= sce.getServletContext();
		String savePath= sce.getServletContext().getInitParameter("savePath");
		savePath= application.getRealPath(savePath);
		application.setAttribute("savePath", savePath);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
