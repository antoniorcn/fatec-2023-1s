package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteDB {
	
	public static void inserir(Connection con) throws SQLException {
		String sql = "INSERT INTO contatos "
		+ "(nome, telefone, email) VALUES "
		+ "('João Silva', '(11) 1111-11111', 'joao@teste.com')";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.executeUpdate();
		System.out.println("Registro inserido com sucesso");
	}
	
	public static void consultar(Connection con) throws SQLException {
		String sql = "SELECT * FROM contatos";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while (rs.next()) { 
			String nome = rs.getString("nome");
			String tel = rs.getString("telefone");
			String email = rs.getString("email");
			
			System.out.printf("%s\t%s\t%s%n", nome, tel, email);
		}
	}
	
	public static void main(String[] args) {
		try { 
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Classe carregada");
			Connection con = DriverManager.getConnection(
			"jdbc:mariadb://localhost:3306/test", "root", "");
			System.out.println("Conexão estabelecida");			
			consultar(con);
		} catch(ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
	}
}
