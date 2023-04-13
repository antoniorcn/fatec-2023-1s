package edu.curso;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BotaoItinerante2 extends Application 
	implements EventHandler<MouseEvent>{
	
	private Button btnTeste = new Button("Teste");
	
	@Override
	public void handle(MouseEvent e) { 
		btnTeste.relocate(e.getX(), e.getY());
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 800, 600);
		
		painel.getChildren().add(btnTeste);
		btnTeste.relocate(400, 400);
		
		scn.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
		
		stage.setScene(scn);
		stage.setTitle("Bot�o itinerante - 2");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
