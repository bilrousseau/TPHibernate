package com.m2i.hibernatecrud.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.m2i.hibernatecrud.entites.Civilite;
import com.m2i.hibernatecrud.entites.Personne;
import com.m2i.hibernatecrud.referentiels.HibernateReferentiel;

public class Tester {

	public static void main(String[] args) {
		HibernateReferentiel hibRef = new HibernateReferentiel();
		
		Personne p = hibRef.recupererPersonne(1);
		System.out.println(p);
		
		Personne p2 = new Personne();
		p2.setNom("Bill");
		p2.setPrenom("Rousseau");
		p2.setCivilite(Civilite.M);
		p2.setNumTel("0648665915");
		p2.setAdresse("2 rue du Miroir");
		p2.setCp("77000");
		p2.setVille("Melun");
		try {
			p2.setDateNaissance(new SimpleDateFormat("yyyy-MM-dd").parse("1986-03-27"));
		} catch (ParseException e) {
			p2.setDateNaissance(null);
			e.printStackTrace();
		}
		
		hibRef.insererPersonne(p2);
		System.out.println("Fin de programme Tester ...");
	}

}
