package edu.curso;

import javafx.application.Application;
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

class AssinanteEvento implements EventHandler<MouseEvent> {
	@Override
	public void handle(MouseEvent event) {
		System.out.println(event.getEventType() + 
				" X: " + event.getX() + "  Y: " + event.getY());
	}
}

public class PizzaBoundary1 extends Application {
	
	public void start(Stage stage) {
		GridPane painel = new GridPane();
		painel.setStyle("-fx-padding: 50px; "
				+ "-fx-background-color: '#ffffdd'");
		Scene scn = new Scene(painel);
		stage.setScene(scn);
				
		AssinanteEvento ae = new AssinanteEvento();
		
		Label lblSabor = new Label("Sabor: ");
		Label lblPreco = new Label("Preço: ");
		Label lblTamanho = new Label("Tamanho: ");
		
		TextField txtSabor = new TextField();
		TextField txtPreco = new TextField();
		TextField txtTamanho = new TextField();
		txtTamanho.setPromptText(
				"Tamanho da Pizza (Grande, Medio, Individual)");
			
		Button btnSalvar = new Button("Salvar");
		
		scn.addEventFilter(MouseEvent.MOUSE_CLICKED, ae);
		
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
		Application.launch(PizzaBoundary1.class, args);
	}

}
