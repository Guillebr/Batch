package com.Batch;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Cities {
	
	public static void addCities(String filename){
		try {
			Connection con = (Connection) JDBCConfiguration.getConnection();

			Statement statement = (Statement) con.createStatement();
		 
			String queryCleanTable = "TRUNCATE cities;";
						
			statement.executeUpdate(queryCleanTable);
			System.out.println("Query TRUNCATE Table OK !");
			
			String queryAddCities = "LOAD DATA LOCAL INFILE '"+filename+"' INTO TABLE cities  FIELDS" + 
					 " TERMINATED BY ';' IGNORE 1 LINES (Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, coordonnes_gps)";

			statement.executeQuery(queryAddCities);
			System.out.println("Query LOAD DATA from CVS file OK !");

			statement.close();
		    
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Bad Query !");
		}
	}
}
