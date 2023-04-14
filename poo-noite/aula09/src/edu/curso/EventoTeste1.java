package edu.curso;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class PegaEvento implements EventHandler<MouseEvent> { 
	private Label lbl;
	public PegaEvento(Label lbl) { 
		this.lbl = lbl;
	}
	
	@Override
	public void handle(MouseEvent e) {
		lbl.setText("Tipo: " + e.getEventType());
	}
}

public class EventoTeste1 extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane painel = new BorderPane();
		Scene scn = new Scene(painel, 400, 200);
		
		Label lblTeste = new Label("Teste de Evento");
		
		PegaEvento pe = new PegaEvento(lblTeste);
		
		Button btnTeste = new Button("Clique-me");
		btnTeste.addEventFilter(MouseEvent.ANY, pe);
		
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
