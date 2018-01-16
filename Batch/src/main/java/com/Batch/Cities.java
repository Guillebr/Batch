package com.Batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Cities {
	
	public static void addCities(String filename){
		try {
			Connection con = (Connection) JDBCConfiguration.getConnection();

			Statement statement = (Statement) con.createStatement();
		 
			String query = "LOAD DATA LOCAL INFILE '"+filename+"' INTO TABLE cities  FIELDS" + 
					 " TERMINATED BY ';' (Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, coordonnes_gps)";
			
			ResultSet resultSet = statement.executeQuery(query);
			System.out.println("Query OK !");
			resultSet.close();
			statement.close();
		    
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Bad Query !");
		}
	}
}
