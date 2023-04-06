package com.edu.hibernateapp.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.edu.hibernateapp.domain.Notice;
import com.edu.hibernateapp.hibernate.HibernateConfig;

public class NoticeDAO {
	
	HibernateConfig config= HibernateConfig.getInstance();
	
	public void insert() {
		SessionFactory factory= config.getSessionFactory();
		
		Session session= factory.openSession();
		org.hibernate.Transaction tx= session.beginTransaction();
		
		Notice notice= new Notice();
		notice.setTitle("하이버네이트");
		notice.setWriter("sk");
		notice.setContent("gdgd");
		
		session.save(notice);
		tx.commit();
		config.release(factory);
	}

}
