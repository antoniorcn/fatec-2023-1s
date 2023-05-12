package edu.curso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class TesteDB {
	
	public static void inserir(Connection con) throws SQLException{ 
		PreparedStatement pst = 
				con.prepareStatement("INSERT INTO agenda "
				+ "(nome, telefone, email) VALUES ('João Silva', "
				+ "'(11) 1234-5678', 'joao@teste.com')");
			int linhas = pst.executeUpdate();
			System.out.println("Foram afetadas " + linhas + " no banco");
	}
	
	public static void consultar(Connection con) throws SQLException { 
		PreparedStatement pst = 
				con.prepareStatement("SELECT * FROM agenda");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) { 
			String nome = rs.getString("nome");
			String tel = rs.getString("telefone");
			String email = rs.getString("email");
			System.out.printf("%s\t%s\t%s%n", nome, tel, email);
		}
	}
	
	public static void main(String[] args) {
		File f = new File("./config.properties");
		System.out.println(f.getAbsolutePath());
		try (InputStream input = new FileInputStream(f)) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            Class.forName(prop.getProperty("db.driver"));
			System.out.println("Driver Mariadb carregado");
			Connection con = 
					DriverManager.getConnection(
							prop.getProperty("db.url"), 
							prop.getProperty("db.user"), 
							prop.getProperty("db.pass"));
			System.out.println("Conectado no banco de dados");
			consultar(con);
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
