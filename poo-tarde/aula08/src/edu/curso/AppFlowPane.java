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

	@Override
	public void start(Stage stage) throws Exception {
		FlowPane painel = new FlowPane();
		painel.setStyle("-fx-background-color: 'lightcyan'");
		Scene scn = new Scene(painel);
		
		Button btnTeste = new Button("Aperte-me");
		
		Label lbl = new Label("Texto Simples");
		
		TextField txt = new TextField();
	
		painel.getChildren().addAll(btnTeste, lbl, txt);
		
		stage.setScene(scn);
		stage.setWidth(600);
		stage.setHeight(400);
		stage.setTitle("Meu primeiro App");
		stage.show();
		// System.out.println("Fim do programa");
	}
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}

}