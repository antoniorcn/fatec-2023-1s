package edu.curso;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReceitaControl {
	private LongProperty id = new SimpleLongProperty(0);
	private StringProperty razao = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> data = 
			new SimpleObjectProperty<>(LocalDate.now());
	private DoubleProperty valor = new SimpleDoubleProperty();
	
	private ObservableList<Receita> receitas = 
				FXCollections.observableArrayList();
	
	private long idCounter = 1l; 
	
	public void novo() { 
		fromEntity(new Receita());
	}
	
	public void salvar() { 
		if (id.get() == 0) { 
			Receita d = new Receita();
			d.setData(data.get());
			d.setRazao(razao.get());
			d.setValor(valor.get());
			d.setId(idCounter ++ );
			// System.out.println(d);
			receitas.add(d);
		} else { 
			for (int i = 0; i < receitas.size(); i++) {
				Receita r = receitas.get(i);
				if (r.getId() == id.get()) { 
					Receita dNova = new Receita();
					dNova.setId(r.getId());
					dNova.setData(data.get());
					dNova.setRazao(razao.get());
					dNova.setValor(valor.get());
					receitas.set(i, dNova);
					break;
				}
			}
		}
	}
	
	public void excluir(Receita d) { 
		receitas.remove(d);
	}
	
	public void fromEntity(Receita d) { 
		id.set(d.getId());
		razao.set(d.getRazao());
		data.set(d.getData());
		valor.set(d.getValor());
	}
	
	public void pesquisar() { 
		for (Receita d : receitas) {
			if (d.getRazao().toLowerCase()
					.contains(razao.get().toLowerCase())) {
				razao.set(d.getRazao());
				valor.set(d.getValor());
				data.set(d.getData());
				break;
			}
		}
		System.out.println("Razao: " + razao.get());
	}
	
	public LongProperty idProperty() { 
		return id;
	}
	
	public StringProperty razaoProperty() { 
		return razao;
	}
	public DoubleProperty valorProperty() { 
		return valor;
	}
	public ObjectProperty<LocalDate> dataProperty() { 
		return data;
	}
	public ObservableList<Receita> getList() { 
		return receitas;
	}
}
