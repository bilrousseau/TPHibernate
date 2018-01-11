package com.m2i.hibernatecrud.referentiels;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.m2i.hibernatecrud.db.DB;
import com.m2i.hibernatecrud.entites.Civilite;
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
		
		try {
			return session.get(Personne.class, id);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println(this.getClass().getSimpleName() + " : erreur lors de la récupération de personne");
			System.out.println("Message : " + e.getMessage());
			return null;
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public Boolean insererPersonne(Personne p) {
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		try {
			session.save(p);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println(this.getClass().getSimpleName() + " : erreur lors de la création de personne");
			System.out.println("Message : " + e.getMessage());
			return false;
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public Boolean modifierPersonne(Integer id, Personne pNouveau) {
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		
		Personne pAncien = session.get(Personne.class, id);

		//TODO : passer par la reflection pour éviter cette forêt de if dégueulasse
		//TODO : créer une table de correspondances entre les champs en base et les propriétés
		
		if (pNouveau.getCivilite() != null)
			pAncien.setCivilite(pNouveau.getCivilite());
		if (pNouveau.getNom() != null)
			pAncien.setNom(pNouveau.getNom());
		if (pNouveau.getPrenom() != null)
			pAncien.setPrenom(pNouveau.getPrenom());
		if (pNouveau.getDateNaissance() != null)
			pAncien.setDateNaissance(pNouveau.getDateNaissance());
		if (pNouveau.getNumTel() != null)
			pAncien.setNumTel(pNouveau.getNumTel());
		if (pNouveau.getAdresse() != null)
			pAncien.setAdresse(pNouveau.getAdresse());
		if (pNouveau.getCp() != null)
			pAncien.setCp(pNouveau.getCp());
		if (pNouveau.getVille() != null)
			pAncien.setVille(pNouveau.getVille());
				
		try {
			session.update(pAncien);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println(this.getClass().getSimpleName() + " : erreur lors de la modification de personne");
			System.out.println("Message : " + e.getMessage());
			return false;
		} finally {
			session.close();
			sessionFactory.close();
		}
		
	}

	@Override
	public Boolean supprimerPersonne(Integer id) {
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		
		try {
			Personne p = session.get(Personne.class, id);
			session.delete(p);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println(this.getClass().getSimpleName() + " : erreur lors de la suppression de personne");
			System.out.println("Message : " + e.getMessage());
			return false;
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public Boolean personneExiste(Personne p) {
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		
		try {
			return p.equals(session.get(Personne.class, p.getId()));
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " : erreur lors de l'opération de vérification de l'existence d'une personne");
			System.out.println("Message : " + e.getMessage());
			return false;
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
