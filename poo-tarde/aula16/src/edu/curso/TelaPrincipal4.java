package edu.curso;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TelaPrincipal4 extends Application {
	private Map<String, Tela> telas = new HashMap<>();
	
	public void gerarTelas() { 
		telas.put("despesa", new DespesaForm());
		telas.put("receita", new ReceitaForm());
		
		for (Tela t : telas.values()) { 
			t.start();
		}
	}
	
	public Tela getTela(String nome) {
		return telas.get(nome);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
	
		gerarTelas();
		
		MenuBar mnuBar = new MenuBar();
		Menu mnuCadastro = new Menu("Cadastro");
		mnuBar.getMenus().add(mnuCadastro);
		
		MenuItem mnuDespesa = new MenuItem("Despesas");
		MenuItem mnuReceita = new MenuItem("Receitas");
		mnuCadastro.getItems().addAll(mnuDespesa, mnuReceita);
		
		BorderPane bp = new BorderPane();
		mnuDespesa.setOnAction((e)-> {
			bp.setCenter(getTela("despesa").render());
		});
		mnuReceita.setOnAction((e)-> {
			bp.setCenter(getTela("receita").render());
		});
		bp.setTop(mnuBar);
		Scene scn = new Scene(bp, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Sistema de Gestão de Orçamentaria");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal4.class, args);
	}

}
