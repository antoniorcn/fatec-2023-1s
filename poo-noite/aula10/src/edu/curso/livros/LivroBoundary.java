package edu.curso.livros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LivroBoundary extends Application {
	private TextField txtTitulo = new TextField();
	private TextField txtPaginas = new TextField();
	private TextField txtPublicacao = new TextField();
	private DateTimeFormatter dtf = 
				DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private List<Livro> lista = new ArrayList<>();
	
	public void adicionar() { 
		Livro l = new Livro();
		l.setTitulo(txtTitulo.getText());
		l.setPaginas(Integer.parseInt(txtPaginas.getText()));
		LocalDate date = 
				LocalDate.parse(txtPublicacao.getText(), dtf);
		l.setDataPublicacao(date);
		lista.add(l);
		System.out.println("Livro adicionado com sucesso");
	}
	
	public void pesquisar() { 
		for( Livro l : lista  ) { 
			if (l.getTitulo().contains(txtTitulo.getText())) { 
				txtTitulo.setText(l.getTitulo());
				txtPaginas.setText(String.valueOf(l.getPaginas()));
				txtPublicacao.setText(
						dtf.format(l.getDataPublicacao()));
				break;
			}
		}
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
