package com.m2i.hibernatecrud.test;

import com.m2i.hibernatecrud.entites.Personne;
import com.m2i.hibernatecrud.referentiels.HibernateReferentiel;

public class Tester {

	public static void main(String[] args) {
		HibernateReferentiel hibRef = new HibernateReferentiel();
		
		Personne p = hibRef.recupererPersonne(1);
		System.out.println(p);
	}

}
