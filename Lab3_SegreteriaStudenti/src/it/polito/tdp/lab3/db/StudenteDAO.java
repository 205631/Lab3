package it.polito.tdp.lab3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab3.model.Corso;
import it.polito.tdp.lab3.model.Studente;

public class StudenteDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root";

	public Studente cercaStudente(String matricola){
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);

			Statement st = conn.createStatement();

			String sql = "SELECT matricola,nome,cognome,cds FROM studente where matricola=\""+matricola+"\"";

			ResultSet res = st.executeQuery(sql);
			
			if(res.next()){
				Studente s=new Studente(res.getString("matricola"),res.getString("nome"),res.getString("cognome"),res.getString("cds"));
				return s;
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Studente> listaStudentiIscritti(Corso c){
		
		List<Studente> l= new ArrayList<Studente>();
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);

			Statement st = conn.createStatement();
			String sql="";
			
			if(c.getCrediti()==-1){
				sql = "select S.matricola,S.nome,S.cognome,S.cds from studente S,corso C, iscrizione I where S.matricola=I.matricola and C.codins=I.codins";	
			}else{
				sql = "select S.matricola,S.nome,S.cognome,S.cds from studente S,corso C, iscrizione I where S.matricola=I.matricola and C.codins=I.codins and I.codins='"+c.getCodiceCorso()+"'";
			}
			
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()){
				Studente s=new Studente(res.getString("matricola"),res.getString("nome"),res.getString("cognome"),res.getString("cds"));
				l.add(s);
			}
			return l;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
