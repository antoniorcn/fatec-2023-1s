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

public class TelaPrincipal4 extends Application 
							implements Executor{
	private Tela autor;
	private Tela livro;
	private BorderPane principal;
	private TabPane abas;
	private Tab abaAutor;
	private Tab abaLivros;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		autor = new AutorBoundary(this);
		autor.start();
		
		livro = new LivroBoundary(this);
		livro.start();
		
		principal = new BorderPane();
		
		abas = new TabPane();

		principal.setCenter(abas);
		MenuBar mnuBar = new MenuBar();
		Menu mnuCadastro = new Menu("Cadastro");
		
		mnuBar.getMenus().addAll(mnuCadastro);
		
		abaAutor = new Tab("Autores");
		abaLivros = new Tab("Livros");
		
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
			if (!abas.getTabs().contains(abaAutor)) { 
				abaAutor.setContent(autor.render());
				abas.getTabs().add(abaAutor);
			}
			
		} else if ("livros".equals(cmd)) { 
			if (!abas.getTabs().contains(abaLivros)) { 
				abaLivros.setContent(livro.render());
				abas.getTabs().add(abaLivros);
			}
		}
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal4.class, args);
	}

}
