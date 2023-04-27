package edu.curso.bce.padrao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DespesaControl {
	
	private StringProperty razao = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> data = 
			new SimpleObjectProperty<>(LocalDate.now());
	private DoubleProperty valor = new SimpleDoubleProperty();
	
	private ObservableList<Despesa> despesas = 
				FXCollections.observableArrayList();
	
	public void adicionar() { 
		Despesa d = new Despesa();
		d.setData(data.get());
		d.setRazao(razao.get());
		d.setValor(valor.get());
		
		System.out.println(d);
		despesas.add(d);
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
