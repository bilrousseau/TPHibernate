package com.m2i.hibernatecrud.referentiels;

import com.m2i.hibernatecrud.entites.Personne;

public interface IReferentiel {
	Personne getPersonne(Integer id);
	
	Boolean insererPersonne(Personne p);
	
	Boolean modifierPersonne(Integer id);
	
	Boolean supprimerPersonne(Integer id);
	
	Boolean personneExiste(Personne p);
}
