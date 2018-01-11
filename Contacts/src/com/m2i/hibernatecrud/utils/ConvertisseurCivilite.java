package com.m2i.hibernatecrud.utils;

import com.m2i.hibernatecrud.entites.Civilite;

public class ConvertisseurCivilite {

	public Civilite recupererCivParNom(String civNomCourt) throws Exception {
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
}
