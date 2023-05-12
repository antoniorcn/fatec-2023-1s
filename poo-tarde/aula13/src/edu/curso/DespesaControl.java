package edu.curso;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
	private Connection con = null;
	
	public DespesaControl() { 
		File fConfig = new File("./config.properties");
		try (InputStream is = new FileInputStream(fConfig)){
			Properties props = new Properties();
			props.load(is);
			
			Class.forName(props.getProperty("db.driver"));
			con = DriverManager.getConnection(
					props.getProperty("db.url"), 
					props.getProperty("db.user"),
					props.getProperty("db.pass")
					);
		} catch (IOException | ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
	}
	
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
			String sql = "INSERT INTO despesas (id, razao, data, valor) "
					+ "VALUES (" + id.get() + ", '"+ razao.get() + "', '" 
					+ data.get() + "', " + valor.get() + ")";
			try { 
				PreparedStatement pst = con.prepareStatement(sql);
				pst.executeUpdate();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
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
		String sql = "DELETE FROM despesas WHERE id = " + d.getId();
		try { 
			PreparedStatement pst = con.prepareStatement(sql);
			pst.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	
	public void fromEntity(Despesa d) { 
		id.set(d.getId());
		razao.set(d.getRazao());
		data.set(d.getData());
		valor.set(d.getValor());
	}
	
	public void pesquisar() { 
//		for (Despesa d : despesas) {
//			if (d.getRazao().toLowerCase()
//					.contains(razao.get().toLowerCase())) {
//				razao.set(d.getRazao());
//				valor.set(d.getValor());
//				data.set(d.getData());
//				break;
//			}
//		}
		despesas.clear();
		try { 
			String sql = "SELECT * FROM despesas "
					+ "WHERE razao LIKE '%" + razao.get() + "%'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) { 
				Despesa d = new Despesa();
				d.setRazao( rs.getString("razao") );
				d.setData( rs.getDate("data").toLocalDate() );
				d.setValor( rs.getDouble("valor") );
				despesas.add(d);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
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
