package com.m2i.hibernatecrud.entites;

public enum Civilite {
	M("Monsieur", "M"),
	MME("Madame", "Mme"),
	MLE("Mademoiselle", "Mlle");
	
	private String nom;
	private String nomCourt;
	
	private Civilite(String nom, String nomCourt) {
		this.nom = nom;
		this.nomCourt = nomCourt;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomCourt() {
		return nomCourt;
	}

	public void setNomCourt(String nomCourt) {
		this.nomCourt = nomCourt;
	}
	
}
