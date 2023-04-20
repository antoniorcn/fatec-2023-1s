package edu.curso.be;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DespesaForm extends Application {

	private TextField txtRazao = new TextField();
	private TextField txtData = new TextField();
	private TextField txtValor = new TextField();
	private List<Despesa> despesas = new ArrayList<>();
	private DateTimeFormatter dtf = 
			DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	
	public void limparCampos() { 
		txtRazao.setText("");
		txtData.setText("");
		txtValor.setText("");
	}
	
	public void adicionar() { 
		Despesa d = new Despesa();
		d.setRazao(txtRazao.getText());
		try { 
			d.setData( LocalDate.parse(txtData.getText(), dtf) );
			d.setValor( Double.parseDouble(txtValor.getText()) );
		} catch(Exception e) {
			e.printStackTrace();
		}
		despesas.add(d);
		Alert a = new Alert(AlertType.INFORMATION, 
				"Despesa adicionada com sucesso", ButtonType.OK);
		a.showAndWait();
		limparCampos();
	}
	
	public void pesquisar() {
		for (Despesa d : despesas) {
			if (d.getRazao().toLowerCase()
					.contains(txtRazao.getText().toLowerCase())) { 
				txtRazao.setText(d.getRazao());
				txtData.setText( dtf.format(d.getData()) );
				txtValor.setText( String.valueOf(d.getValor()) );
				break;
			}
		}
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane principal = new BorderPane();
		principal.setPadding(new Insets(50));
		Scene scn = new Scene(principal, 600, 300);
		GridPane painelForm = new GridPane();
		principal.setCenter(painelForm);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(30);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(70);
		painelForm.getColumnConstraints().addAll(col1, col2);
		
		Button btnAdicionar = new Button("Adicionar");
		Button btnPesquisar = new Button("Pesquisar");
		
		btnAdicionar.setOnAction((e)->{
			adicionar();
		});
		
		btnPesquisar.setOnAction((e)->{
			pesquisar();
		});
		
		
		painelForm.add(new Label("Id"), 0, 0);
		painelForm.add(new Label("Razão"), 0, 1);
		painelForm.add(txtRazao, 1, 1);
		painelForm.add(new Label("Data"), 0, 2);
		painelForm.add(txtData, 1, 2);
		painelForm.add(new Label("Valor"), 0, 3);
		painelForm.add(txtValor, 1, 3);
		painelForm.add(btnAdicionar, 0, 4);
		painelForm.add(btnPesquisar, 1, 4);

		stage.setScene(scn);
		stage.setTitle("Controle de Despesas");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
