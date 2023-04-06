package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AppAnchorPane extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane painel = new AnchorPane();
		painel.setStyle("-fx-background-color: 'lightcyan'");
		Scene scn = new Scene(painel);
		
		Button btnTeste = new Button("Aperte-me");
		
		Label lbl = new Label("Texto Simples");
		
		TextField txt = new TextField();
	
		painel.getChildren().addAll(lbl, txt, btnTeste);
		AnchorPane.setBottomAnchor(btnTeste, 50.0);
		AnchorPane.setBottomAnchor(lbl, 100.0);
		AnchorPane.setRightAnchor(btnTeste, 50.0);
		AnchorPane.setRightAnchor(lbl, 100.0);
		AnchorPane.setLeftAnchor(btnTeste, 50.0);
		AnchorPane.setLeftAnchor(lbl, 100.0);
		
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