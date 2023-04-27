package edu.curso.bce.padrao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

public class DespesaControl {
	private LongProperty id = new SimpleLongProperty(0);
	private StringProperty razao = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> data = 
			new SimpleObjectProperty<>(LocalDate.now());
	private DoubleProperty valor = new SimpleDoubleProperty();
	
	private ObservableList<Despesa> despesas = 
				FXCollections.observableArrayList();
	
	private long idCounter = 1l; 
	
	public void novo() { 
		fromEntity(new Despesa());
	}
	
	public void salvar() { 
		if (id.get() == 0) { 
			Despesa d = new Despesa();
			d.setData(data.get());
			d.setRazao(razao.get());
			d.setValor(valor.get());
			d.setId(idCounter ++ );
			// System.out.println(d);
			despesas.add(d);
		} else { 
			for (int i = 0; i < despesas.size(); i++) {
				Despesa d = despesas.get(i);
				if (d.getId() == id.get()) { 
					Despesa dNova = new Despesa();
					dNova.setId(d.getId());
					dNova.setData(data.get());
					dNova.setRazao(razao.get());
					dNova.setValor(valor.get());
					despesas.set(i, dNova);
					break;
				}
			}
		}
	}
	
	public void excluir(Despesa d) { 
		despesas.remove(d);
	}
	
	public void fromEntity(Despesa d) { 
		id.set(d.getId());
		razao.set(d.getRazao());
		data.set(d.getData());
		valor.set(d.getValor());
	}
	
	public void pesquisar() { 
		for (Despesa d : despesas) {
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
	
	public StringProperty razaoProperty() { 
		return razao;
	}
	public DoubleProperty valorProperty() { 
		return valor;
	}
	public ObjectProperty<LocalDate> dataProperty() { 
		return data;
	}
	public ObservableList<Despesa> getList() { 
		return despesas;
	}
}
