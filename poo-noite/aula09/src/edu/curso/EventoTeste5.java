package edu.curso;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EventoTeste5 extends Application {
	
	private Label lblTeste = new Label("Teste de Evento");
	
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane painel = new BorderPane();
		Scene scn = new Scene(painel, 400, 200);
			
		Button btnTeste = new Button("Clique-me");
		
		btnTeste.addEventFilter(MouseEvent.ANY, 
			e -> lblTeste.setText(e.getEventType().toString())
		);
		
		painel.setTop(lblTeste);
		painel.setBottom(btnTeste);
		stage.setScene(scn);
		stage.setTitle("Teste Evento - 1");
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
