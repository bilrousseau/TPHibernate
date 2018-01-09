package com.m2i.hibernatecrud.entites;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="personnes")
@Access(AccessType.FIELD)
public class Personne {
	
	@Id
	@GeneratedValue
	@Column(name="pers_id", nullable=false)
	private Integer id;
	
	@Column(name="pers_civilite", nullable=false)
	private String civilite;
	
	@Column(name="pers_nom", nullable=false)
	private String nom;
	
	@Column(name="pers_prenom", nullable=false)
	private String prenom;
	
	@Column(name="pers_datenaissance")
	private Date dateNaissance;
	
	@Column(name="pers_numtel", nullable=false)
	private String numTel;
	
	@Column(name="pers_adresse", nullable=false)
	private String adresse;
	
	@Column(name="pers_cp", nullable=false)
	private String cp;
	
	@Column(name="pers_ville", nullable=false)
	private String ville;

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite.getNomCourt();
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

	@Override
	public String toString() {
		return "Personne [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", numTel=" + numTel + ", adresse=" + adresse + ", cp=" + cp
				+ ", ville=" + ville + "]";
	}
	
}
