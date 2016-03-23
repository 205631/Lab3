package it.polito.tdp.lab3.model;

import java.util.List;

import it.polito.tdp.lab3.db.CorsoDAO;

public class SegreteriaStudentiModel {

	public List<Corso> popolaTendina(){
		
		CorsoDAO cD=new CorsoDAO();
		return cD.popolaTendina();
	}
	
}
