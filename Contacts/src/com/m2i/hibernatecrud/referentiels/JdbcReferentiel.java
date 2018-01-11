package com.m2i.hibernatecrud.referentiels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.m2i.hibernatecrud.db.DB;
import com.m2i.hibernatecrud.entites.Civilite;
import com.m2i.hibernatecrud.entites.Personne;

public class JdbcReferentiel implements IReferentiel {
	private List<Personne> listePersonnes;
	
	public JdbcReferentiel() {
		this.listePersonnes = new ArrayList<Personne>();
	}
	
	public void initialiser() {
		this.effacerToutesPersonnes();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			listePersonnes.add(new Personne(Civilite.M, "Besson", "Luc", sdf.parse("1959-13-18"), "0000000000", "5 avenue de l'Element", "75015", "Paris"));
			listePersonnes.add(new Personne(Civilite.MME, "Ullmann", "Liv", sdf.parse("1938-12-16"), "0101010101", "1-16-5 Kabuchi-chô", "22", "Tokyo"));
			listePersonnes.add(new Personne(Civilite.M, "Lynch", "David", sdf.parse("1946-01-20"), "0202020202", "423 Fire Terrace", "59801", "Missoula"));
			listePersonnes.add(new Personne(Civilite.M, "Chéreau", "Patrice", sdf.parse("1944-11-02"), "0303030303", "13 rue d'Anjou", "49430", "Lezigné"));
			listePersonnes.add(new Personne(Civilite.M, "Tarantino", "Quentin", sdf.parse("1963-03-27"), "0404040404", "722 Muroran Street", "37909", "Knoxville"));
			listePersonnes.add(new Personne(Civilite.MLE, "Huppert", "Isabelle", sdf.parse("1953-03-16"), "0505050505", "4 place de Barcelone", "75016", "Paris"));
			
			for (Personne p : listePersonnes) {
				this.insererPersonne(p);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Personne> recupererToutesPersonnes() {
		List<Personne> toutesPersonnes = new ArrayList<Personne>();
		try {
			ResultSet rs = DB.executeSelect("SELECT * FROM personnes");
			while (rs.next()) {
				toutesPersonnes.add(this.recupererPersonneParChamps(rs));
			}
		} catch (Exception e) {
			System.out.println("Erreur lors de la récupération des personnes");
			System.out.println("Message : " + e.getMessage());	
		}
		return toutesPersonnes;
		
	}

	@Override
	public Personne recupererPersonne(Integer id) {
		Personne p = null;
		try {
			ResultSet rs = DB.executeSelect("SELECT * FROM personnes WHERE pers_id = " + DB.parseToSql(String.valueOf(id)) + ";");
			if (rs.next()) {
				return this.recupererPersonneParChamps(rs);
			}
			
		} catch (Exception e) {
			System.out.println("Erreur lors de la récupération d'une personne");
			System.out.println();
		}
		return p;
	}

	@Override
	public Boolean insererPersonne(Personne p) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String query = "INSERT INTO schema_contacts.personnes (pers_civilite, pers_nom, pers_prenom, pers_datenaissance, pers_numtel, pers_adresse, pers_cp, pers_ville)" 
					+ " VALUES ("
					+  DB.parseToSql(p.getCivilite()) +  ", " + DB.parseToSql(p.getNom())
					+  ", " + DB.parseToSql(p.getPrenom()) +  ", " + DB.parseToSql(sdf.format(p.getDateNaissance()))
					+  ", " + DB.parseToSql(p.getNumTel()) +  ", " + DB.parseToSql(p.getAdresse())
					+  ", " + DB.parseToSql(p.getCp()) +  ", " + DB.parseToSql(p.getVille())
					+ ");";
			System.out.println(query);
			return (DB.executeInsert(query) > 0);
		} catch (SQLException e) {
			System.err.println("Erreur d'insertion de personne pour le JDBCReferentiel ");
			System.err.println("Message : " +e.getMessage());
			return false;
		}
		
	}
	
	@Override
	public Boolean modifierPersonne(Integer id, Personne p) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List<String> queryStrings = new ArrayList<String>();
			String query = "UPDATE personnes SET ";
			
			//TODO : passer par la reflection pour éviter cette forêt de if dégueulasse
			//TODO : créer un tableau de correspondances entre les champs en base et les propriétés
			
			
			if (p.getCivilite() != null)
				queryStrings.add("pers_civilite = " + DB.parseToSql(p.getCivilite()));
			if (p.getNom() != null)
				queryStrings.add("pers_nom = " + DB.parseToSql(p.getNom()));
			if (p.getPrenom() != null)
				queryStrings.add("pers_prenom = " + DB.parseToSql(p.getPrenom()));
			if (p.getDateNaissance() != null)
				queryStrings.add("pers_datenaissance = " + DB.parseToSql(sdf.format(p.getDateNaissance())));
			if (p.getNumTel() != null)
				queryStrings.add("pers_numtel = " + DB.parseToSql(p.getNumTel()));
			if (p.getAdresse() != null)
				queryStrings.add("pers_adresse = " + DB.parseToSql(p.getAdresse()));
			if (p.getCp() != null)
				queryStrings.add("pers_cp = " + DB.parseToSql(p.getCp()));
			if (p.getVille() != null)
				queryStrings.add("pers_ville = " + DB.parseToSql(p.getVille()));
			
			for (String queryString : queryStrings) {
				query += queryString;
				// Vérifie que je ne suis pas le dernier élément de la liste
				if (!queryString.equals(queryStrings.get(queryStrings.size() - 1))) {
					query += ", ";
				}
			}
			query += " WHERE pers_id = " + DB.parseToSql(String.valueOf(id)) + ";";

			System.out.println(query);
			
			return DB.executeUpdate(query);
		} catch (SQLException e) {
			System.err.println("Erreur de modification de personne");
			System.err.println("Message : " + e.getMessage());
			return false;
		}
		
	}

	@Override
	public Boolean supprimerPersonne(Integer id) {
		try {
			return DB.executeDelete("DELETE FROM personnes WHERE pers_id = "+DB.parseToSql(String.valueOf(id)) + ";");
		} catch (SQLException e) {
			System.err.println("Erreur lors de la suppression de personne.");
			System.err.println("Message : " + e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean personneExiste(Personne p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Boolean effacerToutesPersonnes() {
		try {
			return DB.executeDelete("DELETE FROM personnes");
		} catch (SQLException e) {
			System.err.println("Erreur lors de la suppression de personne.");
			System.err.println("Message : " + e.getMessage());
			return false;
		}
	}
	
	private Civilite recupererCivParNom(String civNomCourt) throws Exception {
		if (civNomCourt.equals("M")) {
			return Civilite.M;
		} else if (civNomCourt.equals("Mme")) {
			return Civilite.MME;
		} else if (civNomCourt.equals("Mlle")) {
			return Civilite.MLE;
		} else {
			throw new Exception("Civilité inconnue");
		}
	}
	
	private Personne recupererPersonneParChamps(ResultSet rs) throws SQLException, Exception {
		return new Personne(
			rs.getInt("pers_id"), this.recupererCivParNom(rs.getString("pers_civilite")), rs.getString("pers_nom"),
			rs.getString("pers_prenom"), rs.getDate("pers_datenaissance"),
			rs.getString("pers_numtel"), rs.getString("pers_adresse"),
			rs.getString("pers_cp"), rs.getString("pers_ville")
		);
	}
	
}
