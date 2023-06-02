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

public class TelaPrincipal3 extends Application 
							implements Executor{
	private Tela autor;
	private Tela livro;
	private BorderPane principal;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		autor = new AutorBoundary(this);
		autor.start();
		
		livro = new LivroBoundary(this);
		livro.start();
		
		principal = new BorderPane();
		
		TabPane abas = new TabPane();

		principal.setCenter(abas);
		MenuBar mnuBar = new MenuBar();
		Menu mnuCadastro = new Menu("Cadastro");
		
		mnuBar.getMenus().addAll(mnuCadastro);
		
		Tab abaAutor = new Tab("Autores");
		Tab abaLivros = new Tab("Livros");
		
		MenuItem mnuAutores = new MenuItem("Autores");
		mnuAutores.setOnAction( e-> {
			abrir("autores");
		});
		MenuItem mnuLivros = new MenuItem("Livros");
		mnuLivros.setOnAction( e -> { 
			abrir("livros");
		});
		mnuCadastro.getItems().addAll(mnuAutores, mnuLivros);
		
		principal.setTop(mnuBar);
		
		Scene scn = new Scene(principal, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Sistema de Livraria");
		stage.show();
	}
	
	public void abrir(String cmd)  { 
		if ("autores".equals(cmd)) { 
			principal.setCenter(autor.render());
		} else if ("livros".equals(cmd)) { 
			principal.setCenter(livro.render());
		}
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal3.class, args);
	}

}
