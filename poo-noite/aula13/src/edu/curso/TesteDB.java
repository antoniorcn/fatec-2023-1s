package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	public static void main(String[] args) {
		try { 
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Classe carregada");
			Connection con = DriverManager.getConnection(
			"jdbc:mariadb://localhost:3306/test", "root", "");
			System.out.println("Conexão estabelecida");			
			inserir(con);
		} catch(ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
	}
}
