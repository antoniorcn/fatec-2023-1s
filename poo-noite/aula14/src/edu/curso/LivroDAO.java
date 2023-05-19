package edu.curso;

import java.sql.SQLException;
import java.util.List;

public interface LivroDAO {
	Livro adicionar(Livro l) throws SQLException;
	void atualizar(long id, Livro l) throws SQLException;
	void remover(long id) throws SQLException;
	List<Livro> procurarPorTitulo(String titulo) throws SQLException;
	Livro procurarPorId(long id) throws SQLException;
}
