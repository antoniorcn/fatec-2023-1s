package edu.curso;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class PegaMouse implements EventHandler<MouseEvent> { 
	private Button btn;
	
	public PegaMouse(Button btn) { 
		this.btn = btn;
	}
	public void handle(MouseEvent e) { 
		System.out.println("X: " + e.getX() + "  Y: " + e.getY());
		btn.relocate(e.getX(), e.getY());
	}
}

public class BotaoItinerante1 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 800, 600);
		
		Button btnTeste = new Button("Teste");
		PegaMouse pm = new PegaMouse(btnTeste);
		painel.getChildren().add(btnTeste);
		btnTeste.relocate(400, 400);
		
		scn.addEventFilter(MouseEvent.MOUSE_CLICKED, pm);
		
		stage.setScene(scn);
		stage.setTitle("Botão itinerante");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
