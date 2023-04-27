package edu.curso.livros.bce;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LivroControl {
	private StringProperty titulo = new SimpleStringProperty("");
	private IntegerProperty paginas = new SimpleIntegerProperty(0);
	private ObjectProperty<LocalDate> publicacao = 
			new SimpleObjectProperty<>(LocalDate.now()); 
	
	
	private ObservableList<Livro> lista = 
				FXCollections.observableArrayList();
	
	public void adicionar() { 
		Livro l = new Livro();
		l.setTitulo(titulo.get());
		l.setPaginas(paginas.get());
		l.setDataPublicacao(publicacao.get());
		
		lista.add(l);
	}
	
	public void pesquisar() { 
		for( Livro l : lista  ) { 
			if (l.getTitulo().contains(titulo.get())) { 
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
