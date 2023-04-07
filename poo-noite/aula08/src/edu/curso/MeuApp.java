package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MeuApp extends Application {
	public void start(Stage stage) {
		Pane painel = new Pane();
		painel.setStyle("-fx-background-color: '#DDFFFF'");
		Scene scene = new Scene(painel, 600, 400);
		
		Button btnTeste = new Button("Me aperte...");
		painel.getChildren().add(btnTeste);
		btnTeste.relocate(100, 100);
		
		Label lbl = new Label("Texto Simples");
		painel.getChildren().add(lbl);
		lbl.relocate(250, 100);
		
		TextField txt = new TextField();
		painel.getChildren().add(txt);
		txt.relocate(450, 100);
		
		stage.setScene(scene);
		stage.setTitle("Meu App");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
