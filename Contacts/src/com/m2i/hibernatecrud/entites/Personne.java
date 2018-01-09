package com.m2i.hibernatecrud.entites;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="personnes")
@Access(AccessType.FIELD)
public class Personne {
	
	@Id
	@GeneratedValue
	@Column(name="pers_id")
	private Integer id;
	
	@Column(name="pers_civilite")
	private Civilite civilite;
	
	@Column(name="pers_nom")
	private String nom;
	
	@Column(name="pers_prenom")
	private String prenom;
	
	@Column(name="pers_datenaissance")
	private Date dateNaissance;
	
	@Column(name="pers_numtel")
	private String numTel;
	
	@Column(name="pers_adresse")
	private String adresse;
	
	@Column(name="pers_cp")
	private String cp;
	
	@Column(name="pers_ville")
	private String ville;

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getId() {
		return id;
	}
	
	
}
