package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AppFlowPane extends Application {
	public void start(Stage stage) {
		FlowPane painel = new FlowPane();
		painel.setStyle("-fx-background-color: '#DDFFFF'");
		Scene scene = new Scene(painel, 600, 400);
		
		Button btnTeste = new Button("Me aperte...");
		
		Label lbl = new Label("Texto Simples");
		
		TextField txt = new TextField();
		
		painel.getChildren().addAll(lbl, txt, btnTeste);
		
		stage.setScene(scene);
		stage.setTitle("Meu App");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
