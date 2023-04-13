package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PizzaBoundary2 extends Application implements 
	EventHandler<ActionEvent> {
	
	private TextField txtSabor = new TextField();
	private TextField txtPreco = new TextField();
	private TextField txtTamanho = new TextField();
	private Button btnSalvar = new Button("Salvar");
	
	public void handle(ActionEvent e) { 
		Pizza p1 = new Pizza();
		p1.setSabor(txtSabor.getText());
		p1.setPreco(Float.parseFloat(txtPreco.getText()));
		p1.setTamanho(txtTamanho.getText());
		System.out.println(p1);
	}
	
	public void start(Stage stage) {
		GridPane painel = new GridPane();
		painel.setStyle("-fx-padding: 50px; "
				+ "-fx-background-color: '#ffffdd'");
		Scene scn = new Scene(painel);
		stage.setScene(scn);
				
		Label lblSabor = new Label("Sabor: ");
		Label lblPreco = new Label("Preço: ");
		Label lblTamanho = new Label("Tamanho: ");
		
		txtTamanho.setPromptText(
				"Tamanho da Pizza (Grande, Medio, Individual)");
					
		btnSalvar.addEventFilter(ActionEvent.ANY, this);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(20);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(80);
		painel.getColumnConstraints().addAll(col1, col2);
		
		painel.add(lblSabor, 0, 0);
		painel.add(txtSabor, 1, 0);
		painel.add(lblPreco, 0, 1);
		painel.add(txtPreco, 1, 1);
		painel.add(lblTamanho, 0, 2);
		painel.add(txtTamanho, 1, 2);
		painel.add(btnSalvar, 0, 3);
		
		stage.setTitle("Pizzaria Pronta Entrega");
		stage.setWidth(800);
		stage.setHeight(600);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(PizzaBoundary2.class, args);
	}

}
