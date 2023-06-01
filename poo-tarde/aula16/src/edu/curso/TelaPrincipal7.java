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

public class TelaPrincipal7 extends Application 
							implements Executor {
	private Map<String, Tela> telas = new HashMap<>();
	private Tab tabDespesa;
	private Tab tabReceita;
	private TabPane tabs;
	
	public void gerarTelas() { 
		telas.put("despesa", new DespesaForm(this));
		telas.put("receita", new ReceitaForm(this));
		
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
		
		tabs = new TabPane();
		tabDespesa = new Tab("despesa", new Label("Despesas"));
		tabReceita = new Tab("receita", new Label("Receitas"));
				
		MenuBar mnuBar = new MenuBar();
		Menu mnuCadastro = new Menu("Cadastro");
		mnuBar.getMenus().add(mnuCadastro);
		
		MenuItem mnuDespesa = new MenuItem("Despesas");
		MenuItem mnuReceita = new MenuItem("Receitas");
		mnuCadastro.getItems().addAll(mnuDespesa, mnuReceita);
		
		mnuDespesa.setOnAction((e)-> {
			executar("despesa");
		});
		
		mnuReceita.setOnAction((e)-> {
			executar("receita");
		});

		bp.setTop(mnuBar);
		bp.setCenter(tabs);
		
		Scene scn = new Scene(bp, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Sistema de Gestão de Orçamentaria");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal7.class, args);
	}

	@Override
	public void executar(String cmd) {
		if ("despesa".equals(cmd)) { 
			if (!tabs.getTabs().contains(tabDespesa)) {
				tabDespesa.setContent(getTela("despesa").render());
				tabs.getTabs().add(tabDespesa);
			}
		} else if ("receita".equals(cmd)) { 
			if (!tabs.getTabs().contains(tabReceita)) {
				tabReceita.setContent(getTela("receita").render());
				tabs.getTabs().add(tabReceita);
			}
		}
	}

}
