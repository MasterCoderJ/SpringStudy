package com.edu.mvc3.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application= sce.getServletContext();
		String dataPath= application.getInitParameter("dataPath");
		String path= application.getRealPath(dataPath);
		application.setAttribute("dataPath", path);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}

}
