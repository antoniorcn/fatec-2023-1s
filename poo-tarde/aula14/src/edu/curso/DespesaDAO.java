package edu.curso;

import java.sql.SQLException;
import java.util.List;

public interface DespesaDAO {
	
	public Despesa adicionar(Despesa d) throws SQLException;
	public void remover(long id) throws SQLException;
	public void atualizar(long id, Despesa d) throws SQLException;
	public List<Despesa> pesquisarPorRazao(String razao) throws SQLException;
	public Despesa pesquisarporId(long id) throws SQLException;

}
