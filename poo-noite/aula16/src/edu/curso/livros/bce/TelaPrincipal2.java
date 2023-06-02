package edu.curso.livros.bce;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaPrincipal2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		Tela autor = new AutorBoundary();
		autor.start();
		
		Tela livro = new LivroBoundary();
		livro.start();
		
		BorderPane principal = new BorderPane();
		
		TabPane abas = new TabPane();

		principal.setCenter(abas);
		MenuBar mnuBar = new MenuBar();
		Menu mnuCadastro = new Menu("Cadastro");
		
		mnuBar.getMenus().addAll(mnuCadastro);
		
		Tab abaAutor = new Tab("Autores");
		Tab abaLivros = new Tab("Livros");
		
		MenuItem mnuAutores = new MenuItem("Autores");
		mnuAutores.setOnAction( e-> {
			if (!abas.getTabs().contains(abaAutor)) {
				abaAutor.setContent(autor.render());
				abas.getTabs().add(abaAutor);
			}
		});
		MenuItem mnuLivros = new MenuItem("Livros");
		mnuLivros.setOnAction( e -> { 
			if (!abas.getTabs().contains(abaLivros)) {
				abaLivros.setContent(livro.render());
				abas.getTabs().add(abaLivros);
			}
		});
		mnuCadastro.getItems().addAll(mnuAutores, mnuLivros);
		
		principal.setTop(mnuBar);
		
		Scene scn = new Scene(principal, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Sistema de Livraria");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal2.class, args);
	}

}
