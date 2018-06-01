package com.study.dao.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DBUtility {
	private static SessionFactory factory;
	
	
	public static SessionFactory getConnection(){
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		return factory;
	}

}
