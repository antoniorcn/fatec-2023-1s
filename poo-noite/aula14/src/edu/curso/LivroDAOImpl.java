package edu.curso;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl implements LivroDAO {
	private static final String JDBC_DRIVER = 
			"org.mariadb.jdbc.Driver";
	private static final String JDBC_URL = 
			"jdbc:mariadb://localhost:3306/livraria?allowMultiQueries=true";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "";
	private Connection con;
	
	public LivroDAOImpl() 
			throws ClassNotFoundException, SQLException { 
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(
				JDBC_URL, JDBC_USER, JDBC_PASS);

	}

	@Override
	public Livro adicionar(Livro l) throws SQLException {
		String sql = "INSERT INTO livros "
				+ "(titulo, paginas, publicacao) "
				+ "VALUES (?, ?, ?)";
		
		PreparedStatement st = 
			con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		st.setString(1, l.getTitulo());
		st.setInt(2, l.getPaginas());
		st.setDate(3, Date.valueOf(l.getDataPublicacao()));
		st.executeUpdate();
		ResultSet rs = st.getGeneratedKeys();
		if (rs.next()) { 
			long id = rs.getLong(1);
			l.setId(id);
		}
		return l;
	}

	@Override
	public void atualizar(long id, Livro l) throws SQLException {
		String sql = "UPDATE livros SET titulo = ?, "
				+ "publicacao = ?, paginas = ? WHERE id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, l.getTitulo());
		st.setDate(2, Date.valueOf(l.getDataPublicacao()));
		st.setInt(3, l.getPaginas());
		st.setLong(4, id);
		st.executeUpdate();
		
	}

	@Override
	public void remover(long id) throws SQLException {
		String sql = "DELETE FROM livros WHERE id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, id);
		st.executeUpdate();
	}

	@Override
	public List<Livro> procurarPorTitulo(String titulo)
		throws SQLException {
		List<Livro> lista = new ArrayList<>();
		String sql = "SELECT * FROM livros WHERE titulo "
				+ "LIKE ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%" + titulo + "%");
		ResultSet rs = st.executeQuery();
		while( rs.next() ) { 
			Livro l = new Livro();
			l.setId(rs.getLong("id"));
			l.setTitulo(rs.getString("titulo"));
			Date dt = rs.getDate("publicacao");
			l.setDataPublicacao(dt.toLocalDate());
			l.setPaginas(rs.getInt("paginas"));
			lista.add(l);
		}
		return lista;
	}

	@Override
	public Livro procurarPorId(long id) throws SQLException {
		String sql = "SELECT * FROM livros WHERE id = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, id);
		ResultSet rs = st.executeQuery();
		if ( rs.next() ) { 
			Livro l = new Livro();
			l.setId(rs.getLong("id"));
			l.setTitulo(rs.getString("titulo"));
			Date dt = rs.getDate("publicacao");
			l.setDataPublicacao(dt.toLocalDate());
			l.setPaginas(rs.getInt("paginas"));
			return l;
		}
		return null;
	}

}
