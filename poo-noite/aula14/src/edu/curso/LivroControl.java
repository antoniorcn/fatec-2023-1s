package edu.curso;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LivroControl {
	private LongProperty id = new SimpleLongProperty(0);
	private StringProperty titulo = new SimpleStringProperty("");
	private IntegerProperty paginas = new SimpleIntegerProperty(0);
	private ObjectProperty<LocalDate> publicacao = 
			new SimpleObjectProperty<>(LocalDate.now()); 
	private LivroDAO livroDao;
	private long contadorId = 1;
	
	private ObservableList<Livro> lista = 
				FXCollections.observableArrayList();

	public LivroControl() 
			throws ClassNotFoundException, SQLException { 
		livroDao = new LivroDAOImpl();
	}
	
	public void novo() { 
		id.set(0);
		titulo.set("");
		paginas.set(0);
		publicacao.set(LocalDate.now());
	}
	
	public void excluir(Livro l) throws SQLException { 
		lista.remove(l);
		livroDao.remover(l.getId());
	}
	
	public void fromEntity(Livro l) { 
		id.set(l.getId());
		titulo.set(l.getTitulo());
		paginas.set(l.getPaginas());
		publicacao.set(l.getDataPublicacao());
	}
	
	public void adicionar() throws SQLException { 
		if (id.get() == 0) {
			Livro l = new Livro();
			l.setId(id.get());
			l.setTitulo(titulo.get());
			l.setPaginas(paginas.get());
			l.setDataPublicacao(publicacao.get());
			l = livroDao.adicionar(l);
			lista.add(l);
		} else { 
			Livro l = new Livro();
			l.setId(id.get());
			l.setTitulo(titulo.get());
			l.setPaginas(paginas.get());
			l.setDataPublicacao(publicacao.get());
			
			for (int i = 0; i < lista.size(); i++) { 
				Livro livro = lista.get(i);
				if (livro.getId() == id.get()) { 
					lista.set(i, l);
				}
			}
			livroDao.atualizar(id.get(), l);
		}
	}
	
	public void pesquisar() throws SQLException { 
		lista.clear();
		List<Livro> lst = 
				livroDao.procurarPorTitulo( titulo.get() );
		lista.addAll(lst);		
	}
	
	public StringProperty tituloProperty() { 
		return titulo;
	}
	public IntegerProperty paginasProperty() { 
		return paginas;
	}
	public ObjectProperty<LocalDate> publicacaoProperty() { 
		return publicacao;
	}
	
	public ObservableList<Livro> getLista() { 
		return lista;
	}

}
