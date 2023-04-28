package edu.curso.livros.bce;

import java.time.LocalDate;

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
	
	private long contadorId = 1;
	
	private ObservableList<Livro> lista = 
				FXCollections.observableArrayList();
	
	public void novo() { 
		id.set(0);
		titulo.set("");
		paginas.set(0);
		publicacao.set(LocalDate.now());
	}
	
	public void excluir(Livro l) { 
		lista.remove(l);
	}
	
	public void fromEntity(Livro l) { 
		id.set(l.getId());
		titulo.set(l.getTitulo());
		paginas.set(l.getPaginas());
		publicacao.set(l.getDataPublicacao());
	}
	
	public void adicionar() { 
		if (id.get() == 0) {
			id.set(contadorId++);
			Livro l = new Livro();
			l.setId(id.get());
			l.setTitulo(titulo.get());
			l.setPaginas(paginas.get());
			l.setDataPublicacao(publicacao.get());
			
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
		}
	}
	
	public void pesquisar() { 
		for( Livro l : lista  ) { 
			if (l.getTitulo().contains(titulo.get())) { 
				id.set(l.getId());
				titulo.set(l.getTitulo());
				paginas.set(l.getPaginas());
				publicacao.set(l.getDataPublicacao());
				break;
			}
		}
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
