package edu.curso;

import java.sql.SQLException;
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

public class DespesaControl {
	private LongProperty id = new SimpleLongProperty(0);
	private StringProperty razao = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> data = 
			new SimpleObjectProperty<>(LocalDate.now());
	private DoubleProperty valor = new SimpleDoubleProperty();
	
	private ObservableList<Despesa> despesas = 
				FXCollections.observableArrayList();
	
	private DespesaDAO despesaDAO; 
	
	private long idCounter = 1l;
	
	public DespesaControl() 
			throws ClassNotFoundException, SQLException { 
		despesaDAO = new DespesaDAOImpl();
	}
	
	public void novo() { 
		fromEntity(new Despesa());
	}
	
	public void salvar() throws SQLException { 
		Despesa d = new Despesa();
		d.setData(data.get());
		d.setRazao(razao.get());
		d.setValor(valor.get());
		if (id.get() == 0) { 
			d = despesaDAO.adicionar( d );
			despesas.add(d);
		} else { 
			despesaDAO.atualizar(id.get(), d);
		}
	}
	
	public void excluir(Despesa d) throws SQLException { 
		despesas.remove(d);
		despesaDAO.remover(d.getId());
	}
	
	public void fromEntity(Despesa d) { 
		id.set(d.getId());
		razao.set(d.getRazao());
		data.set(d.getData());
		valor.set(d.getValor());
	}
	
	public void pesquisar() throws SQLException { 
		despesas.clear();
		despesas.addAll(despesaDAO.pesquisarPorRazao(razao.get()));
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
	public LongProperty idProperty() { 
		return id;
	}
	public ObservableList<Despesa> getList() { 
		return despesas;
	}
}
