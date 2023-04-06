package com.edu.hibernateapp.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	
	private static HibernateConfig instance;
	
	private SessionFactory sessionFactory;
	
	String resource="com/edu/hibernateapp/hibernate/hibernate.cfg.xml";
	
	public HibernateConfig() {
		
		Configuration config= new Configuration().configure(resource);
		StandardServiceRegistryBuilder sb= new StandardServiceRegistryBuilder();
		sb.applySettings(config.getProperties());
		
		StandardServiceRegistry registry= sb.build();
		sessionFactory= config.buildSessionFactory(registry);
			
	}
	
	public static HibernateConfig getInstance() {
		if(instance==null) {
			instance= new HibernateConfig();
		}
		return instance;
	}
	
	public SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}
	
	public void release(SessionFactory sessionFactory) {
		sessionFactory.close();
	}

}
