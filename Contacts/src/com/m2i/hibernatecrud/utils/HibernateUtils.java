package com.m2i.hibernatecrud.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtils {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			return createSessionFactory();
		}
		return sessionFactory;
	}
	
	private static SessionFactory createSessionFactory() {
		try {
			return new MetadataSources(new StandardServiceRegistryBuilder().configure("contacts-config.xml").build()).getMetadataBuilder().build().getSessionFactoryBuilder().build();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Session factory build failed ");
		}

	}
}
