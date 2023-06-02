package edu.curso.livros.bce;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AutorControl {
	private LongProperty id = new SimpleLongProperty(0);
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty editora = new SimpleStringProperty("");
	private StringProperty cidade = 
			new SimpleStringProperty(""); 
	
	private long contadorId = 1;
	
	private ObservableList<Autor> lista = 
				FXCollections.observableArrayList();
	
	public void novo() { 
		id.set(0);
		nome.set("");
		editora.set("");
		cidade.set("");
	}
	
	public void excluir(Autor l) { 
		lista.remove(l);
	}
	
	public void fromEntity(Autor l) { 
		id.set(l.getId());
		nome.set(l.getNome());
		editora.set(l.getEditora());
		cidade.set(l.getCidade());
	}
	
	public void adicionar() { 
		if (id.get() == 0) {
			id.set(contadorId++);
			Autor l = new Autor();
			l.setId(id.get());
			l.setNome(nome.get());
			l.setEditora(editora.get());
			l.setCidade(cidade.get());
			
			lista.add(l);
		} else { 
			Autor l = new Autor();
			l.setId(id.get());
			l.setNome(nome.get());
			l.setEditora(editora.get());
			l.setCidade(cidade.get());
			
			for (int i = 0; i < lista.size(); i++) { 
				Autor autor = lista.get(i);
				if (autor.getId() == id.get()) { 
					lista.set(i, l);
				}
			}
		}
	}
	
	public void pesquisar() { 
		for( Autor l : lista  ) { 
			if (l.getNome().contains(nome.get())) { 
				id.set(l.getId());
				nome.set(l.getNome());
				editora.set(l.getEditora());
				cidade.set(l.getCidade());
				break;
			}
		}
	}
	
	public StringProperty nomeProperty() { 
		return nome;
	}
	public StringProperty editoraProperty() { 
		return editora;
	}
	public StringProperty cidadeProperty() { 
		return cidade;
	}
	
	public ObservableList<Autor> getLista() { 
		return lista;
	}

}
