package edu.curso.livros.bce;

import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;

public class LivroBoundary extends Application {
	private TextField txtTitulo = new TextField();
	private TextField txtPaginas = new TextField();
	private TextField txtPublicacao = new TextField();
	private DateTimeFormatter dtf = 
				DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LivroControl control = new LivroControl();

	
	public void adicionar() {
		control.adicionar();
	}
	
	public void pesquisar() { 
		control.pesquisar();
	}
	
	public void ligacoes() { 
		Bindings.bindBidirectional(txtTitulo.textProperty(),
				control.tituloProperty());
		Bindings.bindBidirectional(txtPaginas.textProperty(), 
				control.paginasProperty(), 
				(StringConverter)new IntegerStringConverter());
		Bindings.bindBidirectional(txtPublicacao.textProperty(), 
				control.publicacaoProperty(), 
				(StringConverter)new LocalDateStringConverter());
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane principal = new BorderPane();
		Scene scn = new Scene(principal, 600, 400);
		
		GridPane grid = new GridPane();
		principal.setCenter(grid);
		grid.add(new Label("Titulo: "), 0, 0);
		grid.add(txtTitulo, 1, 0);
		grid.add(new Label("#Páginas: "), 0, 1);
		grid.add(txtPaginas, 1, 1);
		grid.add(new Label("Data de Publicação: "), 0, 2);
		grid.add(txtPublicacao, 1, 2);
		
		ligacoes();
		
		Button btnAdicionar = new Button("Adicionar");
		btnAdicionar.setOnAction(e -> adicionar());
		
		Button btnPesquisar = new Button("Pesquisar");
		btnPesquisar.setOnAction(e -> pesquisar());
		
		grid.add(btnAdicionar, 0, 3);
		grid.add(btnPesquisar, 1, 3);
		
		stage.setScene(scn);
		stage.setTitle("Gestão de Livros");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
