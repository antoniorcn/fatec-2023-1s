package edu.curso;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AppStackPane extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		StackPane painel = new StackPane();
		painel.setStyle("-fx-background-color: 'lightcyan'");
		Scene scn = new Scene(painel);
		
		painel.setAlignment(Pos.BASELINE_LEFT);
		
		Button btnTeste = new Button("Aperte-me");
		btnTeste.relocate(100, 100);
		Label lbl = new Label("Texto Simples");
		lbl.relocate(100, 120);
		TextField txt = new TextField();
		txt.relocate(100, 140);
		
		StackPane.setMargin(btnTeste, 
				new Insets(50, 100, 100, 50));
	
		painel.getChildren().addAll(txt,btnTeste, lbl);
		
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