package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AppAnchorPane extends Application {
	public void start(Stage stage) {
		AnchorPane painel = new AnchorPane();
		painel.setStyle("-fx-background-color: '#DDFFFF'");
		Scene scene = new Scene(painel, 600, 400);
		
		Button btnTeste = new Button("Me aperte...");
		
		Label lbl = new Label("Texto Simples");
		
		TextField txt = new TextField();
		
		painel.getChildren().addAll(lbl, txt, btnTeste);
		AnchorPane.setBottomAnchor(btnTeste, 20.0);
		AnchorPane.setLeftAnchor(btnTeste, 20.0);
		AnchorPane.setRightAnchor(btnTeste, 20.0);
		AnchorPane.setTopAnchor(lbl, 20.0);
		AnchorPane.setTopAnchor(txt, 50.0);
		
		stage.setScene(scene);
		stage.setTitle("Meu App");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
