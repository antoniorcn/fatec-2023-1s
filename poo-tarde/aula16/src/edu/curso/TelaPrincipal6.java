package edu.curso;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaPrincipal6 extends Application {
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
	
		BorderPane bp = new BorderPane();
		gerarTelas();
		
		TabPane tabs = new TabPane();
		Tab tabDespesa = new Tab("despesa", new Label("Despesas"));
		Tab tabReceita = new Tab("receita", new Label("Receitas"));
				
		MenuBar mnuBar = new MenuBar();
		Menu mnuCadastro = new Menu("Cadastro");
		mnuBar.getMenus().add(mnuCadastro);
		
		MenuItem mnuDespesa = new MenuItem("Despesas");
		MenuItem mnuReceita = new MenuItem("Receitas");
		mnuCadastro.getItems().addAll(mnuDespesa, mnuReceita);
		
		mnuDespesa.setOnAction((e)-> {
			if (!tabs.getTabs().contains(tabDespesa)) {
				tabDespesa.setContent(getTela("despesa").render());
				tabs.getTabs().add(tabDespesa);
			}
		});
		
		mnuReceita.setOnAction((e)-> {
			if (!tabs.getTabs().contains(tabReceita)) {
				tabReceita.setContent(getTela("receita").render());
				tabs.getTabs().add(tabReceita);
			}
		});

		bp.setTop(mnuBar);
		bp.setCenter(tabs);
		
		Scene scn = new Scene(bp, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Sistema de Gestão de Orçamentaria");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal6.class, args);
	}

}
