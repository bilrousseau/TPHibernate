package com.m2i.hibernatecrud.referentiels;

import java.util.List;

import com.m2i.hibernatecrud.entites.Personne;

public interface IReferentiel {
	List<Personne> recupererToutesPersonnes();
	
	Personne recupererPersonne(Integer id);
	
	Boolean insererPersonne(Personne p);
	
	Boolean modifierPersonne(Integer id, Personne p);
	
	Boolean supprimerPersonne(Integer id);
	
	Boolean personneExiste(Personne p);
}
