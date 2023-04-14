package edu.curso;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BotaoItinerante extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 800, 600);
			
		Button btnTeste = new Button("Clique-me");
		btnTeste.relocate(200, 200);
		painel.getChildren().add(btnTeste);
		
		painel.addEventFilter(MouseEvent.MOUSE_MOVED,
			e -> btnTeste.relocate(e.getX(), e.getY()) 
		);
		
		painel.addEventFilter(KeyEvent.KEY_PRESSED,
			e -> {
				KeyCode tecla = e.getCode();
				if (tecla == KeyCode.H) { 
					btnTeste.setStyle("-fx-opacity: 0.0;");
				} else {
					btnTeste.setStyle("-fx-opacity: 1.0;");
				}
			}
		);

		stage.setScene(scn);
		stage.setTitle("Teste Evento - 1");
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
