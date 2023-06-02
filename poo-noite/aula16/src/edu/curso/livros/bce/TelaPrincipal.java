package edu.curso.livros.bce;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TelaPrincipal extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		Tela autor = new AutorBoundary();
		autor.start();
		
		Tela livro = new LivroBoundary();
		livro.start();
		
		BorderPane principal = new BorderPane();
		
		Button btnAutores = new Button("Autores");
		btnAutores.setOnAction(e -> {
			principal.setCenter(autor.render());
		});
		Button btnLivros = new Button("Livros");
		btnLivros.setOnAction( e-> {
			principal.setCenter(livro.render());
		});
		
		principal.setTop(new HBox(btnLivros, btnAutores));
		
		Scene scn = new Scene(principal, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Sistema de Livraria");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal.class, args);
	}

}
