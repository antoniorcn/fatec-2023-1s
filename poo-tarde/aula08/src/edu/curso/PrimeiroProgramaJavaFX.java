package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrimeiroProgramaJavaFX extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Pane painel = new Pane();
		painel.setStyle("-fx-background-color: 'lightcyan'");
		Scene scn = new Scene(painel);
		
		Button btnTeste = new Button("Aperte-me");
		painel.getChildren().add(btnTeste);
		btnTeste.relocate(260, 180);
		
		Label lbl = new Label("Texto Simples");
		painel.getChildren().add(lbl);
		lbl.relocate(240, 140);
		
		TextField txt = new TextField();
		painel.getChildren().add(txt);
		txt.relocate(330, 140);
		
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