package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PratoFormulario extends Application {
	
	@Override
	public void start(Stage stage)  {
		GridPane painel = new GridPane();
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(20);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(80);
		painel.getColumnConstraints().addAll(col1, col2);
		
		painel.setStyle("-fx-padding: 50px");
		
		Scene scn = new Scene(painel, 800, 300);
				
		Label lblNome = new Label("Nome do prato: ");
		Label lblCodigo = new Label("Codigo: ");
		Label lblIngredientes = new Label("Ingredientes: ");
		
		TextField txtNome = new TextField();
		TextField txtCodigo = new TextField();
		TextArea txtIngredientes = new TextArea();
		
		Button btnSalvar = new Button("Salvar");
		
		painel.add(lblNome, 0, 0);
		painel.add(txtNome, 1, 0);
		painel.add(lblCodigo, 0, 1);
		painel.add(txtCodigo, 1, 1);
		painel.add(lblIngredientes, 0, 2);
		painel.add(txtIngredientes, 1, 2, 1, 3);
		painel.add(btnSalvar, 0, 5);
		
		stage.setScene(scn);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
