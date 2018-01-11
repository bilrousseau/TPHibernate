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
	
	@Temporal(TemporalType.DATE)
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

	public Personne() {}
	
	public Personne(Civilite civilite, String nom, String prenom, Date dateNaissance, String numTel, String adresse,
			String cp, String ville) {
		super();
		this.civilite = civilite.getNomCourt();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.numTel = numTel;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
	}



	public Personne(Integer id, Civilite civilite, String nom, String prenom, Date dateNaissance, String numTel,
			String adresse, String cp, String ville) {
		this.id = id;
		this.civilite = civilite.getNomCourt();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.numTel = numTel;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
	}



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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((civilite == null) ? 0 : civilite.hashCode());
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((numTel == null) ? 0 : numTel.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (civilite == null) {
			if (other.civilite != null)
				return false;
		} else if (!civilite.equals(other.civilite))
			return false;
		if (cp == null) {
			if (other.cp != null)
				return false;
		} else if (!cp.equals(other.cp))
			return false;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numTel == null) {
			if (other.numTel != null)
				return false;
		} else if (!numTel.equals(other.numTel))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", numTel=" + numTel + ", adresse=" + adresse + ", cp=" + cp
				+ ", ville=" + ville + "]";
	}
	
}
