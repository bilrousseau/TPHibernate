package com.m2i.hibernatecrud.referentiels;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.m2i.hibernatecrud.entites.Personne;
import com.m2i.hibernatecrud.utils.HibernateUtils;

public class HibernateReferentiel implements IReferentiel {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public List<Personne> recupererToutesPersonnes() {
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		
		TypedQuery<Personne> query = session.createQuery("from Personne");
		List<Personne> personneList = query.getResultList();
		
		session.close();
		sessionFactory.close();
		return personneList;
	}
	
	@Override
	public Personne recupererPersonne(Integer id) {
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		
		Personne p = session.get(Personne.class, id);
		
		session.close();
		sessionFactory.close();
		
		return p;
	}

	@Override
	public Boolean insererPersonne(Personne p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean modifierPersonne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean supprimerPersonne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean personneExiste(Personne p) {
		// TODO Auto-generated method stub
		return null;
	}

}
