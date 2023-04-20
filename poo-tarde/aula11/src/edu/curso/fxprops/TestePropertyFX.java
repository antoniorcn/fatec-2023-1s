package edu.curso.fxprops;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TestePropertyFX extends Application {
	
	private TextField txtNomeCompleto = new TextField();
	private Label lblNomeCompleto = new Label();
	private StringProperty nome = new SimpleStringProperty("");
	private Button btnTeste = new Button("Mostrar");

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane principal = new BorderPane();
		Scene scn = new Scene(principal, 400, 200);
		
		principal.setCenter(txtNomeCompleto);
		
//		txtNomeCompleto.textProperty().addListener(
//			(ob, antigo, novo) -> {
////				System.out.println("Antigo " + antigo +
////					"       Novo " + novo);
//				nome.set(novo);
//				lblNomeCompleto.setText(novo);
//			}
//		);
		
		nome.bind(txtNomeCompleto.textProperty());
		
		btnTeste.setOnAction(e -> System.out.println(nome.get()));
		
		principal.setRight(btnTeste);
		
		principal.setBottom(lblNomeCompleto);
		
		stage.setScene(scn);
		stage.setTitle("Teste de FX Properties");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
