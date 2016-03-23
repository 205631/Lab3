package it.polito.tdp.lab3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
