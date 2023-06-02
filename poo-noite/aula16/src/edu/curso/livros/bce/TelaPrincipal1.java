package edu.curso.livros.bce;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaPrincipal1 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		Tela autor = new AutorBoundary();
		autor.start();
		
		Tela livro = new LivroBoundary();
		livro.start();
		
		BorderPane principal = new BorderPane();
		
		MenuBar mnuBar = new MenuBar();
		Menu mnuCadastro = new Menu("Cadastro");
		
		mnuBar.getMenus().addAll(mnuCadastro);
		
		MenuItem mnuAutores = new MenuItem("Autores");
		mnuAutores.setOnAction( e-> {
			principal.setCenter(autor.render());
		});
		MenuItem mnuLivros = new MenuItem("Livros");
		mnuLivros.setOnAction( e -> { 
			principal.setCenter(livro.render());
		});
		mnuCadastro.getItems().addAll(mnuAutores, mnuLivros);
		
		principal.setTop(mnuBar);
		
		Scene scn = new Scene(principal, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Sistema de Livraria");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal1.class, args);
	}

}
