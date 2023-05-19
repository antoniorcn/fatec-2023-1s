package edu.curso;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DespesaDAOImpl implements DespesaDAO {
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mariadb:"
										+ "//localhost:3306/despesas?allowMultiQueries=true";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "";
	private Connection con;
	public DespesaDAOImpl() throws 
			ClassNotFoundException, SQLException { 
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(JDBC_URL, 
					JDBC_USER, JDBC_PASS);
	}
	@Override
	public Despesa adicionar(Despesa d) throws SQLException {
		String sql = "INSERT INTO despesas (razao, data, valor) "
				+ "VALUES (?, ?, ?)";
		PreparedStatement st = 
				con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		st.setString(1, d.getRazao());
		st.setDate(2, Date.valueOf(d.getData()));
		st.setDouble(3, d.getValor());
		st.executeUpdate();
		ResultSet rs = st.getGeneratedKeys();
	    if (rs.next()) {
	       d.setId(rs.getInt(1));
	    }
	    return d;
	}

	@Override
	public void remover(long id) 
			throws SQLException {
		String sql = "DELETE FROM despesas WHERE id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, id);
		st.executeUpdate();	
	}

	@Override
	public void atualizar(long id, Despesa d) 
			throws SQLException {
		String sql = "UPDATE despesas SET razao=?, data=?, valor=? "
				+ " WHERE id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, d.getRazao());
		st.setDate(2, Date.valueOf(d.getData()));
		st.setDouble(3, d.getValor());
		st.setDouble(4, id);
		st.executeUpdate();		
	}

	@Override
	public List<Despesa> pesquisarPorRazao(String razao) 
		throws SQLException {
		List<Despesa> lista = new ArrayList<>();
		String sql = "SELECT * FROM despesas "
				+ "WHERE razao LIKE ?"; 
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%" + razao + "%");
		ResultSet rs = st.executeQuery();
		while (rs.next()) { 
			Despesa d = new Despesa();
			d.setId( rs.getLong("id") );
			d.setRazao( rs.getString("razao") );
			d.setData( rs.getDate("data").toLocalDate() );
			d.setValor( rs.getDouble("valor") );
			lista.add(d);
		}
		return lista;
	}

	@Override
	public Despesa pesquisarporId(long id) 
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
