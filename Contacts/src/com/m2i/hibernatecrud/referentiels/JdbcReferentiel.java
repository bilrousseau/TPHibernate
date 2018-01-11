package com.m2i.hibernatecrud.referentiels;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.m2i.hibernatecrud.db.DB;
import com.m2i.hibernatecrud.entites.Civilite;
import com.m2i.hibernatecrud.entites.Personne;

public class JdbcReferentiel implements IReferentiel {
	private List<Personne> listePersonnesStatic;

	public JdbcReferentiel() {
		this.listePersonnesStatic = new ArrayList<Personne>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			listePersonnesStatic.add(new Personne(Civilite.M, "Besson", "Luc", sdf.parse("1959-13-18"), "0000000000", "5 avenue de l'Element", "75015", "Paris"));
			listePersonnesStatic.add(new Personne(Civilite.MME, "Ullmann", "Liv", sdf.parse("1938-12-16"), "0101010101", "1-16-5 Kabuchi-chô", "22", "Tokyo"));
			listePersonnesStatic.add(new Personne(Civilite.M, "Lynch", "David", sdf.parse("1946-01-20"), "0202020202", "423 Fire Terrace", "59801", "Missoula"));
			listePersonnesStatic.add(new Personne(Civilite.M, "Chéreau", "Patrice", sdf.parse("1944-11-02"), "0303030303", "13 rue d'Anjou", "49430", "Lezigné"));
			listePersonnesStatic.add(new Personne(Civilite.M, "Tarantino", "Quentin", sdf.parse("1963-03-27"), "0404040404", "722 Muroran Street", "37909", "Knoxville"));
			listePersonnesStatic.add(new Personne(Civilite.MLE, "Huppert", "Isabelle", sdf.parse("1953-03-16"), "0505050505", "4 place de Barcelone", "75016", "Paris"));
			
			for (Personne p : listePersonnesStatic) {
				this.insererPersonne(p);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Personne> recupererToutesPersonnes() {
		return null;
	}

	@Override
	public Personne recupererPersonne(Integer id) {
		return null;
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
			System.out.println("Erreur d'insertion de personne pour le JDBCReferentiel ");
			System.out.println("Message : " +e.getMessage());
			return false;
		}
		
	}
	
	@Override
	public Boolean modifierPersonne(Integer id, Personne p) {
		return null;
	}

	@Override
	public Boolean supprimerPersonne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean personneExiste(Personne p) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
