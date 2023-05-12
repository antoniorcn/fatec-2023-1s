package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteDB {

	public static void main(String[] args) {
		try { 
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Classe carregada");
			Connection con = DriverManager.getConnection(
			"jdbc:mariadb://localhost:3306/test", "root", "");
			System.out.println("Conexão estabelecida");
		} catch(ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
	}
}
