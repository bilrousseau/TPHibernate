package com.m2i.hibernatecrud.entites;

public enum Civilite {
	M("Monsieur"),
	MME("Madame"),
	MLE("Mademoiselle");
	
	private String nom;
	
	private Civilite(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
