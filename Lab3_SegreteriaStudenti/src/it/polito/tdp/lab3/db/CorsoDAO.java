package it.polito.tdp.lab3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab3.model.Corso;

public class CorsoDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root";
	
	
	public List<Corso> popolaTendina(){
		
		List<Corso> c=new ArrayList<Corso>();
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);

			Statement st = conn.createStatement();

			String sql = "SELECT codins, crediti,nome,pd FROM corso";

			ResultSet res = st.executeQuery(sql);

			while(res.next()){
				Corso temp=new Corso(res.getString("codins"),res.getInt("crediti"),res.getString("nome"),res.getString("pd"));
				c.add(temp);
			}
			res.close();
			conn.close();
			return c;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
