package edu.curso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TelaPrincipal3 extends Application {
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
		
		BorderPane bp = new BorderPane();
		Button btnTelaA = new Button("Despesas");
		btnTelaA.setOnAction((e)-> {
			bp.setCenter(getTela("despesa").render());
		});
		Button btnTelaB = new Button("Receitas");
		btnTelaB.setOnAction((e)-> {
			bp.setCenter(getTela("receita").render());
		});
		bp.setTop(new HBox(btnTelaA, btnTelaB) );
		Scene scn = new Scene(bp, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Sistema de Gestão de Orçamentaria");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal3.class, args);
	}

}
