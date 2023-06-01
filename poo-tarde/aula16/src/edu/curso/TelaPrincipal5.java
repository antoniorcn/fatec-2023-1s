package edu.curso;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class TelaPrincipal5 extends Application {
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
		
		TabPane bp = new TabPane();
		
		Tab tabDespesa = new Tab("despesa", new Label("Despesas"));
		Tab tabReceita = new Tab("receita", new Label("Receitas"));

		bp.getTabs().addAll(tabDespesa, tabReceita);
		tabDespesa.setContent(getTela("despesa").render());
		tabReceita.setContent(getTela("receita").render());

		Scene scn = new Scene(bp, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Sistema de Gestão de Orçamentaria");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal5.class, args);
	}

}
