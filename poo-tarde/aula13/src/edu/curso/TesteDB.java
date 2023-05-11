package edu.curso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TesteDB {
	public static void main(String[] args) {
		File f = new File("./config.properties");
		System.out.println(f.getAbsolutePath());
		try (InputStream input = new FileInputStream(f)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            String driver = prop.getProperty("db.driver");
            String JDBC_URL = "jdbc:mariadb://localhost:3306/test";
            String JDBC_USER = "root";
            String JDBC_PASS = "";
            Class.forName(driver);
			System.out.println("Driver Mariadb carregado");
			Connection con = 
					DriverManager.getConnection(
							JDBC_URL, 
							JDBC_USER, 
							JDBC_PASS);
			System.out.println("Conectado no banco de dados");
		} catch(ClassNotFoundException e) { 
			System.out.println("Erro ao carregar a classe:");
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
