package it.polito.tdp.lab3.model;

import java.util.List;

import it.polito.tdp.lab3.db.CorsoDAO;
import it.polito.tdp.lab3.db.StudenteDAO;

public class SegreteriaStudentiModel {

	public List<Corso> popolaTendina(){
		
		CorsoDAO cD=new CorsoDAO();
		return cD.popolaTendina();
	}
	
	public Studente cercaStudente(String matricola){
		StudenteDAO sD= new StudenteDAO();
		
		return sD.cercaStudente(matricola);
	}
	
}
