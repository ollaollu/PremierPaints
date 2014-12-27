/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ollaollu
 * 
 * utility 'bypass' method to work with search methods who make calls to the database
 */
public class PremierConnection implements Serializable {
    
        //DB static variables for database values
	private final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_CONNECTION = "jdbc:mysql://localhost:3306/premierpaints";
	private final String DB_USER = "root";
	private final String DB_PASSWORD = "admin";
        
        private Connection DBConnection;
        
        //this is used to connect to our database
	public Connection getDBConnection() {
 
		Connection dbConnection = null;
 
		try {
 
			Class.forName(DB_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
 
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
                        return dbConnection;
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
                        return dbConnection;
	} 

}
