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
	
	public List<Studente> listaStudentiIscritti(Corso c){
		StudenteDAO sd=new StudenteDAO();
		return sd.listaStudentiIscritti(c);
	}
	
	public List<Corso> listaCorsiFrequentati(Studente s){
		StudenteDAO sd=new StudenteDAO();
		return sd.listaCorsiFrequentati(s);
	}

	public boolean frequentaCorso(Studente s,Corso c){
		StudenteDAO sd=new StudenteDAO();
		return sd.frequentaCorso(s, c);
	}

	public boolean iscriviStudente(Studente s,Corso c){
		StudenteDAO sd=new StudenteDAO();
		return sd.iscriviStudente(s, c);
	}
	
}
