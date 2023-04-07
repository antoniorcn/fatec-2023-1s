package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AppGridPane extends Application {
	public void start(Stage stage) {
		GridPane painel = new GridPane();
		painel.setStyle("-fx-background-color: '#DDFFFF'");
		Scene scene = new Scene(painel, 600, 400);
		
		Button btnTeste = new Button("Me aperte...");
		
		Label lbl = new Label("Texto Simples");
		
		TextField txt = new TextField();
		
		painel.add(lbl, 0, 0);
		painel.add(txt, 1, 0);
		painel.add(btnTeste, 1, 1);
		
		stage.setScene(scene);
		stage.setTitle("Meu App");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
