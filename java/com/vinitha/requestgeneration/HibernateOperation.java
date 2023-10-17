package com.vinitha.requestgeneration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import jakarta.persistence.criteria.CriteriaQuery;

public class HibernateOperation {

	
	
	public static Session createSession(Class<Object> s[]) {
		Configuration configuration=new Configuration().configure();
		for (Class<Object> class1 : s) {
			configuration.addAnnotatedClass(class1);
		}
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		 Session session=sessionFactory.openSession();
		
		return session;
		
	}

	public static <T> List<T> loadAllData(Class<T> type, Session session) {
	    HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<T> criteria = builder.createQuery(type);
	    criteria.from(type);
	    List<T> data = session.createQuery(criteria).getResultList();
	    return data;
	  }
}
